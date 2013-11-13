package com.example.qauntifiedself.model;

import android.annotation.SuppressLint;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BMI extends DataTime implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double value;
	public BMI(double value, String units, Date time){
		this.value = value;
	}
	
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	@SuppressLint("SimpleDateFormat")
	public String toString()
	{
	 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	 String d = formatter.format(time);
	
	 return "Date: "+d +"\n"+ "Value: "+value+" "+units;
	}
	
}
