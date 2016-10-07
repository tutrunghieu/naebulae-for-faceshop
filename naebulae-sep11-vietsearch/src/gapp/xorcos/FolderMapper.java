package gapp.xorcos;

import java.io.File;

public class FolderMapper {

	private File dataFolder;

	public static FolderMapper startBigData(String tag) 
	{
		FolderMapper res = new FolderMapper();
		res.dataFolder = new File("/opt/naebulae-databases/generated/" + Date2.today_YMD(tag));
		
		return res;
	}


}
