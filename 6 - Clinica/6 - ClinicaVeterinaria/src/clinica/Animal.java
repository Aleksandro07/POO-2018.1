package clinica;

public class Animal {
	
	public String idAnimal;
	public String especie;
	public Cliente dono;

	public Animal(Cliente dono, String idAnimal, String especie) {
		this.dono = dono;
		this.idAnimal = idAnimal;
		this.especie = especie;
	}

	public String toString() {
		return idAnimal + " : " + especie;
	}
}
