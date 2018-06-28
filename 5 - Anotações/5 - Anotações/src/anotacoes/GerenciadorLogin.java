package anotacoes;

public class GerenciadorLogin {
	private Repositorio<Usuario> usuarios;
	private Usuario user;

	public GerenciadorLogin(Repositorio<Usuario> usuarios) {
		this.usuarios = usuarios;
		user = null;
	}

	void login(String username, String senha){
		if(user != null)
			throw new RuntimeException("fail: ja existe alguem logado");
		if(!usuarios.get(username).matchPassword(senha))
			throw new RuntimeException("fail: password invalido");
		this.user = usuarios.get(username);
	}

	void logout(){
		if(user == null)
			throw new RuntimeException("fail: ninguem logado");
		user = null;
	}

	public Usuario getUser(){
		if(user == null)
			throw new RuntimeException("fail: ninguem logado");
		return user;
	}
}
