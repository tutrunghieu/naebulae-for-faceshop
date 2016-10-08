package gapp.xorcos.stat;

import java.util.ArrayList;
import java.util.List;

public class Meanvar {

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

}
