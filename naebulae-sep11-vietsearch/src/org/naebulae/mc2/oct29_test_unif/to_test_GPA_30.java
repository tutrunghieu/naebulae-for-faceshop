package org.naebulae.mc2.oct29_test_unif;

import java.util.List;

import org.naebulae.mc2.BaseSampler;
import org.naebulae.mc2.Student30;
import org.naebulae.util.List2;

public class to_test_GPA_30 
{
	public static void main(String[] args) 
	throws Exception
	{
		BaseSampler b = new BaseSampler();
		TypedSampler<Student30> s = new TypedSampler<Student30>();
		
		List<Student30> items = s.nextList2(100, Student30.class,
				(k, x) -> { 
					x.add("student " + k);
					for(int t=0; t<30; t++) x.add( b.nextUniformDouble(0, 100) );
				});
		
		List2.print(items);
	}

}
