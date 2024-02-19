import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

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
		setBounds(100, 100, 504, 346);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(115, 209, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton InviaRichiestaButton = new JButton("invia richiesta");
		InviaRichiestaButton.setForeground(new Color(255, 255, 255));
		InviaRichiestaButton.setBackground(new Color(0, 128, 192));
		InviaRichiestaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		InviaRichiestaButton.setBounds(176, 248, 127, 25);
		contentPane.add(InviaRichiestaButton);
		
		JLabel NomeGruppo = new JLabel("Nome gruppo:");
		NomeGruppo.setBackground(new Color(255, 255, 255));
		NomeGruppo.setForeground(new Color(255, 255, 255));
		NomeGruppo.setBounds(39, 124, 111, 25);
		contentPane.add(NomeGruppo);
		
		InserisciNome = new JTextField();
		InserisciNome.setBackground(new Color(255, 255, 255));
		InserisciNome.setForeground(new Color(0, 0, 0));
		InserisciNome.setBounds(160, 124, 210, 25);
		contentPane.add(InserisciNome);
		InserisciNome.setColumns(10);
		
		JLabel SelezioneTemi = new JLabel("Seleziona tema:");
		SelezioneTemi.setForeground(new Color(255, 255, 255));
		SelezioneTemi.setBounds(39, 183, 111, 25);
		contentPane.add(SelezioneTemi);
		
		JComboBox SceltaTema = new JComboBox();
		SceltaTema.setBackground(new Color(255, 255, 255));
		SceltaTema.setForeground(new Color(0, 0, 0));
		SceltaTema.setBounds(160, 183, 210, 25);
		contentPane.add(SceltaTema);
		
		JLabel foto = new JLabel("");
		foto.setBounds(24, -63, 439, 260);
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/stemmaLungo.png"));
		foto.setIcon(icon);
		contentPane.add(foto);
	}
}
