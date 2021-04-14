package it.unibs.ingSW;

public class ElementoPN extends ElementoN{
	private PostoPN postoPN;
	private TransizionePN transizionePN;
	private boolean versoPN;
	

	public ElementoPN(PostoPN posto, TransizionePN transizione, boolean verso) {
		super(posto, transizione, verso);
	}
	
	public PostoPN getPosto() {
		return postoPN;
	}
	
	public void setPosto(PostoPN posto) {
		this.postoPN = posto;
	}
	
	public TransizionePN getTransizione() {
		return transizionePN;
	}
	
	public void setTransizione(TransizionePN transizione) {
		this.transizionePN = transizione;
	}
	
	public int getIdPosto()
	{
		return postoPN.getID();
	}
	
	public int getIdTransizione()
	{
		return transizionePN.getID();
	}
	
	public boolean isEqual(ElementoPN ePar)
	{
		if(ePar.getPosto().isEqual(this.postoPN) && ePar.getTransizione().isEqual(this.transizionePN) 
				&& (ePar.getVerso() == this.versoPN))
			return true;
		else 
			return false;
	}
	
	public String print()
	{
		String out = "ID posto: " + this.postoPN.getID() + "\nMarcatura: " + this.postoPN.getMarcatura() + "\nID transizione: " + this.transizionePN.getID() + "\nPeso: " + this.transizionePN.getPeso();
		if(this.versoPN)
			out += "\nVerso: da posto a transizione";
		else 
			out += "\nVerso: da transizione a posto";
		return out;
	}
}
