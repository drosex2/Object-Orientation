import java.util.*;

public class Utente {
	//ATTRIBUTI
	private String username;
	private String email;
	private String password;
	private LinkedList<Gruppo> gruppiAmministrati;
	private LinkedList<Gruppo> gruppiIscrizioni;
	
	//GETTERS e SETTERS
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LinkedList<Gruppo> getGruppiAmministrati() {
		return gruppiAmministrati;
	}
	public void setGruppiAmministrati(LinkedList<Gruppo> gruppiAmministrati) {
		this.gruppiAmministrati = gruppiAmministrati;
	}
	public LinkedList<Gruppo> getGruppiIscrizioni() {
		return gruppiIscrizioni;
	}
	public void setGruppiIscrizioni(LinkedList<Gruppo> gruppiIscrizioni) {
		this.gruppiIscrizioni = gruppiIscrizioni;
	}
	
	
	//COSTRUTTORE
	
	public Utente(String username, String email, String password, LinkedList<Gruppo> gruppiAmministrati,
			LinkedList<Gruppo> gruppiIscrizioni) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.gruppiAmministrati = gruppiAmministrati;
		this.gruppiIscrizioni = gruppiIscrizioni;
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
		Utente other = (Utente) obj;
		return Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "Utente [username=" + username + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
}
