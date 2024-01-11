import java.time.*;
import java.util.Objects;

public class Post {
	//ATTRIBUTI
	private String idString;
	private String foto;
	private String testo;
	private LocalDate dataPubblicazione;
	private LocalTime oraPubblicazione;
	private Gruppo gruppo;
	private Utente utenteAutore;
	
	
	//GETTERS e SETTERS
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public LocalDate getDataPubblicazione() {
		return dataPubblicazione;
	}
	public void setDataPubblicazione(LocalDate dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}
	public LocalTime getOraPubblicazione() {
		return oraPubblicazione;
	}
	public void setOraPubblicazione(LocalTime oraPubblicazione) {
		this.oraPubblicazione = oraPubblicazione;
	}
	public Gruppo getGruppo() {
		return gruppo;
	}
	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}
	public Utente getUtenteAutore() {
		return utenteAutore;
	}
	public void setUtenteAutore(Utente utenteAutore) {
		this.utenteAutore = utenteAutore;
	}
	
	
	//COSTRUTTORE
	public Post(String idString, String foto, String testo, LocalDate dataPubblicazione, LocalTime oraPubblicazione,
			Gruppo gruppo, Utente utenteAutore) {
		super();
		this.idString = idString;
		this.foto = foto;
		this.testo = testo;
		this.dataPubblicazione = dataPubblicazione;
		this.oraPubblicazione = oraPubblicazione;
		this.gruppo = gruppo;
		this.utenteAutore = utenteAutore;
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
		Post other = (Post) obj;
		return Objects.equals(idString, other.idString);
	}
	@Override
	public String toString() {
		return "Post [idString=" + idString + ", foto=" + foto + ", testo=" + testo + ", dataPubblicazione="
				+ dataPubblicazione + ", oraPubblicazione=" + oraPubblicazione + ", gruppo=" + gruppo
				+ ", utenteAutore=" + utenteAutore + "]";
	}
	
	
}
