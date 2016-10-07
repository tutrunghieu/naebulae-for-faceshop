package gapp.abc_search;

import java.util.List;

import gapp.xorcos.Sampler;

public class test1_generating_and_searching 
{

	public static void main(String[] args) 
	{
		StringSampler s = new StringSampler(new char[] { 'a', 'b', 'c'})
		{
			@Override
			public double nextBaseUnif01() { return Sampler.coin197.nextDouble(); }
			
			@Override
			public int nextLength() { return 3; }
		};
		
		List<String> items = s.nextDoubleList(120);
		for(String ik: items) 
		{
			System.out.println(ik);
			if(ik.equals("bbb")) System.out.println("---- found it!");
		}
		
		return;
	}

}
