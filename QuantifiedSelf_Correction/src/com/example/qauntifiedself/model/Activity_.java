package com.example.qauntifiedself.model;

import android.annotation.SuppressLint;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Activity_ extends DataUnits implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date startTime;
	private Date endTime;
	private String type;
	private int calories;
	public Activity_(Date startTime, Date endTime, String type, int calories, String units){
		this.startTime = startTime;
		this.endTime = endTime;
		this.type = type;
		this.calories = calories;
	}
	
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	@SuppressLint("SimpleDateFormat")
	public String toString()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String dend = formatter.format(endTime);
		String dstart = formatter.format(startTime);

		return "Start Time: "+dstart +"\n"+ "End Time: "+dend +"\n" + "Type: "+type+"\n"+
			"Calories: "+ calories + units;
	}
}
