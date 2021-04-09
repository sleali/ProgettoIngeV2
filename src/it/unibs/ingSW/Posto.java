package it.unibs.ingSW;

public class Posto 
{
	private int ID;
	
	public Posto(int ID)
	{
		this.ID = ID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public boolean isEqual(Posto postoPar)
	{
		if(postoPar.getID() == this.ID)
			return true;
		else 
			return false;
	}
}
