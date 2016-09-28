package org.naebulae.test_md5_sha1_sha256;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

public class Joiner 
{
	private String cm;

	public static Joiner start(String cm)
	{
		Joiner res = new Joiner();
		res.cm = cm;
		return res;
	}


	public String joinObject(Object ik)
	throws Exception
	{
		String res = "";
		
		for(Field fj: ik.getClass().getFields())
		if( Modifier.isPublic(fj.getModifiers()) )
		{
			if(res.length() > 0) res += cm;
			res += fj.get(ik);
		}
		
		return res;
	}
	
	public String joinMap(Map<String, Object> m)
	throws Exception
	{
		String res = "";
		
		for(String mk: m.keySet())
		{
			if(res.length() > 0) res += cm;
			res += m.get(mk);
		}
		
		return res;
	}
	
	public String joinArrObj(Object... args) 
	{
		String res = "";
		
		for(Object ak: args)
		{
			if(res.length() > 0) res += cm;
			res += ak;
		}
		
		return res;
	}

	public String joinArrStr(String... args) 
	{
		String res = "";
		
		for(Object ak: args)
		{
			if(res.length() > 0) res += cm;
			res += ak;
		}
		
		return res;
	}
	
	public String join(int... args)
	{
		String res = "";
		
		for(Object ak: args)
		{
			if(res.length() > 0) res += cm;
			res += ak;
		}
		
		return res;
	}
	
	public String join(long... args)
	{
		String res = "";
		
		for(Object ak: args)
		{
			if(res.length() > 0) res += cm;
			res += ak;
		}
		
		return res;
	}	
	
	public String join(double... args)
	{
		String res = "";
		
		for(Object ak: args)
		{
			if(res.length() > 0) res += cm;
			res += ak;
		}
		
		return res;
	}	
	


}
