import javax.swing.*;
import java.awt.*;
import java.util.*;


public class VisualizzaNotificheDialog extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea notificationTextArea;
    private LinkedList<Notifica> notifiche;
    private Controller controller;
    

    public VisualizzaNotificheDialog(Controller gestore,LinkedList<Notifica> notifiche) {
        //super("Visualizza le tue notifiche");
    	controller=gestore;
    	this.notifiche=notifiche;
        setBackground(new Color(0, 255, 255));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(400, 300);
        setModal(true);
        

        

        // Utilizzo di BorderLayout per il pannello principale
        getContentPane().setLayout(new BorderLayout());

        // Creazione dell'area di testo per le notifiche con ScrollPane
        notificationTextArea = new JTextArea();
        notificationTextArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
        notificationTextArea.setForeground(new Color(255,255,255));
        notificationTextArea.setBackground(new Color(115, 209, 255));
        notificationTextArea.setEditable(false);
        notificationTextArea.setLineWrap(true);
        notificationTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(notificationTextArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Aggiunta delle notifiche all'area di testo
        for (Notifica notifica : notifiche) {
        	if(notifica.getInterazioneGenerante()!=null)
        	{
        		if(notifica.getInterazioneGenerante().getClass()==Like.class)
        			notificationTextArea.append(notifica.getInterazioneGenerante().getUtente().getUsername()+" ha messo like al tuo post!" + "\n");
        		else
        			notificationTextArea.append(notifica.getInterazioneGenerante().getUtente().getUsername()+" ha commentato il tuo post: " +notifica.getInterazioneGenerante().getTesto()+ "\n");
        	}
        	else if(notifica.getPostGenerante()!=null)
        	{
        		notificationTextArea.append(notifica.getPostGenerante().getUtenteAutore().getUsername()+" ha aggiunto un post nel gruppo: "+notifica.getPostGenerante().getGruppo().getNome()+"\n");
        	}
        	else
        	{
        		notificationTextArea.append("Un utente si è unito al tuo gruppo"+"\n");
        	}
        	
        }

        // Aggiunta dello scroll pane al frame
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        
    }

    public void setNotifiche(LinkedList<Notifica> notifiche)
    {
    	this.notifiche=notifiche;
    }
}
