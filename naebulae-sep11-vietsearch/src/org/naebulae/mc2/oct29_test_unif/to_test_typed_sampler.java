package org.naebulae.mc2.oct29_test_unif;

import java.util.List;
import java.util.Map;

import org.naebulae.mc2.BaseSampler;
import org.naebulae.util.Jaccard;
import org.naebulae.util.List2;

public class to_test_typed_sampler 
{

	public static void main(String[] args) 
	throws Exception
	{
		BaseSampler b = new BaseSampler();
		TypedSampler<XorDataRow> s = new TypedSampler<XorDataRow>();
		
		List<XorDataRow> items = s.nextList(9000, XorDataRow.class,
				x -> { 
					x.X1 = b.nextBaseDouble() - 0.5; 
					x.X2 = b.nextBaseDouble() - 0.5;
//					x.label = (x.X1*x.X2 > 0 ? "red" : "blue");
					
					x.label = (x.X1 > 0 
							? (x.X2 > 0 ? "red" : "green") 
							: (x.X2 > 0 ? "black" : "white") );
				});
		
		Map<Object, Double> h = List2.hist(items, x -> x.label);
		List2.divide(h, items.size());
		List2.print(h);
		
		System.out.println(Jaccard.jaccardScore(h, 1d/4));
	}

}
