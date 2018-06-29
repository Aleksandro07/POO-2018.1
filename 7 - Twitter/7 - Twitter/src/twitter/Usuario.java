package twitter;

public class Usuario {
	
	private String username;
	
	Repositorio<Usuario> seguidores;
	Repositorio<Usuario> seguidos;
	
	public Usuario(String username) {
		this.username = username;
		seguidores = new Repositorio<Usuario>("Seguidores");
		seguidos = new Repositorio<Usuario>("Seguidos");
	}
	
	public void seguir(Usuario u) {
		this.seguidores.add(u.username, u);
		u.seguidos.add(this.username, new Usuario(this.username));
	}
	
	public String seguidos() {
		String saida = "";
		
		for(Usuario elem : seguidos.getAll()) {
			saida += elem + " ";
		}
		
		return saida;
	}
	
	public String seguidores() {
		String saida = "";
		
		for(Usuario elem : seguidores.getAll()) {
			saida += elem + " ";
		}
		
		return saida;
	}
	
	public String getUsername() {
		return username;
	}

	public Repositorio<Usuario> getSeguidores() {
		return seguidores;
	}

	public Repositorio<Usuario> getSeguidos() {
		return seguidos;
	}

	public String toString() {
		return username;
	}
}
