import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class GruppoDao {
	private Connection conn = null;
	
	public GruppoDao(){
		
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
	
	
	
	public void save(Gruppo gruppo)
	{
		String idGruppo=gruppo.getIdGruppo();
		String nome=gruppo.getNome();
		String tag=gruppo.getTag();
		Date dataCreazione= Date.valueOf(gruppo.getDataCreazione());
		String usernameCreatore=gruppo.getUtenteCreatore().getUsername();
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            String query = "INSERT INTO Gruppo VALUES ('"+idGruppo+"','"+nome+"','"+tag+"','"+dataCreazione+"','"+usernameCreatore+"');";

            stmt.execute(query);
            
            stmt.close();

            


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
        }
	}
	public Gruppo getById(String idGruppo)
	{
		Gruppo gruppoReturn;
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement("Select * from Gruppo where \"idGruppo\" LIKE '"+idGruppo+"';");
            

            ResultSet rs = ps_queryforname.executeQuery();
            rs.next();
            String idGruppoReturn=rs.getString(1);
            String nomeReturn=rs.getString(2);
            String tagReturn=rs.getString(3);
            LocalDate dataCreazioneReturn = rs.getDate(4).toLocalDate();
            String usernameCreatoreReturn =rs.getString(5);
            UtenteDao utenteDao=new UtenteDao();
            Utente utenteCreatoreReturn=utenteDao.getByUsername(usernameCreatoreReturn);
            
            
            gruppoReturn=new Gruppo(idGruppoReturn,nomeReturn,tagReturn,dataCreazioneReturn,utenteCreatoreReturn);
            
            stmt.close();

            
            return gruppoReturn;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
            return null;
        }
        
	}
	public Gruppo getByNome(String nomeGruppo)
	{
		Gruppo gruppoReturn;
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement("Select * from Gruppo where nome LIKE '"+nomeGruppo+"';");
            

            ResultSet rs = ps_queryforname.executeQuery();
            rs.next();
            String idGruppoReturn=rs.getString(1);
            String nomeReturn=rs.getString(2);
            String tagReturn=rs.getString(3);
            LocalDate dataCreazioneReturn = rs.getDate(4).toLocalDate();
            String usernameCreatoreReturn =rs.getString(5);
            UtenteDao utenteDao=new UtenteDao();
            Utente utenteCreatoreReturn=utenteDao.getByUsername(usernameCreatoreReturn);
            
            
            gruppoReturn=new Gruppo(idGruppoReturn,nomeReturn,tagReturn,dataCreazioneReturn,utenteCreatoreReturn);
            
            stmt.close();

            
            return gruppoReturn;

        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
//            System.exit(0);
            return null;
        }
        
	}
	public LinkedList<Gruppo> getByTag(String tagGruppo)
	{
		LinkedList<Gruppo> gruppiReturn=new LinkedList<Gruppo>();
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement("Select * from Gruppo where tag LIKE '"+tagGruppo+"';");
            

            ResultSet rs = ps_queryforname.executeQuery();
            while(rs.next())
            {
	            String idGruppoReturn=rs.getString(1);
	            String nomeReturn=rs.getString(2);
	            String tagReturn=rs.getString(3);
	            LocalDate dataCreazioneReturn = rs.getDate(4).toLocalDate();
	            String usernameCreatoreReturn =rs.getString(5);
	            UtenteDao utenteDao=new UtenteDao();
	            Utente utenteCreatoreReturn=utenteDao.getByUsername(usernameCreatoreReturn);
	            
	            
	            Gruppo gruppoReturn=new Gruppo(idGruppoReturn,nomeReturn,tagReturn,dataCreazioneReturn,utenteCreatoreReturn);
	            gruppiReturn.add(gruppoReturn);
            }
            stmt.close();

            
            return gruppiReturn;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
            return null;
        }
        
	}
	
	public void updateNameById(String idGruppo,String nuovoNome) {
		
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            String query = "UPDATE gruppo SET nome = '"+nuovoNome+"' WHERE \"idGruppo\" LIKE '"+idGruppo+"';";

            stmt.execute(query);
            
            stmt.close();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
        }	
	}
public void updateTagById(String idGruppo,String nuovoTag) {
		
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            String query = "UPDATE gruppo SET tag = '"+nuovoTag+"' WHERE \"idGruppo\" LIKE '"+idGruppo+"';";

            stmt.execute(query);
            
            stmt.close();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
        }	
	}
	public void deleteById(String idGruppo){
		
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            String query = "DELETE FROM gruppo WHERE \"idGruppo\" IN ('"+idGruppo+"');";

            stmt.execute(query);
            
           
            stmt.close();

            


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
        }
		
	}
}
