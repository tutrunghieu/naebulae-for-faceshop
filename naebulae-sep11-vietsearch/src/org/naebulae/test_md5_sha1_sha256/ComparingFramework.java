package org.naebulae.test_md5_sha1_sha256;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ComparingFramework<S, T>
{
	public PrintWriter out;
	public FisherSampler<S> sampler;
	public List<FisherMethod<S, T>> items = new ArrayList<FisherMethod<S, T>>();
	
	public void add(FisherMethod<S, T> lf) 
	{
		items.add(lf);
	}	

	public void compareMethods(int kpar) 
	{
		int nj = items.size();
		
		long[] time = new long[nj];
		for(int j=0; j<nj; j++) time[j] = 0;
		
		
		for(int k=0; k<kpar; k++)
		{
			out.println("Case: " + k + "/" + kpar);
			
			S xk = sampler.nextSample();
						
			for(int j=0; j<nj; j++)
			{
				FisherMethod<S, T> lj = items.get(j);	
				
				long tt = System.currentTimeMillis();
				lj.invokeMethod(xk);			
				time[j] += Math.abs(System.currentTimeMillis() - tt);
			}
			
			recordCase(k, xk, time);
		}
		
		System2.theEnd();		
	}

	protected void recordCase(int k, S xk, long[] time) 
	{
		out.println("Result: " + Joiner.start(", ").join(time));
	}

	public void close() 
	{
		out.close();
	}



}
