package it.unibs.ingSW;

import it.unibs.fp.mylib.*;

public class Menu 
{
	public static void main(String[] args) 
	{
		int scelta = 0;
		do 
		{
			System.out.println("Menu principale [utente: configuratore]\n1) Gestione reti \n2) Gestione reti di petri \n\n0) Esci");
			scelta = InputDati.leggiIntero("Selezionare una delle voci del menu:", 0, 2);
			switch (scelta)
			{
				case 1: 
					System.out.println("\n");
					reti();
				break;
				case 2:
					reti_petri();
				break;
				default:
					System.out.println("Uscita in corso...");
			}
		} 
		while (scelta != 0);
	}
	
	public static void reti()
	{
		int scelta = 0;
		do 
		{
			System.out.println("Menu principale [utente: configuratore]\n1) Inserisci descrizione \n2) Visualizza descrizione \n\n0) Esci");
			scelta = InputDati.leggiIntero("Selezionare una delle voci del menu:", 0, 2);
			switch (scelta)
			{
				case 1: 
					Aggiungi aggiungi = new Aggiungi();
					aggiungi.add();
					System.out.println("\n");
				break;
				case 2:
					Visualizza visualizza = new Visualizza();
					visualizza.print();
					System.out.println("\n");
				break;
				default:
					System.out.println("\n");
				break;
			}
		} 
		while (scelta != 0);
	}
	
	public static void reti_petri()
	{
		
	}
}
