package org.naebulae.mc2.catseq.demo;

import org.naebulae.mc2.catseq.Catseq;
import org.naebulae.mc2.catseq.SamplerShannonMachine2;

public class test_catseq_lovehate2 {

	public static void main(String[] args) 
	{
		String[] corpus = {
				"I want to go",
				"I go to school",
				"they like to go",
				"I love you",
				"I love her very much",
				"they love you too",
				"we can talk",
				"we love her more than we can say"
		};

		SamplerShannonMachine2 eng = new SamplerShannonMachine2(corpus, 2);
		
		
		for(Catseq sk: eng.nextObjectList(1000)) 
			System.out.println(sk.getSymbolString());		
	}

}
