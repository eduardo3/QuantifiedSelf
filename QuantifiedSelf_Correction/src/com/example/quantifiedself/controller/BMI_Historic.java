package com.example.quantifiedself.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.qauntifiedself.model.BMI;
import com.example.qauntifiedself.model.BmiList;
import com.example.qauntifiedself.model.QuantifiedSelf;
import com.example.quantifiedself.R;

public class BMI_Historic extends Activity {
	
	private ListView lv;
	private QuantifiedSelf q;
	private ArrayAdapter<BMI>adaptador;
	private BmiList list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bmi__historic);
		q = QuantifiedSelf.getInstance();
		list= q.getListBmi();
		atualizarLista();
	
	}

	private void atualizarLista() {
		lv = (ListView) findViewById(R.id.lvBmi);
		adaptador = new ArrayAdapter<BMI>(this,android.R.layout.simple_list_item_1,list.getAll());
		lv.setAdapter(adaptador);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bmi__historic, menu);
		return true;
	}

}
