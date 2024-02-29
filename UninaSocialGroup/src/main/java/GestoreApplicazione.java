import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class GestoreApplicazione {
	
	private static Utente utenteConnesso;
	LoginPage loginPage;
	HomePage  homePage;
	InserisciPostPage inserisciPostPage;
	CercaGruppoPage cercaGruppoPage;
	InviaRichiestaDialog inviaRichiestaDialog;
	UtenteDao utenteDao;
	PostDao postDao;
	GruppoDao gruppoDao;
	RichiestaDao richiestaDao;
	
	
	public GestoreApplicazione() {
		loginPage=new LoginPage(this);
		homePage=new HomePage(this);
		inserisciPostPage=new InserisciPostPage(this);
		cercaGruppoPage=new CercaGruppoPage(this);
		inviaRichiestaDialog=new InviaRichiestaDialog(this);
		utenteDao=new UtenteDao();
		postDao=new PostDao();
		gruppoDao=new GruppoDao();
		richiestaDao=new RichiestaDao();
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
	public void inserisciPostClicked() {
		if(utenteConnesso.getGruppiIscrizioni().isEmpty())
		{
			homePage.mostraMessaggioDiErrore("Non sei iscritto a nessun gruppo, non puoi postare nulla","ATTENZIONE!");
		}
		else
		{
			inserisciPostPage.setCbSelezionaGruppo(utenteConnesso.getGruppiIscrizioni());
			homePage.setVisible(false);
			inserisciPostPage.setVisible(true);
			
		}
	}
	public void creaPostClicked(String descrizione, String nomeGruppo) {
		Gruppo gruppoSelezionato = null;
		gruppoSelezionato=gruppoDao.getByNome(nomeGruppo);
		String idPost=String.valueOf(postDao.getUltimoId()+1);
		Post postDaInserire=new Post(idPost,null,descrizione,LocalDate.now(),LocalTime.now(),gruppoSelezionato,utenteConnesso);
		boolean inserito=postDao.save(postDaInserire);
		if(inserito)
		{
			inserisciPostPage.mostraMessaggioDiDialogo("Post inserito con successo!", "Messaggio");
		}
		else
		{
			inserisciPostPage.mostraMessaggioDiDialogo("Errore nell'inserimento!", "ATTENZIONE!");
		}
	}
	
	public void indietroClicked()
	{
		homePage.setVisible(true);
	}
	
	public void cercaGruppoClicked() {
		homePage.setVisible(false);
		cercaGruppoPage.setVisible(true);
		
	}
	public void cercaPerNomeClicked(String descrizione, String nomeGruppo) {
		boolean inserita=inviaRichiesta(descrizione,nomeGruppo);
		if(inserita)
		{
			cercaGruppoPage.mostraMessaggioDiDialogo("Richiesta inserita con successo", "Messaggio");
		}
		else
		{
			cercaGruppoPage.mostraMessaggioDiDialogo("Nessun gruppo trovato oppure Richiesta già inviata", "Errore!");
		}
	}
	public void cercaPerTemaClicked(String descrizione, String temaGruppo) {
		
		LinkedList<Gruppo> gruppi=gruppoDao.getByTag(temaGruppo);
		if(!gruppi.isEmpty())
		{
			inviaRichiestaDialog.setModal(true);
			inviaRichiestaDialog.setCbSelezionaGruppo(gruppi);
			inviaRichiestaDialog.setDescrizione(descrizione);
			inviaRichiestaDialog.setVisible(true);
		}
		else
		{
			cercaGruppoPage.mostraMessaggioDiDialogo("Nessun gruppo trovato per il tema inserito", "Errore!");
		}
		
	}
	public boolean inviaRichiesta(String descrizione, String nomeGruppo)
	{
		Gruppo gruppoRichiesta=gruppoDao.getByNome(nomeGruppo);
		if(gruppoRichiesta!=null)
		{
			String idRichiesta=String.valueOf(richiestaDao.getUltimoId()+1);
			Richiesta richiesta=new Richiesta(idRichiesta,LocalDate.now(),LocalTime.now(),descrizione,false,utenteConnesso,gruppoRichiesta);
			boolean inserito=richiestaDao.save(richiesta);
			if(inserito)
				return true;
			else
				return false;
		}
		else
		{
			
			return false;
		}
	}
}
