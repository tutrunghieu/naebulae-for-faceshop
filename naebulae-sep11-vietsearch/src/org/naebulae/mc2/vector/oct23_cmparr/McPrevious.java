package org.naebulae.mc2.vector.oct23_cmparr;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class McPrevious implements Comparable<McPrevious>
{
	protected List<Object> items = new ArrayList<Object>();
	
	public String toString()
	{
		return items.toString();
	}

	public McPrevious(Object... args)
	{
		for(Object ak: args) items.add(ak);
	}
	
	public int compare(McPrevious a, McPrevious b) 
	{
		int na = a.items.size(), nb = b.items.size();
		int n = Math.min(na, nb);
		
		for(int k=0; k<n; k++)
		{
			Object ak = items.get(k);
			String at = (ak==null ? "" : ak.toString());
			
			Object bk = items.get(k);
			String bt = (bk==null ? "" : ak.toString());			
			
			int dt = at.compareTo(bt);
			if(dt != 0) return dt;
		}
		
		return na - nb;
	}

	@Override
	public int compareTo(McPrevious b) 
	{
		McPrevious a = this;
		
		int na = a.items.size(), nb = b.items.size();
		int n = Math.min(na, nb);
		
		for(int k=0; k<n; k++)
		{
			Object ak = items.get(k);
			String at = (ak==null ? "" : ak.toString());
			
			Object bk = items.get(k);
			String bt = (bk==null ? "" : ak.toString());			
			
			int dt = at.compareTo(bt);
			if(dt != 0) return dt;
		}
		
		return na - nb;
	}

}
