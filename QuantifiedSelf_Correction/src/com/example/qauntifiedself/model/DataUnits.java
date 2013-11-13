package com.example.qauntifiedself.model;

import java.io.Serializable;

public class DataUnits implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 155429731145612155L;
	protected String units;

	public DataUnits() {
		super();
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

}