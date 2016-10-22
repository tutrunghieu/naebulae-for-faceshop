package org.naebulae.mc2.vector;

public class to_generate_vectors {

	public static void main(String[] args) 
	{
		McVectorGenerator g = new McVectorGenerator();
		
		for(int k=0; k<1000; k++)
		{
			McVector<String> vk = g.nextVectorUniform(String.class);
			System.out.println(vk);
		}

		
	}

}
