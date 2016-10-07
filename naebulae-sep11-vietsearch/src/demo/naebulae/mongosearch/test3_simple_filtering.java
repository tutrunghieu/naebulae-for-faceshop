package demo.naebulae.mongosearch;

import java.util.List;

import org.bson.Document;
import org.naebulae.lucas.ScoreDocument;
import org.naebulae.lucas.ScoringFuncStringDoc;
import org.naebulae.lucas.SearchUtils;
import org.naebulae.mongo.MongoUtils;

public class test3_simple_filtering 
{
	public static void main(String[] args)
	throws Exception
	{
		String q = "Ngh?a ?ô gà Ph? ";
		
		List<Document> docs = MongoUtils.listDocuments("tab-franchise-menu-item", "cabine-101");
		System.out.println(docs.size());
		
		List<ScoreDocument> res = SearchUtils.findNearest(q, docs, 17, new ScoringFuncStringDoc("itemName"));
		SearchUtils.print(res);
	}

}
