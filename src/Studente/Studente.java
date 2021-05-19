package Studente;

public class Studente extends Persona {

	/** Materia**/
	private String materia;

	public Studente(String nome,String cognome,String materia) {
		super(nome,cognome);
		this.materia = materia;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

}
