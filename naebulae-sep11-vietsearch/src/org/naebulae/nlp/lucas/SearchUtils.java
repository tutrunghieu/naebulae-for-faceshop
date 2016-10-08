package org.naebulae.nlp.lucas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.bson.Document;

import com.mongodb.client.FindIterable;

public class SearchUtils
{
	public static List<ScoreDocument> findNearest(String q, FindIterable<Document> docs, int kpar, ScoringFunc func) 
	{
		if(kpar < 0) kpar = Integer.MAX_VALUE; 
		
		Map<Double, List<ScoreDocument>> G = new TreeMap<Double, List<ScoreDocument>>(Collections.reverseOrder());
		
		for(Document dk: docs)
		{
			double sk = func.similarScore(q, dk);
			
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
	
	/**
	 * Matching q with each dj in docs using scoring function func
	 * @param q
	 * @param docs
	 * @param kpar
	 * @param func
	 * @return
	 */
	public static List<ScoreDocument> findNearest(String q, List<Document> docs, int kpar, ScoringFunc func) 
	{
		if(kpar < 0) kpar = Integer.MAX_VALUE; 
		
		Map<Double, List<ScoreDocument>> G = new TreeMap<Double, List<ScoreDocument>>(Collections.reverseOrder());
		
		for(Document dk: docs)
		{
			double sk = func.similarScore(q, dk);
			
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

	public static void print(List<ScoreDocument> items) 
	{
		for(ScoreDocument ik: items)
		{
			System.out.println(ik.score + ": " + ik.document);
		}			
		
		return;
	}


}
