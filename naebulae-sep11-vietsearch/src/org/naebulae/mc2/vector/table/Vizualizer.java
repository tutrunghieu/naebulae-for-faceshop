package org.naebulae.mc2.vector.table;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

public class Vizualizer 
{

	public static BufferedImage newImage(int W, int H) 
	{
		BufferedImage res = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
		return res;
	}

	public static void figure(int W, int H, TypedAction<Graphics> lf) 
	throws Exception
	{
		BufferedImage img = newImage(W, H);
		figure(img, lf);
	}
	
	public static void figure(BufferedImage img, TypedAction<Graphics> lf) 
	throws Exception
	{
		Graphics g = img.getGraphics();
		
		g.setColor(Color.white);
		g.fillRect(0, 0, img.getWidth(), img.getHeight());
		
		lf.invokeAction(g);
		g.dispose();
		
		File f = new File("/opt/images/" + System.currentTimeMillis() + ".png");
		f.getParentFile().mkdirs();
		
		ImageIO.write(img, "png", f);
		Desktop.getDesktop().open(f);
	}

	public static void drawList(Graphics g, List<double[]> x) 
	{
	
		g.setColor(Color.blue);
		for(double[] xk: x)
		{
			int xt = (int)xk[0];
			int yt = (int)xk[1];
			g.drawLine(xt, yt, xt, yt);
		}
		
		return;
	}

	public static<T1> void printHist(Map<T1, Double> h, double mul) 
	{
		for(T1 nj: h.keySet())
		{
			double n = h.get(nj)*mul;
			for(int k=0; k<n; k++) System.out.print('-');
			System.out.println(" : " + nj + " : " + h.get(nj));
		}
		
	}

}
