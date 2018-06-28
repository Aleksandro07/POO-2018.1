package anotacoes;

public class Controller {

	Repositorio<Usuario> usuarios;
	Repositorio<Nota> notas;
	GerenciadorLogin gerLogin;

	public Controller() {
		usuarios = new Repositorio<Usuario>("Usuarios");
		notas = new Repositorio<Nota>("Notas");
		gerLogin = new GerenciadorLogin(usuarios);
	}

	public String oracle(String line){
		String ui[] = line.split(" ");

		if(ui[0].equals("help")) {
			return "addUser, showUsers, login, logout, changePass, addNote, showNotes, rmNote";
		}

		else if(ui[0].equals("addUser")) {
			usuarios.add(ui[1], new Usuario(ui[1],ui[2]));
		}

		else if(ui[0].equals("showUsers")) {

			String saida = "";

			for(Usuario elem: usuarios.getAll())
				saida += elem.getUsername() + "\n";
			return saida;
		}

		else if(ui[0].equals("login")) {
			gerLogin.login(ui[1], ui[2]);
		}

		else if(ui[0].equals("logout")) {
			gerLogin.logout();
		}

		else if(ui[0].equals("changePass")) {
			if(gerLogin.getUser().matchPassword(ui[1])) 
				gerLogin.getUser().setPassword(ui[2]);
		}

		else if(ui[0].equals("addNote")) {
			String texto = "";

			Usuario user = gerLogin.getUser();

			for(int i = 2; i < ui.length; i++)
				texto += ui[i] + " ";
			user.notas.add(ui[1], new Nota(ui[1], texto));
		}

		else if(ui[0].equals("showNotes")) {

			String saida = "";

			for(Usuario elem: usuarios.getAll())
				saida += elem.getNotas() + "\n";
			return saida;
		}

		else if(ui[0].equals("rmNote")) {
			gerLogin.getUser().notas.remove(ui[1]);
		}
		else
			return "comando invalido";
		return "done";
	}
}
