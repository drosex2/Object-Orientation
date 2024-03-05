import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;

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

public class CercaGruppoPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNomeGruppo;
	private JTextField tfTemaGruppo;
	private JLabel lblIcon;
	private JLabel lblUsername;
	private JLabel lblTema;
	private JButton btnCercaNome;
	private JLabel lblCercaGruppo;
	private JLabel lblNewLabel;
	private JButton btnCercaTema;
	private JButton btnIndietro;
    private Controller controller;
    private JTextArea taDescrizioneRichiesta;
    private JLabel lblDescrizioneRichiesta;
	
	public CercaGruppoPage(Controller gestore) {
		controller=gestore;
		setTitle("Cerca Gruppo");
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
		gbl_panelRight.columnWidths = new int[]{0, 142, 224, 0, 0};
		gbl_panelRight.rowHeights = new int[]{5, 5, 5, 52, 36, 0, 36, 9, 0, 97, 5, 5, 0};
		gbl_panelRight.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelRight.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panelRight.setLayout(gbl_panelRight);
		
		lblCercaGruppo = new JLabel("Invia una richiesta");
		lblCercaGruppo.setForeground(new Color(255, 255, 255));
		lblCercaGruppo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblCercaGruppo = new GridBagConstraints();
		gbc_lblCercaGruppo.anchor = GridBagConstraints.SOUTH;
		gbc_lblCercaGruppo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCercaGruppo.gridx = 2;
		gbc_lblCercaGruppo.gridy = 3;
		panelRight.add(lblCercaGruppo, gbc_lblCercaGruppo);
		
		lblUsername = new JLabel("Nome gruppo:");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.fill = GridBagConstraints.VERTICAL;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 4;
		panelRight.add(lblUsername, gbc_lblUsername);
		
		tfNomeGruppo = new JTextField();
		tfNomeGruppo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfNomeGruppo.setColumns(14);
		GridBagConstraints gbc_tfNomeGruppo = new GridBagConstraints();
		gbc_tfNomeGruppo.fill = GridBagConstraints.VERTICAL;
		gbc_tfNomeGruppo.ipady = 4;
		gbc_tfNomeGruppo.insets = new Insets(0, 0, 5, 5);
		gbc_tfNomeGruppo.gridx = 2;
		gbc_tfNomeGruppo.gridy = 4;
		panelRight.add(tfNomeGruppo, gbc_tfNomeGruppo);
		
		btnCercaNome = new JButton("Cerca");
		btnCercaNome.setToolTipText("");
		btnCercaNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCercaNome.setForeground(new Color(255, 255, 255));
		btnCercaNome.setBackground(new Color(0, 128, 192));
		btnCercaNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String descrizione=taDescrizioneRichiesta.getText();
				String nomeGruppo=tfNomeGruppo.getText();
				controller.cercaPerNomeClicked(descrizione,nomeGruppo);
				taDescrizioneRichiesta.setText(null);
				tfNomeGruppo.setText(null);
			}
		});
		GridBagConstraints gbc_btnCercaNome = new GridBagConstraints();
		gbc_btnCercaNome.anchor = GridBagConstraints.WEST;
		gbc_btnCercaNome.ipadx = 30;
		gbc_btnCercaNome.insets = new Insets(0, 0, 5, 0);
		gbc_btnCercaNome.gridx = 3;
		gbc_btnCercaNome.gridy = 4;
		panelRight.add(btnCercaNome, gbc_btnCercaNome);
		
		lblNewLabel = new JLabel("Oppure");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 5;
		panelRight.add(lblNewLabel, gbc_lblNewLabel);
		
		lblTema = new JLabel("Tema:");
		lblTema.setForeground(Color.WHITE);
		lblTema.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTema = new GridBagConstraints();
		gbc_lblTema.fill = GridBagConstraints.VERTICAL;
		gbc_lblTema.insets = new Insets(0, 0, 5, 5);
		gbc_lblTema.anchor = GridBagConstraints.EAST;
		gbc_lblTema.gridx = 1;
		gbc_lblTema.gridy = 6;
		panelRight.add(lblTema, gbc_lblTema);
		
		tfTemaGruppo = new JTextField();
		tfTemaGruppo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfTemaGruppo.setColumns(14);
		GridBagConstraints gbc_tfTemaGruppo = new GridBagConstraints();
		gbc_tfTemaGruppo.fill = GridBagConstraints.VERTICAL;
		gbc_tfTemaGruppo.ipady = 4;
		gbc_tfTemaGruppo.insets = new Insets(0, 0, 5, 5);
		gbc_tfTemaGruppo.gridx = 2;
		gbc_tfTemaGruppo.gridy = 6;
		panelRight.add(tfTemaGruppo, gbc_tfTemaGruppo);
		
		btnCercaTema = new JButton("Cerca");
		btnCercaTema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String descrizione=taDescrizioneRichiesta.getText();
				String temaGruppo=tfTemaGruppo.getText();
				controller.cercaPerTemaClicked(descrizione,temaGruppo);
				taDescrizioneRichiesta.setText(null);
				tfTemaGruppo.setText(null);
			}
		});
		btnCercaTema.setToolTipText("");
		btnCercaTema.setForeground(Color.WHITE);
		btnCercaTema.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCercaTema.setBackground(new Color(0, 128, 192));
		GridBagConstraints gbc_btnCercaTema = new GridBagConstraints();
		gbc_btnCercaTema.ipadx = 30;
		gbc_btnCercaTema.anchor = GridBagConstraints.WEST;
		gbc_btnCercaTema.insets = new Insets(0, 0, 5, 0);
		gbc_btnCercaTema.gridx = 3;
		gbc_btnCercaTema.gridy = 6;
		panelRight.add(btnCercaTema, gbc_btnCercaTema);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.setForeground(Color.WHITE);
		btnIndietro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnIndietro.setBackground(new Color(0, 128, 192));
		GridBagConstraints gbc_btnIndietro = new GridBagConstraints();
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				controller.indietroClicked();
			}
		});
		
		lblDescrizioneRichiesta = new JLabel("Descrizione");
		lblDescrizioneRichiesta.setForeground(new Color(255, 255, 255));
		lblDescrizioneRichiesta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblDescrizioneRichiesta = new GridBagConstraints();
		gbc_lblDescrizioneRichiesta.anchor = GridBagConstraints.EAST;
		gbc_lblDescrizioneRichiesta.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrizioneRichiesta.gridx = 1;
		gbc_lblDescrizioneRichiesta.gridy = 8;
		panelRight.add(lblDescrizioneRichiesta, gbc_lblDescrizioneRichiesta);
		
		taDescrizioneRichiesta = new JTextArea();
		taDescrizioneRichiesta.setTabSize(9);
		taDescrizioneRichiesta.setToolTipText("");
		taDescrizioneRichiesta.setColumns(14);
		taDescrizioneRichiesta.setRows(4);
		taDescrizioneRichiesta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JScrollPane scrollPane = new JScrollPane( taDescrizioneRichiesta );
		GridBagConstraints gbc_taDescrizioneRichiesta = new GridBagConstraints();
		gbc_taDescrizioneRichiesta.insets = new Insets(0, 0, 5, 5);
		gbc_taDescrizioneRichiesta.gridx = 2;
		gbc_taDescrizioneRichiesta.gridy = 8;
		panelRight.add(scrollPane, gbc_taDescrizioneRichiesta);
		gbc_btnIndietro.insets = new Insets(0, 0, 5, 0);
		gbc_btnIndietro.gridx = 3;
		gbc_btnIndietro.gridy = 10;
		panelRight.add(btnIndietro, gbc_btnIndietro);
		
	}
	public void mostraMessaggioDiDialogo(String testo, String titolo) {
		javax.swing.UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, 16))); 
		JOptionPane.showMessageDialog(this, testo, titolo, JOptionPane.INFORMATION_MESSAGE);
		
	}
}
