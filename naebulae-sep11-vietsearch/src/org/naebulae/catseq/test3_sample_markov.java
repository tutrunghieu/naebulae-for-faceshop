package org.naebulae.catseq;

import org.naebulae.util.Map2;
import org.naebulae.util.System2;

public class test3_sample_markov {

	public static void main(String[] args)
	{
		Sampler<Catseq> g1 = new SamplerMarkov();
		System2.consume(g1);
		
		SamplerMarkov g = new SamplerMarkov();
		
		MarkovState s1 = g.addState(null, Map2.newMap("red->0.3", "green->0.5", "blue->0.2"));
		
		MarkovState s2 = g.addState(g.states(s1), 
				Map2.newMap("here->0.3", "there->0.5", "we->0.2"));
		
		g.addLink(s1, s1);
		
		MarkovState s3 = g.addState(g.states(s1, s2),
				Map2.newMap("go->0.3", "come->0.5", "love->0.2"));
		
		g.addLink(s3, s3);
		
		for(Catseq sk: g.nextObjectList(1000))
			System.out.println(sk.getSymbolString(" --- "));

		System2.consume(s1, s2, s3);
	}

}
