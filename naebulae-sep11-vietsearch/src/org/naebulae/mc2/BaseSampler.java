package org.naebulae.mc2;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.naebulae.mc2.vector.table.TypedAction;

//providing categorical, gaussian, uniform
public class BaseSampler 
{
	public<T1> void normalize(Map<T1, Double> cat)
	{
		double s = 0;
		for(T1 ck: cat.keySet()) s += cat.get(ck);
		
		if(s==0) s = 1;
		for(T1 ck: cat.keySet()) cat.put(ck, cat.get(ck)/s);
	}	
	
	public<T1> void normalize(double[] cat)
	{
		double s = 0;
		for(double ck: cat) s += ck;
		
		if(s==0) s = 1;
		for(int k=0; k<cat.length; k++) cat[k] /= s;
	}	
	
	public double nextBaseDouble()
	{
		return Math.random();
	}

	public double nextUniformDouble(double a, double b) 
	{
		double t = nextBaseDouble();
		return t*a + (1-t)*b;
	}
	
	public int nextUniformInteger(int a, int b) 
	{
		double t = nextBaseDouble();
		return (int)( t*a + (1-t)*b );
	}
	
	public int nextUniformInteger(int b) 
	{
		double t = nextBaseDouble();
		return (int)Math.floor( t * b );
	}
	
	public<T1> int nextUniformInteger(T1[] b) 
	{
		double t = nextBaseDouble();
		return (int)Math.floor( t * b.length );
	}	
	
	public<T1> int nextUniformInteger(List<T1> b) 
	{
		double t = nextBaseDouble();
		return (int)Math.floor( t * b.size() );
	}	
	
	public<T1> int nextUniformInteger(Set<T1> b) 
	{
		double t = nextBaseDouble();
		return (int)Math.floor( t * b.size() );
	}	
	
	public double nextGaussianSample() 
	{
		double res = -6;
		for(int k=0; k<12; k++) res += nextBaseDouble();
		return res;
	}

	public double nextBoxMullerSample() 
	{
		double U1 = nextBaseDouble();
		U1 = Math.sqrt(-2*Math.log(U1));
		
		double U2 = nextBaseDouble();
		U2 = Math.cos(2*Math.PI*U2);
				
		return U1 * U2;
	}
	
	public double nextGaussianSample(double m, double s) 
	{
		return m + s*nextGaussianSample();
	}
	

	public<T1> T1 nextCategory(double[] cat, List<T1> sym) 
	{
		double r = nextBaseDouble(), s = 0;

		for(int k=0; k<cat.length; k++)
		{
			s += cat[k];
			if(r < s) return sym.get(k);
		}
		
		return null;
	}
	
	public<T1> T1 nextCategory(Map<T1, Double> cat)
	{
		double r = nextBaseDouble(), s = 0;
		for(T1 ck: cat.keySet())
		{
			s += cat.get(ck);
			if(r < s) return ck;
		}
		
		return null;
	}

	
	public<T1> T1 takeOne(Set<T1> cat)
	{
		int r = nextUniformInteger(cat), s = 0;
		
		for(T1 ck: cat)
		{
			s += 1;
			if(r < s) return ck;
		}
		
		return null;
	}
	
	public<T1> T1 takeOne(List<T1> cat)
	{
		int r = nextUniformInteger(cat);
		return cat.get(r);
	}
	
	public<T1> T1 takeOne(T1[] cat)
	{
		int r = nextUniformInteger(cat);
		return cat[r];
	}

		
}
