package com.example.quantifiedself.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.qauntifiedself.model.QuantifiedSelf;
import com.example.quantifiedself.R;

public class PersonalInfoActivity extends Activity {

	private EditText edtTextHeight;
	private EditText edtTextBirthDate;
	private RadioButton rBtnM;
	private RadioButton rBtnF;
	private Button btnEdit;
	private ListView lvLastRecords;
	private ArrayList<String> lastRecords;
	private ArrayAdapter<String> adapter;
	private QuantifiedSelf q;
	private SimpleDateFormat formatter;
	private char newSex = ' ';

	@SuppressLint("SimpleDateFormat")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personal_info);
		

		q = QuantifiedSelf.getInstance();
		char personSex = q.getSex();
		Date personBirthDate = q.getBirthDate();
		formatter = new SimpleDateFormat("yyyy/MM/dd");
		String personBirthDateStr = formatter.format(personBirthDate);
		double personHeight = q.getHeight();

		rBtnF = (RadioButton) findViewById(R.id.rBtnF);
		rBtnM = (RadioButton) findViewById(R.id.rBtnM);
		edtTextBirthDate = (EditText) findViewById(R.id.edtTextBirthDate);
		edtTextHeight = (EditText) findViewById(R.id.edtTextHeight);

		edtTextHeight.setText("" + personHeight);
		edtTextBirthDate.setText(personBirthDateStr);

		if (Character.toUpperCase(personSex) == 'F') {
			rBtnF.setChecked(true);
		} else if (Character.toUpperCase(personSex) == 'M') {
			rBtnM.setChecked(true);
		}

		btnEdit = (Button) findViewById(R.id.btnEdit);
		btnEdit.setOnClickListener(new OnClickListener() {

			@SuppressLint("SimpleDateFormat")
			@Override
			public void onClick(View v) {
				double newHeight;
				Date newBirthDate = null;

				try {
					SimpleDateFormat formatter = new SimpleDateFormat(
							"yyyy/MM/dd");
					newBirthDate = formatter.parse(edtTextBirthDate.getText()
							.toString());

				} catch (ParseException e) {
					e.printStackTrace();
					Toast.makeText(getApplicationContext(), "1",
							Toast.LENGTH_SHORT).show();
				}

				newHeight = Double.parseDouble(edtTextHeight.getText()
						.toString());

				q.setSex(newSex);
				q.setHeight(newHeight);
				q.setBirthDate(newBirthDate);

				finish();
			}
		});

		getLastRecords();

		lvLastRecords = (ListView) findViewById(R.id.lvLastRecords);
		atualizarLista();

		registerForContextMenu(lvLastRecords);
		lvLastRecords.setOnCreateContextMenuListener(this);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.personal_info, menu);
		return true;
	}

	@Override
	protected void onPause() {
		super.onPause();

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);

		menu.add(0, v.getId(), 0, "Edit");

	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		if (featureId == Window.FEATURE_CONTEXT_MENU) {

			AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
					.getMenuInfo();
			int position = info.position;


			if (item.getOrder() == 0 && position == 0) {
				Intent i = new Intent(getApplicationContext(),
						LastRecordGlucose.class);
				startActivity(i);

			}
			if (item.getOrder() == 0 && position == 1) {
				Intent i = new Intent(getApplicationContext(),
						LastRecordBloodPressure.class);
				startActivity(i);
			}
			if (item.getOrder() == 0 && position == 2) {
				Intent i = new Intent(getApplicationContext(),
						LastRecordActivity.class);
				startActivity(i);
			}
			if (item.getOrder() == 0 && position == 3) {
				Intent i = new Intent(getApplicationContext(),
						LastRecordBmi.class);
				startActivity(i);
			}
			if (item.getOrder() == 0 && position == 4) {
				Intent i = new Intent(getApplicationContext(),
						LastRecordBodyFat.class);
				startActivity(i);
			}
			if (item.getOrder() == 0 && position == 5) {
				Intent i = new Intent(getApplicationContext(),
						LastRecordHeartRate.class);
				startActivity(i);
			}
			if (item.getOrder() == 0 && position == 6) {
				Intent i = new Intent(getApplicationContext(),
						LastRecordWeight.class);
				startActivity(i);
			}
		}
		
		return true;
	}

	public void onRadioButtonClicked(View view) {
		// Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();

		// Check which radio button was clicked
		switch (view.getId()) {
		case R.id.rBtnF:
			if (checked)
				newSex = 'F';
			break;
		case R.id.rBtnM:
			if (checked)
				newSex = 'M';
			break;
		}
	}

	private void atualizarLista() {
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, getLastRecords());
		lvLastRecords.setAdapter(adapter);
	}

	@Override
	protected void onResume() {
		super.onResume();
		
		atualizarLista();
	}
	
	public ArrayList<String> getLastRecords(){
		
		lastRecords = new ArrayList<String>();
		lastRecords.add("Glucose:\n" + q.getListGlucose().getLast().toString());
		lastRecords.add("Blood Pressure:\n"
				+ q.getListBloodPressure().getLast().toString());
		lastRecords.add("Activity:\n"
				+ q.getListActivity().getLast().toString());
		lastRecords.add("BMI:\n" + q.getListBmi().getLast().toString());
		lastRecords
				.add("Body Fat:\n" + q.getBodyFatList().getLast().toString());
		lastRecords.add("Heart Rate:\n"
				+ q.getHeartRateList().getLast().toString());
		lastRecords.add("Weight: \n" + q.getListWeight().getLast().toString());
		
		return lastRecords;
	}
}
