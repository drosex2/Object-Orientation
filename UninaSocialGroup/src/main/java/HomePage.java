import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton InserisciPostButton = new JButton("Inserisci Post");
		InserisciPostButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		InserisciPostButton.setBounds(136, 29, 160, 25);
		contentPane.add(InserisciPostButton);
		
		JButton CercaGruppoButton = new JButton("Cerca Gruppo");
		CercaGruppoButton.setBounds(136, 78, 160, 25);
		contentPane.add(CercaGruppoButton);
		
		JButton VisualizzaNotificaButton = new JButton("Visualizza Notifica");
		VisualizzaNotificaButton.setBounds(136, 125, 160, 25);
		contentPane.add(VisualizzaNotificaButton);
		
		JButton VisualizzaReportButton = new JButton("Visualizza Report");
		VisualizzaReportButton.setBounds(136, 171, 160, 25);
		contentPane.add(VisualizzaReportButton);
	}

}
