package org.naebulae.util;

import java.util.ArrayList;
import java.util.List;

import gapp.xorcos.stat.Meanvar;

public class DataGroup 
{
	protected List<Object> items = new ArrayList<Object>();

	public void add(Object ik) 
	{
		items.add(ik);		
	}

	public double size() 
	{
		return items.size();
	}
	
	public String toString()
	{
		List<Double> x = List2.cast(items, Double.class);
		double x1 = Meanvar.min(x);
		double x2 = Meanvar.max(x);
		
		return this.size() + " : " + x1 + " : " + x2;
	}

}
