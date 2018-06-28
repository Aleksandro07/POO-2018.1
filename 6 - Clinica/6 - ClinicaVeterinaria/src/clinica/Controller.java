package clinica;

public class Controller {

	Repositorio<Cliente> clientes;
	Repositorio<Animal> animais;
	Repositorio<Servico> servicos;
	Repositorio<Venda> vendas;
	float saldo = 0;
	
	public Controller() {
		clientes = new Repositorio<Cliente>("Cliente");
		animais = new Repositorio<Animal>("Animal");
		servicos = new Repositorio<Servico>("Servico");
		vendas = new Repositorio<Venda>("Venda");
	}

	public String oracle(String line){
		String ui[] = line.split(" ");

		if(ui[0].equals("help")) {
			return "addCli, showCli, addAni, showAni, showCliAni, addSer, showSer, venSer, showVen";
		}

		else if(ui[0].equals("addCli")) {
			String texto = "";

			for(int i = 2; i < ui.length; i++)
				texto += ui[i] + " ";
			clientes.add(ui[1], new Cliente((ui[1]), texto));
		}

		else if(ui[0].equals("showCli")) {

			String saida = "";

			for(Cliente elem: clientes.getAll())
				saida += elem.toString() + "\n";
			return saida;
		}

		else if(ui[0].equals("addAni")) {
			clientes.get(ui[1]).animais.add(ui[2], new Animal(clientes.get(ui[1]), ui[2], ui[3]));
			animais.add(ui[2], new Animal(clientes.get(ui[1]), ui[2], ui[3]));
		}

		else if(ui[0].equals("showAni")) {

			String saida = "";
			int cont = 1;

			for(Animal elem: animais.getAll()) {
				saida += "[" + cont + ":" + elem.toString() + "]" + "\n";
				cont++;
			}
			return saida;
		}

		else if(ui[0].equals("showCliAni")) {

			String saida = "";
			int cont = 1;
			Cliente cliente = this.clientes.get(ui[1]);

			saida = cliente.getIdCliente() + " " + cliente.getNome() + " ";

			for(Animal elem : cliente.getAnimais().getAll()) {
				saida += "[" + cont + " : " + elem.toString() + "]";
				cont++;
			}
			return saida;
		}

		else if(ui[0].equals("addSer")) {
			servicos.add(ui[1], new Servico(ui[1], Float.parseFloat(ui[2])));
			saldo += servicos.get(ui[1]).valor;
		}

		else if(ui[0].equals("showSer")) {

			String saida = "";

			for(Servico elem : servicos.getAll()) {
				saida += "[" + elem.toString() + "]" + "\n";
			}
			return saida;
		}

		else if(ui[0].equals("venSer")) {
			vendas.add(ui[1], new Venda(ui[1], ui[2], ui[3]));
		}

		else if(ui[0].equals("showVen")) {

			String saida = "";
			int cont = 1;

			for(Venda elem : vendas.getAll()) {
				saida += cont + "[" + elem.toString() + "]" + "\n";
				cont++;
			}
			return saida;
		}

		else if(ui[0].equals("saldo")) {
			System.out.println(saldo);
		}

		else
			return "comando invalido";
		return "done";
	}
}
