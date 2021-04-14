package it.unibs.ingSW;

import java.io.*;
import java.util.*;
import com.google.gson.Gson;

public class Rete {
	protected Vector<ElementoN> rete;

	public Rete() {
		rete = new Vector<>();
	}

	public boolean add(ElementoN e) {
		if (!alreadyExist(e)) // posso procedere all'aggiunta solo se non esiste un elemento identico
			return rete.add(e);
		return false;
	}

	private boolean alreadyExist(ElementoN e) {
		boolean exist = false;
		for (ElementoN elemento : rete) {
			if (elemento.isEqual(e))
				exist = true;
		}
		// return rete.contains(e);
		return exist;
	}

	public void carica(String file) {
		String s;
		ElementoN e;
		Gson gson = new Gson();
		File f = new File(file);
		BufferedReader source;
		try {
			this.rete = new Vector<>();
			source = new BufferedReader(new FileReader(f));
			do {
				s = source.readLine();
				if (!(s == null)) {
					e = gson.fromJson(s, ElementoN.class);
					this.rete.add(e);
				}
			} while (!(s == null));
			source.close();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	public boolean salva(String file) {
		boolean save = false;
		if (this.rete.size() > 0) {
			try {
				File f = new File(file + ".json");
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
				Gson gson = new Gson();
				String jsonString;
				for (ElementoN elemento : rete) {
					jsonString = gson.toJson(elemento);
					pw.println(jsonString);
				}
				pw.close();
				save = true;
			} catch (Exception exp) {
				exp.printStackTrace();
			}
		}
		return save;
	}

	public int size() {
		return this.rete.size();
	}

	public void remove(int index) {
		this.rete.remove(index);
	}

	public ElementoN getElemento(int index) {
		return this.rete.get(index);
	}
	
	public Vector<ElementoN> getElementi(){
		return rete;
	}

	public String printElemento(int index) {
		return getElemento(index).print();
	}

	public boolean isEqual(Rete retePar) {
		Vector<ElementoN> copy = rete;
		boolean equal = false;
		for (int i = 0; i < copy.size(); i++) {
			for (int k = 0; k < retePar.size() && !equal; k++) {
				if (copy.get(i).isEqual(retePar.getElemento(k))) {
					copy.remove(i);
					retePar.remove(k);
					equal = true;
				}
			}
			equal = false;
		}
		if (copy.size() == 0 && retePar.size() == 0)
			return true;
		else
			return false;
	}

}
