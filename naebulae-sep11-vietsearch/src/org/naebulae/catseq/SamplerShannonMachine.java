package org.naebulae.catseq;

import java.util.Map;

import org.naebulae.catseq.demo.CorpusUtils;

public class SamplerShannonMachine extends Sampler<Catseq> 
{
		protected Map<String, Map<String, Double>> mat;
		
		public SamplerShannonMachine(String[] corpus)
		{
			 mat = CorpusUtils.buildLangModel(corpus);			
		}
		
		public double nextDouble()
		{
			return coin197.nextDouble();
		}
		
		@Override
		public int nextSequenceLength() 
		{
			return 0;
		}
		
		@Override
		public Object nextSequenceCategory(int k, Object pref) 
		{
			Object last = ( k==0 ? "" : ((Catseq)pref).get(k-1) );
			
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
				Object vk = nextSequenceCategory(k, res);
				if(vk == null) break;
				res.add(vk);
			}
			
			return res;
		}
}
