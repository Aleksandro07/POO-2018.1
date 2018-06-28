package contato;

public class Controller {

	Contato contato;

	public String oracle(String line){
		String ui[] = line.split(" ");

		if(ui[0].equals("help")) {
			return "initCli, addFone, rmFone, show";
		}

		else if(ui[0].equals("initCli")) {
			contato = new Contato(ui[1]);
		}

		else if(ui[0].equals("addFone")) {
			contato.inserirTelefone(new Telefone(ui[1], Integer.parseInt(ui[2])));
		}

		else if(ui[0].equals("rmFone")) {
			contato.removerTelefone(ui[1]);
		}

		else if(ui[0].equals("updFone")) {
			contato.atualizarTelefone(ui[1], Integer.parseInt(ui[2]), ui[3], Integer.parseInt(ui[4]));
		}

		else if(ui[0].equals("show")) {
			return "" + contato + contato.telefones;
		}
		else
			return "comando invalido";
		return "done";
	}
}
