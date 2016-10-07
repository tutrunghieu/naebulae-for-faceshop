package org.naebulae.test_md5_sha1_sha256;

import java.io.PrintWriter;

public class comparing_methods 
{

	public static void main(String[] args) 
	throws Exception
	{
		ComparingFramework<String, Integer> fw = new ComparingFramework<String, Integer>();

		
		fw.sampler = new FisherSampler<String>() 
		{
			@Override
			public String nextSample() 
			{
				return new String("abcd");
//				String res = "";
//				for(int k=0; k<500; k++) res += "abcd ";
//				return res; 
			}
		};
		
		fw.add(x -> { for(int jj=0; jj<800000; jj++) System2.nop(x.hashCode()); return 0; });
		fw.add(x -> { for(int jj=0; jj<100000; jj++) System2.nop(x.hashCode()); return 0; });
		fw.add(x -> { for(int jj=0; jj<600000; jj++) System2.nop(x.hashCode()); return 0; });
		fw.add(x -> { for(int jj=0; jj<100000; jj++) System2.nop(x.hashCode()); return 0; });
		fw.add(x -> { for(int jj=0; jj<800000; jj++) System2.nop(x.hashCode()); return 0; });
		fw.add(x -> { for(int jj=0; jj<100000; jj++) System2.nop(x.hashCode()); return 0; });
		fw.add(x -> { for(int jj=0; jj<600000; jj++) System2.nop(x.hashCode()); return 0; });
		fw.add(x -> { for(int jj=0; jj<100000; jj++) System2.nop(x.hashCode()); return 0; });
		
		fw.out = new PrintWriter("c:/test1.html");
		fw.compareMethods(100);
		fw.close();
	}

}
