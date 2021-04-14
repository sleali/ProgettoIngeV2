package it.unibs.ingSW;

public interface Elemento<T> {
	public String print();
	
	public boolean isEqual(T value);
	
	public boolean getVerso();
	
	public int getIdPosto();
	
	public int getIdTransizione();
}