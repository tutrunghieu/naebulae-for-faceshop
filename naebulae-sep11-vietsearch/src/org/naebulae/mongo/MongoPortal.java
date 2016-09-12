package org.naebulae.mongo;

import java.util.Set;
import java.util.TreeSet;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class MongoPortal {

	public MongoClient mongo;
	public MongoDatabase db;
	
	public MongoCollection<Document> getCollection(String tname) 
	{
		return db.getCollection(tname);
	}

	public void close() 
	{
		mongo.close();
	}

	public MongoIterable<String> listCollectionNames() 
	{
		return db.listCollectionNames();
	}
	
	public Set<String> getTableNameSet() 
	{
		Set<String> res = new TreeSet<String>();
		for(String sk: db.listCollectionNames()) res.add(sk);
		return res;
	}

	public FindIterable<Document> listDocuments(String tk) 
	{
		return db.getCollection(tk).find();
	}

	public void dropAllTables() 
	{
		db.drop();
	}

	public void insertDocument(String tk, Document dj) 
	{
		db.getCollection(tk).insertOne(dj);
	}

	public Object findOne(String tk, Document dj) 
	{
		for(Document d: db.getCollection(tk).find(dj) ) return d;
		return null;
	}

	public FindIterable<Document> findAll(String tk) 
	{
		return db.getCollection(tk).find();
	}
	
	public FindIterable<Document> findAll(String tk, Document where) 
	{
		return db.getCollection(tk).find(where);
	}

}
