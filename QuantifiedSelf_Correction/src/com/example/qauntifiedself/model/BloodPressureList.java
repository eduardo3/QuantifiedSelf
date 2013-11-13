package com.example.qauntifiedself.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BloodPressureList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4058710986019387581L;

	private LinkedList<BloodPressure> listBloodPressure;
	
	public BloodPressureList ()
	{
		listBloodPressure = new LinkedList<BloodPressure>();
	}
	
	public void add(BloodPressure bp)
	{
		listBloodPressure.add(bp);
	}
	public void remove (BloodPressure bp)
	{
		listBloodPressure.remove(bp);
		
	}
	
	public List<BloodPressure> pesquisar(Date pesquisar) {
		ArrayList<BloodPressure> novaLista = new ArrayList<BloodPressure>();
		for (BloodPressure bp : listBloodPressure) {
			if (bp.getTime().equals(pesquisar));
			novaLista.add(bp);
		}
		return novaLista;
	}
	
	public List<BloodPressure> getAll()
	{
		return listBloodPressure;
	}
	public BloodPressure getLast()
	{
		BloodPressure bp = listBloodPressure.getLast();
		return bp;
	}
	
}
