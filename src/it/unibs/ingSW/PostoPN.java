package it.unibs.ingSW;

public class PostoPN extends PostoN {
	private int marcatura;
	
	public PostoPN(int ID, int marcatura) {
		super(ID);
		this.marcatura = (marcatura>=0) ? marcatura : 0;
	}
	
	public PostoPN(int ID) {
		super(ID);
		this.marcatura=0;
	}
	
	public void setMarcatura(int marcatura) {
		this.marcatura=marcatura;
	}

	public int getMarcatura() {
		return marcatura;
	}
	
	public int getID() {
		return super.getID();
	}
	
	public boolean isEqual(PostoPN postoPar)
	{
		return (postoPar.getID() == super.getID() && postoPar.getMarcatura() == this.marcatura);
	}
}
