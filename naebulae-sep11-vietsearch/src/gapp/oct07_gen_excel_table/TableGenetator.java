package gapp.oct07_gen_excel_table;

import java.io.File;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.naebulae.util.InitAction;
import org.naebulae.util.System2;

public class TableGenetator {

	private File dataFile;
	private PrintWriter out;
	private Map<String, Object> fields = new LinkedHashMap<String, Object>();

	public TableGenetator(File f) 
	throws Exception
	{
		dataFile = f;
		out = new PrintWriter(f);
	}
	
	public void close()
	{
		out.close();
	}

	public void addField(String fname, Object fvals) 
	{
		fields.put(fname, fvals);
	}

	public void generate(int n, InitAction<Object[]> lf) 
	{
		int nf = fields.size();
		
		addSample(fields.keySet().toArray());
		
		for(int k=0; k<n; k++)
		{
			Object[] vals = new Object[nf];
			
			int j=0;
			for(String fj: fields.keySet())
			{
				Object vj = fields.get(fj);
				if(vj != null && vj instanceof FieldVocab) 
				{
					vals[j] = ((FieldVocab)vj).nextFieldValue();
//					System.out.println(vals[j]);
				}
				
				j++;
			}
			
			lf.invokeInitAction(vals);
			
			addSample(vals);
		}
		
		return;
	}

	private void addSample(Object[] vals) 
	{
		String s = System2.joinObjects(", ", vals);
		out.println(s);
	}

}
