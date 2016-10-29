package org.naebulae.util;

import java.util.Comparator;
import java.util.List;

public abstract class ComparatorList<T> implements Comparator<List<T>> 
{
	@Override
	public int compare(List<T> a, List<T> b) 
	{
		int na = a.size(), nb = b.size();
		
		for(int n=Math.min(na, nb), k=0; k<n; k++)
		{
			int dk = compareItem(a.get(k), b.get(k));
			if(dk != 0) return dk;
		}
		
		return na - nb;
	}

	public abstract int compareItem(T a, T b); 

}
