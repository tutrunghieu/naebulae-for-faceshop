package org.naebulae.util.mongo;

import org.bson.Document;

public interface MongoPredicate {

	public boolean invokePredicate(Document dj);

}
