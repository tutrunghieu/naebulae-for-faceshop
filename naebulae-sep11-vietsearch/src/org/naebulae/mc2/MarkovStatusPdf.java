package org.naebulae.mc2;

import java.util.LinkedHashMap;
import java.util.Map;

import org.naebulae.mc2.vector.Sampler1970;

public class MarkovStatusPdf extends Sampler1970
{
	protected Map<MarkovSymbolPdf, Double> items = new LinkedHashMap<MarkovSymbolPdf, Double>();
	
	public String toString()
	{
		return items.toString();
	}
	
	public void add(MarkovSymbolPdf wk)
	{
		Double ck = items.get(wk);
		items.put(wk, ck==null? 1 : ck+1);
	}

	public MarkovSymbolPdf nextMarkovStatus() 
	{
		double r = nextBaseDouble(), s = 0;
		
		for(MarkovSymbolPdf wk: items.keySet())
		{
			s += items.get(wk);
			if(r < s) return wk;
		}
		
		return null;
	}

	public void normalize() 
	{
		double s = 0;
		for(MarkovSymbolPdf wk: items.keySet())
		{
			s += items.get(wk);
		}
		
		for(MarkovSymbolPdf wk: items.keySet())
		{
			items.put(wk, items.get(wk)/s);
		}
		
		return;		
	}

}
