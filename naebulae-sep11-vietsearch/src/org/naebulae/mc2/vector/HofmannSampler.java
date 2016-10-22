package org.naebulae.mc2.vector;

import java.util.LinkedHashMap;
import java.util.Map;

public class HofmannSampler extends Sampler1970
{
	protected int len1;
	protected int len2;
	
	protected Map<UniformVocab, Double> items = new LinkedHashMap<UniformVocab, Double>(); 
	
	public HofmannSampler(int a, int b) 
	{
		len1 = a;
		len2 = b;
	}
		
	public void add(double pj, UniformVocab Vj) 
	{
		items.put(Vj, pj);
	}
		
	public int nextVectorLen()
	{
		double t = Math.random();
		return (int)(t*len1 + (1-t)*len2);
	}
	
	public CatDist nextCategoricalDist(int k) 
	{
		double r = nextBaseDouble(), s = 0;
		
		for(UniformVocab sk: items.keySet())
		{
			s += items.get(sk);
			if(r < s) return sk;
		}
			
		return null;		
	}	

	public<T> McString<T> nextString(Class<T> cl) 
	throws Exception
	{
		McString<T> res = new McString<T>();
		
		for(int n=nextVectorLen(), k=0; k<n; k++)
		{
			CatDist pk = nextCategoricalDist(k);
			T wk = cl.cast( pk.nextCategory() );
			res.add(wk);
		}
		
		return res;
	}

	public void normalize() 
	{
		double v = 0;
		
		for(UniformVocab sk: items.keySet())
		{
			v += items.get(sk);
		}	
		for(UniformVocab sk: items.keySet())
		{
			double vk = items.get(sk);
			items.put(sk, vk/v);
		}	
	}
}
