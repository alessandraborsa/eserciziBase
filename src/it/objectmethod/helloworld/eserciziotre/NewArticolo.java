package it.objectmethod.helloworld.eserciziotre;

public class NewArticolo {
	private String id;
	private String codice;
	private String descrizione;
	private String quantita;
	
	public NewArticolo(String id, String codice, String descrizione, String quantita) { 
		this.id = id; 
		this.codice = codice; 
		this.descrizione = descrizione;
		this.quantita = quantita;
	}

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getQuantita() {
		return quantita;
	}
	public void setQuantita(String quantita) {
		this.quantita = quantita;
	}
	
	@Override 
	public String toString() { 
		return "[id=" + id + ", codice=" + codice + ", descrizione=" + descrizione + ", quantita=" + quantita + "]"; 
	}

}
