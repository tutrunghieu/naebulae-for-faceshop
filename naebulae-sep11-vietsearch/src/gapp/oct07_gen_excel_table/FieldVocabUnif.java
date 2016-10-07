package gapp.oct07_gen_excel_table;

public class FieldVocabUnif extends FieldVocab
{
	private double a;
	private double b;

	public FieldVocabUnif(double a0, double b0) 
	{
		a = a0;
		b = b0;
	}
	
	public Double nextFieldValue()
	{
		double t = super.nextBaseDouble();
		return a*t + b*(1-t);		
	}

}
