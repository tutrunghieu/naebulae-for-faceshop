package org.naebulae.mc2.vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniformVocab implements CatDist 
{
	protected List<String> items = new ArrayList<String>();
	
	public UniformVocab(String... args)
	{
		items = Arrays.asList(args);
	}

	@Override
	public Object nextCategory() 
	{
		int k = (int)Math.floor(Math.random()*items.size());
		return items.get(k);
	}

	@Override
	public void addCategory(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void normalize() {
		// TODO Auto-generated method stub
		
	}

}
