package gapp.xorcos;

import java.util.List;

import org.naebulae.util.System2;

@SuppressWarnings("unused")
public class test1_uniform_sampler 
{
	public static void main(String[] args) 
	{
		ScalarSampler f = new ScalarSamplerUniform(-10, 10);
		
//		test1_printing(f);
		List<Double> x = f.nextDoubleList(10000);

		double m = Meanvar.average(x);
		System2.nv("m", m);
		
		double v = Meanvar.averageDiff(x, m);
		System2.nv("v", v);

		System2.theEnd();
	}

	private static void test1_printing(ScalarSampler f)
	{
		
		for(int k=0; k<100; k++)
		{
			double xk = f.nextDouble();
			System.out.println(k + ": " + xk);
		}
		
	}

}
