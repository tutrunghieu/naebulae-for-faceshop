package org.naebulae.mc2.vector.table;

import org.naebulae.mc2.vector.MixtureComponent;

public class Gaussian implements MixtureComponent 
{
	@Override
	public Object nextSample(double x) 
	{
		return x;
	}

}
