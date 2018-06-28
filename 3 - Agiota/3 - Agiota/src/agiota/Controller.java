package agiota;

public class Controller {

	Emprestimo emprestimo;

	public String oracle(String line){
		String ui[] = line.split(" ");

		if(ui[0].equals("help")) {
			return "init, nwcli, emprestar, mostrarClientes, mostrarCliente, saldo, receber";
		}

		else if(ui[0].equals("init")) {
			emprestimo = new Emprestimo(Float.parseFloat(ui[1]));
			emprestimo.iniciarSistema();
		}
		
		else if(ui[0].equals("nwcli")) {
			emprestimo.cadastrarCliente(ui[1], ui[2]);
		}
		
		else if(ui[0].equals("emprestar")) {
			emprestimo.emprestarDinheiro(ui[1], Float.parseFloat(ui[2]));
		}
		
		else if(ui[0].equals("receber")) {
			emprestimo.receberDinheiro(ui[1], Float.parseFloat(ui[2]));
		}
		else if(ui[0].equals("mostrarClientes")) {
			return emprestimo.mostrarTodosClientes();
		}
		
		else if(ui[0].equals("mostrarCliente")) {
			emprestimo.mostrarCliente(ui[1]);
		}
		
		else if(ui[0].equals("matarCliente")) {
			emprestimo.matarCliente(ui[1]);
		}
		
		else if(ui[0].equals("saldo")) {
			System.out.println(emprestimo.saldo);
		}
		
		else
			return "comando invalido";
		return "done";
	}
}
