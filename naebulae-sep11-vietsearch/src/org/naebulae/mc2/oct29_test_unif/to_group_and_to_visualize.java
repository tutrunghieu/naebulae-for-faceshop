package org.naebulae.mc2.oct29_test_unif;

import java.util.List;
import java.util.Map;

import org.naebulae.mc2.vector.table.Visualizer;
import org.naebulae.util.DataGroup;
import org.naebulae.util.Jaccard;
import org.naebulae.util.List2;

import gapp.xorcos.stat.Meanvar;

public class to_group_and_to_visualize {

	public static void main(String[] args) 
	throws Exception
	{
		List<Double> items = List2.sample(Double.class, 90000, x -> x.add(Math.random()) );
		System.out.println("avg = " + Meanvar.average(items) );
		
		Map<Object, DataGroup> h = List2.group(items, x -> Math.floor(x*20));
		Visualizer.printDataGroups(h, items.size(), 200);
	}

}
