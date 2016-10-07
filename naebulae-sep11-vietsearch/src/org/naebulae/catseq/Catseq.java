package org.naebulae.catseq;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Catseq 
{
	protected List<Object> symbols = new ArrayList<Object>(); 

	public void add(Object cat)
	{
		symbols.add(cat);
	}
	
	public Object get(int k) 
	{
		return symbols.get(k);
	}
	
	public int size() 
	{
		return symbols.size();
	}

	public String getSymbolString() 
	{
		return getSymbolString(" ");
	}
	
	public List<Object> getListObject() 
	{
		return symbols;
	}	
	
	public Set<Object> getSetObject() 
	{
		Set<Object> res = new LinkedHashSet<Object>();
		res.addAll(symbols);
		return res;
	}	
	
	public String getSymbolString(String cm) 
	{
		String res = "";
		
		for(Object sk: symbols) 
		{
			if(res.length() > 0) res += cm;
			res += sk;
		}
		
		return res;
	}

	public String[] last(int kpar) 
	{
		List<String> res = new ArrayList<String>();
		
		int l=Math.max(0, symbols.size()-kpar);
		int r=Math.min(symbols.size(), l+kpar);
		
		for(int tt=l; tt<r; tt++)
		{
			res.add(symbols.get(tt).toString());
		}
		
		return res.toArray(new String[] {});
	}


}
