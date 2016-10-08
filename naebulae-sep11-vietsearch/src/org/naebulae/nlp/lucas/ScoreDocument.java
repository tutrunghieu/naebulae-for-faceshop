package org.naebulae.nlp.lucas;

import java.lang.reflect.Field;

import org.bson.Document;

public class ScoreDocument 
{
	public double score;
	public Object document;

	public ScoreDocument(double sk, Object dk) 
	{
		score = sk;
		document = dk;
	}

	public<T1> T1 getDocumentAsType(Class<T1> cl)
	throws Exception
	{
		T1 res = cl.newInstance();
		
		Document sk = (Document)document;
		for(String fj: sk.keySet())
		{
			Field mj = cl.getField(fj);
			Object vj = sk.get(fj);
			
			mj.set(res, vj);
		}
		
		return res;
	}

}
