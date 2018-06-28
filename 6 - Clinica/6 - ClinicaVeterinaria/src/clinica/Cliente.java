package clinica;

public class Cliente {

	private String idCliente;
	private String nome;
	Repositorio<Animal> animais;

	public Cliente(String idCliente, String nome) {
		this.idCliente = idCliente;
		this.nome = nome;
		animais = new Repositorio<Animal>("Animais");
	}
	
	public String getIdCliente() {
		return idCliente;
	}

	public String getNome() {
		return nome;
	}

	public Repositorio<Animal> getAnimais() {
		return animais;
	}
	
	public String toString() {
		return idCliente + ": " + nome;
	}	
}
