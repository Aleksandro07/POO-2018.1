package junkfood;

import java.util.ArrayList;

public class Maquina {

	private double saldoCliente = 0;
	private double lucro = 0;
	double troco = 0;

	private ArrayList<Espiral> espirais;

	public Maquina(int quantidadeEspirais, int maximoProdutos) {	
		espirais = new ArrayList<Espiral>();

		for(int i = 0; i < quantidadeEspirais; i++) {
			this.espirais.add(new Espiral());
		}
	}

	public void adicionarEspiral(int indice, String nome, int quantidade, float preco) {

		espirais.get(indice).nome = nome;
		espirais.get(indice).quantidade = quantidade;
		espirais.get(indice).preco = preco;

	}

	public boolean inserirDinheiro(float valor) {

		if(valor <= 0)
			throw new RuntimeException("Valor negativo");

		saldoCliente = saldoCliente + valor;
		return true;
	}

	public void vender(String nome) {
		for(Espiral elem : espirais) {
			if(elem.nome.equals(nome)) {
				if(saldoCliente >= elem.preco) {
					elem.quantidade--;

					saldoCliente = saldoCliente - elem.preco;
					lucro = lucro + elem.preco;
					
				}
				
				throw new RuntimeException("fail: saldo inferior ou produto nao existe");
			}		
		}
	
	}
	
	public double getLucro() {
		return lucro; 
	}
	public double getTroco() {
		return saldoCliente;
	}

	public double getSaldoCliente() {
		return saldoCliente;
	}

	public boolean alterarEspiral(int indice, String nome, int quantidade, float preco) {

		if(indice <= espirais.size()) {
			espirais.get(indice).nome = nome;
			espirais.get(indice).quantidade = quantidade;
			espirais.get(indice).preco = preco;
			return true;
		}
		return false;
	}

	public void resetarEspiral(int indice) {

		espirais.get(indice).nome = "";
		espirais.get(indice).quantidade = 0;
		espirais.get(indice).preco = 0;
	}

	public String toString() {
		String saida = "";

		for(int i = 0; i < espirais.size(); i++) {
			saida = saida + espirais.get(i).toString();
		}
		return saida;
	}
}
