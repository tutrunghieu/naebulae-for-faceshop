package org.naebulae.mc2;

import java.util.ArrayList;
import java.util.List;

import org.naebulae.util.Joiner;

public class Student30 
{
//	public String name;
//	public List<Double> scores = new ArrayList<Double>();
//	public double GPA;
	
	public List<Object> scores = new ArrayList<Object>();
	public String toString()
	{
		return scores.toString();
	}

	public void add(Object s) {
		scores.add(s);
	}

}
