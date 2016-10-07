package org.naebulae.catseq;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Map2 
{
	public static<K1, V1> Map<K1, V1> newTreeMap(Class<K1> k1, Class<V1> v1, InitAction<Map<K1, V1>> lf) 
	{
		Map<K1, V1> res = new TreeMap<K1, V1>();
		lf.invokeInitAction(res);
		return res;
	}

	public static<K1, V1> Map<K1, V1> newLinkedHashMap(Class<K1> k1, Class<V1> v1, InitAction<Map<K1, V1>> lf) 
	{
		Map<K1, V1> res = new LinkedHashMap<K1, V1>();
		lf.invokeInitAction(res);
		return res;
	}
}
