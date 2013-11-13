package com.example.quantifiedself.controller;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.qauntifiedself.model.ActivityList;
import com.example.qauntifiedself.model.Activity_;
import com.example.qauntifiedself.model.QuantifiedSelf;
import com.example.quantifiedself.R;

public class Activity_Historic extends DateFormat {

	private QuantifiedSelf q;
	private ListView lv;
	private ArrayAdapter<Activity_> adaptador;
	private ActivityList list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_historic);
		q = QuantifiedSelf.getInstance();
		list = q.getListActivity();
		atualizarLista();

	}

	private void atualizarLista() {
		lv = (ListView) findViewById(R.id.listAct);
		adaptador = new ArrayAdapter<Activity_>(this,
				android.R.layout.simple_list_item_1, list.getAll());
		lv.setAdapter(adaptador);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity__historic, menu);
		return true;
	}

}
