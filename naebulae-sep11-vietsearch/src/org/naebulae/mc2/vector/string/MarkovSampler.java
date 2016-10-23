package org.naebulae.mc2.vector.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.naebulae.mc2.vector.McString;
import org.naebulae.util.Joiner;

public class MarkovSampler 
{
	private Map<List<MarkovSymbolPdf>, MarkovStatusPdf> items 
	= new TreeMap<List<MarkovSymbolPdf>, MarkovStatusPdf>(new ComparatorListMarkovStatus());

	private int grams;

	protected int len1;
	protected int len2;
	
	public int nextVectorLen()
	{
		double t = Math.random();
		return (int)(t*len1 + (1-t)*len2);
	}
	
	protected boolean debug = false; 
	
	public MarkovSampler(int a, int b) 
	{
		len1 = a;
		len2 = b;
	}	
	
	public void setGrams(int g) 
	{
		grams = g;
	}

	public MarkovSymbolPdf addStatus(List<MarkovSymbolPdf> pref, MarkovSymbolPdf s) 
	{
		MarkovStatusPdf mk = items.get(pref);
		if(mk==null) items.put(pref, mk = new MarkovStatusPdf());
		
		mk.add(s);
		return s;
	}

	public void normalize() 
	{
		for(MarkovStatusPdf ik: items.values()) ik.normalize();		
	}

	public void print() 
	{
		for(List<MarkovSymbolPdf> ik: items.keySet()) 
		{
			System.out.println("========= " + Joiner.start(" ").joinArrObj(ik) + " ");
			System.out.println(items.get(ik));
		}
		
		return;		
	}

	public McString<String> nextString() 
	{
		List<MarkovSymbolPdf> st = new ArrayList<MarkovSymbolPdf>();
		List<String> res = new ArrayList<String>();
		
		for(int n=nextVectorLen(), k=0; k<n; k++)
		{
			if(debug) System.out.println("-----" + k);
			
			int sk = Math.max(res.size()-grams, 0);
			int ek = Math.min(sk + grams, k);
			List<MarkovSymbolPdf> cur = st.subList(sk, ek);
			if(debug) System.out.println("ctx: " + cur);
			
			MarkovStatusPdf pk = items.get(cur);
			if(pk==null) break;
			MarkovSymbolPdf sj = pk.nextMarkovStatus();
			if(sj==null) break;
			
			st.add(sj);
			if(debug) System.out.println("dist: " + pk);

			String wk = sj.nextMarkovSymbol();
			if(debug) System.out.println("word: " + wk);
			
			res.add(wk);
		}
		
		System.out.println(st);
		return new McString<String>(res);
	}

}
