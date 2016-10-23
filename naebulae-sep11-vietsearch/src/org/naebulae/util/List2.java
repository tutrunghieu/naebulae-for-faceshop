package org.naebulae.util;

import java.util.ArrayList;
import java.util.List;

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

}
