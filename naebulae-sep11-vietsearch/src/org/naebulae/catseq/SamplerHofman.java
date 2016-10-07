package org.naebulae.catseq;

public class SamplerHofman extends Sampler<Catseq> 
{

	private int baseLen;
	private int varLen;

	public SamplerHofman(int base, int var) 
	{
		baseLen = base;
		varLen = var;		
	}
	
	public int nextSequenceLength()
	{
		return 100;
	}
	
	public Object nextSequenceCategory(int k, Object pref) 
	{
		return null;
	}
	

	public void addTopic(double d, CategoricalVocab vocab)
	{
		// TODO Auto-generated method stub
		
	}

}
