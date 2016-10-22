package org.naebulae.mc2.vector;

import java.util.LinkedHashMap;
import java.util.Map;

public class CatDistMap extends Sampler1970 implements CatDist 
{
	protected Map<Object, Double> p = new LinkedHashMap<Object, Double>();
	
	public String toString()
	{
		return p.toString();
	}

	public CatDistMap(String[] words)
	{
		for(String wk: words)
		{
			Double ck = p.get(wk);
			p.put(wk, ck==null? 1 : ck+1);
		}

		double s = 0;
		for(Object wk: p.keySet())
		{
			s += p.get(wk);
		}
		for(Object wk: p.keySet())
		{
			p.put(wk, p.get(wk)/s);
		}
		
		return;
	}

	@Override
	public Object nextCategory() 
	{
		double r = nextBaseDouble(), s = 0;
		
		for(Object wk: p.keySet())
		{
			s += p.get(wk);
			if(r < s) return wk;
		}
		
		return null;
	}

}
