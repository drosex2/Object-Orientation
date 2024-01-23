import java.sql.*;
import java.sql.Date;
import java.time.*;
import java.util.*;

public class RichiestaDao {
	private Connection conn = null;
	
	public RichiestaDao(){
		
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
	
	
	
	public void save(Richiesta richiesta)
	{
		String idRichiesta=richiesta.getIdRichiesta();
		Date dataRichiesta=Date.valueOf(richiesta.getDataRichiesta());
		Time oraRichiesta=Time.valueOf(richiesta.getOraRichiesta());
		String testo=richiesta.getTesto();
		Boolean esito=false;
		String username=richiesta.getUtenteRichiedente().getUsername();
		String idGruppo=richiesta.getGruppo().getIdGruppo();
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            String query = "INSERT INTO richiesta VALUES ('"+idRichiesta+"','"+dataRichiesta+"','"+oraRichiesta+"','"+testo+"','"+esito+"','"+username+"','"+idGruppo+"');";

            stmt.execute(query);
            
            stmt.close();

            


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
        }
	}
	public Richiesta getById(String idRichiesta)
	{
		Richiesta richiestaReturn;
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement("Select * from richiesta where \"idRichiesta\" LIKE '"+idRichiesta+"' AND esito=false;");
            

            ResultSet rs = ps_queryforname.executeQuery();
            rs.next();
            String idRichiestaReturn=rs.getString(1);
            LocalDate dataRichiesta=rs.getDate(2).toLocalDate();
            LocalTime oraRichiesta=rs.getTime(3).toLocalTime();           
            String testo = rs.getString(4);
            Boolean esito=rs.getBoolean(5);
            String usernameReturn =rs.getString(6);
            UtenteDao utenteDao=new UtenteDao();
            Utente utenteReturn=utenteDao.getByUsername(usernameReturn);
            String idGruppo=rs.getString(7);
            GruppoDao gruppoDao=new GruppoDao();
            Gruppo gruppoReturn=gruppoDao.getById(idGruppo);
            
            richiestaReturn=new Richiesta(idRichiestaReturn,dataRichiesta,oraRichiesta,testo,esito,utenteReturn,gruppoReturn);
            
            
            
            
            stmt.close();

            
            return richiestaReturn;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
            return null;
        }
        
	}
	
	public LinkedList<Richiesta> getByGruppo(String idGruppo)
	{
		LinkedList<Richiesta> richiesteReturn=new LinkedList<Richiesta>();
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement("Select * from richiesta where  \"idGruppo\" LIKE '"+idGruppo+"' AND esito=false;");
            

            ResultSet rs = ps_queryforname.executeQuery();
            while(rs.next())
            {
            	String idRichiestaReturn=rs.getString(1);
                LocalDate dataRichiesta=rs.getDate(2).toLocalDate();
                LocalTime oraRichiesta=rs.getTime(3).toLocalTime();           
                String testo = rs.getString(4);
                Boolean esito=rs.getBoolean(5);
                String usernameReturn =rs.getString(6);
                UtenteDao utenteDao=new UtenteDao();
                Utente utenteReturn=utenteDao.getByUsername(usernameReturn);
                //String idGruppo=rs.getString(7);
                GruppoDao gruppoDao=new GruppoDao();
                Gruppo gruppoReturn=gruppoDao.getById(idGruppo);
                
                Richiesta richiestaReturn=new Richiesta(idRichiestaReturn,dataRichiesta,oraRichiesta,testo,esito,utenteReturn,gruppoReturn);
                richiesteReturn.add(richiestaReturn);
            }
            stmt.close();

            
            return richiesteReturn;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
            return null;
        }
        
	}
	
	public void updateEsitoTrueById(String idRichiesta) {
		
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            String query = "UPDATE richiesta SET nome = true WHERE \"idRichiesta\" LIKE '"+idRichiesta+"';";

            stmt.execute(query);
            
            stmt.close();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
        }	
	}

	public void deleteById(String idRichiesta){
		
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            String query = "DELETE FROM richiesta WHERE \"idRichiesta\" IN ('"+idRichiesta+"');";

            stmt.execute(query);
            
           
            stmt.close();

            


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
        }
		
	}
}
