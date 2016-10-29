package org.naebulae.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.naebulae.mc2.oct29_test_unif.XorDataRow;
import org.naebulae.mc2.vector.table.TypedAction;
import org.naebulae.mc2.vector.table.TypedMapper;

public class List2 {

	@SuppressWarnings("unchecked")
	public static<T> List<T> newList(T... args)
	{
		List<T> res = new ArrayList<T>();
		for(T ak: args) res.add(ak);
		return res;
	}

	public static<T1> List<T1> cast(List<Object> x, Class<T1> cl)
	{
		List<T1> res = new ArrayList<T1>();
		for(Object xk: x) res.add(cl.cast(xk));
		return res;
	}

	public static<T1> List<T1> tail(List<T1> res, int n) 
	{
		int ek = res.size();
		if(res==null || ek==0) return new ArrayList<T1>();
		
		int sk = Math.max(ek - n, 0); 
		return res.subList(sk, ek);
	}

	public static<T1> List<T1> slice(List<T1> words, int sk, int ek) 
	{
		if(words==null) return new ArrayList<T1>();		
		
		sk = Math.max(sk, 0);
		ek = Math.max(ek, 0);
		ek = Math.min(ek, words.size());
		
		return words.subList(sk, ek);
	}

	public static<T1> List<T1> sample(Class<T1> cl, int n, TypedAction<List<T1>> lf) 
	throws Exception
	{
		List<T1> res = new ArrayList<T1>();
		for(int k=0; k<n; k++) lf.invokeAction(res);
		return res;
	}

	public static Map<Double, Double> hist(List<Double> items, double x1, double x2, int n) 
	{
		Map<Double, Double> res = new TreeMap<Double, Double>();
		
		double x = x1, dx = Math.abs(x2 - x1)/n;
		
		for(int k=0; k<n; k++)
		{
			x += dx;
			res.put(x, 0d);
		}
		
		for(Double ik: items)
		for(Double vj: res.keySet())
		{
			if(ik<vj) { res.put(vj, res.get(vj)+1); break; }
		}
		
		
		return res;
	}

	public static<T1> Map<T1, Double> divide(Map<T1, Double> res, int size) 
	{
		for(T1 vj: res.keySet())
		{
			res.put(vj, res.get(vj)/size);
		}		
		
		return res;
	}

	public static<T1> void print(List<T1> items) 
	{
		for(T1 ik: items) System.out.println(ik);
	}

	public static<T1, T2> Map<T2, Double> hist(List<T1> items, TypedMapper<T1, T2> lf)
	throws Exception
	{
		Map<T2, Double> res = new TreeMap<T2, Double>();
		
		for(T1 ik: items)
		{
			T2 vk = lf.invokeAction(ik);
			Double ck = res.get(vk);
			res.put(vk, ck==null ? 1 : ck+1);
		}		
		
		return res;
	}

	public static<T1, T2> void print(Map<T1, T2> h)
	{
		for(T1 nj: h.keySet())
		{
			System.out.println(nj + " >> " + h.get(nj));
		}
	}

}
