package contato;

import java.util.ArrayList;

public class Contato {

	private String nome;
	ArrayList<Telefone> telefones;

	public Contato(String nome) {
		this.nome = nome;
		telefones = new ArrayList<Telefone>();
	}

	public boolean inserirTelefone(Telefone telefone) {

		for(Telefone elem : telefones) {
			if(elem.foneId.equals(telefone.foneId))
				throw new RuntimeException("Fail: telefone ja existe");
		}

		this.telefones.add(telefone);
		return true;
	}

	public boolean removerTelefone(String foneId) {

		for(int i = 0; i < telefones.size(); i++) {
			if(telefones.get(i).foneId.equals(foneId)) {
				telefones.remove(telefones.get(i));
				return true;
			}

		}
		throw new RuntimeException("Fail: telefone nao existe");
	}

	public boolean atualizarTelefone(String foneId, int numero, String novofoneId, int novonumero) {
		for(int i = 0; i < telefones.size(); i++) {
			if(telefones.get(i).foneId.equals(foneId) && telefones.get(i).numero == numero) {
				telefones.get(i).foneId = novofoneId;
				telefones.get(i).numero = novonumero;
				return true;
			}
		}
		throw new RuntimeException("Fail: foneId ou numero nao existe");
	}

	public String toString() {
		return nome;
	}
}
