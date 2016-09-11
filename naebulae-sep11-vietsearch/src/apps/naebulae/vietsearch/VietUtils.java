package apps.naebulae.vietsearch;

import java.util.Map;

public class VietUtils {

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



}
