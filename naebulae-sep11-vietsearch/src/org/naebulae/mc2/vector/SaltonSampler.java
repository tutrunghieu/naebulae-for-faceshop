package org.naebulae.mc2.vector;

import java.util.ArrayList;
import java.util.List;

public class SaltonSampler extends Sampler1970
{
	protected int len1;
	protected int len2;
	
	protected List<UniformVocab> items = new ArrayList<UniformVocab>(); 
	
	public SaltonSampler(int a, int b) 
	{
		len1 = a;
		len2 = b;
	}
		
	public void add(UniformVocab Vj) 
	{
		items.add(Vj);
	}
		


	public int nextVectorLen()
	{
		double t = Math.random();
		return (int)(t*len1 + (1-t)*len2);
	}
	
	public CategoricalDist nextCategoricalDist(int k) 
	{
		return takeOne(items);		
	}	

	public<T> McString<T> nextVectorUniform(Class<T> cl) 
	throws Exception
	{
		McString<T> res = new McString<T>();
		
		for(int n=nextVectorLen(), k=0; k<n; k++)
		{
			CategoricalDist pk = nextCategoricalDist(k);
			T wk = cl.cast( pk.nextCategory() );
			res.add(wk);
		}
		
		return res;
	}



}
