import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

public class NotificaDao {
	private Connection conn = null;
	
	public NotificaDao(){
		
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
	
	
	
	public void save(Notifica notifica)
	{
		String idNotifica=notifica.getIdNotifica();
		Date data=Date.valueOf(notifica.getData());
		Time ora=Time.valueOf(notifica.getOra());
		String utente=notifica.getUtente().getUsername();
		String idPost=notifica.getPostGenerante().getIdPost();
		String idInterazione=notifica.getInterazioneGenerante().getIdInterazione();
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            String query = "INSERT INTO Notifica VALUES ('"+idNotifica+"','"+data+"','"+ora+"','"+utente+"','"+idPost+"','"+idInterazione+"');";

            stmt.execute(query);
            
            stmt.close();

            


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
        }
	}
	public Notifica getById(String idNotifica)
	{
		Notifica notificaReturn;
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement("Select * from Notifica where \"idNotifica\" LIKE '"+idNotifica+"';");
            

            ResultSet rs = ps_queryforname.executeQuery();
            rs.next();
            String idReturn=rs.getString(1);
            LocalDate data=rs.getDate(2).toLocalDate();
            LocalTime ora=rs.getTime(3).toLocalTime();
            
            String usernameUtente =rs.getString(4);
            UtenteDao utenteDao=new UtenteDao();
            Utente utenteReturn=utenteDao.getByUsername(usernameUtente);
            
            String idPost=rs.getString(5);
            PostDao postDao=new PostDao();
            Post postReturn=postDao.getById(idPost);
            
            String idInterazione=rs.getString(6);
            InterazioneDao interazioneDao=new InterazioneDao();
            Interazione interazione=interazioneDao.getById(idInterazione);
            
            
            notificaReturn=new Notifica(idReturn,data,ora,utenteReturn,postReturn,interazione);
            
            stmt.close();

            
            return notificaReturn;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
            return null;
        }
        
	}
	public LinkedList<Notifica> getNotificheByUsername(String username)
	{
		LinkedList<Notifica> notificheReturn=new LinkedList<Notifica>();
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement("Select * from notifica where username LIKE '"+username+"';");
            

            ResultSet rs = ps_queryforname.executeQuery();
            while(rs.next())
            {
            	String idReturn=rs.getString(1);
                LocalDate data=rs.getDate(2).toLocalDate();
                LocalTime ora=rs.getTime(3).toLocalTime();
                
                String usernameUtente =rs.getString(4);
                UtenteDao utenteDao=new UtenteDao();
                Utente utenteReturn=utenteDao.getByUsername(usernameUtente);
                
                String idPost=rs.getString(5);
                PostDao postDao=new PostDao();
                Post postReturn=postDao.getById(idPost);
                
                String idInterazione=rs.getString(6);
                InterazioneDao interazioneDao=new InterazioneDao();
                Interazione interazione=interazioneDao.getById(idInterazione);
                
                
                Notifica notificaReturn=new Notifica(idReturn,data,ora,utenteReturn,postReturn,interazione);
	            
	            
	            
	            notificheReturn.add(notificaReturn);
            }
            stmt.close();

            
            return notificheReturn;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
            return null;
        }
        
	}
	
	
	public void deleteById(String idNotifica){
		
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            String query = "DELETE FROM notifica WHERE \"idNotifica\" IN ('"+idNotifica+"');";

            stmt.execute(query);
            
           
            stmt.close();

            


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
        }
		
	}
}

	

