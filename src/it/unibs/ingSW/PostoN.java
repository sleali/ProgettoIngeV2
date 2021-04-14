package it.unibs.ingSW;

public class PostoN {
	private int ID;
	
	public PostoN(int ID)
	{
		this.ID = ID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public boolean isEqual(PostoN postoPar)
	{
		return postoPar.getID() == this.ID;
	}
}
