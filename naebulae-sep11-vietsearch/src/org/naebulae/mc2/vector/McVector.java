package org.naebulae.mc2.vector;

import java.util.ArrayList;
import java.util.List;

public class McVector<T> 
{
	public List<T> symbols = new ArrayList<T>(); 
	
	public void add(T s)
	{
		symbols.add(s);
	}
	
	public int size()
	{
		return symbols.size();
	}
	
	public List<T> items()
	{
		return symbols;
	}

}
