package agenciabancaria;

public class Cliente implements Comparable<Cliente>{

	private String idCliente;
	protected Repositorio<Conta> contas;
	private String senha;
	int numero;

	public Cliente(String idCliente, String senha){
		this.idCliente = idCliente;
		this.contas = new Repositorio<Conta>("Conta");
		this.senha = senha;
	}
	
	public void addConta(){	
		this.contas.add("Numero conta ", new Conta(numero));
	}
	
	public String getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public Repositorio<Conta> getContas() {
		return contas;
	}

	public void setPassword(String senha) {
		this.senha = senha;
	}

	public boolean matchPassword(String senha) {
		return this.senha.equals(senha);
	}
	
	public int compareTo(Cliente o) {
		return this.idCliente.compareTo(o.idCliente);
	}
}
