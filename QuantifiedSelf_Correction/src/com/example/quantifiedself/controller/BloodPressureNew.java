package com.example.quantifiedself.controller;

import java.util.Date;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qauntifiedself.model.BloodPressure;
import com.example.qauntifiedself.model.QuantifiedSelf;
import com.example.quantifiedself.R;

public class BloodPressureNew extends DateFormat {
	private EditText editValueD;
	private EditText editValueS;
		private EditText editTime;
	private QuantifiedSelf q;
	private Button btnSave;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_blood_pressure_new);
	
		q = QuantifiedSelf.getInstance();
		editValueD = (EditText) findViewById(R.id.edValueD);
		editValueS = (EditText) findViewById(R.id.edValue);
		editTime=(EditText) findViewById(R.id.edTime);
		btnSave = (Button) findViewById(R.id.btnSave);
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
				Date time = transformDate(editTime.getText().toString().trim(),BloodPressureNew.this);
				BloodPressure bp = new BloodPressure(valueS,valueD,"mg/dL",time);
				q.getListBloodPressure().add(bp);
				
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
}
