package org.naebulae.catseq;

import java.util.LinkedHashMap;
import java.util.Map;

public class SamplerUniformBox extends Sampler<Catseq> 
{
	public Map<String, CategoricalVocab> slots = new LinkedHashMap<String, CategoricalVocab>();

	public void addSlot(String name, CategoricalVocab lf)
	{
		slots.put(name, lf);
	}
	
	public Catseq nextObject()
	{
		Catseq res = new Catseq();
		
		for(String nk: slots.keySet())
		{
			CategoricalVocab vk = slots.get(nk);			
			
			Object wj = vk.nextCategoricalValue( nextDouble() );
			res.add(wj);
		}
		
		return res;
	}
}
