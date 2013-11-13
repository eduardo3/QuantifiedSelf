package com.example.quantifiedself.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.qauntifiedself.model.QuantifiedSelf;
import com.example.qauntifiedself.model.Weight;
import com.example.qauntifiedself.model.WeightList;
import com.example.quantifiedself.R;

public class WeightHistoric extends Activity {

	private QuantifiedSelf q;
	private ListView lv;
	private ArrayAdapter<Weight> adaptador;
	private WeightList list;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weight_historic);
		q = QuantifiedSelf.getInstance();
		list = q.getListWeight();
		atualizarLista();

	}

	private void atualizarLista() {
		lv = (ListView) findViewById(R.id.lvW);
		adaptador = new ArrayAdapter<Weight>(this,android.R.layout.simple_list_item_1, list.getAll());
		lv.setAdapter(adaptador);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.weight_historic, menu);
		return true;
	}

}
