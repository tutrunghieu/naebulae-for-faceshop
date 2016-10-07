package gapp.xorcos;

import java.util.List;

@SuppressWarnings("unused")
public class test2_generate_xor 
{
	public static void main(String[] args) 
	{
		VectorSampler<double[]> f = new VectorSampler<double[]>() 
		{
			ScalarSampler X1 = new ScalarSamplerUniform(-10, 10);
			ScalarSampler X2 = new ScalarSamplerUniform(-20, 20);
			
			@Override
			public double[] nextVector() 
			{
				return new double[] { X1.nextDouble(), X2.nextDouble() };
			}	
		};
		
		if(System2.IGNORE_THIS_BLOCK)
		{
			for(int k=0; k<100; k++)
			{
				double[] x = f.nextVector();
				System2.printVector(x);
			}
		}
		
		List<double[]> x = f.nextDoubleList(9000);
		
		List<StatisticalFactor> fields = Meanvar.range(x);
		for(StatisticalFactor fj: fields)
		{
			System2.hr("X" + fj.number);
			System2.nv("min", fj.min());
			System2.nv("max", fj.min());
			System2.nv("avg", fj.avg());
		}
		
		System2.theEnd();
	}


}
