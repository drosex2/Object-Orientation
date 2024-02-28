
import java.sql.*;
import java.sql.Date;
import java.time.*;

public class PostDao {
	private Connection conn = null;
	
	public PostDao(){
		
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
	
	
	
	public void save(Post postDaSalvare)
	{
		String idPost=postDaSalvare.getIdPost();
		String foto=postDaSalvare.getFoto();
		String testo=postDaSalvare.getTesto();
		Date dataPubblicazione= Date.valueOf(postDaSalvare.getDataPubblicazione());
		Time oraPubblicazione=Time.valueOf(postDaSalvare.getOraPubblicazione());
		String idGruppo=postDaSalvare.getGruppo().getIdGruppo();
		String usernameAutore=postDaSalvare.getUtenteAutore().getUsername();
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            String query = "INSERT INTO post VALUES ('"+idPost+"','"+foto+"','"+testo+"','"+dataPubblicazione+"','"+oraPubblicazione+"','"+idGruppo+"','"+usernameAutore+"');";

            stmt.execute(query);
            
            stmt.close();

            


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
        }
	}
	public Post getById(String idPost)
	{
		Post postReturn;
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement("Select * from post where \"idPost\" LIKE '"+idPost+"';");
            

            ResultSet rs = ps_queryforname.executeQuery();
            rs.next();
            
            String idPostReturn=rs.getString(1);
            String fotoReturn=rs.getString(2);
            String testoReturn=rs.getString(3);
            LocalDate dataPubblicazioneReturn = rs.getDate(4).toLocalDate();
            LocalTime oraPubblicazioneReturn=rs.getTime(5).toLocalTime();
            String idGruppoReturn=rs.getString(6);
            String usernameAutoreReturn =rs.getString(7);
            GruppoDao gruppoDao=new GruppoDao();
            Gruppo gruppoReturn=gruppoDao.getById(idGruppoReturn);
            UtenteDao utenteDao=new UtenteDao();
            Utente utenteAutoreReturn=utenteDao.getByUsername(usernameAutoreReturn);
            
            
            postReturn=new Post(idPostReturn,fotoReturn,testoReturn,dataPubblicazioneReturn,oraPubblicazioneReturn,gruppoReturn,utenteAutoreReturn);
            
            stmt.close();

            
            return postReturn;

        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
//            System.exit(0);
            return null;
        }
        
	}
	public Post getPostConPiuLikeMensile(String idGruppo,int year,int month)
	{
		Post postReturn;
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement(
            		"Select post.*,count(*) as num_like\r\n"
            		+ "From post inner join interazione on post.\"idPost\"=interazione.\"idPost\"\r\n"
            		+ "Where post.\"idGruppo\" like '"+idGruppo+"' AND EXTRACT(YEAR FROM post.\"dataPubblicazione\")="+year+"\r\n"
            		+ "	AND EXTRACT(MONTH FROM post.\"dataPubblicazione\")="+month+" AND interazione.\"tipoInterazione\" LIKE 'like'\r\n"
            		+ "Group by post.\"idPost\"\r\n"
            		+ "Order by num_like Desc;");
            

            ResultSet rs = ps_queryforname.executeQuery();
            rs.next();
            String idPostReturn=rs.getString(1);
            String fotoReturn=rs.getString(2);
            String testoReturn=rs.getString(3);
            LocalDate dataPubblicazioneReturn = rs.getDate(4).toLocalDate();
            LocalTime oraPubblicazioneReturn=rs.getTime(5).toLocalTime();
            String idGruppoReturn=rs.getString(6);
            String usernameAutoreReturn =rs.getString(7);
            GruppoDao gruppoDao=new GruppoDao();
            Gruppo gruppoReturn=gruppoDao.getById(idGruppoReturn);
            UtenteDao utenteDao=new UtenteDao();
            Utente utenteAutoreReturn=utenteDao.getByUsername(usernameAutoreReturn);
            
            
            postReturn=new Post(idPostReturn,fotoReturn,testoReturn,dataPubblicazioneReturn,oraPubblicazioneReturn,gruppoReturn,utenteAutoreReturn);
            
            stmt.close();

            
            return postReturn;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
            return null;
        }
        
	}
	public Post getPostConMenoLikeMensile(String idGruppo,int year,int month)
	{
		Post postReturn;
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement(
            		"Select post.*,count(*) as num_like\r\n"
            		+ "From post inner join interazione on post.\"idPost\"=interazione.\"idPost\"\r\n"
            		+ "Where post.\"idGruppo\" like '"+idGruppo+"' AND EXTRACT(YEAR FROM post.\"dataPubblicazione\")="+year+"\r\n"
            		+ "	AND EXTRACT(MONTH FROM post.\"dataPubblicazione\")="+month+" AND interazione.\"tipoInterazione\" LIKE 'like'\r\n"
            		+ "Group by post.\"idPost\"\r\n"
            		+ "Order by num_like Asc;");
            

            ResultSet rs = ps_queryforname.executeQuery();
            rs.next();
            String idPostReturn=rs.getString(1);
            String fotoReturn=rs.getString(2);
            String testoReturn=rs.getString(3);
            LocalDate dataPubblicazioneReturn = rs.getDate(4).toLocalDate();
            LocalTime oraPubblicazioneReturn=rs.getTime(5).toLocalTime();
            String idGruppoReturn=rs.getString(6);
            String usernameAutoreReturn =rs.getString(7);
            GruppoDao gruppoDao=new GruppoDao();
            Gruppo gruppoReturn=gruppoDao.getById(idGruppoReturn);
            UtenteDao utenteDao=new UtenteDao();
            Utente utenteAutoreReturn=utenteDao.getByUsername(usernameAutoreReturn);
            
            
            postReturn=new Post(idPostReturn,fotoReturn,testoReturn,dataPubblicazioneReturn,oraPubblicazioneReturn,gruppoReturn,utenteAutoreReturn);
            
            stmt.close();

            
            return postReturn;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
            return null;
        }
        
	}
	public Post getPostConPiuCommentiMensile(String idGruppo,int year,int month)
	{
		Post postReturn;
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement(
            		"Select post.*,count(*) as num_like\r\n"
            		+ "From post inner join interazione on post.\"idPost\"=interazione.\"idPost\"\r\n"
            		+ "Where post.\"idGruppo\" like '"+idGruppo+"' AND EXTRACT(YEAR FROM post.\"dataPubblicazione\")="+year+"\r\n"
            		+ "	AND EXTRACT(MONTH FROM post.\"dataPubblicazione\")="+month+" AND interazione.\"tipoInterazione\" LIKE 'commento'\r\n"
            		+ "Group by post.\"idPost\"\r\n"
            		+ "Order by num_like Desc;");
            

            ResultSet rs = ps_queryforname.executeQuery();
            rs.next();
            String idPostReturn=rs.getString(1);
            String fotoReturn=rs.getString(2);
            String testoReturn=rs.getString(3);
            LocalDate dataPubblicazioneReturn = rs.getDate(4).toLocalDate();
            LocalTime oraPubblicazioneReturn=rs.getTime(5).toLocalTime();
            String idGruppoReturn=rs.getString(6);
            String usernameAutoreReturn =rs.getString(7);
            GruppoDao gruppoDao=new GruppoDao();
            Gruppo gruppoReturn=gruppoDao.getById(idGruppoReturn);
            UtenteDao utenteDao=new UtenteDao();
            Utente utenteAutoreReturn=utenteDao.getByUsername(usernameAutoreReturn);
            
            
            postReturn=new Post(idPostReturn,fotoReturn,testoReturn,dataPubblicazioneReturn,oraPubblicazioneReturn,gruppoReturn,utenteAutoreReturn);
            
            stmt.close();

            
            return postReturn;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
            return null;
        }
        
	}
	public Post getPostConMenoCommentiMensile(String idGruppo,int year,int month)
	{
		Post postReturn;
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement(
            		"Select post.*,count(*) as num_like\r\n"
            		+ "From post inner join interazione on post.\"idPost\"=interazione.\"idPost\"\r\n"
            		+ "Where post.\"idGruppo\" like '"+idGruppo+"' AND EXTRACT(YEAR FROM post.\"dataPubblicazione\")="+year+"\r\n"
            		+ "	AND EXTRACT(MONTH FROM post.\"dataPubblicazione\")="+month+" AND interazione.\"tipoInterazione\" LIKE 'commento'\r\n"
            		+ "Group by post.\"idPost\"\r\n"
            		+ "Order by num_like Asc;");
            

            ResultSet rs = ps_queryforname.executeQuery();
            rs.next();
            String idPostReturn=rs.getString(1);
            String fotoReturn=rs.getString(2);
            String testoReturn=rs.getString(3);
            LocalDate dataPubblicazioneReturn = rs.getDate(4).toLocalDate();
            LocalTime oraPubblicazioneReturn=rs.getTime(5).toLocalTime();
            String idGruppoReturn=rs.getString(6);
            String usernameAutoreReturn =rs.getString(7);
            GruppoDao gruppoDao=new GruppoDao();
            Gruppo gruppoReturn=gruppoDao.getById(idGruppoReturn);
            UtenteDao utenteDao=new UtenteDao();
            Utente utenteAutoreReturn=utenteDao.getByUsername(usernameAutoreReturn);
            
            
            postReturn=new Post(idPostReturn,fotoReturn,testoReturn,dataPubblicazioneReturn,oraPubblicazioneReturn,gruppoReturn,utenteAutoreReturn);
            
            stmt.close();

            
            return postReturn;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
            return null;
        }
        
	}
	public void updateTestoById(String idPost,String nuovoTesto) {
		
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            String query = "UPDATE post SET nome = '"+nuovoTesto+"' WHERE \"idGruppo\" LIKE '"+idPost+"';";

            stmt.execute(query);
            
            stmt.close();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
        }	
	}

	public void deleteById(String idPost){
		
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            String query = "DELETE FROM post WHERE \"idPost\" IN ('"+idPost+"');";

            stmt.execute(query);
            
           
            stmt.close();

            


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
            System.exit(0);
        }
		
	}
}
