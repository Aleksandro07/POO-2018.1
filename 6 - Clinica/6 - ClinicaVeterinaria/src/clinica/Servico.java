package clinica;

public class Servico {
	
	public String idServico;
	public float valor;
	
	public Servico(String idServico, float valor) {
		this.idServico = idServico;
		this.valor = valor;
	}

	public String toString() {
		return  idServico + " : " + valor;
	}
}
