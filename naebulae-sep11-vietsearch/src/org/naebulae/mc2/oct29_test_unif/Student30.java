package org.naebulae.mc2.oct29_test_unif;

import java.util.ArrayList;
import java.util.List;

import org.naebulae.util.Joiner;

public class Student30 {

	public String name;
	public List<Double> scores = new ArrayList<Double>();
	public double GPA;
	
	public String toString()
	{
		return Joiner.start(" --- ").joinArrObj(name, scores, GPA);
	}

}
