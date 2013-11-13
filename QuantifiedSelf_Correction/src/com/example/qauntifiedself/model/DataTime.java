package com.example.qauntifiedself.model;

import java.io.Serializable;
import java.util.Date;

public class DataTime extends DataUnits implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3173573855810117097L;
	protected Date time;
	public DataTime() {
		super();
	}


	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}