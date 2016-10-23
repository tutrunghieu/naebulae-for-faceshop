package org.naebulae.mc2.vector;

import java.util.LinkedHashMap;
import java.util.Map;

public class MixtureModel extends Sampler1970
{
	protected Map<MixtureComponent, Double> items = new LinkedHashMap<MixtureComponent, Double>(); 
	
	public void add(double pj, MixtureComponent cj) 
	{
		items.put(cj, pj);		
	}
	

	public void normalize() 
	{
		double v = 0;
		
		for(MixtureComponent sk: items.keySet())
		{
			v += items.get(sk);
		}	
		for(MixtureComponent sk: items.keySet())
		{
			double vk = items.get(sk);
			items.put(sk, vk/v);
		}	
	}	
	
	public MixtureComponent nextComponent() 
	{
		double r = nextBaseDouble(), s = 0;
		
		for(MixtureComponent sk: items.keySet())
		{
			s += items.get(sk);
			if(r < s) return sk;
		}
			
		return null;		
	}	

	public Object nextSample() 
	{
		MixtureComponent pk = nextComponent();
		return pk.nextSample(nextBaseDouble());
	}

}
