import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class UtenteDao {
	private Connection conn = null;
	
	public UtenteDao(){
		
        // istanzia la classe di connessione al DB
        DBConnection dbConnection= DBConnection.getDBConnection();        // recupera la connessione
        //conn = dbConnection.getConnection();
        // se conosco già ed ho già creato lo schema !!!
        conn = dbConnection.getConnection();

        if (conn == null) {
            System.out.println("Connessione NON riuscita!");
            System.exit(0);
        }
	}
	
	
	
	public void save(Utente utente)
	{
		String username=utente.getUsername();
		String email=utente.getEmail();
		String password=utente.getPassword();
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            String query = "INSERT INTO Utente VALUES ('"+username+"','"+email+"','"+password+"');";

            stmt.execute(query);
            
            stmt.close();

            


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
        }
	}
	public Utente getByUsername(String username)
	{
		Utente utenteReturn;
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement("Select * from Utente where username LIKE '"+username+"';");
            

            ResultSet rs = ps_queryforname.executeQuery();
            rs.next();
            String usernameReturn=rs.getString(1);
            String emailReturn=rs.getString(2);
            String passwordReturn=rs.getString(3);
            
            ps_queryforname = conn.prepareStatement("Select gruppo.* From amministra INNER JOIN gruppo on amministra.\"idGruppo\"=gruppo.\"idGruppo\" Where amministra.username LIKE '"+username+"';");
            rs = ps_queryforname.executeQuery();
            LinkedList<Gruppo> gruppiAmministrati=new LinkedList<Gruppo>();
            while(rs.next())
            {
            	String idGruppo=rs.getString(1);
            	String nomeGruppo=rs.getString(2);
            	String tag=rs.getString(3);
            	LocalDate dataCreazione = rs.getDate(4).toLocalDate();
            	Utente utenteCreatore= new Utente(rs.getString(5),null,null,null,null);
            	Gruppo gruppoAmministrato=new Gruppo(idGruppo,nomeGruppo,tag,dataCreazione,utenteCreatore);
            	gruppiAmministrati.add(gruppoAmministrato);
            }
            ps_queryforname = conn.prepareStatement("Select gruppo.* From iscrizione INNER JOIN gruppo on iscrizione.\"idGruppo\"=gruppo.\"idGruppo\" Where iscrizione.username LIKE '"+username+"';");
            rs = ps_queryforname.executeQuery();
            LinkedList<Gruppo> iscrizioni=new LinkedList<Gruppo>();
            while(rs.next())
            {
            	String idGruppo=rs.getString(1);
            	String nomeGruppo=rs.getString(2);
            	String tag=rs.getString(3);
            	LocalDate dataCreazione = rs.getDate(4).toLocalDate();
            	Utente utenteCreatore= new Utente(rs.getString(5),null,null,null,null);
            	Gruppo gruppoIscritto=new Gruppo(idGruppo,nomeGruppo,tag,dataCreazione,utenteCreatore);
            	iscrizioni.add(gruppoIscritto);
            }
            utenteReturn=new Utente(usernameReturn,emailReturn,passwordReturn,gruppiAmministrati,iscrizioni);
            
            stmt.close();

            
            return utenteReturn;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
            return null;
        }
        
	}
	
	public void updateEmailByUser(String username,String email) {
		
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            String query = "UPDATE utente SET email = '"+email+"' WHERE username = '"+username+"';";

            stmt.execute(query);
            
            stmt.close();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
        }	
	}
	public void updatePasswordByUser(String username,String password) {
		
	    Statement stmt = null;
        try {

            // crea uno statement 
            stmt = this.conn.createStatement();

            String query = "UPDATE utente SET password = '"+password+"' WHERE username = '"+username+"';";

            stmt.execute(query);
            
            stmt.close();

            

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
        }	
	}
	public void deleteById(String username){
		
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            String query = "DELETE FROM utente WHERE username IN ('"+username+");";

            stmt.execute(query);
            
           
            stmt.close();

            


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
        }
		
	}
}
