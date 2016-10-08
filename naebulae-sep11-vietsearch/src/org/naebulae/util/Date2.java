package org.naebulae.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date2 {

	public static String today_YMD() 
	{
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		return fmt.format(new Date());
	}

	public static String today_YMD(String tag) 
	{
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		return fmt.format(new Date()) + "-" + tag;
	}
}
