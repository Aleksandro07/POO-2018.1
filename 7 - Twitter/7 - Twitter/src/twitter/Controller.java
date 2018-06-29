package twitter;

public class Controller {

	Repositorio<Usuario> usuarios;
	Repositorio<Usuario> seguidores;
	Repositorio<Usuario> seguidos;
	
	public Controller() {
		usuarios = new Repositorio<Usuario>("Usuario");
	}

	public String oracle(String line){
		String ui[] = line.split(" ");

		if(ui[0].equals("help")) {
			return "addUser, showUsers, seguir";
		}

		else if(ui[0].equals("addUser")) {
			usuarios.add(ui[1], new Usuario(ui[1]));
		}

		else if(ui[0].equals("showUsers")) {

			String saida = "";

			for(Usuario elem : usuarios.getAll()) {
				saida += elem.toString() + "\nseguidores [" + elem.seguidores() +"]\nseguidos [" + elem.seguidos() + "]\n";
			}
			return saida;
		}

		else if(ui[0].equals("seguir")) {
			usuarios.get(ui[2]).seguir(usuarios.get(ui[1]));
		}
		
		else
			return "comando invalido";
		return "done";
	}
}
