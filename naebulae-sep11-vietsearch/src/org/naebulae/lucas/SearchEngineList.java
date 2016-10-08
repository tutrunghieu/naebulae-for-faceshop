package org.naebulae.lucas;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class SearchEngineList<T> extends SearchEngine<String> {

	private List<String> storedDocs;

	public SearchEngineList(List<String> docs) 
	{
		storedDocs = docs;
	}

	
	private String __q;
	private Map<String, Double> __q_set;
	private String __dk;
	private Map<String, Double> __dk_set;
	
	@Override
	public double similarScore(String q, String dk) 
	{
		if(q != __q) __q_set = getQueryEntitySet(__q = q);
		if(dk != __dk) __dk_set = getStoredEntitySet(__dk = dk);

		return Jaccard.jaccardScore(__q_set, __dk_set);
	}
	

	@Override
	public Collection<String> fetchStockedDocuments() 
	{
		return storedDocs;
	}	

	public Map<String, Double> getStoredEntitySet(String dk) 
	{
		 dk = VietlangUtils.removePunctuators(dk);
	     dk = VietlangUtils.detone(dk);
		 dk = dk.trim().toLowerCase();	
		 
		return Jaccard.getWordHist(dk);
	}

	public Map<String, Double> getQueryEntitySet(String q) 
	{
		q = q.trim().toLowerCase();
		return Jaccard.getWordHist(q);
	}


	public void clearBuffer() 
	{
		__q = null;
		__dk = null;				
	}


}
