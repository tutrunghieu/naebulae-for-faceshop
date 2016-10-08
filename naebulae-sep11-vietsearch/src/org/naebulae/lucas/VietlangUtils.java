package org.naebulae.lucas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VietlangUtils 
{
	public static File getTruyenKieu()
	{
		URL u = VietlangUtils.class.getResource("Truyen-Kieu.txt");
		System.out.println(u);
		return new File(u.getFile());
	}
	
	public static List<String> getTruyenKieuSentences()
	throws Exception
	{
		List<String> res = new ArrayList<String>();
		
		File f = getTruyenKieu();
		BufferedReader rd = new BufferedReader(new FileReader(f));
		
		while(true)
		{
			String s = rd.readLine();
			if(s==null) break;
			res.add(s);
		}
		
		rd.close();		
		
		return res;
	}

	public static String detone(String s) 
	{
		String res = "";
		for(int k=0; k<s.length(); k++)
		{
			int ck = s.charAt(k);
			res += (char)(ck < 128 ? ck : '?');
		}
		
		return res;
	}
	
	public static String detone(String s, Map<Character, Character> map) 
	{
		String res = "";
		for(int k=0; k<s.length(); k++)
		{
			Character sk = s.charAt(k);
			Character tk = map.get(sk);
			res += (tk==null ? sk : tk);
		}
		
		return res;
	}	

	public static void addEntry(Map<Character, Character> map, String sk, char tk) 
	{
		map.put(sk.charAt(0), tk);
	}


	public static String removePunctuators(String s) 
	{
		return s.replaceAll("[,.!?:;'\"��]+", "");
	}



}
