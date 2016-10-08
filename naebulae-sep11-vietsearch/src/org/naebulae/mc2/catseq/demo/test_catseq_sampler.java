package org.naebulae.mc2.catseq.demo;

import org.naebulae.mc2.catseq.Catseq;
import org.naebulae.mc2.catseq.Sampler;
import org.naebulae.mc2.catseq.SamplerCatseqLoop;
import org.naebulae.mc2.catseq.SamplerShannonMachine;
import org.naebulae.util.System2;

public class test_catseq_sampler 
{
	public static void main(String[] args)
	{
		Sampler<Catseq> eng = new SamplerCatseqLoop(); 
	

//		for(int k=0; k<1000; k++)
//		{
//			Catseq sk = eng.nextObject();
//			System.out.println(sk.getSymbolString());
//		}
		
		for(Catseq sk: eng.nextObjectList(1000)) 
			System.out.println(sk.getSymbolString());
			
		System2.theEnd();
	}

}
