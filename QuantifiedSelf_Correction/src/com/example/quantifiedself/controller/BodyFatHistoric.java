package com.example.quantifiedself.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.qauntifiedself.model.BodyFat;
import com.example.qauntifiedself.model.BodyFatList;
import com.example.qauntifiedself.model.QuantifiedSelf;
import com.example.quantifiedself.R;

public class BodyFatHistoric extends Activity {

	private ListView lv;
	private QuantifiedSelf q;
	private ArrayAdapter<BodyFat>adaptador;
	private BodyFatList list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_body_fat_historic);
		q = QuantifiedSelf.getInstance();
		list= q.getBodyFatList();
		atualizarLista();
	
	}

	private void atualizarLista() {
		lv = (ListView) findViewById(R.id.lvBf);
		adaptador = new ArrayAdapter<BodyFat>(this,android.R.layout.simple_list_item_1,list.getAll());
		lv.setAdapter(adaptador);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.body_fat_historic, menu);
		return true;
	}

}
