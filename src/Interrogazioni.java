import java.util.ArrayList;
import java.util.Random;
import Studente.*;

public class Interrogazioni {
	
	/** Numero di persone della lista**/
	private int n_persone;
	
	/** Numero di studenti per sessione**/
	private int n_studenti_sessione;
	
	/** Nummero di sessioni **/
	private int n_sessioni;
	
	/** Stringa del ritorno**/
	private String ritorno;

	/** Lista Utenti  **/
	 private ArrayList<Studente> studenti;
	
	/** Lista Utenti  **/
	 private ArrayList<Studente> studenti_sorteggiati;
	 
	 /** Contiene la lista di date **/
	 private ArrayList<String> date_sessione;
	
	public Interrogazioni(int n_persone,int n_studenti_sessione,int n_sessioni) {
		if(n_persone>0) {this.n_persone = n_persone;}
		if(n_studenti_sessione>0) {this.n_studenti_sessione = n_studenti_sessione;}
		if(n_sessioni>0) {this.n_sessioni = n_sessioni;}
		
		this.ritorno = "";
		this.studenti = new ArrayList<Studente>();
		this.studenti_sorteggiati = new ArrayList<Studente>();
		this.date_sessione = new ArrayList<String>();
	}
	
	public int getN_studenti_sessione() {
		return n_studenti_sessione;
	}

	public void setN_studenti_sessione(int n_studenti_sessione) {
		this.n_studenti_sessione = n_studenti_sessione;
	}

	public void setStudenti(ArrayList<Studente> studenti) {
		this.studenti = studenti;
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
	
	public String getRitorno() {
		return ritorno;
	}

	public void setRitorno(String ritorno) {
		this.ritorno = ritorno;
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
		if(index>=0&&index<this.studenti_sorteggiati.size()) {
			return studenti_sorteggiati.get(index);
		}
		return null;
	}
	
	/** Restituisce true se l'elemento è contenuto nell'array **/
	public boolean isStessaDataInArray(String data,ArrayList<String> array) {
		for(int i = 0;i<array.size();i++) {
			if(data.equals(array.get(i))){
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<String> getDate() {
		return this.date_sessione;
	}

	public void addData(String data) {
		if((this.date_sessione.size()<this.n_sessioni)&&!isStessaDataInArray(data,this.date_sessione)) {
			this.date_sessione.add(data);
		}
	}
	
	public String getDataIndex(int index) {
		if(index>=0&&index<this.date_sessione.size()) {
			return date_sessione.get(index);
		}
		return null;
	}

	
	/** Questo Metodo Genera La Lista Di Sorteggiati **/
	public void Sorteggio() {
		ArrayList<Studente> copia_studenti = this.studenti;
		Random rand = new Random();
		int sorteggiato;
		for(int j = 0;j<this.n_sessioni;j++) {
			for(int i  = copia_studenti.size()-1;i>=0;i--) {
				sorteggiato = rand.nextInt((i - 0) + 1) + 0;
				this.studenti_sorteggiati.add(copia_studenti.get(sorteggiato));
				copia_studenti.remove(sorteggiato);
			}
		}
	}
	
	/** Questo Metodo Crea Una Stringa con gli utenti sorteggiati **/
	public void ArchiviaUtenti() {
		int j = 0;
		/** Valore Per Stabilire il giusto studente da stampare **/
		if(this.n_sessioni==this.date_sessione.size()&&this.n_persone==this.studenti_sorteggiati.size()&&this.n_persone>0) {
			for(int i = 0;i<this.date_sessione.size();i++) {
				this.ritorno += "\n"+this.getDataIndex(i);
				for(int k = j;k<this.n_studenti_sessione+(this.n_studenti_sessione*i);k++) {
					ritorno+= "\n"+this.studenti_sorteggiati.get(k).getCognome();
					j++;
				}
				this.ritorno += "\n";
				if(j==this.studenti_sorteggiati.size()) {break;}
			}
		}
	}
	
	/** Questo Metodo Gestisce Le Date **/
//	public void GestisciData() {
//		 Come Posso Gestire Le Date
//		 Ipotesi 
//		 Gestire Con ArrayListi di  String
//			 Creare Attributo ArrayList String
//			 Esiste La Classe Data per ottenere la data corrente
//			 Creare Attributo Int Giorni Di Interrogazionu
//			 Creare Attributi Per I Sostituti
//  }
	
	public static void main(String[] args) {
		
		
		
		int n_interrogati = 3;
		int n_studenti_sessione = 3;
		int n_sessioni = 0;
		
		Interrogazioni prova = new Interrogazioni(n_interrogati,n_studenti_sessione,n_sessioni);
		prova.addStudente(new Studente("Ferioli","Andrea","Inglese","4AINF"));
		prova.addStudente(new Studente("Becchi","Federico","Inglese","4AINF"));
		prova.addStudente(new Studente("Zhu","Massimo","Inglese","4AINF"));
		prova.addStudente(new Studente("Mazza","GianMarco","Inglese","4AINF"));
		prova.addStudente(new Studente("Perazzoli","Davide","Inglese","4AINF"));
		prova.addStudente(new Studente("Calabrese","Alessandro","Inglese","4AINF"));
		
		prova.addData("3 Maggio");
		prova.addData("4 Maggio");
		
		prova.Sorteggio();
		prova.ArchiviaUtenti();
		
		System.out.println(prova.getRitorno());
	}
	
}
