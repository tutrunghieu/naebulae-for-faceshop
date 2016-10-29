package org.naebulae.mc2.vector.table;

public interface TypedMapper<T1, T2> 
{
	public T2 invokeAction(T1 x) throws Exception;
}