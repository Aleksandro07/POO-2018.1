package agiota;

public class Cliente {
	
	String vida = "vivo";
	String clienteId;
	String nome;
	float saldoCliente = 0;
	
	public Cliente(String clienteId, String nome) {
		this.clienteId = clienteId;
		this.nome = nome;
	}
	
	public String saldoCliente() {
		return "[" + clienteId + " " + saldoCliente + "] \n";
	}
}