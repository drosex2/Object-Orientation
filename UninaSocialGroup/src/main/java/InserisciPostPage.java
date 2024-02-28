import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class InserisciPostPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblIcon;
	private JLabel lblInserisciDescrizione;
	private JLabel lblSelezionaGruppo;
	private JButton btnLogin;
	private JLabel lblCreaPost;
	private JComboBox cbSelezionaGruppo;
	private JTextArea textArea;
	private JButton btnIndietro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserisciPostPage frame = new InserisciPostPage();
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
	public InserisciPostPage() {
		setTitle("Login");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{203, 389, 0};
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
		gbl_panelRight.rowHeights = new int[]{5, 5, 5, 52, 36, 36, 9, 97, 5, 5, 0};
		gbl_panelRight.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelRight.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panelRight.setLayout(gbl_panelRight);
		
		lblCreaPost = new JLabel("Crea Post");
		lblCreaPost.setForeground(new Color(255, 255, 255));
		lblCreaPost.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblCreaPost = new GridBagConstraints();
		gbc_lblCreaPost.anchor = GridBagConstraints.SOUTH;
		gbc_lblCreaPost.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreaPost.gridx = 2;
		gbc_lblCreaPost.gridy = 3;
		panelRight.add(lblCreaPost, gbc_lblCreaPost);
		
		lblInserisciDescrizione = new JLabel("Inserisci una descrizione");
		lblInserisciDescrizione.setForeground(new Color(255, 255, 255));
		lblInserisciDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblInserisciDescrizione = new GridBagConstraints();
		gbc_lblInserisciDescrizione.insets = new Insets(0, 0, 5, 5);
		gbc_lblInserisciDescrizione.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblInserisciDescrizione.gridx = 1;
		gbc_lblInserisciDescrizione.gridy = 4;
		panelRight.add(lblInserisciDescrizione, gbc_lblInserisciDescrizione);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textArea.setRows(5);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.ipady = 5;
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 4;
		panelRight.add(textArea, gbc_textArea);
		
		lblSelezionaGruppo = new JLabel("Seleziona Gruppo");
		lblSelezionaGruppo.setForeground(Color.WHITE);
		lblSelezionaGruppo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblSelezionaGruppo = new GridBagConstraints();
		gbc_lblSelezionaGruppo.fill = GridBagConstraints.VERTICAL;
		gbc_lblSelezionaGruppo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelezionaGruppo.anchor = GridBagConstraints.EAST;
		gbc_lblSelezionaGruppo.gridx = 1;
		gbc_lblSelezionaGruppo.gridy = 5;
		panelRight.add(lblSelezionaGruppo, gbc_lblSelezionaGruppo);
		
		btnLogin = new JButton("Crea Post");
		btnLogin.setToolTipText("");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(0, 128, 192));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		cbSelezionaGruppo = new JComboBox();
		GridBagConstraints gbc_cbSelezionaGruppo = new GridBagConstraints();
		gbc_cbSelezionaGruppo.insets = new Insets(0, 0, 5, 5);
		gbc_cbSelezionaGruppo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbSelezionaGruppo.gridx = 2;
		gbc_cbSelezionaGruppo.gridy = 5;
		panelRight.add(cbSelezionaGruppo, gbc_cbSelezionaGruppo);
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.ipadx = 30;
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 2;
		gbc_btnLogin.gridy = 6;
		panelRight.add(btnLogin, gbc_btnLogin);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.setForeground(new Color(255, 255, 255));
		btnIndietro.setBackground(new Color(0, 128, 192));
		btnIndietro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnIndietro = new GridBagConstraints();
		gbc_btnIndietro.insets = new Insets(0, 0, 5, 0);
		gbc_btnIndietro.gridx = 3;
		gbc_btnIndietro.gridy = 8;
		panelRight.add(btnIndietro, gbc_btnIndietro);
	}

}
