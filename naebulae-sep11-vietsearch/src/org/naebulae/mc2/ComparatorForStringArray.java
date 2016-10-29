package org.naebulae.mc2;

import java.util.Comparator;

public class ComparatorForStringArray implements Comparator<String[]> 
{
	@Override
	public int compare(String[] a, String[] b) 
	{
		int n = Math.min(a.length, b.length);
		
		for(int k=0; k<n; k++)
		{
			int dk = a[k].compareTo(b[k]);
			if(dk != 0) return dk;
		}

		return a.length - b.length;
	}

}
