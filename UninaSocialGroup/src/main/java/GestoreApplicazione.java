import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class GestoreApplicazione {
	
	private static Utente utenteConnesso;
	public static void main(String[] args)
	{
		UtenteDao utenteDao=new UtenteDao();
		utenteConnesso=utenteDao.getByUsername("sjobs");
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
//		Post postPiuLike=postDao.getPostConPiuCommentiMensile(gruppo.getIdGruppo(), 2023, 12);
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
	}
}
