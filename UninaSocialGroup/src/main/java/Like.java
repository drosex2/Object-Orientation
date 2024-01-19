import java.time.LocalDate;
import java.time.LocalTime;

public class Like extends Interazione {

	//COSTRUTTORE
	public Like(String idInterazione, LocalDate data, LocalTime ora, Utente utente, Post post) {
		super(idInterazione, data, ora, utente, post);
		
	}

	//
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Like "+super.toString();
	}
	
	

}
