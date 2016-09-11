package demo.naebulae.vietsearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;

import org.naebulae.vietsearch.VietlangUtils;

public class test3_detone_truyen_kieu 
{
	public static void main(String[] args)
	throws Exception
	{
		List<String> lines = VietlangUtils.getTruyenKieuSentences();
		
		for(int k=0; k<lines.size(); k++)
		{
			lines.set(k, VietlangUtils.removePunctuators( lines.get(k)).trim() );
		}
		
		PrintWriter out = new PrintWriter("C:\\Users\\henrytu\\Desktop\\out.txt");
		
		int cnt = 1;
		for(String s: lines)
		{
			s = VietlangUtils.removePunctuators(s);
			System.out.println(cnt + ": " + s + " >> " + VietlangUtils.detone(s));
			out.println(s);
			
			String[] words = s.trim().split("\\s+");
			if(words.length != 6 && words.length != 8) 
				throw new Exception("Invalid verse");
			
			cnt++;
		}
		
		out.close();
	}

}
