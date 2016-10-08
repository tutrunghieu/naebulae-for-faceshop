package demo.naebulae.vietsearch;

import java.util.List;

import org.naebulae.lucas.ScoreDocument;
import org.naebulae.lucas.SearchEngineList;
import org.naebulae.lucas.VietlangUtils;

public class test4_search_with_unknown_chars 
{
	public static void main(String[] args)
	throws Exception
	{
		String q = "s? ?? H?i thu?c PH??ng xa";
		
		List<String> docs = VietlangUtils.getTruyenKieuSentences();
		for(int k=0; k<docs.size(); k++)
		{
			String dk = docs.get(k);
			docs.set(k, dk.trim() );
		}
		
		SearchEngineList<String> eng = new SearchEngineList<String>(docs);
		
		List<ScoreDocument> items = eng.filterDocuments(q, 17);
		eng.print(items);
		
		eng.clearBuffer();
		eng.similarScore(q, docs.get(3));
	}

}
