import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Controller {
	
	private Utente utenteConnesso;
	private LoginPage loginPage;
	private HomePage  homePage;
	private InserisciPostPage inserisciPostPage;
	private CercaGruppoPage cercaGruppoPage;
	private InviaRichiestaDialog inviaRichiestaDialog;
	private VisualizzaNotificheDialog visualizzaNotificheDialog;
	private GestisciGruppoPage gestisciGruppoPage;
	private RichiesteDialog richiesteDialog;
	private VisualizzaPostDialog visualizzaPostDialog;
	
	UtenteDao utenteDao;
	PostDao postDao;
	GruppoDao gruppoDao;
	RichiestaDao richiestaDao;
	NotificaDao notificaDao;
	
	
	public Controller() {
		loginPage=new LoginPage(this);
		homePage=new HomePage(this);
		inserisciPostPage=new InserisciPostPage(this);
		cercaGruppoPage=new CercaGruppoPage(this);
		inviaRichiestaDialog=new InviaRichiestaDialog(this);
		gestisciGruppoPage=new GestisciGruppoPage(this);
		
		utenteDao=new UtenteDao();
		postDao=new PostDao();
		gruppoDao=new GruppoDao();
		richiestaDao=new RichiestaDao();
		notificaDao=new NotificaDao();
		loginPage.setVisible(true);
	}
	public static void main(String[] args)
	{
		Controller controller=new Controller();

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
			homePage.mostraMessaggioDiDialogo("Non sei iscritto a nessun gruppo, non puoi postare nulla","ATTENZIONE!");
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
			inviaRichiestaDialog.setLocationRelativeTo(cercaGruppoPage);
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
	public void visualizzaNotificheClicked() 
	{
		LinkedList<Notifica> notifiche=notificaDao.getNotificheByUsername(utenteConnesso.getUsername());
		if(notifiche.isEmpty())
		{
			homePage.mostraMessaggioDiDialogo("Non hai nessuna notifica da visualizzare","Errore!");
		}
		else
		{	
			visualizzaNotificheDialog=new VisualizzaNotificheDialog(this,notifiche);
			//visualizzaNotificheDialog.setModal(true);
			//visualizzaNotificheDialog.setNotifiche(notifiche);
			visualizzaNotificheDialog.setLocationRelativeTo(homePage);
			visualizzaNotificheDialog.setVisible(true);
		}
	}
	public void gestisciGruppoClicked() {
		LinkedList<Gruppo> gruppiGestibili=gruppoDao.getByCreatore(utenteConnesso.getUsername());
		gruppiGestibili.addAll(utenteConnesso.getGruppiAmministrati());
		if(gruppiGestibili.isEmpty())
		{
			homePage.mostraMessaggioDiDialogo("Non sei il creatore o amministratore di nessun gruppo!", "Attenzione");
		}
		else
		{
			gestisciGruppoPage.setCbSelezionaGruppo(gruppiGestibili);
			homePage.setVisible(false);
			gestisciGruppoPage.setVisible(true);
		}
		
	}
	public void visualizzaRichiesteClicked(String nomeGruppo) {
		
			Gruppo gruppoSelezionato=gruppoDao.getByNome(nomeGruppo);
			LinkedList<Richiesta> richieste=richiestaDao.getByGruppo(gruppoSelezionato.getIdGruppo());
			if(richieste.isEmpty())
			{
				gestisciGruppoPage.mostraMessaggioDiDialogo("Non hai nessuna richiesta da visualizzare","Errore!");
			}
			else
			{	
				richiesteDialog=new RichiesteDialog(this,richieste);
				richiesteDialog.setLocationRelativeTo(gestisciGruppoPage);
				richiesteDialog.setVisible(true);
			
		}
	}
	public void accettaClicked(Richiesta richiesta) {
		richiestaDao.updateEsitoTrueById(richiesta.getIdRichiesta());
		
	}
	public void rifiutaClicked(Richiesta richiesta) {
		richiestaDao.deleteById(richiesta.getIdRichiesta());
		
	}
	public void visualizzaReportClicked(String nomeGruppo, int anno, int mese, String reportScelto) {
		Gruppo gruppo=gruppoDao.getByNome(nomeGruppo);
		Post postReport = null;
		int numeroInterazioni=0;
		if(reportScelto.equals("Post con più like"))
		{
			postReport=postDao.getPostConPiuLikeMensile(gruppo.getIdGruppo(), anno, mese);
			if(postReport!=null)
				numeroInterazioni=postDao.getNumeroLike(postReport.getIdPost());
			
		}
		if(reportScelto.equals("Post con meno like"))
		{
			postReport=postDao.getPostConMenoLikeMensile(gruppo.getIdGruppo(), anno, mese);
			if(postReport!=null)
				numeroInterazioni=postDao.getNumeroLike(postReport.getIdPost());
		}
		if(reportScelto.equals("Post con più commenti"))
		{
			postReport=postDao.getPostConPiuCommentiMensile(gruppo.getIdGruppo(), anno, mese);
			if(postReport!=null)
				numeroInterazioni=postDao.getNumeroCommenti(postReport.getIdPost());
		}
		if(reportScelto.equals("Post con meno commenti"))
		{
			postReport=postDao.getPostConMenoCommentiMensile(gruppo.getIdGruppo(), anno, mese);
			if(postReport!=null)
				numeroInterazioni=postDao.getNumeroCommenti(postReport.getIdPost());
		}
		if(reportScelto.equals("Numero di contenuti postati"))
		{
			int numeroContenutiPostati=postDao.getNumeroContenutiPostati(gruppo.getIdGruppo(),anno,mese);
			gestisciGruppoPage.mostraMessaggioDiDialogo("Numero di contenuti postati questo mese: "+numeroContenutiPostati, "Report");
		}
		else
		{
			if(postReport==null)
			{
				gestisciGruppoPage.mostraMessaggioDiDialogo("Nessun post disponibile","Errore!");
			}
			else
			{
				visualizzaPostDialog=new VisualizzaPostDialog(this,postReport,numeroInterazioni);
				visualizzaPostDialog.setLocationRelativeTo(gestisciGruppoPage);
				visualizzaPostDialog.setVisible(true);
					
			}
		}
		
	}
}
