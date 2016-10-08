package org.naebulae.nlp.lucas;

import java.util.Map;

import org.bson.Document;
import org.naebulae.nlp.vietlang.VietlangUtils;

public class ScoringFuncStringDoc implements ScoringFunc 
{
	private String __q;
	private Map<String, Double> __q_set;
	private Document __dk;
	private Map<String, Double> __dk_set;
	
	public String[] fields = {};

	public ScoringFuncStringDoc(String... args) 
	{
		fields = args;
	}

	@Override
	public double similarScore(String q, Document dk) 
	{
		if(q != __q) __q_set = getQueryEntitySet(__q = q);
		if(dk != __dk) __dk_set = getStoredEntitySet(__dk = dk);

		return Jaccard.jaccardScore(__q_set, __dk_set);
	}
	
	public Map<String, Double> getQueryEntitySet(String q) 
	{
		q = q.trim().toLowerCase();
		return Jaccard.getWordHist(q);
	}	

	public Map<String, Double> getStoredEntitySet(Document d0) 
	{
		String res = "";
				
		for(String fj: fields) 
		{
			String dk = d0.getString(fj);
			
			 dk = VietlangUtils.removePunctuators(dk);
		     dk = VietlangUtils.detone(dk);
			 dk = dk.trim().toLowerCase();	
			
			 if(res.length() > 0) res += " ";
			 res += dk;
		}
		 
		return Jaccard.getWordHist(res);
	}


	
}
