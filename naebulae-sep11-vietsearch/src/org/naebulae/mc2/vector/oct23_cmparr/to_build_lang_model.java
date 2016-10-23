package org.naebulae.mc2.vector.oct23_cmparr;

import java.util.List;

public class to_build_lang_model 
{
	public static void main(String[] args) 
	{
//		ShanonPdf p1 = newShannonPdf(new String[] {}, "I", "they", "we", "I", "I");
//		ShanonPdf p2 = newShannonPdf(new String[] {"I"}, "love", "hate");
//		ShanonPdf p3 = newShannonPdf(new String[] {"we"}, "need", "want");
//		
//		for(int k=0; k<10; k++)
//		{
//			String w = p1.nextWord();
//			System.out.println(w);
//		}
		
//		m.add("I love you");
//		m.add("they love you more");
//		m.add("we love to");
//		m.add("we go to school");
		
	}

	protected static ShanonPdf newShannonPdf(List<String> prev, String... args)
	{
		ShanonPdf pdf = new ShanonPdf();
		
		pdf.previous = prev;
		
		for(String ak: args) pdf.add(ak);
		pdf.normalize();
		
		return pdf;
	}

}
