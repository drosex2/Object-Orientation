import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CercaGruppo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField InserisciNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CercaGruppo frame = new CercaGruppo();
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
	public CercaGruppo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton InviaRichiestaButton = new JButton("invia richiesta");
		InviaRichiestaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		InviaRichiestaButton.setBounds(170, 182, 100, 25);
		contentPane.add(InviaRichiestaButton);
		
		JLabel NomeGruppo = new JLabel("Nome gruppo:");
		NomeGruppo.setBounds(70, 51, 80, 25);
		contentPane.add(NomeGruppo);
		
		InserisciNome = new JTextField();
		InserisciNome.setText("inserisci testo...");
		InserisciNome.setBounds(160, 51, 210, 25);
		contentPane.add(InserisciNome);
		InserisciNome.setColumns(10);
		
		JLabel SelezioneTemi = new JLabel("Selezione temi:");
		SelezioneTemi.setBounds(70, 118, 80, 25);
		contentPane.add(SelezioneTemi);
		
		JComboBox SceltaTema = new JComboBox();
		SceltaTema.setBounds(160, 119, 210, 25);
		contentPane.add(SceltaTema);
	}

}
