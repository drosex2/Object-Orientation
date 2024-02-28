import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class GestoreApplicazione {
	
	private static Utente utenteConnesso;
	LoginPage loginPage;
	HomePage  homePage;
	UtenteDao utenteDao;
	public GestoreApplicazione() {
		loginPage=new LoginPage(this);
		homePage=new HomePage(this);
		utenteDao=new UtenteDao();
		loginPage.setVisible(true);
	}
	public static void main(String[] args)
	{
		GestoreApplicazione controller=new GestoreApplicazione();
//		UtenteDao utenteDao=new UtenteDao();
//		utenteConnesso=utenteDao.getLogin("MarySmith","pw0003");
//		//System.out.println(utenteConnesso);
//		
//		for(Gruppo g:utenteConnesso.getGruppiAmministrati())
//		{
//			System.out.println(g);
//		}
//		GruppoDao gruppoDao=new GruppoDao();
//		gruppoDao.updateNameById("g3", "Sviluppatori");
//		gruppoDao.updateTagById("g3", "DevTeam");
//		LinkedList<Gruppo> gruppi=gruppoDao.getByTag("DevTeam");
//		for(Gruppo g:gruppi)
//		{
//			System.out.println(g);
//		}
//		Gruppo nuovoGruppo=new Gruppo("g5","Premier League","calcio",LocalDate.now(),utenteConnesso);
//		Gruppo gruppo=gruppoDao.getById("g1");
//		PostDao postDao=new PostDao();
//		Post post2=postDao.getById("3");
//		InterazioneDao interazioneDao=new InterazioneDao();
//		Interazione interazione;//=new Like("4",LocalDate.now(),LocalTime.now(),utenteConnesso,post2);
//		//interazioneDao.updateTestoById("1", "Brutto post, non mi è piaciuto");
//		NotificaDao notificaDao=new NotificaDao();
//		LinkedList<Notifica> notifiche=notificaDao.getNotificheByUsername(utenteConnesso.getUsername());
//		for(Notifica n:notifiche)
//		{
//			System.out.println(n);
//		}
//		
//		//interazioneDao.deleteById("9");
//		//		Post postPiuLike=postDao.getPostConPiuCommentiMensile(gruppo.getIdGruppo(), 2023, 12);
//		System.out.println(postPiuLike);
//		postDao.save(new Post("p6","null","che gol!",LocalDate.now(),LocalTime.now(),gruppo,utenteConnesso));
//		RichiestaDao richiestaDao=new RichiestaDao();
//		Richiesta richiesta=richiestaDao.getById("r1");
//		System.out.println(richiesta);
//		LinkedList<Richiesta> richieste=richiestaDao.getByGruppo( gruppo.getIdGruppo());
//		for(Richiesta r:richieste)
//		{
//			System.out.println(r);
//		}
//		Interazione commento=new Commento(null, null, null, utenteConnesso, null, null);
//		if(commento.getClass()==Commento.class)
//		{
//			System.out.println("è un commento");
//		}
//		Interazione like=new Like(null, null, null, utenteConnesso, null);
//		if(like.getClass()==Like.class)
//		{
//			System.out.println("è un like");
//		}
	}
	public boolean controllaLogin(String username, String password) {
		
		utenteConnesso=utenteDao.getLogin(username, password);
		
		if(utenteConnesso!=null) {
			loginPage.setVisible(false);
			homePage.setVisible(true);
			return true;
			
		}
		else
			return false;
		
		
	}
	public void effettuaLogout()
	{
		utenteConnesso=null;
		homePage.setVisible(false);
		loginPage.setVisible(true);
	}

}
