package org.naebulae.mc2.vector;

import java.util.ArrayList;
import java.util.List;

public class McVectorGenerator extends Sampler1970
{
	protected List<CatDist> vocab = new ArrayList<CatDist>();
	
	public void add(CatDist v) 
	{
		vocab.add(v);
	}
	
	public int nextVectorLen()
	{
		return vocab.size();
	}
	
	public CatDist nextCategoricalDist(int k) 
	{
		return vocab.get(k);
	}	

	public<T> McString<T> nextVectorUniform(Class<T> cl) 
	throws Exception
	{
		McString<T> res = new McString<T>();
		
		for(int n=nextVectorLen(), k=0; k<n; k++)
		{
			CatDist pk = nextCategoricalDist(k);
			T wk = cl.cast( pk.nextCategory() );
			res.add(wk);
		}
		
		return res;
	}



}
