package org.naebulae.mc2.vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.naebulae.list.ObjectComparator;
import org.naebulae.util.Joiner;
import org.naebulae.util.List2;

public class ShannonSampler 
{
	protected int len1;
	protected int len2;
	
	protected Map<Object[], CatDist> items 
		= new TreeMap<Object[], CatDist>(new ObjectComparator());
	protected int grams = 2;
	protected boolean debug = false; 
	
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
		List<String> res = new ArrayList<String>();
		
		for(int n=nextVectorLen(), k=0; k<n; k++)
		{
			if(debug) System.out.println("-----" + k);
			
			int sk = Math.max(res.size()-grams, 0);
			int ek = Math.min(sk + grams, k);
			List<String> cur = res.subList(sk, ek);
			if(debug) System.out.println("ctx: " + cur);
			
			CatDist pk = nextCategoricalDist(cur.toArray());
			if(debug) System.out.println("dist: " + pk);
			if(pk==null) break;

			String wk = (String)pk.nextCategory();
			if(debug) System.out.println("word: " + wk);
			
			res.add(wk);
		}
		
		return new McString<String>(res);
	}

	public void addSentence(String s) 
	{
		int g = grams;
		
		List<String> words = Arrays.asList(s.split("\\s+"));
		
		for(int nk=words.size(), k=0; k<nk; k++)
		{
			int sk = Math.max(0, k-g); 
			int ek = Math.min(sk+g, k); 
			List<String> pk = words.subList(sk, ek);
//			System.out.println("Prefix " + pk);
			
			CatDist ck = getCatDistForPrefix(pk);
			ck.addCategory(words.get(k));
		}
	
		
	}

	private CatDist getCatDistForPrefix(List<String> pk) 
	{
		Object[] arr = pk.toArray();
		
		CatDist ck = items.get(arr);
		if(ck == null) items.put(arr, ck = new CatDistMap());
		
		return ck;
	}

	public void normalize() 
	{
		for(CatDist ik: items.values()) ik.normalize();
	}

	public void print() 
	{
		for(Object[] ik: items.keySet()) 
		{
			System.out.println("=========[" + Joiner.start(" ").joinArrObj(ik) + "]");
			System.out.println(items.get(ik));
		}
		
		return;
	}

	public void setGrams(int arg)
	{
		grams = arg;
	}
}
