package org.naebulae.mc2.oct29_test_unif;

import java.util.List;
import java.util.Map;

import org.naebulae.mc2.oct23_file.BaseSampler;
import org.naebulae.mc2.vector.table.Vizualizer;
import org.naebulae.util.List2;

public class to_test_box_muller_method {

	public static void main(String[] args) 
	throws Exception
	{
		BaseSampler b = new BaseSampler();
		
		List<Double> items = List2.sample(Double.class, 90000, 
				x -> x.add(b.nextBoxMullerSample()) );
		
		int n = 20;		
		Map<Double, Double> h = List2.hist(items, -3, 3, n);
		List2.divide(h, items.size());
		System.out.println(h);
		
		Vizualizer.printHist(h, 200);
	}

}
