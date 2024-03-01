import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RichiesteDialog extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private JButton btnAccetta;
//	private JButton btnRifiuta;
	private LinkedList<Richiesta> richieste;
    private GestoreApplicazione controller;

    public RichiesteDialog(GestoreApplicazione gestore,LinkedList<Richiesta> richieste) {
       
    	this.controller=gestore;
        this.richieste=richieste;
        setTitle("Richieste di accesso");
        getContentPane().setBackground(new Color(115, 209, 255));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(550, 80*richieste.size());
        setResizable(false);
        setModal(true);
        
        

        // Pannello principale con BoxLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(115, 209, 255));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(mainPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Aggiunta delle richieste al pannello
        for (final Richiesta richiesta : richieste) {
            JPanel pannelloRichiesta = new JPanel();
            pannelloRichiesta.setLayout(new GridLayout());
            pannelloRichiesta.setBackground(new Color(115, 209, 255));
            JLabel lblUsername = new JLabel(richiesta.getUtenteRichiedente().getUsername());
            lblUsername.setFont(new Font("Tahoma",Font.PLAIN,16));
            lblUsername.setForeground(new Color(255,255,255));
            JLabel lblTesto=new JLabel(richiesta.getTesto());
            lblTesto.setFont(new Font("Tahoma",Font.PLAIN,16));
            lblTesto.setForeground(new Color(255,255,255));
            final JButton btnAccetta = new JButton("Accetta");
            final JButton btnRifiuta = new JButton("Rifiuta");
            
            JPanel acceptPanel = new JPanel();
            acceptPanel.setSize(20, 20);
            acceptPanel.add(btnAccetta);
            acceptPanel.setBackground(new Color(115, 209, 255));
            
            
            JPanel rejectPanel = new JPanel(); // Usa FlowLayout per default
            rejectPanel.add(btnRifiuta);
            rejectPanel.setSize(20, 20);
            rejectPanel.setBackground(new Color(115, 209, 255));
            btnAccetta.setFont(new Font("Tahoma", Font.BOLD, 16));

            
            btnAccetta.setForeground(new Color(255, 255, 255));
            btnAccetta.setBackground(new Color(44, 145, 52));

           

            // Rimuove il bordo attorno al testo quando il pulsante è in focus
            btnAccetta.setFocusPainted(false);

            // Cambia il cursore in una mano quando è sopra il pulsante
            btnAccetta.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            btnRifiuta.setFont(new Font("Tahoma", Font.BOLD, 16));

            // Impostazioni di colore
            btnRifiuta.setForeground(new Color(255, 255, 255));
            btnRifiuta.setBackground(new Color(158, 46, 46));

            

            // Rimuove il bordo attorno al testo quando il pulsante è in focus
            btnRifiuta.setFocusPainted(false);

            // Cambia il cursore in una mano quando è sopra il pulsante
            btnRifiuta.setCursor(new Cursor(Cursor.HAND_CURSOR));
            // Aggiunta di azioni ai pulsanti
            btnAccetta.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	btnAccetta.setEnabled(false);
                	btnRifiuta.setEnabled(false);
                    controller.accettaClicked(richiesta);
                }
            });
            btnRifiuta.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	btnAccetta.setEnabled(false);
                	btnRifiuta.setEnabled(false);
                	controller.rifiutaClicked(richiesta);
                }
            });

            pannelloRichiesta.add(lblUsername);         
            pannelloRichiesta.add(lblTesto); 
            pannelloRichiesta.add(acceptPanel);
            pannelloRichiesta.add(rejectPanel);

            mainPanel.add(pannelloRichiesta);
            
        }

        // Aggiunta del pannello principale al frame
        getContentPane().add(scrollPane);

        
    }

    
    
}
