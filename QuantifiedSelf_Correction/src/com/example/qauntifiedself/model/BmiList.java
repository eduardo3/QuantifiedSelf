package com.example.qauntifiedself.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BmiList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2684156464098493303L;

	public LinkedList<BMI> listBmi;
	
	public BmiList()
	{
		listBmi=new LinkedList<BMI>();
	}
	
	public void add(BMI bmi)
	{
		listBmi.add(bmi);
	}
	
	public void remove(DataTime bmi)
	{
		listBmi.remove(bmi);
	}
	
	public List<BMI> getAll()
	{
		return listBmi;
	}
	
	public List<BMI> pesquisar(Date pesquisar) {
		ArrayList<BMI> novaLista = new ArrayList<BMI>();
		for (BMI b : listBmi) {
			if (b.getTime().equals(pesquisar));
			novaLista.add(b);
		}
		return novaLista;
	}
	public BMI getLast()
	{
		BMI b = listBmi.getLast();
		return b;
	}
	
}
