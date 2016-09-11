package apps.naebulae.vietsearch;

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

}
