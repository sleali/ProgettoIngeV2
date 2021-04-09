package it.unibs.ingSW;

public class PostoPN extends Posto{
	private int marcatura;
	public PostoPN(int ID) {
		super(ID);
		// TODO Auto-generated constructor stub
		marcatura=0;
	}
	
	public void setMarcatura(int marcatura) {
		this.marcatura=marcatura;
	}

	public int getMarcatura() {
		return marcatura;
	}
	
	public boolean isEqual(PostoPN postoPar)
	{
		if(postoPar.getID() == super.getID() && postoPar.getMarcatura() == this.marcatura)
			return true;
		else 
			return false;
	}
}
