package anotacoes;

public class Usuario implements Comparable<Usuario>{

	private String username;
	private String password;
	Repositorio<Nota> notas;

	public Usuario(String username, String password) {
		this.username = username;
		this.password = password;
		notas = new Repositorio<Nota>("Notas");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Repositorio<Nota> getNotas() {
		return notas;
	}

	public void setNotas(Repositorio<Nota> notas) {
		this.notas = notas;
	}

	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}

	public String toString() {
		return " [username: " + username + " ]";
	}

	public int compareTo(Usuario o) {
		return this.username.compareTo(o.username);
	}
}
