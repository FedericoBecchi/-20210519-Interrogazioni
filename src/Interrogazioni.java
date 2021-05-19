import java.util.ArrayList;
import java.util.Random;
import Studente.*;

public class Interrogazioni {
	
	/** Numero di persone della lista**/
	private int n_persone;

	/** Lista Utenti  **/
	 private ArrayList<Studente> studenti;
	
	/** Lista Utenti  **/
	 private ArrayList<Studente> studenti_sorteggiati;
	
	public Interrogazioni(int n_interrogati) {
		this.n_persone = n_interrogati;
		this.studenti = new ArrayList<Studente>();
		this.studenti_sorteggiati = new ArrayList<Studente>();
	}
	
	public int getN_persone() {
		return n_persone;
	}

	public void setN_persone(int n_persone) {
		this.n_persone = n_persone;
	}

	public ArrayList<Studente> getStudenti() {
		return studenti;
	}
	
	/** Restuisce True Se Lo Studente è Contenuto Nell ArrayList**/
	public boolean IsStudenteInArrayList(Studente secondo_studente,ArrayList<Studente> array) {
		for(Studente stud : array) {
			if(secondo_studente.isStessaPersona(stud)) {
				return true;
			}
		}
		return false;
	}
	
	/** Restituisce l'elemento degli studenti (l'elemento dell'indice richiesto) **/
	public Studente getStudenteIndex(int index) {
		if(index>0&&index<this.studenti.size()) {
			return studenti.get(index);
		}
		return null;
	}


	public void addStudente(Studente nuovo_studente) {
		if((this.studenti.size()<this.n_persone)&&!IsStudenteInArrayList(nuovo_studente,this.studenti)) {
			this.studenti.add(nuovo_studente);
		}
	}

	public ArrayList<Studente> getStudenti_Sorteggiati() {
		return studenti_sorteggiati;
	}

	public void addStudenteSorteggiato(Studente nuovo_studente) {
		if((this.studenti_sorteggiati.size()<this.n_persone)&&!IsStudenteInArrayList(nuovo_studente,this.studenti_sorteggiati)) {
			this.studenti_sorteggiati.add(nuovo_studente);
		}
	}
	
	public Studente getStudenteSorteggiatoIndex(int index) {
		if(index>0&&index<this.studenti_sorteggiati.size()) {
			return studenti_sorteggiati.get(index);
		}
		return null;
	}

	
	/** Questo Metodo Genera La Lista Di Sorteggiati **/
	public void Sorteggio() {
		ArrayList<Studente> copia_studenti = this.studenti;
		this.studenti_sorteggiati = new ArrayList<Studente>();
		Random rand = new Random();
		int sorteggiato;
		for(int i  = copia_studenti.size()-1;i>=0;i--) {
			sorteggiato = rand.nextInt((i - 0) + 1) + 0;
			this.studenti_sorteggiati.add(copia_studenti.get(sorteggiato));
			copia_studenti.remove(sorteggiato);
		}
	}
	
	/** Questo Metodo Stampa Gli Utenti **/
	public void StampaUtenti() {
		
	}
	
	/** Questo Metodo Gestisce Le Date **/
	public void GestisciData() {
		// Come Posso Gestire Le Date
		// Ipotesi 
		// Gestire Con ArrayListi di  String
			// Creare Attributo ArrayList String
			// Esiste La Classe Data per ottenere la data corrente
			// Creare Attributo Int Giorni Di Interrogazionu
			// Creare Attributi Per I Sostituti
	}
	
	public static void main(String[] args) {
		Interrogazioni prova = new Interrogazioni(4);
		prova.addStudente(new Studente("Becchi","Federico","Inglese","4AINF"));
		prova.addStudente(new Studente("Becchi","Federice","Inglese","4AINF"));
		prova.addStudente(new Studente("Becchi","Federicaa","Inglese","4AINF"));
		prova.addStudente(new Studente("Becchi","Federicai","Inglese","4AINF"));
		prova.Sorteggio();
	
	}
	
}
