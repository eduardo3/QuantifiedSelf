package com.example.qauntifiedself.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BodyFatList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1064494993469900744L;

	private LinkedList<BodyFat> listBodyFat;
	
	public BodyFatList ()
	{
		listBodyFat = new LinkedList<BodyFat>();
		
	}
	
	public void add(BodyFat bf)
	{
		listBodyFat.add(bf);
		
	}
	
	public void remove (BodyFat bf)
	{
		listBodyFat.add(bf);
	}
	
	public List<BodyFat> getAll()
	{
		return listBodyFat;
	}
	
	public List<BodyFat> pesquisar(Date pesquisar) {
		ArrayList<BodyFat> novaLista = new ArrayList<BodyFat>();
		for (BodyFat bf : listBodyFat) {
			if ((bf.getTime()).equals(pesquisar))
			novaLista.add(bf);
		}
		return novaLista;
	}
	
	public BodyFat getLast()
	{
		BodyFat bf = listBodyFat.getLast();
		return bf;
	}
}
