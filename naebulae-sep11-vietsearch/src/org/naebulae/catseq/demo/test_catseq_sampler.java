package org.naebulae.catseq.demo;

import org.naebulae.catseq.Catseq;
import org.naebulae.catseq.Sampler;
import org.naebulae.catseq.SamplerCatseqLoop;
import org.naebulae.catseq.SamplerShannonMachine;
import org.naebulae.test_md5_sha1_sha256.System2;

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
