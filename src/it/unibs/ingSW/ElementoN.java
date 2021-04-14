package it.unibs.ingSW;

public class ElementoN implements Elemento<ElementoN>{
	private PostoN posto;
	private  TransizioneN transizione;
	private boolean verso; //se true allora il verso va dal posto alla transizione
						   //se false allora il verso va dalla transizione al posto
	
	public ElementoN(PostoN posto, TransizioneN transizione, boolean verso){
		this.posto = posto;
		this.transizione = transizione;
		this.verso = verso;
	}

	public boolean getVerso() {
		return this.verso;
	}

	public void setVerso(boolean verso) {
		this.verso = verso;
	}
	
	public PostoN getPosto() {
		return posto;
	}

	public void setPosto(PostoN posto) {
		this.posto = posto;
	}

	public TransizioneN getTransizione() {
		return transizione;
	}

	public void setTransizione(TransizioneN transizione) {
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
	
	public boolean isEqual(ElementoN ePar)
	{
		return (ePar.getPosto().isEqual(posto) && ePar.getTransizione().isEqual(transizione) && (ePar.getVerso() == verso));
	}
	
	public String print()
	{
		String out = "ID posto: " + posto.getID() + "\nID transizione: " + transizione.getID();
		if(verso)
			out += "\nVerso: da posto a transizione";
		else 
			out += "\nVerso: da transizione a posto";
		return out;
	}
}
