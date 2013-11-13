package com.example.quantifiedself.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.net.ParseException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.qauntifiedself.model.Activity_;
import com.example.qauntifiedself.model.QuantifiedSelf;
import com.example.quantifiedself.R;

public class LastRecordActivity extends DateFormat {
	private EditText editEndT;
	private EditText editStartT;
	private EditText editType;
	private EditText editCal;
	private QuantifiedSelf q;
	private Button btnSave;
	private Activity_ a;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_last_record_activity);
	
		q = QuantifiedSelf.getInstance();
		editEndT = (EditText) findViewById(R.id.edTime);
		editStartT = (EditText) findViewById(R.id.edValue);
		editCal = (EditText) findViewById(R.id.edCal);
		editType = (EditText) findViewById(R.id.edType);
		btnSave = (Button) findViewById(R.id.btnSave);	
		
		editEndT.setText(transformDate2(q.getListActivity().getLast().getEndTime()));
		editStartT.setText(transformDate2(q.getListActivity().getLast().getStartTime()));
		
		String strCal = Integer.toString(q.getListActivity().getLast().getCalories());
		
		editCal.setText(strCal);
		editType.setText(q.getListActivity().getLast().getType());
		
		
		
		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
						
				
				int calories = Integer.parseInt(editCal.getText().toString().trim());
				Date timeEnd = transformDate(editEndT.getText().toString().trim(),LastRecordActivity.this);
				Date timeS = transformDate(editStartT.getText().toString().trim(),LastRecordActivity.this);
				String type = editType.getText().toString();
				a = new Activity_(timeS,timeEnd,type,calories,"Kcal");
				
				q.getListActivity().getLast().setCalories(calories);
				q.getListActivity().getLast().setStartTime(timeS);
				q.getListActivity().getLast().setEndTime(timeEnd);
				q.getListActivity().getLast().setType(type);
				
				finish();
			}
		
		});
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_new, menu);
		return true;
	}
	@SuppressLint("SimpleDateFormat")
	public String transformDate2(Date d) {

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			
			String finalDate = formatter.format(d);
			
			return finalDate;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
