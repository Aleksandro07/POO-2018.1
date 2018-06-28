package contato;

public class Telefone {

	String foneId;
	int numero;

	public Telefone(String foneId, int numero) {
		this.foneId = foneId;
		this.numero = numero;
	}
	public String toString() {
		return "foneId : " + foneId + ", numero :  " + numero;
	}

}
