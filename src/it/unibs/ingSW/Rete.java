package it.unibs.ingSW;

import java.io.*;
import java.util.*;
import com.google.gson.Gson;

public class Rete {
	protected Vector<Elemento> rete;

	public Rete() {
		rete = new Vector<>();
	}

	public boolean add(Elemento e) {
		if (!alreadyExist(e)) // posso procedere all'aggiunta solo se non esiste un elemento identico
			return rete.add(e);
		return false;
	}

	private boolean alreadyExist(Elemento e) {
		boolean exist = false;
		for (Elemento elemento : rete) {
			if (elemento.isEqual(e))
				exist = true;
		}
		// return rete.contains(e);
		return exist;
	}

	public void carica(String file, Class<?> c) {
		String s;
		Elemento e;
		Gson gson = new Gson();
		File f = new File(file);
		BufferedReader source;
		try {
			this.rete = new Vector<>();
			source = new BufferedReader(new FileReader(f));
			do {
				s = source.readLine();
				if (!(s == null)) {
					e = (Elemento) gson.fromJson(s, c);
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
				for(int i = 1; f.exists() && !f.isDirectory(); i++)
				{
					f = new File(file + "(" + i + ")" + ".json");
				}
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
				Gson gson = new Gson();
				String jsonString;
				for (Elemento elemento : rete) {
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

	public Elemento getElemento(int index) {
		return this.rete.get(index);
	}
	
	public Vector<Elemento> getElementi(){
		return rete;
	}

	public String printElemento(int index) {
		return getElemento(index).print();
	}

	public boolean isEqual(Rete retePar) {
		boolean find = false;
		if(this.rete.size() != retePar.size())
			return false;
		else 
		{
			for(int i = 0; i < this.rete.size(); i++)
			{
				for(int k = 0; k < retePar.size() && !find; k++)
				{
					if(this.rete.get(i).isEqual(retePar.getElemento(k)))
					{
						retePar.remove(k);
						find = true;
					}
				}
				if(!find)
					return false;
				find = false;
			}
			if(retePar.size() == 0)
				return true;
			else 
				return false;
		}
	}
}
