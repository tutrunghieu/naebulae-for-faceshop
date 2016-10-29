package org.naebulae.mc2;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class ScalarSampler extends Sampler 
{
	public abstract double nextDouble();

	public List<Double> nextDoubleList(int n) 
	{
		List<Double> res = new ArrayList<Double>(); 
		for(int k=0; k<n; k++) res.add(nextDouble());
		return res;
	}
	
	public Set<Double> nextDoubleSet(int n) 
	{
		Set<Double> res = new LinkedHashSet<Double>(); 
		for(int k=0; k<n; k++) res.add(nextDouble());
		return res;
	}
	
	public double[] nextDoubleArray(int n) 
	{
		double[] res = new double[n]; 
		for(int k=0; k<n; k++) res[k] = nextDouble();
		return res;
	}
}
