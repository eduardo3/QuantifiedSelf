package com.example.qauntifiedself.model;

import android.annotation.SuppressLint;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Glucose extends DataTime implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int value;
	private String unit;
	public Glucose(int value, String unit, Date time){
		this.value = value;
	}
	
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	@SuppressLint("SimpleDateFormat")
	public String toString()
	{
	 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	 String d = formatter.format(time);
	
	 return "Date: "+d +"\n"+ "Value: "+value+" "+unit;
	}
}
