package agenciabancaria;

public class GerenciadorLogin {

	private Repositorio<Cliente> usuariosClientes;
	private Cliente cliente;

	public GerenciadorLogin(Repositorio<Cliente> usuariosClientes) {
		this.usuariosClientes = usuariosClientes;
		cliente = null;
	}

	void login(String username, String senha){
		if(cliente != null)
			throw new RuntimeException("fail: ja existe alguem logado");

		if(!usuariosClientes.get(username).matchPassword(senha))
			throw new RuntimeException("fail: senha invalida");

		this.cliente = usuariosClientes.get(username);
	}

	void logout(){
		if(cliente == null)
			throw new RuntimeException("fail: ninguem logado");
		this.cliente = null;
	}

	public Cliente getUser(){
		if(cliente == null)
			throw new RuntimeException("fail: ninguem logado");
		return cliente;
	}
}
