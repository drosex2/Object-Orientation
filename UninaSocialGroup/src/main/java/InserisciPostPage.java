import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class InserisciPostPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblIcon;
	private JLabel lblInserisciDescrizione;
	private JLabel lblSelezionaGruppo;
	private JButton btnCreaPost;
	private JLabel lblCreaPost;
	private JComboBox<String> cbSelezionaGruppo;
	private JTextArea taDescrizione;
	private JButton btnIndietro;
	private GestoreApplicazione controller;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public InserisciPostPage(GestoreApplicazione gestore) {
		controller=gestore;
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
		gbl_panelRight.columnWidths = new int[]{0, 220, 217, 168, 0};
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
		
		taDescrizione = new JTextArea();
		taDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 13));
		taDescrizione.setRows(8);
		GridBagConstraints gbc_taDescrizione = new GridBagConstraints();
		JScrollPane scrollPane = new JScrollPane( taDescrizione );
		gbc_taDescrizione.ipady = 5;
		gbc_taDescrizione.fill = GridBagConstraints.BOTH;
		gbc_taDescrizione.insets = new Insets(0, 0, 5, 5);
		gbc_taDescrizione.gridx = 2;
		gbc_taDescrizione.gridy = 4;
		panelRight.add(scrollPane, gbc_taDescrizione);
		
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
		
		btnCreaPost = new JButton("Crea Post");
		btnCreaPost.setToolTipText("");
		btnCreaPost.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCreaPost.setForeground(new Color(255, 255, 255));
		btnCreaPost.setBackground(new Color(0, 128, 192));
		btnCreaPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String descrizione=taDescrizione.getText();
				if (descrizione.isEmpty())
				{
					mostraMessaggioDiDialogo("Inserisci una descrizione!","ATTENZIONE!");
				}
				else
				{
				String nomeGruppo=(String)cbSelezionaGruppo.getSelectedItem();
				controller.creaPostClicked(descrizione, nomeGruppo);
				taDescrizione.setText(null);
				}
			}
		});
		
		cbSelezionaGruppo = new JComboBox();
		cbSelezionaGruppo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_cbSelezionaGruppo = new GridBagConstraints();
		gbc_cbSelezionaGruppo.insets = new Insets(0, 0, 5, 5);
		gbc_cbSelezionaGruppo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbSelezionaGruppo.gridx = 2;
		gbc_cbSelezionaGruppo.gridy = 5;
		panelRight.add(cbSelezionaGruppo, gbc_cbSelezionaGruppo);
		GridBagConstraints gbc_btnCreaPost = new GridBagConstraints();
		gbc_btnCreaPost.ipadx = 30;
		gbc_btnCreaPost.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreaPost.gridx = 2;
		gbc_btnCreaPost.gridy = 6;
		panelRight.add(btnCreaPost, gbc_btnCreaPost);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				controller.indietroClicked();
			}
		});
		btnIndietro.setForeground(new Color(255, 255, 255));
		btnIndietro.setBackground(new Color(0, 128, 192));
		btnIndietro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnIndietro = new GridBagConstraints();
		gbc_btnIndietro.insets = new Insets(0, 0, 5, 0);
		gbc_btnIndietro.gridx = 3;
		gbc_btnIndietro.gridy = 8;
		panelRight.add(btnIndietro, gbc_btnIndietro);
	}
	
	public void mostraMessaggioDiDialogo(String testo, String titolo) {
		JOptionPane.showMessageDialog(this, testo, titolo, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void setCbSelezionaGruppo(LinkedList<Gruppo> gruppi) {
		for(Gruppo g:gruppi)
		{
			this.cbSelezionaGruppo.addItem(g.getNome());
		}
	}
}
