package org.naebulae.util;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Jaccard {

	public static Map<String, Double> getWordHist(String str) 
	{
		
		Map<String, Double> res = new TreeMap<String, Double>();
		
				
		for(String wk: str.split("\\s+"))
		{
			Double ck = res.get(wk);
			res.put(wk, ck==null ? 1 : ck+1);
		}
		
//		System.out.println("input: " + str);
//		System.out.println("output: " + res);
		return res;
	}

	public static double jaccardScore(Map<String, Double> A, Map<String, Double> B)
	{
		Set<String> U = new TreeSet<String>();
		
		U.addAll(A.keySet());
		U.addAll(B.keySet());
		
		double c = 0, s = 0;
		for(String uk: U)
		{
			Double ak = A.get(uk);
			if(ak == null) ak = 0d;
			
			Double bk = B.get(uk);
			if(bk == null) bk = 0d;
			
			c += Math.min(ak, bk);
			s += Math.max(ak, bk);
		}
		
		if(s==0) s = 1;
		return c/s;
	}

	public static<T1> double jaccardScore(Map<T1, Double> h, double d) 
	{
		double a = 0, b = 0;
		
		for(T1 nj: h.keySet())
		{
			Double vj = h.get(nj);
			a += Math.min(vj, d);
			b += Math.max(vj, d);
		}

		return a/(b==0 ? 1 : b);
	}


}
