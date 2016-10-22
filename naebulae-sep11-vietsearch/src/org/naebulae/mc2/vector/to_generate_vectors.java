package org.naebulae.mc2.vector;

import org.naebulae.util.System2;

public class to_generate_vectors 
{

	public static void main(String[] args) 
	throws Exception
	{
		McVectorGenerator g = new McVectorGenerator();
		
		g.add( () -> 100*Math.random() );
		g.add( () -> 20*Math.random() );
		
		
		for(int k=0; k<1000; k++)
		{
			McString<Double> vk = g.nextVectorUniform(Double.class);
			System.out.println(vk);
		}
		
		System2.theEnd();
	}

}
