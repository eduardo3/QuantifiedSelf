package com.example.quantifiedself.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.net.ParseException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qauntifiedself.model.QuantifiedSelf;
import com.example.qauntifiedself.model.Weight;
import com.example.quantifiedself.R;

public class WeightNew extends DateFormat {
	private EditText editValue;
	private EditText editTime;
	private QuantifiedSelf q;
	private Button btnSave;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new);
		q = QuantifiedSelf.getInstance();
		editTime = (EditText) findViewById(R.id.edTime);
		editValue = (EditText) findViewById(R.id.edValue);
		btnSave = (Button) findViewById(R.id.btnSave);
		if((!(editTime.getContext().toString()=="")) && (!(editValue.getText().toString()=="")))
		{
		if(editValue.getText().toString().contains("[a-zA-Z]"))
			Toast.makeText(this, "Valores Inseridos estão inválidos!\nExprimente algorismos", Toast.LENGTH_LONG).show();
	
		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
						
			
				String valueS = editValue.getText().toString().trim();
				int value = Integer.parseInt(valueS);
				Date time = transformDate(editTime.getText().toString().trim());
				Weight g = new Weight(value,"grams",time);
				q.getListWeight().add(g);
				
				finish();
			}
		
		});
		
	}
	}
		
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.glucose__new, menu);
		return true;
	}

	
	public Date transformDate(String dateStr) {

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			try {
				Date finalDate = formatter.parse(dateStr);

				return finalDate;
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
