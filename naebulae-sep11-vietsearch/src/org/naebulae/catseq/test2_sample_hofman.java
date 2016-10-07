package org.naebulae.catseq;

import org.naebulae.util.Map2;

import gapp.xorcos.System2;

public class test2_sample_hofman {

	public static void main(String[] args)
	{
		Sampler<Catseq> g1 = new SamplerHofman(10, 20);
		System2.consume(g1);
		
		SamplerHofman g = new SamplerHofman(100, 200);
		
		g.addTopic(0.7, Map2.newMap("red->0.3", "green->0.5", "blue->0.2"));
		g.addTopic(0.1, Map2.newMap("here->0.3", "there->0.5", "we->0.2"));
		g.addTopic(0.2, Map2.newMap("go->0.3", "come->0.5", "love->0.2"));
		
		for(Catseq sk: g.nextObjectList(1000))
			System.out.println(sk.getSymbolString(" --- "));

	}

}
