package org.naebulae.mc2;

import org.naebulae.mc2.vector.table.TypedAction;

public abstract class FileSampler<T> 
{
	public abstract void writeHeader(Class<T> cl);
	
	public abstract void write(Object rk); 
	

	public void nextDataRows(int n, Class<T> cl, TypedAction<T> lf) 
	throws Exception
	{
		writeHeader(cl);
		
		for(int k=0; k<1000; k++)
		{
			T rk = cl.newInstance();
			lf.invokeAction(rk);
			write(rk);
		}
		
		return;
	}

	public void close() 
	{		
	}	

}
