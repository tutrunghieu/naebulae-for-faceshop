package gapp.oct07_gen_excel_table;

import java.io.File;

import org.naebulae.util.System2;

public class test1_sampling_table {

	public static void main(String[] args) 
	throws Exception
	{
		File f = new File("C:/Users/henrytu/Desktop/test1.txt");
		
		TableGenetator g = new TableGenetator(f);
		
		g.addField("X1", new FieldVocabUnif(-10, 10));
		g.addField("X2", new FieldVocabUnif(-20, 20));
		g.addField("F", null);
		
		g.generate(1000, x -> { 
			x[2] = 1234*System2.getDouble(x, 0) + 4321*System2.getDouble(x, 1); 
		});
		
		g.close();
		
		System2.theEnd();
	}

}
