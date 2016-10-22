package org.naebulae.mc2.vector;

import org.naebulae.util.System2;

public class to_generate_string_shannon 
{

	public static void main(String[] args) 
	throws Exception
	{
		ShannonSampler g = new ShannonSampler(20, 25);
		
		g.add(newArray(), newUniformCategorical("I", "they"));
		g.add(newArray("I"), newUniformCategorical("love", "hate"));
		g.add(newArray("they"), newUniformCategorical("want", "need", "like"));
		g.add(newArray("love"), newUniformCategorical("you", "her"));
		g.add(newArray("hate"), newUniformCategorical("you", "her", "it"));
		g.add(newArray("want"), newUniformCategorical("him", "us", "those"));
		g.add(newArray("need"), newUniformCategorical("him", "us", "those"));
		g.add(newArray("like"), newUniformCategorical("him", "us", "those"));
		g.add(newArray("you"), newUniformCategorical("too", "more"));
		
//		for(int k=0; k<20; k++)
//		{
			McString<String> vk = g.nextString();
			System.out.println(vk);
//		}
		
		System2.theEnd();
	}

	private static CategoricalDist newUniformCategorical(String...args)
	{
		CategoricalDist res = new CategoricalDist()
		{
			public String[] arr = args;
			public Sampler1970 coin = new Sampler1970();

			@Override
			public Object nextCategory() 
			{
				return coin.takeOne(arr);
			}	
		};

		return res;
	}

	private static Object[] newArray(Object... args) 
	{
		return args;
	}

}
