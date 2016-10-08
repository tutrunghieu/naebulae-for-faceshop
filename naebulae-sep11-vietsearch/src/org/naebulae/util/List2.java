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

}
