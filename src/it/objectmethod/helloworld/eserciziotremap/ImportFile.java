package it.objectmethod.helloworld.eserciziotremap;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import it.objectmethod.helloworld.eserciziotre.NewArticolo;

import java.util.Scanner;

public class ImportFile {
	public static void main(String... args) {

			Scanner scanner = new Scanner(System.in);
		 	String fileToParse = "articoli.csv";
	        
	        HashMap<String,NewArticolo> articolo = readDataFromCSV(fileToParse);
	        for (Map.Entry entry : articolo.entrySet())
	        {
	            System.out.println("key: " + entry.getKey() + "; value: " + entry.getValue());
	        }
      
	        boolean exit = false;
            while (!exit) {
            	System.out.println("Vuoi inserire un nuovo articolo? Y/N");
            	String answer = scanner.nextLine();
	            if (answer.equals("Y")) {
	            	
	            	System.out.println("inserisci codice, descrizione e quantita");
	            	String codice = scanner.nextLine();
	    			String descrizione = scanner.nextLine();
	    			String quantita = scanner.nextLine();
	    			scanner.nextLine();
	    			
	    			
	    			int size = articolo.size() + 1;
	    			String id = Integer.toString(size);
	    			NewArticolo nuovoArticolo = new NewArticolo(id, codice, descrizione, quantita);
	    			nuovoArticolo.setId(id);
	    			nuovoArticolo.setCodice(codice);
	    			nuovoArticolo.setDescrizione(descrizione);
	    			nuovoArticolo.setQuantita(quantita);
	    			
	    			articolo.put(codice, nuovoArticolo);
	    			
	    			exit = false;
	    			
	            } else {
	            	exit = !exit;
	            	System.out.println("esercizio finito");
	            	
	            	System.out.println(articolo);
	            	System.out.println("inserisci codice di ricerca");
	            	String codiceRicerca = scanner.nextLine();
	            	NewArticolo articoloCercato = articolo.get(codiceRicerca);
	            	System.out.println(articoloCercato);
	            	String nextLine = System.getProperty("line.separator");
	            	Writer writer;
					try {
						writer = new FileWriter("nuovi-articoli.csv");
						for (Entry<String, NewArticolo> entry : articolo.entrySet()) {
		    				writer.append(String.valueOf(entry.getValue().getId()))
		    				.append(';')
		    				.append(String.valueOf(entry.getValue().getCodice()))
		    				.append(';')
		    				.append(String.valueOf(entry.getValue().getDescrizione()))
		    				.append(';')
		    				.append(String.valueOf(entry.getValue().getQuantita()))
		    				.append(nextLine);
		    				
		    			}
		            	writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    			
	            }
            }
            
            scanner.close();
	}
	private static HashMap<String,NewArticolo> readDataFromCSV(String fileName) { 
		
		HashMap<String,NewArticolo> articolo = new HashMap<String,NewArticolo>(); 
		Path pathToFile = Paths.get(fileName);

	    try (BufferedReader br = Files.newBufferedReader(pathToFile)) {
	         String line = br.readLine();
	            while (line != null) {
	                String[] tokens = line.split(";");
	                NewArticolo newArticolo = createArticolo(tokens);
	                articolo.put(tokens[1], newArticolo);
	                line = br.readLine();
	            }
	            
	    } catch (IOException ioe) {
	            ioe.printStackTrace();
	    } 
	    return articolo;
		}
	private static NewArticolo createArticolo(String[] metadata) { 
		
		String id = metadata[0]; 
		String codice = metadata[1]; 
		String descrizione = metadata[2]; 
		String quantita = metadata[3];
		return new NewArticolo(id, codice, descrizione, quantita); 
	}	
}
