package org.naebulae.util;

public class System2
{

	public static final boolean IGNORE_THIS_BLOCK = false;

	public static void hr(Object name) 
	{
		System.out.println("----------------- " + name + "----------");
	}
	
	public static void nv(String name, Object val) 
	{
		System.out.println(name + "=" + val);
	}

	public static void nvq(String name, Object val) 
	{
		System.out.println(name + "=[" + val + "]");
	}

	public static void printVector(double... x)
	{
		for(int n=x.length, k=0; k<n; k++)
		{
			System.out.print(x[k] + " ");			
		}
		
		System.out.println();
	}

	public static void printVector(int... x)
	{
		for(int n=x.length, k=0; k<n; k++)
		{
			System.out.print(x[k] + " ");			
		}
		
		System.out.println();
	}
	
	public static void printVector(long... x)
	{
		for(int n=x.length, k=0; k<n; k++)
		{
			System.out.print(x[k] + " ");			
		}
		
		System.out.println();
	}

	public static Double getDouble(Object[] x, int k) 
	{
		return (Double)x[k];
	}

	public static void consume(Object... obj)
	{	
	}	

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

	public static String joinObjects(String cm, Object... args)
	{
		String res = "";
		
		for(int k=0; k<args.length; k++)
		{
			if(k>0) res += cm;
			res += args[k];
		}
				
		return res;
	}
}
