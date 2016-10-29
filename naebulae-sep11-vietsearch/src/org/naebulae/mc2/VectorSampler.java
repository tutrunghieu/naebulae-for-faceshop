package org.naebulae.mc2;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class VectorSampler<T> extends Sampler
{
	public abstract T nextVector();

	public List<T> nextDoubleList(int n) 
	{
		List<T> res = new ArrayList<T>(); 
		for(int k=0; k<n; k++) res.add(nextVector());
		return res;
	}
	
	public Set<T> nextDoubleSet(int n) 
	{
		Set<T> res = new LinkedHashSet<T>(); 
		for(int k=0; k<n; k++) res.add(nextVector());
		return res;
	}
	
	public T[] nextDoubleArray(int n, Class<T[]> cl) 
	throws Exception
	{
		T[] res = cl.newInstance(); 
		for(int k=0; k<n; k++) res[k] = nextVector();
		return res;
	}

}
