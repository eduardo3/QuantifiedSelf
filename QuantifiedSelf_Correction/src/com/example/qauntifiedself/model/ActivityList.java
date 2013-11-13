package com.example.qauntifiedself.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ActivityList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8930101182203503797L;

	private LinkedList<Activity_> listActivities;
	
	public ActivityList()
	{
		listActivities = new LinkedList<Activity_>();
	}
	
	public void add(Activity_ a)
	{
		listActivities.add(a);
	}
	
	public List<Activity_> pesquisar(String pesquisar) {
		ArrayList<Activity_> novaLista = new ArrayList<Activity_>();
		for (Activity_ a : listActivities) {
			if (a.getType().contains(pesquisar));
			novaLista.add(a);
		}
		return novaLista;
	}
	
	public void remove(DataUnits a)
	{
		listActivities.remove(a);
	}
	
	public List<Activity_> getAll()
	{
		return listActivities;
	}
	
	public Activity_ getLast()
	{
		Activity_ a = listActivities.getLast();
		return a;
	}
	
}
