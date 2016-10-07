package gapp.kn_search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine<T> 
{
	public SearchResult<T> findNearst(String q, List<T> s, int kpar)
	{
		SearchResult<T> res = new SearchResult<T>();
		
		res.query = q;
		res.kpar = kpar;
		res.items = new ArrayList<SearchResultItem<T>>();
		
		for(T ik: s)
		{
			double dk = similarScore(ik, q);
			res.items.add(new SearchResultItem<T>(dk, ik));
		}
				
		
		return res;
	}

	public double similarScore(T ik, String q) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	public void print(SearchResult<T> item) 
	{
		System.out.println(item.query);
		System.out.println(item.kpar);
		
		System.out.println("----------------");
		for(SearchResultItem<T> ik: item.items)
		{
			System.out.println(ik);		
		}
		
		return;
	}

}
