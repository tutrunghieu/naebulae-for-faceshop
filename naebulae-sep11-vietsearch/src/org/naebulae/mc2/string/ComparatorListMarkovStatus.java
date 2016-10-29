package org.naebulae.mc2.string;

import org.naebulae.list.ComparatorList;

public class ComparatorListMarkovStatus extends ComparatorList<MarkovSymbolPdf>
{

	@Override
	public int compareItem(MarkovSymbolPdf a, MarkovSymbolPdf b) 
	{
		return a.getName().compareTo(b.getName());
	}

}
