package it.unibs.ingSW;

import java.io.File;
import java.io.FilenameFilter;

import it.unibs.fp.mylib.InputDati;

public class AggiungiN {
	private static final String DIRECTORY = "./salvataggi/retiN/";

	public AggiungiN() {}
	
	public void add()
	{
		Rete rete = new Rete();
		int scelta = 0;
		boolean uscita = false, modifiche = false;
		do 
		{
			System.out.println("\n\nMenu di inserimento di una nuova rete:\n"
					+ "1) Inserisci un nuovo elemento alla rete \n2) Termina l’inserimento e salva la rete "
					+ "\n3) Esci senza salvare");
			scelta = InputDati.leggiIntero("Selezionare una delle voci del menu:", 1, 3);
			switch (scelta)
			{
				case 1: 
					int IDp,IDt;
					boolean verso;
					IDp = InputDati.leggiIntero("Inserire l'ID del posto (e' richiesto un numero intero): ");
					IDt = InputDati.leggiIntero("Inserire l'ID della transizione (e' richiesto un numero intero): ");
					if(sceltaDoppia("Selezionare il verso dell'elemento (1/2):\n"
							+ "1) Dal posto alla transizione\n"
							+ "2) Dalla transizione al posto\n", '1', '2').equals('1'))
						verso = true;
					else 
						verso = false;
					ElementoN e = new ElementoN(new PostoN(IDp), new TransizioneN(IDt), verso);
					if(rete.add(e))
					{
						modifiche = true;
						System.out.println("Elemento aggiunto con successo!");
					}
					else 
						System.out.println("Errore, l'elemento e' già presente nella rete");
				break;
				case 2:
					String filename;
					boolean exist, esito;
					if(rete.size() > 0)
					{
						exist = checkDuplicate(rete);
						if(exist)
							System.out.println("Errore, la rete che si desidera salvare e' il duplicato di una rete gia' esistente ");
						else 
						{
							filename = InputDati.leggiStringa("Inserire il nome con cui si desidera salvare la descrizione: ");
							esito = rete.salva(DIRECTORY + filename);
							if(esito)
							{
								uscita = true;
								modifiche = false;
								System.out.println("Salvataggio avvenuto con successo!");
							}
							else 
								System.out.println("Si e' verificato un errore nel salvataggio");
						}
					}
					else 
						System.out.println("Errore, non e' possibile salvare una rete priva di elementi");
				break;
				case 3:
					if(modifiche) //distinguo il caso in cui l'utente non ha fatto nulla e quindi può uscire senza 
						//alcun rischio ed il caso in cui sono state fatte modifiche senza salvare,
						//in quest'ultimo caso chiedo conferma prima di uscire
					{
						if(sceltaDoppia("Attenzione: le modifiche effettuate non sono state salvate, "
							+ "si e' sicuri di voler uscire comunque (y/n)?", 'y', 'n').equals('y'))
						uscita = true; //altrimenti uscita rimane == false
					}
					else 
						uscita = true;
				break;
			}
		} 
		while (!((scelta == 2 || scelta == 3) && uscita == true));
	}
	
	private Character sceltaDoppia(String messaggio, char scelta1, char scelta2)
	{
		Character input;
		do 
		{
			input = InputDati.leggiChar(messaggio);
			input = Character.toLowerCase(input);
			if(!input.equals(scelta1) && !input.equals(scelta2))
				System.out.println("Errore, scegliere tra le opzioni " + scelta1 + "/" + scelta2);
		}
		while(!input.equals(scelta1) && !input.equals(scelta2));
		return input;
	}
	
	private boolean checkDuplicate(Rete rete)
	{
		boolean find = false;
		File dir = new File(DIRECTORY);
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
			reteEsistente.carica(DIRECTORY + names[i], 1);
			if (rete.isEqual(reteEsistente)) 
				find = true;
		}
		return find;
	}
}
