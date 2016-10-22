package org.naebulae.mc2.vector;

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

}
