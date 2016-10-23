package org.naebulae.mc2.oct23_file;

import org.naebulae.util.System2;

public class to_test_file_sampler {

	public static void main(String[] args) 
	throws Exception
	{
		BaseSampler b = new BaseSampler();
		
		double x = b.nextBaseDouble();
		x = b.nextGaussianSample();
		x = b.nextGaussianSample(10, 3);
		
		System2.consume(x);
		
		FileSampler<Container1> f = new FileSampler<Container1>() 
		{
			@Override
			public void writeHeader(Class<Container1> cl) { System.out.println(cl.getName());}

			@Override
			public void write(Object rk) { System.out.println(rk); }	
		};
		
		f.nextDataRows(1000, Container1.class, rk -> { 
			rk.X1 = b.nextBaseDouble();  
			rk.X2 = b.nextBaseDouble();
			rk.Y = 1234*rk.X1 + 4321*rk.X2 + b.nextBaseDouble()*0.01;
		});
		
		f.close();
	}

}
