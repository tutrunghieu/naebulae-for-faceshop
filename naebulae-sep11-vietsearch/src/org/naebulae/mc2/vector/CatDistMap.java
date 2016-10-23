package org.naebulae.mc2.vector;

import java.util.LinkedHashMap;
import java.util.Map;

public class CatDistMap extends Sampler1970 implements CatDist 
{
	protected Map<Object, Double> items = new LinkedHashMap<Object, Double>();
	
	public String toString()
	{
		return items.toString();
	}

	public CatDistMap()
	{
		
	}
	
	public CatDistMap(String[] words)
	{
		for(String wk: words)
		{
			Double ck = items.get(wk);
			items.put(wk, ck==null? 1 : ck+1);
		}

		double s = 0;
		for(Object wk: items.keySet())
		{
			s += items.get(wk);
		}
		for(Object wk: items.keySet())
		{
			items.put(wk, items.get(wk)/s);
		}
		
		return;
	}

	@Override
	public Object nextCategory() 
	{
		double r = nextBaseDouble(), s = 0;
		
		for(Object wk: items.keySet())
		{
			s += items.get(wk);
			if(r < s) return wk;
		}
		
		return null;
	}

	@Override
	public void addCategory(Object wk) 
	{
		Double ck = items.get(wk);
		items.put(wk, ck==null? 1 : ck+1);		
	}

	@Override
	public void normalize() 
	{
		double s = 0;
		for(Object wk: items.keySet())
		{
			s += items.get(wk);
		}
		for(Object wk: items.keySet())
		{
			items.put(wk, items.get(wk)/s);
		}
		
		return;		
	}

}
