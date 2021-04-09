package it.unibs.ingSW;

public class Transizione 
{
private int ID;
	
	public Transizione(int ID)
	{
		this.ID = ID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public boolean isEqual(Transizione tranPar)
	{
		if(tranPar.getID() == this.ID)
			return true;
		else 
			return false;
	}
}
