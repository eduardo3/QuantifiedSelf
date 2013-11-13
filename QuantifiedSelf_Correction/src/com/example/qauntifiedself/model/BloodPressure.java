package com.example.qauntifiedself.model;

import android.annotation.SuppressLint;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BloodPressure extends DataUnits implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int valueSys;
	private int valueDias;
	private Date time;
	
	public BloodPressure(int valueSys, int valueDias, String units, Date time){
		this.valueSys = valueSys;
		this.valueDias = valueDias;
		this.time = time;
	}

	public int getValueSys() {
		return valueSys;
	}

	public void setValueSys(int valueSys) {
		this.valueSys = valueSys;
	}

	public int getValueDias() {
		return valueDias;
	}

	public void setValueDias(int valueDias) {
		this.valueDias = valueDias;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	@SuppressLint("SimpleDateFormat")
	public String toString()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String d = formatter.format(time);

		return "Date: "+d +"\n"+ "Value Systolic: "+ valueSys + units+"\n"+ "Value Diastolic: " + valueDias+
			units;
	}

	
	
}
