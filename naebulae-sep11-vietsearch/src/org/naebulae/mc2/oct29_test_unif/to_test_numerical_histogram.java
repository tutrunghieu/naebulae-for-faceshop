package org.naebulae.mc2.oct29_test_unif;

import java.util.List;
import java.util.Map;

import org.naebulae.mc2.Meanvar;
import org.naebulae.mc2.vector.table.Visualizer;
import org.naebulae.util.Jaccard;
import org.naebulae.util.List2;

public class to_test_numerical_histogram {

	public static void main(String[] args) 
	throws Exception
	{
		List<Double> items = List2.sample(Double.class, 90000, x -> x.add(Math.random()) );
		System.out.println("avg = " + Meanvar.average(items) );
		
		Map<Double, Double> h = List2.hist(items, x -> Math.floor(x*20));
		List2.divide(h, items.size());
		Visualizer.printHist(h, 200);
	}

}
