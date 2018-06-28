package junkfood;

import java.util.Scanner;

public class Controller {
	
	static final int DEFAULT_ESPIRAIS = 3;
	static final int DEFAULT_MAX = 5;

	Maquina maquina;
	Scanner entrada;

	public Controller() {
		maquina = new Maquina(DEFAULT_ESPIRAIS, DEFAULT_MAX);
		entrada = new Scanner(System.in);
	}
	
	public String oracle(String linha){

		String ui[] = linha.split(" ");

		if(ui[0].equals("help"))
			return "iniciarEspiral, mostrarEspiral, adicionarEspiral, inserirDinheiro, "
					+ " \ncomprarProduto, imparEspiral, alterarEspiral, saldo, troco, lucro";

		else if(ui[0].equals("iniciarEspiral")) {
			maquina = new Maquina(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
		}
		
		else if(ui[0].equals("mostrarEspiral")) {
			return "" + maquina.toString();
		}
		
		else if(ui[0].equals("adicionarEspiral")) {
			maquina.adicionarEspiral(Integer.parseInt(ui[1]), ui[2], Integer.parseInt(ui[3]),Float.parseFloat(ui[4]));
		}
		
		else if(ui[0].equals("inserirDinheiro")) {
			maquina.inserirDinheiro(Float.parseFloat(ui[1]));
		}
		
		else if(ui[0].equals("comprarProduto")) {
			maquina.vender(ui[1]);
		}
		
		else if(ui[0].equals("limparEspiral")) {
			maquina.resetarEspiral(Integer.parseInt(ui[1]));
		}
		
		else if(ui[0].equals("alterarEspiral"))	{
			maquina.alterarEspiral(Integer.parseInt(ui[1]), ui[2], Integer.parseInt(ui[3]), Float.parseFloat(ui[4]));
		}
		
		else if(ui[0].equals("saldo")) {
			System.out.println(maquina.getSaldoCliente());
		}
		
		else if(ui[0].equals("troco")) {
			System.out.println(maquina.getTroco());
		}
		
		else if(ui[0].equals("lucro")) {
			System.out.println(maquina.getLucro());
		}
		else
			return "Comando incorreto!";
		return "done";
	}
}
