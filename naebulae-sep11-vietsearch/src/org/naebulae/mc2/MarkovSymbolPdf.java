package org.naebulae.mc2;

import java.util.Map;
import java.util.TreeMap;

import org.naebulae.mc2.vector.Sampler1970;

public class MarkovSymbolPdf extends Sampler1970
{
	private String markName;
	private Map<String, Double> items = new TreeMap<String, Double>();

	public String toString()
	{
		return markName;
	}

	public MarkovSymbolPdf(String name, String... args) 
	{
		markName = name;
		for(String ak: args)
		{
			Double dk = items.get(ak);
			items.put(ak, dk==null ? 1 : dk+1);
		}
		
		double s = Math.max(1, args.length);
		
		for(String ak: args)
		{
			Double dk = items.get(ak);
			items.put(ak, dk/s);
		}
		
		return;
	}

	public String getName() 
	{
		return markName;
	}

	public String nextMarkovSymbol() 
	{
		double r = nextBaseDouble(), s = 0;
		
		for(String wk: items.keySet())
		{
			s += items.get(wk);
			if(r < s) return wk;
		}
		
		return null;
	}

}
