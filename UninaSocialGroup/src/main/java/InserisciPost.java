import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;

public class InserisciPost extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField AddTesto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserisciPost frame = new InserisciPost();
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
	public InserisciPost() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		AddTesto = new JTextField();
		AddTesto.setText("Inserisci testo...");
		AddTesto.setBounds(164, 11, 240, 95);
		contentPane.add(AddTesto);
		AddTesto.setColumns(10);
		
		JButton SalvaButton = new JButton("Salva");
		SalvaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SalvaButton.setBounds(346, 228, 90, 35);
		contentPane.add(SalvaButton);
		
		JComboBox SceltaGruppo = new JComboBox();
		SceltaGruppo.setToolTipText("");
		SceltaGruppo.setMaximumRowCount(10);
		SceltaGruppo.setBounds(164, 145, 240, 45);
		contentPane.add(SceltaGruppo);
		
		JLabel SelezionaGruppo = new JLabel("Seleziona Gruppo:");
		SelezionaGruppo.setBounds(62, 155, 110, 25);
		contentPane.add(SelezionaGruppo);
		
		JLabel DescrizionePost = new JLabel("Descrizione post:");
		DescrizionePost.setBounds(62, 46, 110, 25);
		contentPane.add(DescrizionePost);
	}
}
