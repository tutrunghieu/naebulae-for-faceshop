package org.naebulae.mc2.oct23_file;

import java.util.Arrays;
import java.util.List;

import org.naebulae.mc2.vector.table.TypedAction;
import org.naebulae.util.System2;

public class to_test_file_gmm {

	public static void main(String[] args) 
	throws Exception
	{
		BaseSampler b = new BaseSampler();
		
		FileSampler<Container1> f = new FileSampler<Container1>() 
		{
			@Override
			public void writeHeader(Class<Container1> cl) { System.out.println(cl.getName());}

			@Override
			public void write(Object rk) { System.out.println(rk); }	
		};
		
		TypedAction<Container1> c1 = (rk -> {
			rk.X1 = b.nextGaussianSample(10, 5);  
			rk.X2 = b.nextGaussianSample(20, 3);  
			rk.Y = 1;				
		});
		
		TypedAction<Container1> c2 = (rk -> {
			rk.X1 = b.nextGaussianSample(110, 15);  
			rk.X2 = b.nextGaussianSample(220, 23);  
			rk.Y = 2;				
		});
		
		TypedAction<Container1> c3 = (rk -> {
			rk.X1 = b.nextGaussianSample(50, 15);  
			rk.X2 = b.nextGaussianSample(220, 23);  
			rk.Y = 3;				
		});
		
		double[] P = System2.doubleArray(0.3, 0.1, 0.6); 
		List<TypedAction<Container1>> C = Arrays.asList(c1, c2, c3);
		
		f.nextDataRows(1000, Container1.class, 
				rk -> b.nextCategory(P, C).invokeAction(rk) );
		
		f.close();
	}

}
