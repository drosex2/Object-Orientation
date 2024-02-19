

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
		setBackground(new Color(255, 255, 255));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 500, 355);
			contentPane = new JPanel();
			contentPane.setForeground(new Color(255, 255, 255));
			contentPane.setBackground(new Color(255, 255, 255));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 186, 318);
			panel.setBackground(new Color(115, 209, 255));
			contentPane.add(panel);
			panel.setLayout(null);
			
			JButton VisualizzaReportButton = new JButton("Visualizza Report");
			VisualizzaReportButton.setForeground(new Color(255, 255, 255));
			VisualizzaReportButton.setBackground(new Color(0, 128, 192));
			VisualizzaReportButton.setBounds(21, 37, 155, 23);
			panel.add(VisualizzaReportButton);
			
			JButton InserisciPostButton = new JButton("Inserisci Post");
			InserisciPostButton.setForeground(new Color(255, 255, 255));
			InserisciPostButton.setBackground(new Color(0, 128, 192));
			InserisciPostButton.setBounds(21, 88, 155, 23);
			panel.add(InserisciPostButton);
			
			JButton CercaGruppoButton = new JButton("Cerca Gruppo");
			CercaGruppoButton.setForeground(new Color(255, 255, 255));
			CercaGruppoButton.setBackground(new Color(0, 128, 192));
			CercaGruppoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			CercaGruppoButton.setBounds(21, 142, 155, 23);
			panel.add(CercaGruppoButton);
			
			JButton VisualizzaNotificaButton = new JButton("Visualizza Notifica");
			VisualizzaNotificaButton.setForeground(new Color(255, 255, 255));
			VisualizzaNotificaButton.setBackground(new Color(0, 128, 192));
			VisualizzaNotificaButton.setBounds(21, 193, 155, 23);
			panel.add(VisualizzaNotificaButton);
			
			JLabel immagine = new JLabel("");
			immagine.setLabelFor(this);
			immagine.setBackground(new Color(255, 255, 255));
			immagine.setBounds(170, 0, 480, 282);
			ImageIcon icon = new ImageIcon(this.getClass().getResource("/LogoTest.png"));
			immagine.setIcon(icon);
			contentPane.add(immagine);
			InserisciPostButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
}
