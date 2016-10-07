package gapp.kn_search;

public class SearchResultItem<T> {

	public double score;
	public T item;

	public SearchResultItem(double dk, T ik) 
	{
		score = dk;
		item = ik;
	}

	public String toString()
	{
		return score + ": " + item;
	}
}
