package gapp.xorcos;

import java.util.ArrayList;
import java.util.List;

public class StatisticalFactor 
{
	public Double minVal;
	public Double maxVal;
	
	public int number;
	public List<Double> values = new ArrayList<Double>();
	
	public void add(double d) 
	{
		values.add(d);
	}

	public Double min() 
	{
		if(minVal!=null) return minVal;
	
		for(Double vk: values)
		{
			if(minVal == null) minVal = vk;
			else minVal = Math.min(minVal, vk);
		}
		
		return minVal;
	}

	public Double max() 
	{
		if(maxVal!=null) return maxVal;
	
		for(Double vk: values)
		{
			if(maxVal == null) maxVal = vk;
			else maxVal = Math.max(maxVal, vk);
		}
		
		return maxVal;
	}

	public Double avg()
	{
		double s = 0;
		for(Double xk: values) s += xk;
		
		int n = values.size();
		return s /( n==0 ? 1 : n);
	}
}
