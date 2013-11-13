package com.example.qauntifiedself.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class HeartRateList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4111908345028210667L;

	private LinkedList<HeartRate> listHeartRate;
	
	public HeartRateList()
	{
		listHeartRate= new LinkedList<HeartRate>();
	}
	
	public void add(HeartRate h)
	{
		listHeartRate.add(h);
	}
	
	public List<HeartRate> pesquisar(Date pesquisar) {
		ArrayList<HeartRate> novaLista = new ArrayList<HeartRate>();
		for (HeartRate h : listHeartRate) {
			if (h.getTime().equals(pesquisar))
			novaLista.add(h);
		}
		return novaLista;
	}
	
	public void remove(HeartRate h) {

		listHeartRate.remove(h);

	}
	public List<HeartRate> getAll() {
		return listHeartRate;
	}
	public HeartRate getLast()
	{
		HeartRate hr = listHeartRate.getLast();
		return hr;
	}
}
