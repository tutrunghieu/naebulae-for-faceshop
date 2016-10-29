package org.naebulae.mc2.oct29_test_unif;

import java.util.List;
import java.util.Map;

import org.naebulae.mc2.Meanvar;
import org.naebulae.util.Jaccard;
import org.naebulae.util.List2;

public class to_test_math_random {

	public static void main(String[] args) 
	throws Exception
	{
		List<Double> items = List2.sample(Double.class, 90000, x -> x.add(Math.random()) );
		System.out.println("avg = " + Meanvar.average(items) );
		
		int n = 100;
		
		Map<Double, Double> h = List2.hist(items, 0, 1, n);
		List2.divide(h, items.size());
		System.out.println(h);
		
		double j = Jaccard.jaccardScore(h, 1d/n);
		System.out.println("similarity score = " + j);
		
	}

}
