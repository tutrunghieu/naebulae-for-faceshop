package org.naebulae.mc2.vector.oct23_cmparr;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.naebulae.list.ComparatorListString;

public class to_compare_two_arrays 
{

	public static void main(String[] args) 
	{
		Map<List<String>, Double> m = new TreeMap<List<String>, Double>(
				new ComparatorListString());
		m.put(Arrays.asList("a", "b"), 0d);
		m.put(Arrays.asList("a", "b", "d"), 0d);
		m.put(Arrays.asList("a", "b", "c"), 0d);
		m.put(Arrays.asList("c", "d"), 1d);
		m.put(Arrays.asList("c", "b", "a"), 1d);
		
		for(List<String> mk: m.keySet())
		{
			System.out.println(mk);
		}
		
//		
//		
//		McPrevious c1 = new McPrevious("a", "b", "c");
//		McPrevious c2 = new McPrevious("a", "b");
//		
//		Map<McPrevious, Double> m = new TreeMap<McPrevious, Double>();
//		m.put(c1, 0.0);
//		m.put(c2, 0.1);
//		
//		for(McPrevious mk: m.keySet())
//			System.out.println(mk + " >> " + m.get(mk));

	}

}
