package org.naebulae.mc2.vector;

import java.util.ArrayList;
import java.util.List;

public class Sampler1970 
{
	public double nextBaseDouble()
	{
		return Math.random();
	}
	
	public<T> T takeOne(List<T> items)
	{
		int k = (int)(nextBaseDouble()*items.size());
		return items.get(k);
	}

	
	public<T> T takeOne(T[] items)
	{
		int k = (int)(nextBaseDouble()*items.length);
		return items[k];
	}
	
	public static<T1> List<T1> nextList(int n, RandAction<T1> lf) 
	{
		List<T1> res = new ArrayList<T1>();
		
		for(int k=0; k<1000; k++)
		{
			T1 vk = lf.invokeRandAction();
			res.add(vk);
		}
		
		return res;
	}

}
