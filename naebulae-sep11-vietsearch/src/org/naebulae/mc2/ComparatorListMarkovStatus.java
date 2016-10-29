package org.naebulae.mc2;

import org.naebulae.util.ComparatorList;

public class ComparatorListMarkovStatus extends ComparatorList<MarkovSymbolPdf>
{

	@Override
	public int compareItem(MarkovSymbolPdf a, MarkovSymbolPdf b) 
	{
		return a.getName().compareTo(b.getName());
	}

}
