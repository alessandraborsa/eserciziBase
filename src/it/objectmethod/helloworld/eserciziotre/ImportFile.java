package it.objectmethod.helloworld.eserciziotre;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportFile {
	public static void main(String... args) {

			Scanner scanner = new Scanner(System.in);
		 	String fileToParse = "articoli.csv";
	        
	        List<NewArticolo> articolo = readDataFromCSV(fileToParse);
	        for (NewArticolo a : articolo) {
	        	System.out.println(a);
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
	    			
	    			articolo.add(nuovoArticolo);
	    			
	    			exit = false;
	    			
	            } else {
	            	exit = !exit;
	            	System.out.println("esercizio finito");
	            	
	            	System.out.println(articolo);
	            	String nextLine = System.getProperty("line.separator");
	            	Writer writer;
					try {
						writer = new FileWriter("nuovi-articoli.csv");
						for (NewArticolo a : articolo) {
		    				writer.append(String.valueOf(a.getId()))
		    				.append(';')
		    				.append(String.valueOf(a.getCodice()))
		    				.append(';')
		    				.append(String.valueOf(a.getDescrizione()))
		    				.append(';')
		    				.append(String.valueOf(a.getQuantita()))
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
	private static List<NewArticolo> readDataFromCSV(String fileName) { 
		
		List<NewArticolo> articolo = new ArrayList<NewArticolo>(); 
		Path pathToFile = Paths.get(fileName);

	    try (BufferedReader br = Files.newBufferedReader(pathToFile)) {
	         String line = br.readLine();
	            while (line != null) {
	                String[] tokens = line.split(";");
	                NewArticolo newArticolo = createArticolo(tokens);
	                articolo.add(newArticolo);
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
