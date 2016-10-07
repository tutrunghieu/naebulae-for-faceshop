package org.naebulae.catseq;

import java.util.Map;

import org.naebulae.catseq.demo.CorpusUtils;
import org.naebulae.test_md5_sha1_sha256.System2;

public class SamplerShannonMachine2 extends Sampler<Catseq> 
{
		protected int kpar;
		
		protected Map<String, Map<String, Double>> mat;
		
		public SamplerShannonMachine2(String[] corpus, int k)
		{
			kpar = k;
			
			mat = CorpusUtils.buildLangModel2(corpus, kpar);
//			CorpusUtils.printLangModel(mat);
		}
		
		public double nextDouble()
		{
			return coin197.nextDouble();
		}
		
		
		@Override
		public Object nextSequenceCategory(int k, Object pref) 
		{
			String last = (String)pref;
			
			Map<String, Double> m = mat.get(last);
			if(m==null) return null;
			
			return pickItem(m);
		}

		@Override
		public Catseq nextObject() 
		{
			Catseq res = new Catseq();
			
			for(int k=0; true; k++) 
			{
//				System.out.println("Sampling " + k);
				
				String pref = System2.join( CorpusUtils.getLast(res.getListObject(), kpar) );
				Object vk = nextSequenceCategory(k, pref);
				if(vk == null) break;
				res.add(vk);
			}
			
			return res;
		}
}
