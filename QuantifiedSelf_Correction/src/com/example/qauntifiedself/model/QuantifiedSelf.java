package com.example.qauntifiedself.model;

import java.io.Serializable;
import java.util.Date;

public class QuantifiedSelf implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date birthDate;
	private char sex;
	private double height;
	private final GlucoseList listGlucose;
	private final ActivityList listActivity;
	private final BloodPressureList listBloodPressure;
	private final BmiList listBmi;
	private final BodyFatList bodyFatList;
	private final HeartRateList heartRateList;
	private final WeightList listWeight;
	
	private static QuantifiedSelf instance;

	
	
	private QuantifiedSelf(){
		birthDate = null;
		sex = ' ';
		height = 0;
		listGlucose = new GlucoseList();
		listActivity = new ActivityList();
		listBloodPressure = new BloodPressureList();
		listBmi = new BmiList();
		bodyFatList = new BodyFatList();
		heartRateList = new HeartRateList();
		listWeight  = new WeightList();
		

	}
	
	

	public static QuantifiedSelf getInstance()
	{
	
		if(instance == null)
			instance = new QuantifiedSelf();
		
		return instance;
	}
	
	public static void setInstance(QuantifiedSelf q)
	{
		instance = q;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}

	public GlucoseList getListGlucose() {
		return listGlucose;
	}
	

	public ActivityList getListActivity() {
		return listActivity;
	}

	public BloodPressureList getListBloodPressure() {
		return listBloodPressure;
	}

	public BmiList getListBmi() {
		return listBmi;
	}

	public BodyFatList getBodyFatList() {
		return bodyFatList;
	}

	public HeartRateList getHeartRateList() {
		return heartRateList;
	}

	public WeightList getListWeight() {
		return listWeight;
	}
	

}
