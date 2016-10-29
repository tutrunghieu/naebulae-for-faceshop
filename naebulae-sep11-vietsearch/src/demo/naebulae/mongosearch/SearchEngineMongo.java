package demo.naebulae.mongosearch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.naebulae.nlp.lucas.SearchEngine;
import org.naebulae.nlp.vietlang.VietlangUtils;
import org.naebulae.util.Jaccard;
import org.naebulae.util.mongo.MongoPortal;

public class SearchEngineMongo<T> extends SearchEngine<Document> 
{
	private String tableName;
	private MongoPortal dataPortal;
	private String[] dataFields;
	
	public SearchEngineMongo() 
	{
		
	}
	
	public SearchEngineMongo(String tname, MongoPortal port, String[] fields) 
	{
		tableName = tname;
		dataPortal = port;
		dataFields = fields;
	}


	@Override
	public Collection<Document> fetchStockedDocuments() 
	{
		List<Document> res = new ArrayList<Document>();
		for(Document rk: dataPortal.getCollection(tableName).find()) res.add(rk);
		return res;
	}


	private Document __q;
	private Map<String, Double> __q_set;
	private Document __dk;
	private Map<String, Double> __dk_set;
	
	@Override
	public double similarScore(Document q, Document dk) 
	{
		if(q != __q) __q_set = getQueryEntitySet(__q = q);
		if(dk != __dk) __dk_set = getStoredEntitySet(__dk = dk);

		return Jaccard.jaccardScore(__q_set, __dk_set);
	}
	
	public Map<String, Double> getQueryEntitySet(Document q) 
	{
		String keywords = q.get("_keywords").toString().trim().toLowerCase();
		return Jaccard.getWordHist(keywords);
	}	

	public Map<String, Double> getStoredEntitySet(Document dk) 
	{
		String res = "";
		
		for(String fk: dataFields)
		{
			String vk = dk.get(fk).toString();
			vk = VietlangUtils.removePunctuators(vk);
			vk = VietlangUtils.detone(vk);
			vk = vk.trim().toLowerCase();
			
			if(res.length() > 0) res += " ";
			res += vk;
		}

		return Jaccard.getWordHist(res);
	}


	
}
