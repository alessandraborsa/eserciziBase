package it.objectmethod.helloworld.esercizioquattro;

import java.util.Scanner;

public class Saluta {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("inserisci il tuo nome");
		String nome = scanner.nextLine();
		System.out.println("Digita Y per saluto formale, digita N per saluto informale");
		String saluto = scanner.nextLine();
		if (!saluto.equalsIgnoreCase("y") && !saluto.equalsIgnoreCase("n")) {
			System.out.println("errore!");
			saluto = scanner.nextLine();
		}
		System.out.println("inserire orario 0-24");
		int ore = Integer.parseInt(scanner.nextLine());
		
		ISalutatore salutatore;
		switch(saluto.toUpperCase()) {
		case "Y": 
			salutatore= new SalutatoreFormale();
			if(ore>=6.00 && ore<=13.00) {
				System.out.println(salutatore.salutaMattino(nome));
			}else if(ore > 13.00 && ore <= 22.00) {
				System.out.println(salutatore.salutaSera(nome));
			}else if(ore > 22.00 && ore < 6.00) {
				System.out.println(salutatore.salutaNotte(nome));
			}
			break;
		case "N":
			salutatore = new SalutatoreInformale();
			if(ore>=6.00 && ore<=13.00) {
				System.out.println(salutatore.salutaMattino(nome));
			}else if(ore > 13.00 && ore <= 22.00) {
				System.out.println(salutatore.salutaSera(nome));
			}else if(ore > 22.00 && ore < 6.00) {
				System.out.println(salutatore.salutaNotte(nome));
			}
			break;
		}
		scanner.close();
	}
}
