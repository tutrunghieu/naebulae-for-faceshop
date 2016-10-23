package org.naebulae.mc2.oct23_file;

import org.naebulae.util.Joiner;

public class Container1 {

	public double X1;
	public double X2;
	public double Y;
	
	public String toString()
	{
		return Joiner.start(" ---- ").join(X1, X2, Y); 
	}

}
