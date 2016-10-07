package gapp.abc_search;

import gapp.xorcos.VectorSampler;

public abstract class StringSampler extends VectorSampler<String>
{
	protected char[] vocab;

	public StringSampler(char[] v) 
	{
		vocab = v;
	}

	public abstract int nextLength();

//	public List<String> nextStringList(int n, char[] v) 
//	{
//		List<String> res = new ArrayList<String>();
//		for(int k=0; k<n; k++) res.add( nextString(v) );
//		return res;
//	}
//	
//	public Set<String> nextStringSet(int n, char[] v) 
//	{
//		Set<String> res = new LinkedHashSet<String>();
//		for(int k=0; k<n; k++) res.add( nextString(v) );
//		return res;
//	}

	@Override
	public String nextVector() 
	{
		char[] v = vocab;
		
		String res = "";
		int len = nextLength();
		
		for(int k=0; k<len; k++) 
		{
			int xk = nextBaseInt(v.length);
			res += v[xk];
		}
		
		return res;
	}

}
