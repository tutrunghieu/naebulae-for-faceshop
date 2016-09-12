package org.naebulae.lucas;

import org.bson.Document;

public interface ScoringFunc {

	double similarScore(String q, Document dk);

}
