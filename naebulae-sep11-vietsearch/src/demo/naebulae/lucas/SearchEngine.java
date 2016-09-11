package demo.naebulae.lucas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class SearchEngine<T> 
{
	public List<RetrievedDocument> filterDocuments(T q, int kpar) 
	{
		if(kpar < 0) kpar = Integer.MAX_VALUE; 
		
		Map<Double, List<RetrievedDocument>> G = new TreeMap<Double, List<RetrievedDocument>>(Collections.reverseOrder());
		
		for(T dk: fetchStockedDocuments())
		{
			double sk = similarScore(q, dk);
			
			List<RetrievedDocument> lk = G.get(sk);
			if(lk == null) G.put(sk, lk = new ArrayList<RetrievedDocument>());
			
			lk.add(new RetrievedDocument(sk, dk));
		}
		
		List<RetrievedDocument> res = new ArrayList<RetrievedDocument>();
		for(Double sk: G.keySet())
		for(RetrievedDocument dj: G.get(sk))
		{
			res.add(dj);
			if(res.size() >= kpar) break;
		}
		
		return res;
	}

	public abstract double similarScore(T q, T dk);

	public abstract Collection<T> fetchStockedDocuments();

	public void print(List<RetrievedDocument> items) 
	{
		for(RetrievedDocument ik: items)
		{
			System.out.println(ik.score + ": " + ik.document);
		}		
	} 

}
