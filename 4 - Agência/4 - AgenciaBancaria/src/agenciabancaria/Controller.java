package agenciabancaria;

public class Controller {

	Repositorio<Cliente> clientes;
	Repositorio<Conta> contas;
	GerenciadorLogin gerLogin;

	public Controller() {

		clientes = new 	Repositorio<Cliente>("Cliente");
		contas = new Repositorio<Conta>("Conta");
		gerLogin = new GerenciadorLogin(clientes);
	}

	public String oracle(String line){
		String ui[] = line.split(" ");

		if(ui[0].equals("help")) {
			return "login, logout, showCliente, showContas, addCliente, addConta, depositar, sacar, encerrar, saldo";
		}

		else if(ui[0].equals("addCliente")) {
			clientes.add(ui[1], new Cliente(ui[1], ui[2]));
		}

		else if(ui[0].equals("login")) {
			gerLogin.login(ui[1], ui[2]);

		}
		else if(ui[0].equals("logout")) {
			gerLogin.logout();
		}

		else if(ui[0].equals("addConta")) {
			contas.add(ui[1], new Conta(Integer.parseInt(ui[1])));
		}

		else if(ui[0].equals("saldo")) { 
			System.out.println(contas.get(ui[1]).getSaldo());
		}

		else if(ui[0].equals("depositar")) {
			contas.get(ui[1]).depositar(Float.parseFloat(ui[2]));
		}

		else if(ui[0].equals("sacar")) {
			contas.get(ui[1]).sacar(Float.parseFloat(ui[2]));
		}

		else if(ui[0].equals("encerrar")) {
			contas.get(ui[1]).encerrar();
		}

		else if(ui[0].equals("showClientes")) {

			String saida = "";

			for(Cliente elem : clientes.getAll()) {
				saida = saida + elem.getIdCliente() + "\n";
			}
			return saida;
		}

		else if(ui[0].equals("showContas")) {

			String saida = "";

			for(Conta elem: contas.getAll())
				saida = saida + elem.getNumero() + "\n";
			return saida;
		}

		else {
			return "comando invalido";	
		}
		return "done";
	}	
}