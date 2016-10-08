package org.naebulae.mc2.catseq.demo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.naebulae.util.System2;

public class CorpusUtils 
{
	public static Map<String[], Map<String, Double>> buildLangModel2(String[] corpus, int kpar) 
	{
		Map<String[], Map<String, Double>> res = new TreeMap<String[], Map<String, Double>>(new ComparatorForStringArray());
		
		for(String ck: corpus)
		{
			System.out.println(ck);
			addLine2(res, ck.split("\\s+"), kpar);			
		}
		
		return normalize2(res);
	}
	
	private static void addLine2(Map<String[], Map<String, Double>> res, String[] words, int kpar) 
	{
		for(int k=0; k<words.length; k++)
		{
			String[] pk = getLast(words, k, kpar);
			String wk = words[k];
			
			Map<String, Double> mk = res.get(pk);
			if(mk == null) res.put(pk, mk = new LinkedHashMap<String, Double>());
			
			Double cj = mk.get(wk);
			mk.put(wk, cj==null ? 1 : cj+1);
		}
		
		return;
	}
	
	
	public static Map<String[], Map<String, Double>> normalize2(Map<String[], Map<String, Double>> res) 
	{
		for(String[] w1: res.keySet())
		{
			Map<String, Double> r1 = res.get(w1);
			
			double s1 = 0;
			
			for(String w2: r1.keySet()) {
				s1 += r1.get(w2);
			}
			
			for(String w2: r1.keySet()) 
			{
				double s2 = r1.get(w2);
				r1.put(w2, s2/s1);												
			}
		}
		
		return res;
	}
	
	
	public static Map<String, Map<String, Double>> buildLangModel(String[] corpus) 
	{
		Map<String, Map<String, Double>> res = new LinkedHashMap<String, Map<String, Double>>();
		
		for(String ck: corpus)
		{
			System.out.println(ck);
			addLine(res, ck.split("\\s+"));			
		}
		
		return normalize(res);
	}

	public static Map<String, Map<String, Double>> normalize(Map<String, Map<String, Double>> res) 
	{
		for(String w1: res.keySet())
		{
			Map<String, Double> r1 = res.get(w1);
			
			double s1 = 0;
			
			for(String w2: r1.keySet()) {
				s1 += r1.get(w2);
			}
			
			for(String w2: r1.keySet()) 
			{
				double s2 = r1.get(w2);
				r1.put(w2, s2/s1);												
			}
		}
		
		return res;
	}

	private static void addLine(Map<String, Map<String, Double>> res, String[] words) 
	{
		for(int k=0; k<words.length; k++)
		{
			String pk = (k==0 ? "" : words[k-1]);
			String wk = words[k];
			
//			System.out.println("Adding " + pk + " -- " + wk);
			
			Map<String, Double> mk = res.get(pk);
			if(mk == null) res.put(pk, mk = new LinkedHashMap<String, Double>());
			
			Double cj = mk.get(wk);
			mk.put(wk, cj==null ? 1 : cj+1);
		}
		
		return;
	}

	public static String[] getLast(List<Object> items, int kpar) 
	{
		int right = items.size();
		int left = Math.max(0, right-kpar);
		
		List<String> res = new ArrayList<String>();
		
		for(int k=left; k<right; k++)
		{
			Object vk = items.get(k); 
			res.add(vk==null ? null : vk.toString());
		}
		
		return res.toArray(new String[] {});		
	}

	public static String[] getLast(String[] items, int from, int kpar) 
	{
		int right = from;
		int left = Math.max(0, from-kpar);
		
		List<String> res = new ArrayList<String>();
		
		for(int k=left; k<right; k++)
		{
			Object vk = items[k]; 
			res.add(vk==null ? null : vk.toString());
		}
		
		return res.toArray(new String[] {});		
	}

	public static void printLangModel(Map<String[], Map<String, Double>> mat) 
	{
		
		for(String[] mk: mat.keySet())
		{
			System.out.println("============= " + System2.join(mk) );
			System.out.println(mat.get(mk));
		}
		
	}
}
