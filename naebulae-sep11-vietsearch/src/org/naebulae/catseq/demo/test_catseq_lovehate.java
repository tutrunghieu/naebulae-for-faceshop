package org.naebulae.catseq.demo;

import org.naebulae.catseq.Catseq;
import org.naebulae.catseq.Sampler;
import org.naebulae.catseq.SamplerShannonMachine;

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
