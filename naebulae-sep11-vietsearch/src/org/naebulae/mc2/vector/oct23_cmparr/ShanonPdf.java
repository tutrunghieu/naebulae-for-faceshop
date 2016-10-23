package org.naebulae.mc2.vector.oct23_cmparr;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.naebulae.mc2.vector.Sampler1970;
import org.naebulae.mc2.vector.UniformVocab;

public class ShanonPdf extends Sampler1970
{

	public List<String> previous;
	
	public Map<String, Double> items = new TreeMap<String, Double>();

	public void add(String v)
	{
		Double ck = items.get(v);
		items.put(v, ck==null ? 1 : ck+1);
	}
	
	public void normalize() 
	{
		double v = 0;
		
		for(String sk: items.keySet()) v += items.get(sk);
		if(v==0) v = 1;
			
		for(String sk: items.keySet())
		{
			double vk = items.get(sk);
			items.put(sk, vk/v);
		}	
		
	}

	public String nextWord() 
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
