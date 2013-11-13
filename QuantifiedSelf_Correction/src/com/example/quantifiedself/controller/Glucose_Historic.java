package com.example.quantifiedself.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.qauntifiedself.model.Glucose;
import com.example.qauntifiedself.model.GlucoseList;
import com.example.qauntifiedself.model.QuantifiedSelf;
import com.example.quantifiedself.R;

public class Glucose_Historic extends Activity {

	private QuantifiedSelf q;
	private ListView lv;
	private ArrayAdapter<Glucose> adaptador;
	private GlucoseList list;
	protected static final String NEW_GLUCOSE= "com.example.quantifiedself.controller.NEW_GLUCOSE";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_glucose);
		q = QuantifiedSelf.getInstance();
		list= q.getListGlucose();
		atualizarLista();
	
	}

	private void atualizarLista() {
		lv = (ListView) findViewById(R.id.lvGlucose);
		adaptador = new ArrayAdapter<Glucose>(this,android.R.layout.simple_list_item_1,list.getAll());
		lv.setAdapter(adaptador);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.glucose, menu);
		return true;
	}

}
