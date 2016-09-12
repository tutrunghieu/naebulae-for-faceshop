package org.naebulae.mongo;

import java.util.List;

import org.bson.Document;

public interface MongoAccess1970 {

	List<String> getTableNames();

	List<Document> fetchRowsAsDocuments(String tk);
	List<Document> fetchRowsAsDocuments(String tk, Document where);

	void insertDocument(String tk, Document dj);

	void deleteDocuments(String tk, Document where);

}
