import java.time.*;
import java.util.Objects;

public class Richiesta {
	//ATTRIBUTI
	private String idRichiesta;
	private LocalDate dataRichiesta;
	private LocalTime oraRichiesta;
	private String testo;
	private boolean esito;
	private Utente utenteRichiedente;
	private Gruppo gruppo;
	
	//SETTERS e GETTERS
	public String getIdRichiesta() {
		return idRichiesta;
	}
	public void setIdRichiesta(String idRichiesta) {
		this.idRichiesta = idRichiesta;
	}
	public LocalDate getDataRichiesta() {
		return dataRichiesta;
	}
	public void setDataRichiesta(LocalDate dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}
	public LocalTime getOraRichiesta() {
		return oraRichiesta;
	}
	public void setOraRichiesta(LocalTime oraRichiesta) {
		this.oraRichiesta = oraRichiesta;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public boolean isEsito() {
		return esito;
	}
	public void setEsito(boolean esito) {
		this.esito = esito;
	}
	public Utente getUtenteRichiedente() {
		return utenteRichiedente;
	}
	public void setUtenteRichiedente(Utente utenteRichiedente) {
		this.utenteRichiedente = utenteRichiedente;
	}
	public Gruppo getGruppo() {
		return gruppo;
	}
	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}
	
	//COSTRUTTORE
	public Richiesta(String idRichiesta, LocalDate dataRichiesta, LocalTime oraRichiesta, String testo, boolean esito,
			Utente utenteRichiedente, Gruppo gruppo) {
		super();
		this.idRichiesta = idRichiesta;
		this.dataRichiesta = dataRichiesta;
		this.oraRichiesta = oraRichiesta;
		this.testo = testo;
		this.esito = esito;
		this.utenteRichiedente = utenteRichiedente;
		this.gruppo = gruppo;
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
		Richiesta other = (Richiesta) obj;
		return Objects.equals(idRichiesta, other.idRichiesta);
	}
	@Override
	public String toString() {
		return "Richiesta [idRichiesta=" + idRichiesta + ", dataRichiesta=" + dataRichiesta + ", oraRichiesta="
				+ oraRichiesta + ", testo=" + testo + ", esito=" + esito + ", utenteRichiedente=" + utenteRichiedente
				+ ", gruppo=" + gruppo + "]";
	}
	
	
	
	
	
}
