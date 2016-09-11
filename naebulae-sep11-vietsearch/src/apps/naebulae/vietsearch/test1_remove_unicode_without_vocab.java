package apps.naebulae.vietsearch;

public class test1_remove_unicode_without_vocab {

	public static void main(String[] args)
	{
		String s = "Trăm năm trong cõi người ta";
		System.out.println("Before: " + s);
		
		s = VietUtils.detone(s);
		System.out.println("After: " + s);
	}

}
