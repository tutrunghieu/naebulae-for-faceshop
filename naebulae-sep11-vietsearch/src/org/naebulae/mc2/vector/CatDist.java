package org.naebulae.mc2.vector;

public interface CatDist 
{
	public Object nextCategory();

	public static CatDist fromArrayString(String...args)
	{
		CatDist res = new CatDistArr(args);
		return res;
	}

	public static CatDist fromWordHist(String words)
	{
		CatDist res = new CatDistMap(words.split("\\s+"));
		return res;		
	}

	public abstract void addCategory(Object obj);
	
	public abstract void normalize();

}
