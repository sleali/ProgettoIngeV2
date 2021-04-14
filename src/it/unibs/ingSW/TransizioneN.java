package it.unibs.ingSW;

public class TransizioneN {
private int ID;
	
	public TransizioneN(int ID)
	{
		this.ID = ID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public boolean isEqual(TransizioneN tranPar)
	{
		if(tranPar.getID() == this.ID)
			return true;
		else 
			return false;
	}
}