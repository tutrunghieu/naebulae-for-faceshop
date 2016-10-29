package org.naebulae.mc2.oct29_test_unif;

import java.util.ArrayList;
import java.util.List;

import org.naebulae.mc2.BaseSampler;
import org.naebulae.mc2.vector.table.TypedAction;
import org.naebulae.mc2.vector.table.TypedAction2;

public class TypedSampler<T> 
{
	public List<T> nextList(int n, Class<T> cl, TypedAction<T> lf)
	throws Exception
	{
		List<T> res = new ArrayList<T>();
		for(int k=0; k<n; k++)
		{
			T ik = cl.newInstance();
			lf.invokeAction(ik);
			res.add(ik);
		}
		return res;
	}
	
	public List<T> nextList2(int n, Class<T> cl, TypedAction2<Integer, T> lf)
	throws Exception
	{
		List<T> res = new ArrayList<T>();
		for(int k=0; k<n; k++)
		{
			T ik = cl.newInstance();
			lf.invokeAction(k, ik);
			res.add(ik);
		}
		return res;
	}
	
	public List<T> nextList(int n)
	{
		List<T> res = new ArrayList<T>();
		for(int k=0; k<n; k++)
		{
			T ik = nextObject();
			res.add(ik);
		}
		return res;
	}

	public T nextObject() {
		// TODO Auto-generated method stub
		return null;
	}

}
