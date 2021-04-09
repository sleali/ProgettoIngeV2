package it.unibs.ingSW;

public class Elemento 
{
	private Posto posto;
	private Transizione transizione;
	private boolean verso; //se true allora il verso va dal posto alla transizione
						   //se false allora il verso va dalla transizione al posto
	
	//passare direttamente l'oggetto già creato
	public Elemento(int IDp, int IDt, boolean verso)
	{
		this.posto = new Posto(IDp);
		//this.posto = postoParam;
		this.transizione = new Transizione(IDt);
		this.verso = verso;
	}

	public boolean getVerso() {
		return this.verso;
	}

	public void setVerso(boolean verso) {
		this.verso = verso;
	}
	
	public Posto getPosto() {
		return posto;
	}

	public void setPosto(Posto posto) {
		this.posto = posto;
	}

	public Transizione getTransizione() {
		return transizione;
	}

	public void setTransizione(Transizione transizione) {
		this.transizione = transizione;
	}

	public int getIdPosto()
	{
		return posto.getID();
	}
	
	public int getIdTransizione()
	{
		return transizione.getID();
	}
	
	public boolean isEqual(Elemento ePar)
	{
		if(ePar.getPosto().isEqual(this.posto) && ePar.getTransizione().isEqual(this.transizione) 
				&& (ePar.getVerso() == this.verso))
			return true;
		else 
			return false;
	}
	
	public String print()
	{
		if(this.verso)
			return "ID posto: " + this.posto.getID() + "\nID transizione: " + this.transizione.getID() + 
				"\nVerso: da posto a transizione";
		else 
			return "ID posto: " + this.posto.getID() + "\nID transizione: " + this.transizione.getID() + 
					"\nVerso: da transizione a posto";
	}
}
