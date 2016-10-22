package org.naebulae.mc2.vector;

import org.naebulae.util.System2;

public class to_generate_string_hofmann 
{

	public static void main(String[] args) 
	throws Exception
	{
		HofmannSampler g = new HofmannSampler(20, 25);
		
		g.add(1, new UniformVocab("red", "green", "blue") );
		g.add(3, new UniformVocab("here", "there", "this", "that") );
		g.add(6, new UniformVocab("love", "hate") );
		
		g.normalize();
		
		for(int k=0; k<20; k++)
		{
			McString<String> vk = g.nextString(String.class);
			System.out.println(vk);
		}
		
		System2.theEnd();
	}

}
