package org.naebulae.mc2.vector;

import java.util.ArrayList;
import java.util.List;

public class McString<T> 
{
	protected List<T> items = new ArrayList<T>();
	
	public McString() 
	{
	}
	
	public McString(List<T> res) 
	{
		items = res;
	}

	public void add(T s)
	{
		items.add(s);
	}
	
	public int size()
	{
		return items.size();
	}
	
	public T get(int k)
	{
		return items.get(k);
	}
	
	public String toString()
	{
		StringBuilder res = new StringBuilder();
		
		for(int k=0; k<items.size(); k++)
		{
			T ik = items.get(k);
			if(k>0) res.append(" ");
			res.append(ik);
		}
		
		return res.toString();
	}

}
