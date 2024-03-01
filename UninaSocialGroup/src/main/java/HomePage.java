import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblIcon;
	private JButton btnInserisciPost;
	private JButton btnCercaGruppo;
	private JButton btnNotifiche;
	private JButton btnLogin;
	private JButton btnLogout;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private GestoreApplicazione controller;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public HomePage(GestoreApplicazione gestore) {
		controller=gestore;
		setTitle("HomePage");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{186, 389, 0};
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
		gbl_panelRight.columnWidths = new int[]{118, 200, 118, 0};
		gbl_panelRight.rowHeights = new int[]{5, 5, 5, 52, 36, 36, 9, 97, 5, 5, 0};
		gbl_panelRight.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelRight.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panelRight.setLayout(gbl_panelRight);
		
		lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		panelRight.add(lblNewLabel, gbc_lblNewLabel);
		
		btnInserisciPost = new JButton("Inserisci un Post");
		btnInserisciPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.inserisciPostClicked();
			}
		});
		btnInserisciPost.setBackground(new Color(0, 128, 192));
		btnInserisciPost.setForeground(new Color(255, 255, 255));
		btnInserisciPost.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnInserisciPost = new GridBagConstraints();
		gbc_btnInserisciPost.anchor = GridBagConstraints.SOUTH;
		gbc_btnInserisciPost.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInserisciPost.insets = new Insets(0, 0, 5, 5);
		gbc_btnInserisciPost.gridx = 1;
		gbc_btnInserisciPost.gridy = 3;
		panelRight.add(btnInserisciPost, gbc_btnInserisciPost);
		
		btnCercaGruppo = new JButton("Cerca Gruppo");
		btnCercaGruppo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.cercaGruppoClicked();
			}
		});
		btnCercaGruppo.setForeground(new Color(255, 255, 255));
		btnCercaGruppo.setBackground(new Color(0, 128, 192));
		btnCercaGruppo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnCercaGruppo = new GridBagConstraints();
		gbc_btnCercaGruppo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCercaGruppo.insets = new Insets(0, 0, 5, 5);
		gbc_btnCercaGruppo.gridx = 1;
		gbc_btnCercaGruppo.gridy = 4;
		panelRight.add(btnCercaGruppo, gbc_btnCercaGruppo);
		
		btnNotifiche = new JButton("Visualizza Notifiche");
		btnNotifiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.visualizzaNotificheClicked();
			}
		});
		btnNotifiche.setBackground(new Color(0, 128, 192));
		btnNotifiche.setForeground(new Color(255, 255, 255));
		btnNotifiche.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNotifiche = new GridBagConstraints();
		gbc_btnNotifiche.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNotifiche.insets = new Insets(0, 0, 5, 5);
		gbc_btnNotifiche.gridx = 1;
		gbc_btnNotifiche.gridy = 5;
		panelRight.add(btnNotifiche, gbc_btnNotifiche);
		
		btnLogin = new JButton("Gestisci Gruppo");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.gestisciGruppoClicked();
			}
		});
		btnLogin.setToolTipText("");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setBackground(new Color(0, 128, 192));
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 1;
		gbc_btnLogin.gridy = 6;
		panelRight.add(btnLogin, gbc_btnLogin);
		
		btnLogout = new JButton("Esci");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.effettuaLogout();
			}
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogout.setBackground(new Color(0, 128, 192));
		GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		gbc_btnLogout.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogout.gridx = 1;
		gbc_btnLogout.gridy = 7;
		panelRight.add(btnLogout, gbc_btnLogout);
		
		lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 8;
		panelRight.add(lblNewLabel_1, gbc_lblNewLabel_1);
	}
	public void mostraMessaggioDiDialogo(String testo, String titolo) {
		JOptionPane.showMessageDialog(this, testo, titolo, JOptionPane.INFORMATION_MESSAGE);
	}
}
