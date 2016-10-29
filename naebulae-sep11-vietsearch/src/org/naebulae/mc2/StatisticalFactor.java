package org.naebulae.mc2;

import java.util.ArrayList;
import java.util.List;

public class StatisticalFactor 
{
	public Double minVal = Double.MAX_VALUE;
	public Double maxVal = -Double.MAX_VALUE;
	
	public int number;
	public List<Double> values = new ArrayList<Double>();
	
	public void add(double d) 
	{
		values.add(d);
		minVal = Math.min(minVal, d);
		maxVal = Math.max(maxVal, d);
	}

	public Double lower() 
	{
		return minVal;
	}

	public Double upper() 
	{
		return maxVal;
	}

	public Double avg()
	{
		double s = 0;
		for(Double xk: values) s += xk;
		
		int n = values.size();
		return s /( n==0 ? 1 : n);
	}

	public void print() 
	{
		System.out.println("lower=" + lower());
		System.out.println("upper=" + upper());
	}
}
