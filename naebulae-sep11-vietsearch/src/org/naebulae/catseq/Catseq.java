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

}
