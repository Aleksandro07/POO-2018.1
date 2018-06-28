package agiota;

import java.util.ArrayList;

public class Emprestimo {

	float saldo;
	float valor;
	int id = 0;
	ArrayList<Cliente> clientesEmprestimo;

	public Emprestimo(float saldo) {
		this.saldo = saldo;
		clientesEmprestimo = new ArrayList<Cliente>();
	}
	public void iniciarSistema() {
		clientesEmprestimo.clear();
		System.out.println("Sistema inciado com " + saldo + " reais");
	}

	public void cadastrarCliente(String clienteId, String nome) {
		for(Cliente elem : clientesEmprestimo) {
			if(elem.clienteId.equals(clienteId))
				throw new RuntimeException("Fail: cliente " + clienteId + " ja existe");
		}
		clientesEmprestimo.add(new Cliente(clienteId, nome));
	}

	public void emprestarDinheiro(String clienteId, float valor) {
		boolean existe = false;
		
		for(Cliente elem : clientesEmprestimo) { 
			if(elem.clienteId.equals(clienteId)) {
				existe = true;
				
				if(saldo < valor) {
					throw new RuntimeException("Fail: saldo invalido");
				}

				if(saldo >= valor) {
					elem.saldoCliente -= valor;
					System.out.println("id:" + id + " [" + clienteId  + " - " + valor + "]");
					id++;
					this.saldo -= valor;
				}
			}
		}
		if(!existe)
			throw new RuntimeException("Fail: " + clienteId + " nao existe");
	}

	public void receberDinheiro(String clienteId, float valor) {
		for(Cliente elem : clientesEmprestimo) {
			if(elem.clienteId.equals(clienteId)) {

				if(valor > (elem.saldoCliente * -1)) {
					throw new RuntimeException("Fail: valor maior que divida");	
				}

				elem.saldoCliente = elem.saldoCliente + valor;
				System.out.println("id:" + id + " [" + clienteId  + " " + valor + "]");
				id++;
				this.saldo += valor;
			}
		}
	}

	public void mostrarCliente(String clienteId) {

		//nao consegui mostrar todas as transacoes, apenas o saldo

		for(Cliente elem : clientesEmprestimo)
			if(elem.clienteId.equals(clienteId)) {
				System.out.println(elem.saldoCliente());
			}
			else {
				throw new RuntimeException("Fail: " + clienteId + " nao existe");
			}
	}

	public String mostrarTodosClientes() {
		String saida = "";

		for(int i = 0; i < clientesEmprestimo.size(); i++) 
			saida = saida + clientesEmprestimo.get(i).saldoCliente();
		return saida;
	}

	public void matarCliente(String clientId) {
		for(int i = 0; i < clientesEmprestimo.size(); i++) {
			if(clientesEmprestimo.get(i).clienteId.equals(clientId)) {
				clientesEmprestimo.remove(clientesEmprestimo.get(i));
				return;
			}
		}
		throw new RuntimeException("Fail: cliente " + clientId + " nao existe");
	}
	public float getSaldo() {
		return saldo;
	}
}