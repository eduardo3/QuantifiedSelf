package com.example.quantifiedself.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.qauntifiedself.model.BloodPressure;
import com.example.qauntifiedself.model.BloodPressureList;
import com.example.qauntifiedself.model.QuantifiedSelf;
import com.example.quantifiedself.R;

public class BloodPressure_Historic extends Activity {
	
	private ListView lv;
	private QuantifiedSelf q;
	private ArrayAdapter<BloodPressure>adaptador;
	private BloodPressureList list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_blood_pressure__historic);
	
		q = QuantifiedSelf.getInstance();
		list= q.getListBloodPressure();
		atualizarLista();
	
	}

	private void atualizarLista() {
		lv = (ListView) findViewById(R.id.lvBp);
		adaptador = new ArrayAdapter<BloodPressure>(this,android.R.layout.simple_list_item_1,list.getAll());
		lv.setAdapter(adaptador);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.blood_pressure__historic, menu);
		return true;
	}

}
