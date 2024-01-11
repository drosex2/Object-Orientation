import java.time.*;
import java.util.Objects;

public class Gruppo {
	
	//ATTRIBUTI
	private String idGruppo;
	private String nome;
	private String tag;
	private LocalDate dataCreazione;
	private Utente utenteCreatore;
	
	//GETTERS e SETTERS
	
	public String getIdGruppo() {
		return idGruppo;
	}
	public void setIdGruppo(String idGruppo) {
		this.idGruppo = idGruppo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public LocalDate getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(LocalDate dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	public Utente getUtenteCreatore() {
		return utenteCreatore;
	}
	public void setUtenteCreatore(Utente utenteCreatore) {
		this.utenteCreatore = utenteCreatore;
	}
	
	
	//COSTRUTTORE
	public Gruppo(String idGruppo, String nome, String tag, LocalDate dataCreazione, Utente utenteCreatore) {
		super();
		this.idGruppo = idGruppo;
		this.nome = nome;
		this.tag = tag;
		this.dataCreazione = dataCreazione;
		this.utenteCreatore = utenteCreatore;
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
		Gruppo other = (Gruppo) obj;
		return Objects.equals(idGruppo, other.idGruppo);
	}
	@Override
	public String toString() {
		return "Gruppo [idGruppo=" + idGruppo + ", nome=" + nome + ", tag=" + tag + ", dataCreazione=" + dataCreazione
				+ ", utenteCreatore=" + utenteCreatore + "]";
	}
	
	
}
