package it.unibs.ingSW;

import it.unibs.fp.mylib.*;

public class Menu 
{
	public static void main(String[] args) throws Exception{
		int scelta = 0;
		do 
		{
			System.out.println("Menu principale [utente: configuratore]\n1) Gestione reti N \n2) Gestione reti PN \n\n0) Esci");
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
					break;
			}
		} 
		while (scelta != 0);
	}
	
	public static void reti(){
		int scelta = 0;
		do 
		{
			System.out.println("Menu principale Reti N [utente: configuratore]\n1) Inserisci descrizione \n2) Visualizza descrizione \n\n0) Esci");
			scelta = InputDati.leggiIntero("Selezionare una delle voci del menu:", 0, 2);
			switch (scelta)
			{
				case 1: 
					AggiungiN aggiungi = new AggiungiN();
					aggiungi.add();
					System.out.println("\n");
				break;
				case 2:
					VisualizzaN visualizza = new VisualizzaN();
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
	
	public static void reti_petri() throws Exception{
		int scelta = 0;
		do 
		{
			System.out.println("Menu principale Reti PN [utente: configuratore]\n1) Inserisci descrizione \n2) Visualizza descrizione \n\n0) Esci");
			scelta = InputDati.leggiIntero("Selezionare una delle voci del menu:", 0, 2);
			switch (scelta)
			{
				case 1: 
					AggiungiPN aggiungi = new AggiungiPN();
					aggiungi.toPN();
					System.out.println("\n");
				break;
				case 2:
					VisualizzaPN visualizza = new VisualizzaPN();
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
}
