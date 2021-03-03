package it.objectmethod.helloworld.esercizioquattro;

public class SalutatoreFormale implements ISalutatore {

public String salutaMattino(String name) {
		
		return ("Buongiorno " + name + " buona giornata");
	}

	public String salutaSera(String name) {
		
		return ("Buon Pomeriggio " + name);
	}

	public String salutaNotte(String name) {
		
		return ("Buonanotte " + name);
	}

}
