package junkfood;

import java.util.Scanner;

public class UI {
	
	static Scanner entrada = new Scanner(System.in);

	static private String tab(String text) {
		return " " + String.join("\n ",text.split("\n"));
	}

	public static void main(String[] args) {

		Controller controller = new Controller();
		
		System.out.println("Digite help ou um outro comando!");
		
		while(true) {
			
			String linha;
			
			linha = entrada.nextLine();
			
			try{
				System.out.println(tab(controller.oracle(linha)));
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(tab(e.getMessage()));
			}
		}
	}
}
