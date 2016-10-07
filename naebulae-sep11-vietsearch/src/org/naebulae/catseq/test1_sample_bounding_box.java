package org.naebulae.catseq;

public class test1_sample_bounding_box {

	public static void main(String[] args)
	{
		SamplerUniformBox g = new SamplerUniformBox();
		
		g.addSlot("X1", x -> -10*x + 10*(1-x) );
		g.addSlot("X3", x -> -123*x + 456*(1-x) );
		g.addSlot("X4", x -> 5 );
		
		for(Catseq sk: g.nextObjectList(1000))
			System.out.println(sk.getSymbolString(" --- "));

	}

}
