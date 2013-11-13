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

import com.example.qauntifiedself.model.QuantifiedSelf;
import com.example.quantifiedself.R;

public class LastRecordGlucose extends DateFormat {
	
	
	private QuantifiedSelf q;
	private Button btnSave;
	private EditText editValue;
	private EditText editTime;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_last_records);
		
		
		q = QuantifiedSelf.getInstance();
		editValue = (EditText) findViewById(R.id.edValueLR);
		editTime=(EditText) findViewById(R.id.edTimeLR);
		btnSave = (Button) findViewById(R.id.btnSave);
		
		String strValue = Integer.toString(q.getListGlucose().getLast().getValue());
		editValue.setText(strValue);
		editTime.setText(transformDate2(q.getListGlucose().getLast().getTime()));
		
		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
						
			
				
				int value = Integer.parseInt(editValue.getText().toString().trim());
				Date time = transformDate(editTime.getText().toString().trim(),LastRecordGlucose.this);
				
				q.getListGlucose().getLast().setValue(value);
				q.getListGlucose().getLast().setTime(time);
				
				finish();
			}
		
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.last_record_glucose, menu);
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
