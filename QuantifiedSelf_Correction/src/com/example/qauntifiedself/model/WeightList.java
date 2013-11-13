package com.example.qauntifiedself.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class WeightList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2229239187213165740L;

	private LinkedList<Weight> listWeight;
	
	public WeightList()
	{
		listWeight=new LinkedList<Weight>();
	}
	
	public void add(Weight w)
	{
		listWeight.add(w);
	}
	
	public List<Weight> pesquisar(Date pesquisar) {
		ArrayList<Weight> novaLista = new ArrayList<Weight>();
		for (Weight w : listWeight) {
			if (w.getTime().equals(pesquisar))
			novaLista.add(w);
		}
		return novaLista;
	}
	
	public void remove(Weight g) {

		listWeight.remove(g);

	}
	public List<Weight> getAll() {
		return listWeight;
	}
	public Weight getLast()
	{
		Weight w = listWeight.getLast();
		return w;
	}
}
