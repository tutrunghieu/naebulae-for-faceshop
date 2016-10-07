package gapp.xorcos;

public class ScalarSamplerUniform extends ScalarSampler
{
	private double lowerBound;
	private double upperBound;

	public ScalarSamplerUniform(double lower, double upper) 
	{
		lowerBound = lower;
		upperBound = upper;
	}

	@Override
	public double nextDouble() 
	{
		double t = this.nextBaseUnif01();
		return lowerBound*t + upperBound*(1-t);
	}

}
