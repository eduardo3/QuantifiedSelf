package com.example.quantifiedself.controller;

import java.util.Date;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.qauntifiedself.model.BodyFat;
import com.example.qauntifiedself.model.QuantifiedSelf;
import com.example.quantifiedself.R;

public class BodyFatNew extends DateFormat {
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

		btnSave.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

					String valueS = editValue.getText().toString().trim();

					int value = Integer.parseInt(valueS);

					Date time = transformDate(editTime.getText().toString()
							.trim(),BodyFatNew.this);
					BodyFat g = new BodyFat(value, "percent", time);
					q.getBodyFatList().add(g);

					finish();

				
			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.glucose__new, menu);
		return true;
	}

}
