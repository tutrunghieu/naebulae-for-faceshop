package gapp.xorcos.stat;

import java.util.ArrayList;
import java.util.List;

public class Meanvar {

	public static double max(List<Double> x) 
	{
		double s = -Double.MAX_VALUE;
		for(Double xk: x) s = Math.max(s, xk);
		return s;
	}
	
	public static double min(List<Double> x) 
	{
		double s = Double.MAX_VALUE;
		for(Double xk: x) s = Math.min(s, xk);
		return s;
	}
	
	public static double average(List<Double> x) 
	{
		double s = 0;
		for(Double xk: x) s += xk;
		
		int n = x.size();
		return s /( n==0 ? 1 : n);
	}

	public static double averageDiff(List<Double> x, double x0)
	{
		double s = 0;
		for(Double xk: x) {
			double dk = xk - x0;
			s += dk*dk;
		}
		
		int n = x.size();
		return s /( n==0 ? 1 : n);
	}

	public static List<StatisticalFactor> range(List<double[]> x) 
	{
		List<StatisticalFactor> res = new ArrayList<StatisticalFactor>();
		
		for(double[] xk: x)
		for(int nk=xk.length, j=0; j<nk; j++)
		{
			StatisticalFactor rj = rangeFactor(res, j);
			rj.add(xk[j]);
		}
		
		return res;
	}

	private static StatisticalFactor rangeFactor(List<StatisticalFactor> res, int j) 
	{
		while(res.size() <= j) 
		{
			StatisticalFactor rj = new StatisticalFactor();
			rj.number = j;
			res.add(rj);
		}
		return res.get(j);
	}

	public static StatisticalFactor rangeListDouble(List<Object> x) 
	{
		StatisticalFactor res = new StatisticalFactor();
		res.maxVal = -Double.MAX_VALUE;
		res.minVal = Double.MAX_VALUE;
		
		for(Object xk: x)
		{
			double vk = (Double)xk;
			res.add(vk);
		}

		return res;
	}

	public static int count(List<Object> x, WhereFunc lf) 
	{
		int c = 0;
		for(Object xk: x)
		{
			boolean vk = lf.invokeWhereAction(xk);
			if(vk) c++;
		}

		return c;
	}

}
