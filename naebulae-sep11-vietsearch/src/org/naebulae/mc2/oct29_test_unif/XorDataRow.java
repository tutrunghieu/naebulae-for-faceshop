package org.naebulae.mc2.oct29_test_unif;

import org.naebulae.util.Joiner;

public class XorDataRow {

	public double X1;
	public double X2;
	public Object label;

	public String toString()
	{
		try { return Joiner.start(" --- ").joinObject(this); }
		catch(Exception xp) { return super.toString(); }
	}
}

