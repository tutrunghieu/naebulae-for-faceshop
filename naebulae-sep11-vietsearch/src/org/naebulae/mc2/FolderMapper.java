package org.naebulae.mc2;

import java.io.File;

import org.naebulae.util.Date2;

public class FolderMapper {

	private File dataFolder;

	public static FolderMapper startBigData(String tag) 
	{
		FolderMapper res = new FolderMapper();
		res.dataFolder = new File("/opt/naebulae-databases/generated/" + Date2.today_YMD(tag));
		
		return res;
	}


}
