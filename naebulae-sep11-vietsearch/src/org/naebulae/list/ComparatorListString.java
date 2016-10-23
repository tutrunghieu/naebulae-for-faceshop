package org.naebulae.list;

public class ComparatorListString extends ComparatorList<String> 
{
	@Override
	public int compareItem(String a, String b) 
	{
		return a.compareTo(b);
	}

}
