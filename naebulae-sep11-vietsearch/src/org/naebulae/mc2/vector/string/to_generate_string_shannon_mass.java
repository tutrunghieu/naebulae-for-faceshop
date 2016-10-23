package org.naebulae.mc2.vector.string;

import java.util.Arrays;

import org.naebulae.mc2.vector.CatDist;
import org.naebulae.mc2.vector.McString;
import org.naebulae.mc2.vector.ShannonSampler;
import org.naebulae.util.List2;
import org.naebulae.util.System2;

public class to_generate_string_shannon_mass 
{

	public static void main(String[] args) 
	throws Exception
	{
		ShannonSampler g = new ShannonSampler(20, 25);
		g.setGrams(2);
		g.addSentence("I love you too");
		g.addSentence("they love you more");
		g.addSentence("we love to");
		g.addSentence("they love you more than we do");
		g.addSentence("we do love you");
		g.addSentence("I go to school");
		g.addSentence("we hate you more than we can say");
		
		g.normalize();
		if(System2.IGNORE_THIS_BLOCK) g.print();
		
		for(int k=0; k<20; k++)
		{
			McString<String> vk = g.nextString();
			System.out.println(vk);
		}
		
		System2.theEnd();
	}


}
