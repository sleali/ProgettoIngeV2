package it.unibs.ingSW;

import java.io.File;
import java.io.FilenameFilter;

import it.unibs.fp.mylib.InputDati;

public class VisualizzaPN {
	private static final String DIRECTORY = "./salvataggi/retiPN/";
	
	public VisualizzaPN() {}
	
	public void print()
	{
		int scelta = 0;
		do 
		{
			System.out.println("\n\nMenu di visualizzazione delle reti PN:\n"
					+ "1) Visualizza la descrizione di una rete\n"
					+ "2) Torna al menu principale");
			scelta = InputDati.leggiIntero("Selezionare una delle voci del menu:", 1, 2);
			switch (scelta)
			{
				case 1: 
					try 
					{
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
						if(names.length > 0)
						{
							int descr;
							Rete rete = new Rete();
							System.out.println("\n\nElenco delle descrizioni disponibili:");
							for(int i = 1; i <= names.length; i++)
							{
								System.out.println(i + ") " + names[i - 1]);
							}
							descr = InputDati.leggiIntero("Inserire il numero della descrizione "
									+ "che si desidera visualizzare: ", 1, names.length);
							rete.carica(DIRECTORY + names[descr - 1]);
							System.out.println("\nElenco degli elementi della rete " + descr + ":");
							for(int i = 0; i < rete.size(); i++)
							{
								System.out.println("");
								System.out.println("Elemento " + (i + 1) + ":");
								System.out.println(rete.printElemento(i));
								System.out.println("");
							}
						}
						else 
							System.out.println("Non e' possibile visualizzare alcuna descrizione, "
									+ "nessuna rete e' ancora stata salvata");
					} 
					catch (Exception e) 
					{
						// TODO: handle exception
					}
					
				break;
			}
		} 
		while (scelta != 2);
	}
}
