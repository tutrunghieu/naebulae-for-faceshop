package org.naebulae.mc2.catseq.demo;

import org.naebulae.mc2.Catseq;

public class test_catseq {

	public static void main(String[] args)
	{
		Catseq s = new Catseq();
		
		s.add("abc");
		s.add("a");
		s.add("b");
		s.add("c");
		
		String t1 = s.getSymbolString(" ");
		System.out.println(t1);
	}

}
