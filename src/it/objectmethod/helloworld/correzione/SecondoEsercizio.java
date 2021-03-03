package it.objectmethod.helloworld.correzione;

import java.util.Scanner;

import it.objectmethod.helloworld.correzione.model.Articolo;

public class SecondoEsercizio {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Articolo[] articoli = new Articolo[3];

		for (int i = 0; i < articoli.length; i++) {

			articoli[i] = new Articolo();

			System.out.println("inserisci codice descrizione e quantita di un articolo");

			String codice = sc.nextLine();
			String descrizione = sc.nextLine();
			int quantita = sc.nextInt();
			sc.nextLine();

			articoli[i].setId(i + 1);
			articoli[i].setCodice(codice);
			articoli[i].setDescrizione(descrizione);
			articoli[i].setQuantita(quantita);

		}

		Articolo articoloQtaMax = articoli[0];

		for (Articolo art : articoli) {
			if (art.getQuantita() > articoloQtaMax.getQuantita()) {
				articoloQtaMax = art;
			}
		}

		System.out.println("L'articolo con quantita† maggiore Ë: \n" + "id: " + articoloQtaMax.getId() + "\n"
				+ "descrizione: " + articoloQtaMax.getDescrizione() + "\n" + "quantit√†: "
				+ articoloQtaMax.getQuantita() + "\n" + "codice: " + articoloQtaMax.getCodice());

		sc.close();
	}

}
