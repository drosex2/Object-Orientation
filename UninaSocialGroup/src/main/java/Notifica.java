import java.time.*;
import java.util.Objects;

public class Notifica {
	//ATTRIBUTI
	private String idNotifica;
	private LocalDate data;
	private LocalTime ora;
	private Utente utente;
	private Post postGenerante;
	private Interazione interazioneGenerante;
	
	//GETTERS e SETTERS
	public String getIdNotifica() {
		return idNotifica;
	}

	public void setIdNotifica(String idNotifica) {
		this.idNotifica = idNotifica;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	public LocalTime getOra() {
		return ora;
	}


	public void setOra(LocalTime ora) {
		this.ora = ora;
	}


	public Utente getUtente() {
		return utente;
	}


	public void setUtente(Utente utente) {
		this.utente = utente;
	}


	public Post getPostGenerante() {
		return postGenerante;
	}


	public void setPostGenerante(Post postGenerante) {
		this.postGenerante = postGenerante;
	}


	public Interazione getInterazioneGenerante() {
		return interazioneGenerante;
	}


	public void setInterazioneGenerante(Interazione interazioneGenerante) {
		this.interazioneGenerante = interazioneGenerante;
	}


	//COSTRUTTORE
	public Notifica(String idNotifica, LocalDate data, LocalTime ora, Utente utente, Post postGenerante,
			Interazione interazioneGenerante) {
		super();
		this.idNotifica = idNotifica;
		this.data = data;
		this.ora = ora;
		this.utente = utente;
		this.postGenerante = postGenerante;
		this.interazioneGenerante = interazioneGenerante;
	}

	//EQUALS e TOSTRING
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notifica other = (Notifica) obj;
		return Objects.equals(idNotifica, other.idNotifica);
	}

	@Override
	public String toString() {
		return "Notifica [idNotifica=" + idNotifica + ", data=" + data + ", ora=" + ora + ", utente=" + utente
				+ ", postGenerante=" + postGenerante + ", interazioneGenerante=" + interazioneGenerante + "]";
	}
	
	
	
}
