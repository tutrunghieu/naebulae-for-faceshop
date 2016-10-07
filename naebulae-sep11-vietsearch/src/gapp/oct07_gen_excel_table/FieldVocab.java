package gapp.oct07_gen_excel_table;

public abstract class FieldVocab {

	public double nextBaseDouble() 
	{
		return Math.random();
	}

	public abstract Object nextFieldValue();

}
