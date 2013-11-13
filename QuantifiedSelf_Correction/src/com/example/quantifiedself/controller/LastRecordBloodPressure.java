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
import android.widget.Toast;

import com.example.qauntifiedself.model.QuantifiedSelf;
import com.example.quantifiedself.R;

public class LastRecordBloodPressure extends DateFormat{
	private EditText editValueD;
	private EditText editValueS;
	private EditText editTime;
	private QuantifiedSelf q;
	private Button btnSave;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_last_record_blood_pressure);
	
		q = QuantifiedSelf.getInstance();
		editValueD = (EditText) findViewById(R.id.edValueDLR);
		editValueS = (EditText) findViewById(R.id.edValueLR);
		editTime=(EditText) findViewById(R.id.edTimeLR);
		btnSave = (Button) findViewById(R.id.btnSave);
		
		
		String strValueD = Integer.toString(q.getListBloodPressure().getLast().getValueDias());
		String strValueS = Integer.toString(q.getListBloodPressure().getLast().getValueSys());
		
		editValueD.setText(strValueD);
		editValueS.setText(strValueS);
		editTime.setText(transformDate2(q.getListBloodPressure().getLast().getTime()));
		
		
		
		if((!(editTime.getContext().toString()=="")) && (!(editValueD.getText().toString()==""))
				&&(!(editValueS.getText().toString()=="")))
		{
		if(editValueS.getText().toString().contains("[a-zA-Z]"))
			Toast.makeText(this, "Valores Inseridos estão inválidos!\nExprimente algorismos", Toast.LENGTH_LONG).show();
	
		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
						
			
				
				String valueDs = editValueD.getText().toString().trim();
				String valueSs= editValueS.getText().toString().trim();
				int valueD = Integer.parseInt(valueDs);
				int valueS = Integer.parseInt(valueSs);
				Date time = transformDate(editTime.getText().toString().trim(),LastRecordBloodPressure.this);
				
				q.getListBloodPressure().getLast().setValueDias(valueD);
				q.getListBloodPressure().getLast().setValueSys(valueS);
				q.getListBloodPressure().getLast().setTime(time);
				
				finish();
			}
		
		});
		
	}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.blood_pressure_new, menu);
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
