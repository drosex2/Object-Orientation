import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.*;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;

public class GestisciGruppoPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblIcon;
	private JLabel lblVisualizzaRichieste;
	private JLabel lblSelezionaReport;
	private JButton btnMostraPost;
	private JComboBox cbSelezionaReport;
	private JButton btnIndietro;
	private JButton btnVisualizzaRichieste;
	private JComboBox cbSelezionaGruppo;
	private JLabel lblSelezionaGruppo;
	private JLabel lblNewLabel;
	private Button button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestisciGruppoPage frame = new GestisciGruppoPage();
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
	public GestisciGruppoPage() {
		setTitle("Login");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{202, 389, 0};
		gbl_contentPane.rowHeights = new int[]{416, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 4.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(0, 103, 153));
		GridBagConstraints gbc_panelLeft = new GridBagConstraints();
		gbc_panelLeft.fill = GridBagConstraints.BOTH;
		gbc_panelLeft.insets = new Insets(0, 0, 0, 0);
		gbc_panelLeft.gridx = 0;
		gbc_panelLeft.gridy = 0;
		contentPane.add(panelLeft, gbc_panelLeft);		
		ImageIcon icon= new ImageIcon(this.getClass().getResource("/Napoli_university_seal_alfachannel.png"));
		panelLeft.setLayout(new GridLayout(0, 1, 0, 0));

		lblIcon = new JLabel(icon);
		panelLeft.add(lblIcon);
		
		
		
		
		
		
		
		JPanel panelRight = new JPanel();
		panelRight.setBackground(new Color(115, 209, 255));
		GridBagConstraints gbc_panelRight = new GridBagConstraints();
		gbc_panelRight.fill = GridBagConstraints.BOTH;
		gbc_panelRight.gridx = 1;
		gbc_panelRight.gridy = 0;
		contentPane.add(panelRight, gbc_panelRight);
		GridBagLayout gbl_panelRight = new GridBagLayout();
		gbl_panelRight.columnWidths = new int[]{0, 81, 186, 168, 0};
		gbl_panelRight.rowHeights = new int[]{5, 5, 5, 52, 36, 36, 9, 0, 97, 0, 5, 5, 0};
		gbl_panelRight.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelRight.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelRight.setLayout(gbl_panelRight);
		
		lblSelezionaGruppo = new JLabel("Seleziona gruppo");
		lblSelezionaGruppo.setForeground(new Color(255, 255, 255));
		lblSelezionaGruppo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblSelezionaGruppo = new GridBagConstraints();
		gbc_lblSelezionaGruppo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelezionaGruppo.anchor = GridBagConstraints.EAST;
		gbc_lblSelezionaGruppo.gridx = 1;
		gbc_lblSelezionaGruppo.gridy = 3;
		panelRight.add(lblSelezionaGruppo, gbc_lblSelezionaGruppo);
		
		cbSelezionaGruppo = new JComboBox();
		cbSelezionaGruppo.setBackground(new Color(255, 255, 255));
		cbSelezionaGruppo.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_cbSelezionaGruppo = new GridBagConstraints();
		gbc_cbSelezionaGruppo.insets = new Insets(0, 0, 5, 5);
		gbc_cbSelezionaGruppo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbSelezionaGruppo.gridx = 2;
		gbc_cbSelezionaGruppo.gridy = 3;
		panelRight.add(cbSelezionaGruppo, gbc_cbSelezionaGruppo);
		
		lblVisualizzaRichieste = new JLabel("Visualizza le richieste d'accesso");
		lblVisualizzaRichieste.setForeground(new Color(255, 255, 255));
		lblVisualizzaRichieste.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblVisualizzaRichieste = new GridBagConstraints();
		gbc_lblVisualizzaRichieste.insets = new Insets(0, 0, 5, 5);
		gbc_lblVisualizzaRichieste.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblVisualizzaRichieste.gridx = 1;
		gbc_lblVisualizzaRichieste.gridy = 4;
		panelRight.add(lblVisualizzaRichieste, gbc_lblVisualizzaRichieste);
		
		btnVisualizzaRichieste = new JButton("Visualizza");
		btnVisualizzaRichieste.setToolTipText("Visualizza richieste");
		btnVisualizzaRichieste.setForeground(Color.WHITE);
		btnVisualizzaRichieste.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVisualizzaRichieste.setBackground(new Color(0, 128, 192));
		GridBagConstraints gbc_btnVisualizzaRichieste = new GridBagConstraints();
		gbc_btnVisualizzaRichieste.ipadx = 30;
		gbc_btnVisualizzaRichieste.insets = new Insets(0, 0, 5, 5);
		gbc_btnVisualizzaRichieste.gridx = 2;
		gbc_btnVisualizzaRichieste.gridy = 4;
		panelRight.add(btnVisualizzaRichieste, gbc_btnVisualizzaRichieste);
		
		lblSelezionaReport = new JLabel("Seleziona richiesta del report");
		lblSelezionaReport.setForeground(Color.WHITE);
		lblSelezionaReport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblSelezionaReport = new GridBagConstraints();
		gbc_lblSelezionaReport.fill = GridBagConstraints.VERTICAL;
		gbc_lblSelezionaReport.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelezionaReport.anchor = GridBagConstraints.EAST;
		gbc_lblSelezionaReport.gridx = 1;
		gbc_lblSelezionaReport.gridy = 5;
		panelRight.add(lblSelezionaReport, gbc_lblSelezionaReport);
		
		cbSelezionaReport = new JComboBox();
		GridBagConstraints gbc_cbSelezionaReport = new GridBagConstraints();
		gbc_cbSelezionaReport.insets = new Insets(0, 0, 5, 5);
		gbc_cbSelezionaReport.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbSelezionaReport.gridx = 2;
		gbc_cbSelezionaReport.gridy = 5;
		panelRight.add(cbSelezionaReport, gbc_cbSelezionaReport);
		
		btnMostraPost = new JButton("Visualizza Report");
		btnMostraPost.setToolTipText("Crea");
		btnMostraPost.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMostraPost.setForeground(new Color(255, 255, 255));
		btnMostraPost.setBackground(new Color(0, 128, 192));
		btnMostraPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		lblNewLabel = new JLabel("Seleziona mese");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 6;
		panelRight.add(lblNewLabel, gbc_lblNewLabel);
		
		JDateChooser calendar = new JDateChooser();
		calendar.setDateFormatString(" MM y");
		calendar.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 2;
		gbc_button.gridy = 6;
		panelRight.add(calendar, gbc_button);
		GridBagConstraints gbc_btnMostraPost = new GridBagConstraints();
		gbc_btnMostraPost.ipadx = 30;
		gbc_btnMostraPost.insets = new Insets(0, 0, 5, 5);
		gbc_btnMostraPost.gridx = 2;
		gbc_btnMostraPost.gridy = 7;
		panelRight.add(btnMostraPost, gbc_btnMostraPost);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.setForeground(new Color(255, 255, 255));
		btnIndietro.setBackground(new Color(0, 128, 192));
		btnIndietro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnIndietro = new GridBagConstraints();
		gbc_btnIndietro.insets = new Insets(0, 0, 5, 0);
		gbc_btnIndietro.gridx = 3;
		gbc_btnIndietro.gridy = 9;
		panelRight.add(btnIndietro, gbc_btnIndietro);
	}

}
