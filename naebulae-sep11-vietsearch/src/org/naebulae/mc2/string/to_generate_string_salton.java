package org.naebulae.mc2.string;

import org.naebulae.mc2.vector.McString;
import org.naebulae.mc2.vector.SaltonSampler;
import org.naebulae.mc2.vector.UniformVocab;
import org.naebulae.util.System2;

public class to_generate_string_salton 
{

	public static void main(String[] args) 
	throws Exception
	{
		SaltonSampler g = new SaltonSampler(20, 25);
		
		g.add(new UniformVocab("red", "green", "blue") );
		
		for(int k=0; k<20; k++)
		{
			McString<String> vk = g.nextVectorUniform(String.class);
			System.out.println(vk);
		}
		
		System2.theEnd();
	}

}
