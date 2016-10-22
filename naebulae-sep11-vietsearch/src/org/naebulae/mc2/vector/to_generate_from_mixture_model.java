package org.naebulae.mc2.vector;

import java.util.List;

import gapp.xorcos.stat.Meanvar;

public class to_generate_from_mixture_model 
{
	public static void main(String[] args) 
	{
		MixtureModel m = new MixtureModel();
		
		m.add(0.3, new MixtureComponent() {
			@Override
			public Object nextSample() 
			{
				return 20 + 10 * Math.random();
			}});
		
		m.add(0.7, new MixtureComponent() {
			@Override
			public Object nextSample() 
			{
				return 1000 + 10 * Math.random();
			}});
		
		List<Object> x = Sampler1970.nextList(9000, () -> m.nextSample());
		for(Object xk: x) System.out.println(xk);
		
		int c = Meanvar.count(x, xk -> (Double)xk > 1000 );
		System.out.println(c/(double)x.size());
		
//		StatisticalFactor xf = Meanvar.rangeListDouble(x);
//		xf.print();
		
//		System2.theEnd();
	}

}
