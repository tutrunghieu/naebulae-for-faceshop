package org.naebulae.mc2.oct29_test_unif;

import java.util.List;
import java.util.Map;

import org.naebulae.mc2.oct23_file.BaseSampler;
import org.naebulae.nlp.lucas.Jaccard;
import org.naebulae.util.List2;

import gapp.xorcos.stat.Meanvar;

public class to_test_class_30 {

	public static void main(String[] args) 
	throws Exception
	{
		BaseSampler b = new BaseSampler();
		TypedSampler<Student30> s = new TypedSampler<Student30>();
		
		List<Student30> items = s.nextList2(9000, Student30.class,
				(k, x) -> { 
					x.name = "student " + k;
					for(int t=0; t<30; t++) x.scores.add( b.nextUniformDouble(0, 100) );
					x.GPA = Meanvar.average(x.scores);
				});
		
		List2.print(items);
	}

}
