package it.objectmethod.helloworld.esercizioquattro;

public class SalutatoreInformale implements ISalutatore {
	
	

	public String salutaMattino(String name) {
		
		return "Ciao " + name + " ben svegliato!";
	}

	public String salutaSera(String name) {
		
		return "Ciao " + name + " buon pomeriggio!";
	}

	public String salutaNotte(String name) {
		
		return "Ciao " + name + " buonanotte!";
	}

}
