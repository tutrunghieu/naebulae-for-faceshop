package org.naebulae.catseq;

import java.util.Map;

public class SamplerCatseqLoop extends Sampler<Catseq> 
{
	
		@Override
		public int nextSequenceLength() 
		{
			return 50 + nextInteger(9);
		}
		
		@Override
		public Object nextSequenceCategory(int k, Object pref) 
		{
			final Map<String, Double> m = Map2.newTreeMap(String.class, Double.class, 
					res -> { res.put("a", 0.7); res.put("b", 0.2); res.put("c", 0.1); });
			
			return pickItem(m);
		}

		@Override
		public Catseq nextObject() 
		{
			Catseq res = new Catseq();
			
			int nk = this.nextSequenceLength();
			
			for(int k=0; k<nk; k++) 
			{
				Object vk = nextSequenceCategory(k, res);
				res.add(vk);
			}
			
			return res;
		}

}
