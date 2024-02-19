

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

	
	public InserisciPost() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 366);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(115, 209, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		AddTesto = new JTextField();
		AddTesto.setBounds(213, 100, 240, 78);
		AddTesto.setForeground(new Color(0, 0, 0));
		AddTesto.setBackground(new Color(255, 255, 255));
		contentPane.add(AddTesto);
		AddTesto.setColumns(10);
		
		JButton SalvaButton = new JButton("Salva");
		SalvaButton.setBounds(420, 294, 90, 35);
		SalvaButton.setForeground(new Color(255, 255, 255));
		SalvaButton.setBackground(new Color(0, 128, 192));
		SalvaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(SalvaButton);
		
		JComboBox SceltaGruppo = new JComboBox();
		SceltaGruppo.setBounds(213, 209, 240, 45);
		SceltaGruppo.setBackground(new Color(255, 255, 255));
		SceltaGruppo.setToolTipText("");
		SceltaGruppo.setMaximumRowCount(10);
		contentPane.add(SceltaGruppo);
		
		JLabel SelezionaGruppo = new JLabel("Seleziona Gruppo:");
		SelezionaGruppo.setBounds(24, 219, 110, 25);
		SelezionaGruppo.setForeground(new Color(255, 255, 255));
		contentPane.add(SelezionaGruppo);
		
		JLabel DescrizionePost = new JLabel("Descrizione post:");
		DescrizionePost.setBounds(46, 118, 110, 25);
		DescrizionePost.setForeground(new Color(255, 255, 255));
		contentPane.add(DescrizionePost);
		
		JLabel foto = new JLabel("");
		foto.setBounds(10, -109, 510, 329);
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/stemmaLungo.png"));
		foto.setIcon(icon);
		contentPane.add(foto);
	}

}
