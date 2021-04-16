package it.unibs.ingSW;

import java.io.File;
import java.util.HashMap;
import java.io.FilenameFilter;

import it.unibs.fp.mylib.InputDati;

public class AggiungiPN {
	private static final String DIRECTORYN = "./salvataggi/retiN/";
	private static final String DIRECTORYPN = "./salvataggi/retiPN/";
	
	public AggiungiPN() {}
	
	public void toPN() throws Exception {
		int scelta = 0;
		do {
			System.out.println("\n\nMenu di visualizzazione delle reti:\n"
					+ "1) Visualizza e converti la descrizione di una rete n in una rete pn\n"
					+ "\n0) Torna al menu principale");
			scelta = InputDati.leggiIntero("Selezionare una delle voci del menu:", 0, 1);
			switch (scelta)
			{
				case 1:
					File dir = new File(DIRECTORYN);
					String names[] = dir.list(new FilenameFilter() {
						@Override
						public boolean accept(File dir, String name) {
							boolean value;
							// return files only that begins with test
							if(name.startsWith(".")){
								value=false;
							}
							else{
								value=true;
							}
							return value;
						}
					});
					if(names.length > 0)
					{
						int descr;
						Rete reteN = new Rete();
						System.out.println("\n\nElenco delle descrizioni disponibili:");
						for(int i = 1; i <= names.length; i++)
						{
							System.out.println(i + ") " + names[i - 1]);
						}
						descr = InputDati.leggiIntero("Inserire il numero della descrizione "
								+ "che si desidera convertire: ", 1, names.length);
						reteN.carica(DIRECTORYN + names[descr - 1], ElementoPN.class);
						creaPN(reteN); //Metodo per convertire la rete N in rete PN
					}
					else 
						System.out.println("Non e' possibile visualizzare alcuna descrizione, nessuna rete e' ancora stata salvata");		
					break;
			}
		} while (scelta != 0);
		System.out.println("Uscita dal menù delle reti PN avvenuta");
	}
	
	private void creaPN(Rete reteN) {
		Rete pn = new Rete();
		HashMap<Integer, Integer> pesi = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> marcature = new HashMap<Integer, Integer>();
		
		
		for (Elemento el : reteN.getElementi()) {
			int marcatura = marcature.containsKey(el.getIdPosto()) ? marcature.get(el.getIdPosto()) : InputDati.leggiIntero("Inserisci marcatura del posto con id "+el.getIdPosto()+": ", 0, Integer.MAX_VALUE);
			int peso = pesi.containsKey(el.getIdTransizione()) ? pesi.get(el.getIdTransizione()) : InputDati.leggiIntero("Inserisci peso della transizione con id "+el.getIdTransizione()+": ", 1, Integer.MAX_VALUE);
			
			pesi.put(el.getIdTransizione(), peso);
			marcature.put(el.getIdPosto(), marcatura);
			
			ElementoPN elPN = new ElementoPN(new PostoPN(el.getIdPosto(), marcatura), new TransizionePN(el.getIdTransizione(), peso), el.getVerso());
			
			pn.add(elPN);
		}
		int salva = InputDati.leggiIntero("\n\nVuoi salvare?\n1) SI\n2) NO", 1, 2);
		if(salva==1) {
			String filename;
			boolean exist, esito;
			if(pn.size() > 0)
			{
				exist = checkDuplicate(pn);
				if(exist)
					System.out.println("Errore, la rete che si desidera salvare e' il duplicato di una rete gia' esistente ");
				else 
				{
					filename = InputDati.leggiStringa("Inserire il nome con cui si desidera salvare la descrizione: ");
					esito = pn.salva(DIRECTORYPN + filename);
					if(esito)
						System.out.println("Salvataggio avvenuto con successo!");
					else 
						System.out.println("Si e' verificato un errore nel salvataggio");
				}
			}
			else 
				System.out.println("Errore, non e' possibile salvare una rete priva di elementi");
		}
			
	}
	
	private boolean checkDuplicate(Rete rete)
	{
		boolean find = false;
		File dir = new File(DIRECTORYPN);
		String names[] = dir.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				boolean value;
				// return files only that begins with test
				if(name.startsWith(".")){
					value=false;
				}
				else{
					value=true;
				}
				return value;
			}
		});
		for (int i = 0; i < names.length && !find; i++) 
		{
			Rete reteEsistente = new Rete();
			reteEsistente.carica(DIRECTORYPN + names[i], ElementoPN.class);
			if (rete.isEqual(reteEsistente)) 
				find = true;
		}
		return find;
	}
}
