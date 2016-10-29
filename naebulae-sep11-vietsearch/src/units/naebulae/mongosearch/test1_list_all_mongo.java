package units.naebulae.mongosearch;

import org.naebulae.util.mongo.MongoPortal;
import org.naebulae.util.mongo.MongoUtils;

public class test1_list_all_mongo 
{
	//"C:\Program Files\MongoDB\Server\3.2\bin\mongorestore"  -d  cabine-101 D:\out-java\mongo-backup-from98-aug24\cabine-101
	
	public static void main(String[] args)
	{
		MongoPortal port = MongoUtils.openPortal("cabine-101");
		
		for(String tname: port.getTableNameSet())
		{
			System.out.println(tname);
		}

		port.close();
	}

}
