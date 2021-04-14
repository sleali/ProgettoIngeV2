package it.unibs.ingSW;

public class TransizionePN extends TransizioneN {
	private int peso;
	
	public TransizionePN(int ID, int peso) {
		super(ID);
		this.peso = (peso>0) ? peso : 1;
	}
	
	public TransizionePN(int ID) {
		super(ID);
		this.peso=1;
	}
	
	public int getPeso() {
		return peso;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public boolean isEqual(TransizionePN tranPar)
	{
		if(tranPar.getID() == super.getID() && tranPar.getPeso() == this.getPeso())
			return true;
		else 
			return false;
	}
}