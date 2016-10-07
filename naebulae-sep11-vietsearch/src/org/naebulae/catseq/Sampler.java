package org.naebulae.catseq;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public abstract class Sampler<T> 
{
	public static Random coin197 = new Random(197);
	
	public int nextSequenceLength()
	{
		return 100;
	}
	
	public Object nextSequenceCategory(int k, Object pref) 
	{
		return null;
	}

	public double nextDouble()
	{
		return Math.random();
	}
	
	
	public T nextObject()
	{
		return null;
	}
	
	public int nextInteger(int len)
	{
		return (int) Math.floor(len * nextDouble());
	}
	
	public List<T> nextObjectList(int n)
	{
		List<T> res = new ArrayList<T>();
		for(int k=0; k<n; k++) res.add(nextObject());
		return res;
	}
	
	public Set<T> nextObjectSet(int n)
	{
		Set<T> res = new LinkedHashSet<T>();
		for(int k=0; k<n; k++) res.add(nextObject());
		return res;
	}
	
	public T[] nextObjectArray(int n, Class<T[]> cl)
	throws Exception
	{
		T[] res = cl.newInstance();
		for(int k=0; k<n; k++) res[k] = nextObject();
		return res;
	}
	
	public<T1> T1 pickItem(List<T1> items)
	{
		int rk = nextInteger(items.size());
		return items.get(rk);
	}
	
	public<T1> T1 pickItem(Set<T1> items)
	{
		int k=0, rk = nextInteger(items.size());
		for(T1 ik: items) if(k++ == rk) return ik;
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public<T1> T1 pickItem(T1... items)
	{
		int rk = nextInteger(items.length);
		return items[rk];
	}
	
	public<T1> T1 pickItem(Map<T1, Double> items)
	{
		double s = 0, r = nextDouble();
		for(T1 ik: items.keySet())
		{
			s += items.get(ik);
			if(r < s) return ik;
		}
		
		return null;
	}

	
}
