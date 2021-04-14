package it.unibs.ingSW;

public class ElementoPN implements Elemento<ElementoPN>{
	private PostoPN posto;
	private TransizionePN transizione;
	private boolean verso;
	

	public ElementoPN(PostoPN posto, TransizionePN transizione, boolean verso) {
		this.verso = verso;
		this.posto = posto;
		this.transizione = transizione;
	}
	
	public PostoPN getPosto() {
		return posto;
	}
	
	public void setPosto(PostoPN posto) {
		this.posto = posto;
	}
	
	public TransizionePN getTransizione() {
		return transizione;
	}
	
	public void setTransizione(TransizionePN transizione) {
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
	
	public boolean getVerso() {
		return verso;
	}
	
	public boolean isEqual(ElementoPN ePar)
	{
		return (ePar.getPosto().isEqual(posto) && ePar.getTransizione().isEqual(transizione) && (ePar.getVerso() == verso));
	}
	
	public String print()
	{
		String out = "ID posto: " + posto.getID() + "\nMarcatura: " + posto.getMarcatura() + "\nID transizione: " + transizione.getID() + "\nPeso: " + transizione.getPeso();
		if(verso)
			out += "\nVerso: da posto a transizione";
		else 
			out += "\nVerso: da transizione a posto";
		return out;
	}
}
