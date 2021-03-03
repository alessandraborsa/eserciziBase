package it.objectmethod.helloworld.correzione;

import java.util.Scanner;

public class PrimoEsercizio {

	public static void main(String[] args) {

		// Correzione 1-1

//		Scanner scanner = new Scanner(System.in);
//
//		System.out.println("Inserire i 2 numeri da sommare");
//
//		int primoVal = scanner.nextInt();
//		int secVal = scanner.nextInt();
//
//		System.out.println("La somma dei 2 numeri è: " + (primoVal + secVal));
//		scanner.close();

		// Correzione 1-2

//		boolean exit = false;
//		Scanner scanner = new Scanner(System.in);
//		while (!exit) {
//
//			System.out.println("inserisci due numeri");
//
//			int primoVal = scanner.nextInt();
//			int secVal = scanner.nextInt();
//
//			System.out.println("i numeri inseriti sono: " + primoVal + " e " + secVal);
//
//			System.out.println("vuoi procedere con una nuova operazione?");
//			scanner.nextLine();
//			String answer = scanner.nextLine();
//
//			if (answer.equals("N")) {
//				System.out.println("operazione finita");
//				exit = true;
//			} else if (answer.equals("Y")) {
//				exit = false;
//			} else {
//				System.out.println("operazione non valida");
//				exit = true;
//
//			}
//
//		}
//		scanner.close();

		Scanner scanner = new Scanner(System.in);
		System.out.println("inserisci una frase");
		String phrase = scanner.nextLine();

		int space = phrase.indexOf(" ");
		System.out.println(phrase.substring(0, space));
		scanner.close();
	}

}
