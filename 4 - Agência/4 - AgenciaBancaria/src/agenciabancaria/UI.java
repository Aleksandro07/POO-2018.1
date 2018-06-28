package agenciabancaria;

import java.util.Scanner;

public class UI {

	static Scanner scan = new Scanner(System.in);

	static private String tab(String text){
		return "  " + String.join("\n  ", text.split("\n"));
	}

	public static void main(String[] args) {
		Controller cont = new Controller();
		
		System.out.println("Digite um comando ou help:");
		
		while(true){
			String line = scan.nextLine();
			try {
				System.out.println(tab(cont.oracle(line)));
			}catch(Exception e) {
				System.out.println(tab(e.getMessage()));
			}
		}
	}
}
