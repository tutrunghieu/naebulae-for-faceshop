package org.naebulae.util.mongo;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CounterSet 
{
	private Map<String, Integer> map = new TreeMap<String, Integer>(); 

	public void increase(String string) 
	{
		Integer c = map.get(string);
		map.put(string, c==null ? 1 : c+1);
	}
	
	public Set<String> keySet()
	{
		return map.keySet();
	}
	
	public Integer value(String key)
	{
		return map.get(key);
	}

	public void print() 
	{
		System.out.println("------------");
		
		for(String k: map.keySet())
			System.out.println(k + ":" + map.get(k));
	}

	public Set<String> toSetString() 
	{
		Set<String> res = new LinkedHashSet<String>();
		for(String k: map.keySet()) res.add(k + ":" + map.get(k));
		return res;
	}
	
}
