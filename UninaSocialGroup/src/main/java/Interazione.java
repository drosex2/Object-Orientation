import java.time.*;
import java.util.Objects;

public class Interazione {
	//ATTRIBUTI
	private String idInterazione;
	private LocalDate data;
	private LocalTime ora;
	private Utente utente;
	private Post post;
	
	public Interazione(String idInterazione, LocalDate data, LocalTime ora, Utente utente, Post post) {
		this.idInterazione=idInterazione;
		this.data=data;
		this.ora=ora;
		this.utente=utente;
		this.post=post;
	}
	//GETTERS e SETTERS
	public String getIdInterazione() {
		return idInterazione;
	}
	public void setIdInterazione(String idInterazione) {
		this.idInterazione = idInterazione;
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
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	//COSTRUTTORE
	
	
	
	
	//EQUALS e TOSTRING
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interazione other = (Interazione) obj;
		return Objects.equals(idInterazione, other.idInterazione);
	}
	@Override
	public String toString() {
		return "Interazione [idInterazione=" + idInterazione + ", data=" + data + ", ora=" + ora + ", utente=" + utente
				+ ", post=" + post + "]";
	}
	public String getTesto() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
