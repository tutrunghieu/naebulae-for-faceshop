package gapp.xorcos;

import java.util.Random;

public class Sampler 
{
	protected static final Random coin197 = new Random(197);

	public double nextBaseUnif01()
	{
		return Math.random();
	}

	public int nextBaseInt(int len)
	{
		return (int)Math.floor(len * nextBaseUnif01());
	}
		

}
