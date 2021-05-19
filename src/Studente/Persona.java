package Studente;

public class Persona {

	/** Nome Persona **/
	protected String nome;
	/** Cognome Persona **/
    protected String cognome;
    
    public Persona(String cognome, String nome) {
        this.cognome = cognome;
        this.nome = nome;
    }
    
    public String getNome() {
		return nome;
	}
    
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
}