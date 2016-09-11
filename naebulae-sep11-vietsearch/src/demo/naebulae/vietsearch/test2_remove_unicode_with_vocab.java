package demo.naebulae.vietsearch;

import java.util.Map;
import java.util.TreeMap;

import apps.naebulae.vietsearch.VietlangUtils;

public class test2_remove_unicode_with_vocab {

	public static void main(String[] args)
	{
		String s = "Trăm năm trong cõi người ta";
		System.out.println("Before: " + s);
		
		Map<Character, Character> map = new TreeMap<Character, Character>();
		VietlangUtils.addEntry(map, "ă", 'a');
		VietlangUtils.addEntry(map, "õ", 'o');
		VietlangUtils.addEntry(map, "ư", 'u');
		VietlangUtils.addEntry(map, "ờ", 'o');
		
		s = VietlangUtils.detone(s, map);
		System.out.println("After: " + s);
	}

}
