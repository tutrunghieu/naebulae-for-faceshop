package gapp.kn_search;

import java.util.List;

public class test3_seach_over_textlines 
{
	public static void main(String[] args) 
	{
		SearchEngine<String> eng = new SearchEngine<String>();
		
		String q = "abc";
		List<String> S = List2.newList("abd", "aaa", "abcd", "bcd", "abcded", "bcabcd");
		
		SearchResult<String> items = eng.findNearst(q, S, 3);
		eng.print(items);
	}

}
