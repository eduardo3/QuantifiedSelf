package com.example.quantifiedself.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.qauntifiedself.model.HeartRate;
import com.example.qauntifiedself.model.HeartRateList;
import com.example.qauntifiedself.model.QuantifiedSelf;
import com.example.quantifiedself.R;

public class HeartRateHistoric extends Activity {

	private QuantifiedSelf q;
	private ListView lv;
	private ArrayAdapter<HeartRate> adaptador;
	private HeartRateList list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_heart_rate_historic);
		q = QuantifiedSelf.getInstance();
		list = q.getHeartRateList();
		atualizarLista();

	}

	private void atualizarLista() {
		lv = (ListView) findViewById(R.id.lvHr);
		adaptador = new ArrayAdapter<HeartRate>(this,android.R.layout.simple_list_item_1, list.getAll());
		lv.setAdapter(adaptador);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.heart_rate_historic, menu);
		return true;
	}

}
