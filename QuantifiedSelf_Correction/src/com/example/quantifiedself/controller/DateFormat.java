package com.example.quantifiedself.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.ParseException;
import android.widget.Toast;

public class DateFormat extends Activity {

	public DateFormat() {
		super();
	}

	@SuppressLint("SimpleDateFormat")
	public Date transformDate(String dateStr, Activity a ) {
	
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			try {
				Date finalDate = formatter.parse(dateStr);
				return finalDate;
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			     Toast.makeText(a, "WRONG DATE", Toast.LENGTH_LONG).show();
			}
	
		} catch (ParseException e) {
			e.printStackTrace();
			   Toast.makeText(a, "WRONG DATE", Toast.LENGTH_LONG).show();
		}
		return null;
	}

}