package org.naebulae.mc2.catseq.demo;

import org.naebulae.mc2.Catseq;
import org.naebulae.mc2.Sampler;
import org.naebulae.mc2.SamplerShannonMachine;

public class test_catseq_lovehate {

	public static void main(String[] args) 
	{
		String[] corpus = {
				"I want to go",
				"I go to school",
				"they like to go",
				"I love you",
				"I love her very much",
				"they love you too",
				"we love her more than we can say"
		};

		Sampler<Catseq> eng = new SamplerShannonMachine(corpus);
		
		for(Catseq sk: eng.nextObjectList(1000)) 
			System.out.println(sk.getSymbolString());		
	}

}
