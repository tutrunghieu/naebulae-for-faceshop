package org.naebulae.mc2.vector.string;

import org.naebulae.mc2.vector.CatDist;
import org.naebulae.mc2.vector.McString;
import org.naebulae.mc2.vector.ShannonSampler;
import org.naebulae.util.System2;

public class to_generate_string_shannon 
{

	public static void main(String[] args) 
	throws Exception
	{
		ShannonSampler g = new ShannonSampler(20, 25);
		
		g.add(newArray(), CatDist.fromWordHist("I I I I they"));
		g.add(newArray("I"), CatDist.fromArrayString("love", "hate"));
		g.add(newArray("they"), CatDist.fromArrayString("want", "need", "like"));
		g.add(newArray("love"), CatDist.fromArrayString("you", "her"));
		g.add(newArray("hate"), CatDist.fromArrayString("you", "her", "it"));
		g.add(newArray("want"), CatDist.fromArrayString("him", "us", "those"));
		g.add(newArray("need"), CatDist.fromArrayString("him", "us", "those"));
		g.add(newArray("like"), CatDist.fromArrayString("him", "us", "those"));
		g.add(newArray("you"), CatDist.fromArrayString("too", "more"));
		
//		for(int k=0; k<20; k++)
//		{
			McString<String> vk = g.nextString();
			System.out.println(vk);
//		}
		
		System2.theEnd();
	}



	private static Object[] newArray(Object... args) 
	{
		return args;
	}

}
