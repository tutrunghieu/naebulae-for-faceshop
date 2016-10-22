package org.naebulae.mc2.vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ShannonSampler 
{
	protected int len1;
	protected int len2;
	
	protected Map<Object[], CatDist> items 
		= new TreeMap<Object[], CatDist>(new ObjectComparator()); 
	
	public ShannonSampler(int a, int b) 
	{
		len1 = a;
		len2 = b;
	}
		
	public void add(Object[] cj, CatDist Vj) 
	{
		items.put(cj, Vj);
	}

		
	public int nextVectorLen()
	{
		double t = Math.random();
		return (int)(t*len1 + (1-t)*len2);
	}
	
	public CatDist nextCategoricalDist(Object[] arg) 
	{
		return items.get(arg);		
	}	
	
	public McString<String> nextString() 
	throws Exception
	{
		McString<String> res = new McString<String>();
		
		List<Object> cur = new ArrayList<Object>(); 
		
		for(int n=nextVectorLen(), k=0; k<n; k++)
		{
			System.out.println("----" + k);
			System.out.println("ctx " + cur);
			
			CatDist pk = nextCategoricalDist(cur.toArray());
			System.out.println("dist " + pk);
			if(pk==null) break;

			String wk = (String)pk.nextCategory();
			System.out.println("word " + wk);
			
			res.add(wk);
			
			cur.add(0, wk);
			if(cur.size() > 1) cur.remove(cur.size()-1);
		}
		
		return res;
	}

}
