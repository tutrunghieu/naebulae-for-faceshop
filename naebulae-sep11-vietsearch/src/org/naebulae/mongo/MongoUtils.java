package org.naebulae.mongo;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringEscapeUtils;
import org.bson.Document;
import org.codehaus.jackson.map.ObjectMapper;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoUtils 
{
	private static ObjectMapper json = new ObjectMapper();
	
	public static CounterSet listAll(MongoAccess1970 db, File tar)
	throws Exception
	{
		CounterSet s = new CounterSet();
		
		for(String tk: db.getTableNames())
		{
						
			for(Document dj: db.fetchRowsAsDocuments(tk))
			{
				Object dj_num = dj.get("_id");
				
				System.out.println("Writing " + tk + ":" + dj_num);
				
				File dj_file = new File(tar.getAbsolutePath() + "/" + tk + "/" + dj_num);
				dj_file.getParentFile().mkdirs();
				
				json.writeValue(dj_file, convertDocToMap(dj) );
				
				s.increase("total");
				s.increase(tk);
			}
		}
		
		return s;
	}
	
	@SuppressWarnings("unused")
	public static CounterSet checkAll(MongoAccess1970 db)
	throws Exception
	{
		CounterSet s = new CounterSet();
		
		for(String tk: db.getTableNames())
		for(Document dj: db.fetchRowsAsDocuments(tk))
		{
			s.increase("total");
			s.increase(tk);
		}
		
		for(String sk: s.keySet())
			System.out.println(sk + ":" + s.value(sk));
		
		return s;
	}	
	
	public static Map<String, List<String>> listRowKeys(MongoAccess1970 db)
	throws Exception
	{
		 Map<String, List<String>> res = new  LinkedHashMap<String, List<String>>();
		
		for(String tk: db.getTableNames())
		{
			List<String> rk = new ArrayList<String>();
			res.put(tk, rk);
			
			for(Document dj: db.fetchRowsAsDocuments(tk))
			{
				rk.add(dj.get("_id").toString());
			}
		}
		
		return res;
	}
		
	@SuppressWarnings("unchecked")
	public static Document documentFromMap(Object src) 
	{
		return documentFromMap((Map<String, Object>) src);
	}
	
	public static Document documentFromMap(Map<String, Object> src) 
	{
		Document res = new Document();
		
		for(String sk: src.keySet())
		if(!sk.equals("_id"))
		{
			res.put(sk, src.get(sk));
		}
				
		return res;
	}
	
	public static Map<String, Object> convertDocToMap(Document src) 
	{
		Map<String, Object> res = new LinkedHashMap<String, Object>();
		
		for(String sk: src.keySet())
		if(!sk.equals("_id"))
		{
			res.put(sk, src.get(sk));
		}
				
		return res;
	}
	
	public static Map<String, Object> convertDocToMapJava(Document src) 
	{
		Map<String, Object> res = new LinkedHashMap<String, Object>();
		
		for(String sk: src.keySet())
		if(!sk.equals("_id"))
		{
			Object vk = src.get(sk);
			if(vk != null) vk = StringEscapeUtils.escapeJava(vk.toString()); 
			res.put(sk, vk);
		}
				
		return res;
	}	

	@SuppressWarnings("unchecked")
	public static void importFromJson(File tar, MongoAccess1970 db)
	throws Exception
	{
		CounterSet s = new CounterSet();
		if(!tar.exists()) return;
		
		for(File tk_file: tar.listFiles()) 
		if(tk_file.isDirectory())
		for(File fj: tk_file.listFiles()) 
		if(fj.isFile())
		try
		{
			String tk = tk_file.getName();
			Map<String, Object> rj = json.readValue(fj, LinkedHashMap.class);
			
			Document dj = MongoUtils.documentFromMap(rj);
			
			db.insertDocument(tk, dj);
			
			s.increase("total");
			s.increase(tk);
		}
		catch(Exception xp) 
		{ 
			System.out.println(fj.getAbsolutePath());
			xp.printStackTrace(System.out);
			break; 
		}
			
		for(String sk: s.keySet()) {
			System.out.println(sk + ": " + s.value(sk));
		}
	}

	@SuppressWarnings("unchecked")
	public static Document documentFromString(String dj) 
	throws Exception
	{
		Document res = new Document(); 
		
		Map<String, Object> src = json.readValue(dj, LinkedHashMap.class);
		
		for(String sk: src.keySet()) res.append(sk, src.get(sk));
		
		return res;
	}

	@SuppressWarnings("unchecked")
	public static Document documentFromStringJava(String dj) 
	throws Exception
	{
		Document res = new Document(); 
		
		Map<String, Object> src = json.readValue(dj, LinkedHashMap.class);
		
		for(String sk: src.keySet()) 
		{
			Object vk = src.get(sk);
			if(vk != null) vk = StringEscapeUtils.unescapeJava(vk.toString());
			res.append(sk, vk);
		}
		
		return res;
	}
	
	public static String dataHost = "localhost";
	public static int dataPort = 27017;
	
	public static MongoPortal openPortal(String dname)
	{
		MongoPortal res = new MongoPortal();
		res.mongo = new MongoClient(dataHost, dataPort);
		res.db = res.mongo.getDatabase(dname);

//		MongoCollection<Document> table = res.getCollection("");
//		res.close();
		
		return res;
	}
	
	public static MongoPortal openPortal(String dname, String host, int port)
	{
		MongoPortal res = new MongoPortal();
		res.mongo = new MongoClient(host, port);
		res.db = res.mongo.getDatabase(dname);
		
		return res;
	}
	
	public static MongoPortal openPortal(Map<String, Object> conf)
	{
		String host = conf.get("dataHost").toString();
		Integer port = Integer.parseInt( conf.get("dataPort").toString() );
		String name = conf.get("dataName").toString();
		
		MongoPortal res = new MongoPortal();
		
		res.mongo = new MongoClient(host, port);
		res.db = res.mongo.getDatabase(name);

		return res;
	}
	
	public static void insertDocument(String dname, String tname, Document doc) 
	{
		MongoClient mongo = new MongoClient(dataHost, dataPort);
		MongoDatabase db = mongo.getDatabase(dname);

		MongoCollection<Document> table = db.getCollection(tname);
		table.insertOne(doc);
		mongo.close();
	}
//
//	public static boolean insertDocumentIf(MongoPortal dp, String tname, Document dj) 
//	{
////		MongoClient mongo = new MongoClient(dataHost, dataPort);
////		MongoDatabase db = mongo.getDatabase(dname);
//
//		MongoCollection<Document> table = dp.getCollection(tname);
//		
//		Document where = new Document();
//		for(String nk: dj.keySet()) if(!nk.equals("_id")) where.put(nk, dj.get(nk));
//		
//		Document found = table.find(where).first(); 
//		if(found == null) table.insertOne(dj);
//		
//		return found==null;
//	}
	
	public static boolean insertDocumentIf(MongoPortal dname, String tname, Document dj) 
	{
		MongoCollection<Document> table = dname.getCollection(tname);
		
		Document where = new Document();
		for(String nk: dj.keySet()) if(!nk.equals("_id")) where.put(nk, dj.get(nk));
		
		Document found = table.find(where).first(); 
		if(found == null) table.insertOne(dj);
		
		return found==null;
	}	
	
	public static void insertDocument(MongoPortal p, String tk, Document rj) 
	{
		p.getCollection(tk).insertOne(rj);
	}

	
	public static Map<String, List<String>> listRowKeys1(MongoAccess1970 db, String whereStr) 
	throws Exception
	{
		if(whereStr==null || whereStr.length()==0) return listRowKeys(db);
		
		Map<String, List<String>> res = new  LinkedHashMap<String, List<String>>();
			
		for(String tk: db.getTableNames())
		{
			List<String> rk = new ArrayList<String>();
			res.put(tk, rk);
			
			Document where = documentFromWhereString(whereStr);
			
			for(Document dj: db.fetchRowsAsDocuments(tk, where))
			{
				rk.add(dj.get("_id").toString());
			}
		}
		
		return res;		
	}
	
	
	public static Map<String, List<String>> listRowKeys2(MongoAccess1970 db, String whereStr) 
	throws Exception
	{
		if(whereStr==null || whereStr.length()==0) return listRowKeys(db);
		
		Map<String, List<String>> res = new  LinkedHashMap<String, List<String>>();
			
		for(String tk: db.getTableNames())
		{
			List<String> rk = new ArrayList<String>();
			res.put(tk, rk);
			
			Document where = documentFromWhereString(whereStr);
			
			for(Document dj: db.fetchRowsAsDocuments(tk, where))
			{
				rk.add(dj.get("_id").toString());
			}
		}
		
		return res;		
	}

	public static Document documentFromWhereString(String whereStr) 
	{
		String[] cells = whereStr.split(";");
		
		Document res = new Document();
		for(String ck: cells)
		{
			String[] lr = ck.split(":");
			if(lr.length != 2 || lr[0].trim().length() == 0) continue; 
			
			res.put(lr[0].trim(), lr[1].trim());
		}
		
		return res;
	}

	public static boolean documentContains(Document doc, String fname, Object fval) 
	{
		Object v = doc.get(fname);
		if(v==null) return false;
		return v.equals(fval);
	}

	public static void deleteDocumentsContaining(MongoAccess1970 db, String fname, Object fval)
	throws Exception
	{
		Document where = new Document(fname, fval);
		
		for(String tk: db.getTableNames())
		{
			System.out.println("Cleaning " + tk + " where " + where);
			db.deleteDocuments(tk, where);
		}

		return;
	}

	public static double jaccardScore(Set<String> s1, Set<String> s2) 
	{
		int c = 0;
		for(String x: s1) if(s2.contains(x)) c++;
		
		int s = s1.size() + s2.size() - c;
			
		return c/(double)(s==0 ? 1 : s);
	}


	public static double compareCounters(String db1, String db2) 
	{
		CounterSet s1 = readCounters(db1);
		s1.print();
		
		CounterSet s2 = readCounters(db2);
		s2.print();
		
		return jaccardScore(s1.toSetString(), s2.toSetString()); 
	}

	@SuppressWarnings("unused")
	public static CounterSet readCounters(String dbname) 
	{
		CounterSet s = new CounterSet();
		
		MongoPortal db = MongoUtils.openPortal(dbname);
		
		for(String tk: db.listCollectionNames())
		for(Document dj: db.listDocuments(tk))
		{
			s.increase("total");
			s.increase(tk);
		}
		
		db.close();
		
		return s;				
	}


	@SuppressWarnings("unchecked")
	public static void deployFromJessie(File tar, MongoAccess1970 db)
	throws Exception
	{
		CounterSet s = new CounterSet();
		if(!tar.exists()) return;
		
		for(File tk_file: tar.listFiles()) 
		if(tk_file.isDirectory())
		for(File fj: tk_file.listFiles()) 
		if(fj.isFile())
		try
		{
			String tk = tk_file.getName();
			Map<String, Object> rj = json.readValue(fj, LinkedHashMap.class);
			
			Document dj = MongoUtils.documentFromMap(rj);
			
			db.insertDocument(tk, dj);
			
			s.increase("total");
			s.increase(tk);
		}
		catch(Exception xp) 
		{ 
			System.out.println(fj.getAbsolutePath());
			xp.printStackTrace(System.out);
			break; 
		}
			
		for(String sk: s.keySet()) {
			System.out.println(sk + ": " + s.value(sk));
		}
	}
	
	public static CounterSet exportDocumentsWithJessie(String dbname, File tar)
	throws Exception
	{
		CounterSet s = new CounterSet();
		
		MongoPortal db = MongoUtils.openPortal(dbname);
		
		for(String tk: db.listCollectionNames())
		for(Document dj: db.listDocuments(tk))
		{
				Object dj_num = dj.get("_id");
				
				System.out.println("Writing " + tk + ":" + dj_num);
				
				File dj_file = new File(tar.getAbsolutePath() + "/" + tk + "/" + dj_num);
				dj_file.getParentFile().mkdirs();
				
				json.writeValue(dj_file, dj);
				
				s.increase("total");
				s.increase(tk);
		}
		
		db.close();
		
		return s;
	}	

	public static CounterSet exportWithJessie(String dbname, File tar)
	throws Exception
	{
		CounterSet s = new CounterSet();
		
		MongoPortal db = MongoUtils.openPortal(dbname);
		
		for(String tk: db.listCollectionNames())
		for(Document dj: db.listDocuments(tk))
		{
				Object dj_num = dj.get("_id");
				
				System.out.println("Writing " + tk + ":" + dj_num);
				
				File dj_file = new File(tar.getAbsolutePath() + "/" + tk + "/" + dj_num);
				dj_file.getParentFile().mkdirs();
				
				json.writeValue(dj_file, convertDocToMap(dj) );
				
				s.increase("total");
				s.increase(tk);
		}
		
		db.close();
		
		return s;
	}

	public static Document documentFromObject(Object item)
	throws Exception
	{
		Document res = new Document();
		
		for(Field fj: item.getClass().getFields())
		if( Modifier.isPublic(fj.getModifiers()) )
		{
			Object vj = fj.get(item);
			res.put(fj.getName(), vj);
		}
		
		return res;
	}
	
	public static Document documentFromObjectNotNull(Object item)
	throws Exception
	{
		Document res = new Document();
		
		for(Field fj: item.getClass().getFields())
		if( Modifier.isPublic(fj.getModifiers()) )
		{
			Object vj = fj.get(item);
			if(vj != null) res.put(fj.getName(), vj);
		}
		
		return res;
	}

	public static void copyDocuments(String source, String target, MongoPredicate lf) 
	{
		MongoPortal dbs = MongoUtils.openPortal(source);
		MongoPortal dbt = MongoUtils.openPortal(target);
		
		for(String tk: dbs.listCollectionNames())
		for(Document dj: dbs.listDocuments(tk))
		if( lf.invokePredicate(dj) )
		{
			if(dbt.findOne(tk, dj) == null) {
				System.out.println("Inserting");
				dbt.insertDocument(tk, dj);
			}
		}
		
		dbs.close();
		dbt.close();
	}

	public static void copyDocuments(String source, String target, String[] colnames) 
	{
		MongoPortal dbs = MongoUtils.openPortal(source);
		MongoPortal dbt = MongoUtils.openPortal(target);
		
		for(String tk: colnames)
		for(Document dj: dbs.listDocuments(tk))
		{
			if(dbt.findOne(tk, dj) == null) {
				System.out.println("Inserting");
				dbt.insertDocument(tk, dj);
			}
		}
		
		dbs.close();
		dbt.close();		
	}

	public static List<Document> listDocuments(String tname, String dname) 
	{
		MongoPortal p = MongoUtils.openPortal(dname);
		
		List<Document> res = new ArrayList<Document>();
		for(Document dk: p.listDocuments(tname)) res.add(dk);
		p.close();
		
		return res;
	}


}
