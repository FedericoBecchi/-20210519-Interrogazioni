package Studente;

public class Studente extends Persona {

	/** materia studiata **/
	private String materia;
	
	/** classe dello studente **/
	private String classe;

	public Studente(String nome,String cognome,String materia,String classe) {
		super(nome,cognome);
		this.materia = materia;
		this.classe = classe;
	}

	public String getMateria() {
		return materia;
	}
	
	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	public String getClasse() {
		return this.classe;
	}
	
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	public boolean isStessaPersona(Persona secondo_studente) {
		if(secondo_studente instanceof Studente) {
			if(secondo_studente.getCognome().equals(this.cognome)&&secondo_studente.getNome().equals(this.nome)&& ((Studente)secondo_studente).getClasse().equals(this.classe)) {
				return true;
			}
		}
		return false;
	}
	
}
