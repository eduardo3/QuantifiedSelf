package com.example.quantifiedself.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.qauntifiedself.model.Activity_;
import com.example.qauntifiedself.model.QuantifiedSelf;
import com.example.quantifiedself.R;

@SuppressLint("SimpleDateFormat")
public class ActivityNew extends DateFormat {
	private EditText editEndT;
	private EditText editStartT;
	private EditText editType;
	private EditText editCal;
	private QuantifiedSelf q;
	private Button btnSave;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_new);
	
		q = QuantifiedSelf.getInstance();
		editEndT = (EditText) findViewById(R.id.edTime);
		editStartT = (EditText) findViewById(R.id.edValue);
		editCal = (EditText) findViewById(R.id.edCal);
		editType = (EditText) findViewById(R.id.edType);
		btnSave = (Button) findViewById(R.id.btnSave);
	
		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				int calories = Integer.parseInt(editCal.getText().toString().trim());
				Date timeEnd = transformDate(editEndT.getText().toString().trim(), ActivityNew.this);
				Date timeS = transformDate(editStartT.getText().toString().trim(),ActivityNew.this);
				boolean isAfter = isDateAfter(editStartT.getText().toString().trim(), editEndT.getText().toString().trim());
				if(isAfter)
				{
					Activity_ a = new Activity_(timeS,timeEnd,editType.getText().toString(),calories,"Kcal");
					q.getListActivity().add(a);
				}
				
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
	public Boolean isDateAfter(String dateI, String dateE) {

		try {
		
			String dateStr =  "dd/MM/yyyy HH:mm";
	        SimpleDateFormat df = new SimpleDateFormat(dateStr);
	            Date date1 = df.parse(dateE);
	            Date startingDate = df.parse(dateI);
				if (date1.after(startingDate))
	                return true;
	            else
	                return false;
	        }
			catch (java.text.ParseException e) {
				e.printStackTrace();
			}

		return false;
	}
	
}
