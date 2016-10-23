package org.naebulae.mc2.vector;

public class CatDistArr extends Sampler1970 implements CatDist 
{
	public String[] arr;

	public CatDistArr(String[] a)
	{
		arr = a;
	}

	@Override
	public Object nextCategory() 
	{
		return takeOne(arr);
	}

	@Override
	public void addCategory(Object obj) 
	{		
	}

	@Override
	public void normalize() 
	{
		
	}	
}
