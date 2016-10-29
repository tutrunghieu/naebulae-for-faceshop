package org.naebulae.mc2.vector.table;

import java.awt.image.BufferedImage;
import java.util.List;

import org.apache.tomcat.jni.Buffer;
import org.naebulae.mc2.vector.MixtureComponent;
import org.naebulae.mc2.vector.MixtureModel;
import org.naebulae.mc2.vector.Sampler1970;
import org.naebulae.util.Joiner;
import org.naebulae.util.List2;
import org.naebulae.util.System2;

public class to_generate_table_gmm 
{
	public static void main(String[] args) 
	throws Exception
	{
		MixtureModel m = new MixtureModel();
		
		m.add(0.3, newMixtureComp(10, 12, 25.0, 27.0));
		m.add(0.7, newMixtureComp(70, 70, 27.0, 30.0));
		m.normalize();
		
		List<Object> x = Sampler1970.nextList(30, () -> m.nextSample());
		
		List<double[]> x1 = List2.cast(x, double[].class);

		for(double[] xk: x1)
		{
			System.out.println(Joiner.start(" ").join(xk) );
		}
		
		Visualizer.figure(150, 150, g -> Visualizer.drawList(g, x1));
		System2.theEnd();
}

	private static MixtureComponent newMixtureComp(int x0, int y0, double dx, double dy)
	{
		MixtureComponent res = new MixtureComponent() 
		{
			@Override
			public Object nextSample(double t) 
			{ 
				return new double[] {
						x0 + dx * Math.random(), 
						y0 + dy * Math.random() 
				};
			}			
		};
		
		return res;
	}
}