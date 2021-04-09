package it.unibs.ingSW;

public class TransizionePN extends Transizione{
	private int peso;
	public TransizionePN(int ID) {
		super(ID);
		// TODO Auto-generated constructor stub
		peso=1;
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
