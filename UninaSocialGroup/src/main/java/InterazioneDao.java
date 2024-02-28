import java.sql.*;
import java.sql.Date;
import java.time.*;
import java.util.*;

public class InterazioneDao {
	private Connection conn = null;
	
	public InterazioneDao(){
		
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
	
	
	
	public void save(Interazione interazione)
	{
		String idInterazione=interazione.getIdInterazione();
		Date data=Date.valueOf(interazione.getData());
		Time ora=Time.valueOf(interazione.getOra());
		String testo;
		String tipoInterazione;
		if(interazione.getClass()==Commento.class)
		{
			testo=interazione.getTesto();
			tipoInterazione="commento";
		}
		else
		{
			testo=null;
			 tipoInterazione="like";
		}
		String username=interazione.getUtente().getUsername();
		String idPost=interazione.getPost().getIdPost();
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            String query = "INSERT INTO interazione VALUES ('"+idInterazione+"','"+data+"','"+ora+"','"+testo+"','"+tipoInterazione+"','"+username+"','"+idPost+"');";

            stmt.execute(query);
            
            stmt.close();

            


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
        }
	}
	public Interazione getById(String idInterazione)
	{
		Interazione interazioneReturn;
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement("Select * from Interazione where \"idInterazione\" LIKE '"+idInterazione+"';");
            

            ResultSet rs = ps_queryforname.executeQuery();
            rs.next();
            //String idInterazione=rs.getString(1);
            
            LocalDate data=rs.getDate(2).toLocalDate();
            LocalTime ora=rs.getTime(3).toLocalTime();
            String tipoInterazione=rs.getString(5);
            String testo = null;
            if(tipoInterazione.equals("commento"))
            	{
            	  testo=rs.getString(4);
            	}
            String username=rs.getString(6);
            UtenteDao utenteDao=new UtenteDao();
            Utente utente=utenteDao.getByUsername(username);
            String idPost=rs.getString(7);
            PostDao postDao=new PostDao();
            Post post=postDao.getById(idPost);
            if(tipoInterazione.equals("commento"))
            {
            	interazioneReturn=new Commento(idInterazione,data,ora,utente,post,testo);
            }
            else
            {
            	interazioneReturn=new Like(idInterazione,data,ora,utente,post);
            }
           
            
            stmt.close();

            
            return interazioneReturn;

        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
//            System.exit(0);
            return null;
        }
        
	}
	
	
	
	public void updateTestoById(String idInterazione,String nuovoTesto) {
		
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            String query = "UPDATE interazione SET testo = '"+nuovoTesto+"' WHERE \"idInterazione\" LIKE '"+idInterazione+"';";

            stmt.execute(query);
            
            stmt.close();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
        }	
	}
	
	public void deleteById(String idInterazione){
		
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            String query = "DELETE FROM interazione WHERE \"idInterazione\" IN ('"+idInterazione+"');";

            stmt.execute(query);
            
           
            stmt.close();

            


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
        }
		
	}
}
