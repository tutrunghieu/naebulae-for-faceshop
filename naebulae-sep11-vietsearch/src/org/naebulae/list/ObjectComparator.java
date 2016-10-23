package org.naebulae.list;

import java.util.Comparator;

public class ObjectComparator implements Comparator<Object[]>
{
	@Override
	public int compare(Object[] a, Object[] b) 
	{
		int n = Math.min(a.length, b.length);
		
		for(int k=0; k<n; k++)
		{
			String ak = (String)a[k];
			String bk = (String)b[k];
			int dk = ak.compareTo(bk);
			if(dk != 0) return dk;
		}
		
		return a.length - b.length;
	}

}
