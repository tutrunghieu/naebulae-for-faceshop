package org.naebulae.test_md5_sha1_sha256;

public class System2 {

	public static void theEnd() 
	{
		System.out.println("------------THE END--------------");
		
	}

	public static void nop(Object src)
	{
//		return Math.exp(1.1);	
	}

	public static String join(String... args)
	{
		String res = "";
		
		for(int k=0; k<args.length; k++)
		{
			if(k>0) res += " ";
			res += args[k];
		}
				
		return res;
	}

}
