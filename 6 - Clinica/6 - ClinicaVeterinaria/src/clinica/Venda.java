package clinica;

public class Venda {
	
	public String idAnimal;
	public String idCliente;
	public String idServico;
	
	public Venda(String idCliente, String idAnimal, String idServico) {
		this.idCliente = idCliente;
		this.idAnimal = idAnimal;
		this.idServico = idServico;
	}	
	
	public String toString() {
		return idCliente + " " + idAnimal + " " + idServico;
	}
}
