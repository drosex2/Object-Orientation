
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
	
	
	
	public boolean save(Post postDaSalvare)
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

            return true;


        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
//            System.exit(0);
        	return false;
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
	public int getUltimoId()
	{
		int idReturn;
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement("Select max(\"idPost\"::INTEGER) from post;");
            

            ResultSet rs = ps_queryforname.executeQuery();
            rs.next();
            idReturn=Integer.valueOf(rs.getString(1));
            
            
            
            
            
            stmt.close();

            
            return idReturn;

        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            System.err.println( throwables.getClass().getName()+": "+ throwables.getMessage() );
//            System.exit(0);
            return 0;
        }
        
	}
	public Post getPostConPiuLikeMensile(String idGruppo,int anno,int mese)
	{
		Post postReturn;
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement(
            		"Select post.*,count(*) as num_like\r\n"
            		+ "From post inner join interazione on post.\"idPost\"=interazione.\"idPost\"\r\n"
            		+ "Where post.\"idGruppo\" like '"+idGruppo+"' AND EXTRACT(YEAR FROM post.\"dataPubblicazione\")="+anno+"\r\n"
            		+ "	AND EXTRACT(MONTH FROM post.\"dataPubblicazione\")="+mese+" AND interazione.\"tipoInterazione\" LIKE 'like'\r\n"
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
           
            return null;
        }
        
	}
	public Post getPostConMenoLikeMensile(String idGruppo,int anno,int mese)
	{
		Post postReturn;
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement(
            		"Select post.*,count(*) as num_like\r\n"
            		+ "From post inner join interazione on post.\"idPost\"=interazione.\"idPost\"\r\n"
            		+ "Where post.\"idGruppo\" like '"+idGruppo+"' AND EXTRACT(YEAR FROM post.\"dataPubblicazione\")="+anno+"\r\n"
            		+ "	AND EXTRACT(MONTH FROM post.\"dataPubblicazione\")="+mese+" AND interazione.\"tipoInterazione\" LIKE 'like'\r\n"
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
            
            return null;
        }
        
	}
	public Post getPostConPiuCommentiMensile(String idGruppo,int anno,int mese)
	{
		Post postReturn;
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement(
            		"Select post.*,count(*) as num_like\r\n"
            		+ "From post inner join interazione on post.\"idPost\"=interazione.\"idPost\"\r\n"
            		+ "Where post.\"idGruppo\" like '"+idGruppo+"' AND EXTRACT(YEAR FROM post.\"dataPubblicazione\")="+anno+"\r\n"
            		+ "	AND EXTRACT(MONTH FROM post.\"dataPubblicazione\")="+mese+" AND interazione.\"tipoInterazione\" LIKE 'commento'\r\n"
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
            
            return null;
        }
        
	}
	public Post getPostConMenoCommentiMensile(String idGruppo,int anno,int mese)
	{
		Post postReturn;
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement(
            		"Select post.*,count(*) as num_like\r\n"
            		+ "From post inner join interazione on post.\"idPost\"=interazione.\"idPost\"\r\n"
            		+ "Where post.\"idGruppo\" like '"+idGruppo+"' AND EXTRACT(YEAR FROM post.\"dataPubblicazione\")="+anno+"\r\n"
            		+ "	AND EXTRACT(MONTH FROM post.\"dataPubblicazione\")="+mese+" AND interazione.\"tipoInterazione\" LIKE 'commento'\r\n"
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
            
            return null;
        }
        
	}
	public int getNumeroLike(String idPost)
	{
		int numLikeReturn;
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement(
            		"Select count(*) from interazione inner join post on post.\"idPost\"=interazione.\"idPost\""+
            		"where post.\"idPost\"='"+idPost+"' AND interazione.\"tipoInterazione\"='like';");
            		
            
            ResultSet rs = ps_queryforname.executeQuery();
            rs.next();
            numLikeReturn=rs.getInt(1);

            stmt.close();

            
            return numLikeReturn;

        } catch (SQLException throwables) {
        	
            return 0;
        }
	}
	public int getNumeroCommenti(String idPost)
	{
		int numLikeReturn;
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement(
            		"Select count(*) from interazione inner join post on post.\"idPost\"=interazione.\"idPost\""+
            		"where post.\"idPost\"='"+idPost+"' AND interazione.\"tipoInterazione\"='commento';");
            		
            
            ResultSet rs = ps_queryforname.executeQuery();
            rs.next();
            numLikeReturn=rs.getInt(1);

            stmt.close();

            
            return numLikeReturn;

        } catch (SQLException throwables) {
        	
            return 0;
        }
	}
	public int getNumeroContenutiPostati(String idGruppo, int anno, int mese) {
		int numeroContenutiReturn;
	    Statement stmt = null;
        try {

            // crea uno statement semplice
            stmt = this.conn.createStatement();

            PreparedStatement ps_queryforname = conn.prepareStatement("select count(*)\r\n from post where post.\"idGruppo\"='"+idGruppo+"' AND extract(year from post.\"dataPubblicazione\")="+anno+" AND extract(month from post.\"dataPubblicazione\")="+mese+";");
            		
            
            ResultSet rs = ps_queryforname.executeQuery();
            rs.next();
            numeroContenutiReturn=rs.getInt(1);

            stmt.close();

            
            return numeroContenutiReturn;

        } catch (SQLException throwables) {
        	
            return 0;
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
