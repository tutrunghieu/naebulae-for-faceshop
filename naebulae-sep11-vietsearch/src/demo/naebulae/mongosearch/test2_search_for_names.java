package demo.naebulae.mongosearch;

import java.util.List;

import org.bson.Document;
import org.naebulae.lucas.ScoreDocument;
import org.naebulae.mongo.MongoPortal;
import org.naebulae.mongo.MongoUtils;

import com.mongodb.client.FindIterable;

public class test2_search_for_names 
{
	public static void main(String[] args)
	throws Exception
	{
		Document q = new Document("_keywords", "Ngh?a ?ô Ph? gà");
		
		MongoPortal p = MongoUtils.openPortal("cabine-101");
		FindIterable<Document> docs = p.findAll("tab-franchise-menu-item");
		p.close();
		
		SearchEngineMongo<Document> eng = new SearchEngineMongo<Document>();
		
		List<ScoreDocument> items = eng.filterDocuments(q, docs, 17);
		
		items.get(0).getDocumentAsType(Document.class);
		eng.print(items);
		
	}

}
