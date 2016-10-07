package org.naebulae.catseq;

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
