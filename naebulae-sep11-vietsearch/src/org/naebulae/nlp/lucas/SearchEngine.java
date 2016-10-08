package org.naebulae.nlp.lucas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.mongodb.client.FindIterable;

public abstract class SearchEngine<T> 
{
	
	
	
	public List<ScoreDocument> filterDocuments(T q, FindIterable<T> docs, int kpar) 
	{
		if(kpar < 0) kpar = Integer.MAX_VALUE; 
		
		Map<Double, List<ScoreDocument>> G = new TreeMap<Double, List<ScoreDocument>>(Collections.reverseOrder());
		
		for(T dk: docs)
		{
			double sk = similarScore(q, dk);
			
			List<ScoreDocument> lk = G.get(sk);
			if(lk == null) G.put(sk, lk = new ArrayList<ScoreDocument>());
			
			lk.add(new ScoreDocument(sk, dk));
		}
		
		List<ScoreDocument> res = new ArrayList<ScoreDocument>();
		for(Double sk: G.keySet())
		for(ScoreDocument dj: G.get(sk))
		{
			res.add(dj);
			if(res.size() >= kpar) break;
		}
		
		return res;
	}
	
	public List<ScoreDocument> filterDocuments(T q, Collection<T> docs, int kpar) 
	{
		if(kpar < 0) kpar = Integer.MAX_VALUE; 
		
		Map<Double, List<ScoreDocument>> G = new TreeMap<Double, List<ScoreDocument>>(Collections.reverseOrder());
		
		for(T dk: docs)
		{
			double sk = similarScore(q, dk);
			
			List<ScoreDocument> lk = G.get(sk);
			if(lk == null) G.put(sk, lk = new ArrayList<ScoreDocument>());
			
			lk.add(new ScoreDocument(sk, dk));
		}
		
		List<ScoreDocument> res = new ArrayList<ScoreDocument>();
		for(Double sk: G.keySet())
		for(ScoreDocument dj: G.get(sk))
		{
			res.add(dj);
			if(res.size() >= kpar) break;
		}
		
		return res;
	}
	
	public List<ScoreDocument> filterDocuments(T q, int kpar) 
	{
		if(kpar < 0) kpar = Integer.MAX_VALUE; 
		
		Map<Double, List<ScoreDocument>> G = new TreeMap<Double, List<ScoreDocument>>(Collections.reverseOrder());
		
		for(T dk: fetchStockedDocuments())
		{
			double sk = similarScore(q, dk);
			
			List<ScoreDocument> lk = G.get(sk);
			if(lk == null) G.put(sk, lk = new ArrayList<ScoreDocument>());
			
			lk.add(new ScoreDocument(sk, dk));
		}
		
		List<ScoreDocument> res = new ArrayList<ScoreDocument>();
		for(Double sk: G.keySet())
		for(ScoreDocument dj: G.get(sk))
		{
			res.add(dj);
			if(res.size() >= kpar) break;
		}
		
		return res;
	}

	public abstract double similarScore(T q, T dk);

	public abstract Collection<T> fetchStockedDocuments();

	public void print(List<ScoreDocument> items) 
	{
		for(ScoreDocument ik: items)
		{
			System.out.println(ik.score + ": " + ik.document);
		}		
	}



}
