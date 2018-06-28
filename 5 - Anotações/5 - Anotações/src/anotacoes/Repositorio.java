package anotacoes;

import java.util.ArrayList;

class  Elemento <T> {
	String chave;
	T valor;

	public  Elemento ( String  chave , T valor) {
		this.chave = chave;
		this.valor = valor;
	}

	public  String  toString () {
		return  " "  + chave +  " : "  + valor;
	}
}

public class Repositorio<T> {
	
	private ArrayList<Elemento<T>> lista;
	private String typename;

	public Repositorio(String typename) {

		lista = new ArrayList<Elemento<T>>();
		this.typename = typename;
	}

	public void add(String chave, T t) {

		for (Elemento<T> elem : lista) {
			if (elem.chave.equals(chave)) {
				throw new RuntimeException("fail: " + typename + " " + chave + " ja existe"); 
			}
		}

		lista.add(new Elemento<T>(chave, t));
	}

	public T get(String chave) {

		for (Elemento<T> elem : lista)
			if (elem.chave.equals(chave))
				return elem.valor;
		throw new RuntimeException("fail: " + typename + " " + chave + " não existe!");
	}

	public void remove(String chave) {

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).chave.equals(chave)) {
				lista.remove(i);
				return;
			}
		}

		throw new RuntimeException("fail: " + typename + " " + chave + " não existe!");
	}

	public ArrayList<T> getAll() {

		ArrayList<T> all = new ArrayList<T>();
		for (Elemento<T> elem : lista)
			all.add(elem.valor);
		return all;
	}

	public String toString() {

		String saida = "";

		for (Elemento<T> elem : lista)
			saida += elem + "\n";
		return saida;
	}
}
