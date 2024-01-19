import java.time.*;
import java.util.*;

public class Commento extends Interazione {
	private String testo;

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	
	
	
	
	
	public Commento(String idInterazione, LocalDate data, LocalTime ora, Utente utente, Post post, String testo) {
		super(idInterazione, data, ora, utente, post);
		this.testo = testo;
	}

	//EQUALS e TOSTRING
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commento other = (Commento) obj;
		return Objects.equals(testo, other.testo);
	}

	@Override
	public String toString() {
		return super.toString()+"[testo=" + testo + "]";
	}
	
	

}
