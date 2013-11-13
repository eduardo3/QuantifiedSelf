package com.example.quantifiedself.controller;

public enum IndicatorEnum {

	PERSON(1), BLOOD_GLUCOSE(2), BLOOD_PRESSURE(3), BMI(4), BODY_FAT(5), HEART_RATE(
			6), WEIGHT(7), ACTIVITIES(8);
	
	private int value;

	private IndicatorEnum(int value) {
		this.value = value;
	}
	
	
}
