package org.naebulae.mc2.string;

import java.util.Arrays;
import java.util.List;

import org.naebulae.mc2.MarkovSampler;
import org.naebulae.mc2.MarkovSymbolPdf;
import org.naebulae.mc2.vector.McString;
import org.naebulae.util.System2;

public class to_generate_string_markov_mass 
{

	@SuppressWarnings("unused")
	public static void main(String[] args) 
	throws Exception
	{
		MarkovSampler g = new MarkovSampler(20, 25);
		g.setGrams(2);
		
		MarkovSymbolPdf n = g.addStatus(newPrefix(), new MarkovSymbolPdf("n", "I", "you", "we"));
		MarkovSymbolPdf v = g.addStatus(newPrefix(n), new MarkovSymbolPdf("v", "come", "go", "like"));
		MarkovSymbolPdf vt = g.addStatus(newPrefix(n), new MarkovSymbolPdf("vt", "take", "took", "pick"));
		MarkovSymbolPdf a = g.addStatus(newPrefix(n, v), new MarkovSymbolPdf("a", "here", "there", "this", "that"));
		g.addStatus(newPrefix(n, vt), a);
		
		MarkovSymbolPdf n1 = g.addStatus(newPrefix(), new MarkovSymbolPdf("n1", "he", "she", "it"));
		MarkovSymbolPdf v1 = g.addStatus(newPrefix(n1), new MarkovSymbolPdf("v1", "comes", "goes", "wants"));
		MarkovSymbolPdf a1 = g.addStatus(newPrefix(n1, v1), new MarkovSymbolPdf("a1", "crazy", "mad", "wild"));
		
		g.normalize();
		g.print();
		
		for(int k=0; k<20; k++)
		{
			McString<String> vk = g.nextString();
			System.out.println(vk);
		}
		
		System2.theEnd();
	}

	private static List<MarkovSymbolPdf> newPrefix(MarkovSymbolPdf... n) 
	{
		return Arrays.asList(n);
	}


}
