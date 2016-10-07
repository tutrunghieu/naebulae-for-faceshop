package org.naebulae.catseq;

import java.util.Map;

import org.naebulae.util.Map2;

public class SamplerSlotMachine extends Sampler<Catseq> {


	@Override
	public int nextSequenceLength() 
	{
		return 3;
	}
	
	@Override
	public Object nextSequenceCategory(int k, Object pref) 
	{
		final Map<String, Double> s1 = Map2.newTreeMap(String.class, Double.class, 
				res -> { res.put("a", 0.7); res.put("b", 0.2); res.put("c", 0.1); });
		
		final Map<String, Double> s2 = Map2.newTreeMap(String.class, Double.class, 
				res -> { res.put("m", 0.6); res.put("n", 0.2); res.put("p", 0.1); res.put("q", 0.1); });
		
		final Map<String, Double> s3 = Map2.newTreeMap(String.class, Double.class, 
				res -> { res.put("apple", 0.7); res.put("orange", 0.3);  });
		
		return pickItem(k==0 ? s1 : k==1 ? s2 : s3);
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
