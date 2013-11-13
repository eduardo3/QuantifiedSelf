package com.example.qauntifiedself.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class GlucoseList implements Serializable{
	private Glucose g;
	/**
	 * 
	 */
	private static final long serialVersionUID = -7582002328708258220L;

	private LinkedList<Glucose> glucoseList;
	
	public GlucoseList ()
	{
		glucoseList=new LinkedList<Glucose>();
	}
	
	public void add(Glucose g)
	{
		glucoseList.add(g);
	}
	
	public List<Glucose> pesquisar(Date pesquisar) {
		ArrayList<Glucose> novaLista = new ArrayList<Glucose>();
		for (Glucose g : glucoseList) {
			if (g.getTime().equals(pesquisar))
			novaLista.add(g);
		}
		return novaLista;
	}
	
	public void remove(Glucose g) {

		glucoseList.remove(g);

	}
	public List<Glucose> getAll() {
		return glucoseList;
	}
	
	public int count()
	{
		return glucoseList.size();
	}
	
	public Glucose getLast()
	{
		g = glucoseList.getLast();
		return g;
	}

	
	public Glucose getElments(int i )
	{
		Glucose g = glucoseList.get(i);
		return g;
	}
	
	
}
