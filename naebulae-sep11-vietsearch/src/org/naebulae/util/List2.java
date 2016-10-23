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

}
