import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.*;
import java.util.Date;
import java.util.Calendar;
public class GestisciGruppoPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblIcon;
	private JLabel lblVisualizzaRichieste;
	private JLabel lblSelezionaReport;
	private JButton btnMostraReport;
	private JComboBox<String> cbSelezionaReport;
	private JButton btnIndietro;
	private JButton btnVisualizzaRichieste;
	private JComboBox<String> cbSelezionaGruppo;
	private JLabel lblSelezionaGruppo;
	private JLabel lblSelezionaMese;
	private GestoreApplicazione controller;
	private JSpinner spinnerMese;
	private JLabel lblSelezionaAnno;
	private JSpinner spinnerAnno;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	
	public GestisciGruppoPage(GestoreApplicazione gestore) {
		controller=gestore;
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
		gbl_panelRight.rowHeights = new int[]{5, 5, 5, 52, 36, 36, 9, 0, 0, 97, 0, 5, 5, 0};
		gbl_panelRight.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelRight.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelRight.setLayout(gbl_panelRight);
		
		lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		panelRight.add(lblNewLabel, gbc_lblNewLabel);
		
		lblSelezionaGruppo = new JLabel("Seleziona gruppo");
		lblSelezionaGruppo.setForeground(new Color(255, 255, 255));
		lblSelezionaGruppo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblSelezionaGruppo = new GridBagConstraints();
		gbc_lblSelezionaGruppo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelezionaGruppo.anchor = GridBagConstraints.EAST;
		gbc_lblSelezionaGruppo.gridx = 1;
		gbc_lblSelezionaGruppo.gridy = 3;
		panelRight.add(lblSelezionaGruppo, gbc_lblSelezionaGruppo);
		
		cbSelezionaGruppo = new JComboBox<String>();
		cbSelezionaGruppo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbSelezionaGruppo.setBackground(new Color(255, 255, 255));
		cbSelezionaGruppo.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_cbSelezionaGruppo = new GridBagConstraints();
		gbc_cbSelezionaGruppo.insets = new Insets(0, 0, 5, 5);
		gbc_cbSelezionaGruppo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbSelezionaGruppo.gridx = 2;
		gbc_cbSelezionaGruppo.gridy = 3;
		panelRight.add(cbSelezionaGruppo, gbc_cbSelezionaGruppo);
		
		lblVisualizzaRichieste = new JLabel("Visualizza le richieste");
		lblVisualizzaRichieste.setForeground(new Color(255, 255, 255));
		lblVisualizzaRichieste.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblVisualizzaRichieste = new GridBagConstraints();
		gbc_lblVisualizzaRichieste.insets = new Insets(0, 0, 5, 5);
		gbc_lblVisualizzaRichieste.anchor = GridBagConstraints.EAST;
		gbc_lblVisualizzaRichieste.gridx = 1;
		gbc_lblVisualizzaRichieste.gridy = 4;
		panelRight.add(lblVisualizzaRichieste, gbc_lblVisualizzaRichieste);
		
		btnVisualizzaRichieste = new JButton("Visualizza");
		btnVisualizzaRichieste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gruppoSelezionato=(String)cbSelezionaGruppo.getSelectedItem();
				controller.visualizzaRichiesteClicked(gruppoSelezionato);
			}
		});
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
		
		lblSelezionaReport = new JLabel("Seleziona report");
		lblSelezionaReport.setForeground(Color.WHITE);
		lblSelezionaReport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblSelezionaReport = new GridBagConstraints();
		gbc_lblSelezionaReport.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelezionaReport.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblSelezionaReport.gridx = 1;
		gbc_lblSelezionaReport.gridy = 5;
		panelRight.add(lblSelezionaReport, gbc_lblSelezionaReport);
		
		cbSelezionaReport = new JComboBox<String>();
		cbSelezionaReport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_cbSelezionaReport = new GridBagConstraints();
		gbc_cbSelezionaReport.anchor = GridBagConstraints.SOUTH;
		gbc_cbSelezionaReport.insets = new Insets(0, 0, 5, 5);
		gbc_cbSelezionaReport.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbSelezionaReport.gridx = 2;
		gbc_cbSelezionaReport.gridy = 5;
		panelRight.add(cbSelezionaReport, gbc_cbSelezionaReport);
		
		btnMostraReport = new JButton("Visualizza Report");
		btnMostraReport.setToolTipText("Crea");
		btnMostraReport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMostraReport.setForeground(new Color(255, 255, 255));
		btnMostraReport.setBackground(new Color(0, 128, 192));
		btnMostraReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeGruppo=(String)cbSelezionaGruppo.getSelectedItem();
				
				
				int anno=(int) spinnerAnno.getValue();
				int mese=(int) spinnerMese.getValue();
				String reportScelto=(String)cbSelezionaReport.getSelectedItem();
				controller.visualizzaReportClicked(nomeGruppo,anno,mese,reportScelto);
				
			}
		});
		
		lblSelezionaMese = new JLabel("Seleziona mese");
		lblSelezionaMese.setForeground(new Color(255, 255, 255));
		lblSelezionaMese.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblSelezionaMese = new GridBagConstraints();
		gbc_lblSelezionaMese.anchor = GridBagConstraints.EAST;
		gbc_lblSelezionaMese.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelezionaMese.gridx = 1;
		gbc_lblSelezionaMese.gridy = 6;
		panelRight.add(lblSelezionaMese, gbc_lblSelezionaMese);
		
		spinnerMese = new JSpinner();
		spinnerMese.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinnerMese.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_spinnerMese = new GridBagConstraints();
		gbc_spinnerMese.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerMese.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerMese.gridx = 2;
		gbc_spinnerMese.gridy = 6;
		panelRight.add(spinnerMese, gbc_spinnerMese);
		
		lblSelezionaAnno = new JLabel("Seleziona anno");
		lblSelezionaAnno.setForeground(Color.WHITE);
		lblSelezionaAnno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblSelezionaAnno = new GridBagConstraints();
		gbc_lblSelezionaAnno.anchor = GridBagConstraints.EAST;
		gbc_lblSelezionaAnno.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelezionaAnno.gridx = 1;
		gbc_lblSelezionaAnno.gridy = 7;
		panelRight.add(lblSelezionaAnno, gbc_lblSelezionaAnno);
		
		spinnerAnno = new JSpinner();
		spinnerAnno.setModel(new SpinnerNumberModel(Integer.valueOf(2024), null, null, Integer.valueOf(1)));
		JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spinnerAnno, "#");
		spinnerAnno.setEditor(editor);
		
		spinnerAnno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_spinnerAnno = new GridBagConstraints();
		gbc_spinnerAnno.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerAnno.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerAnno.gridx = 2;
		gbc_spinnerAnno.gridy = 7;
		panelRight.add(spinnerAnno, gbc_spinnerAnno);
		
		
		
		GridBagConstraints gbc_btnMostraReport = new GridBagConstraints();
		gbc_btnMostraReport.ipadx = 30;
		gbc_btnMostraReport.insets = new Insets(0, 0, 5, 5);
		gbc_btnMostraReport.gridx = 2;
		gbc_btnMostraReport.gridy = 8;
		panelRight.add(btnMostraReport, gbc_btnMostraReport);
		
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
		gbc_btnIndietro.gridy = 10;
		panelRight.add(btnIndietro, gbc_btnIndietro);
		
		cbSelezionaReport.addItem("Post con più like");
		cbSelezionaReport.addItem("Post con meno like");
		cbSelezionaReport.addItem("Post con più commenti");
		cbSelezionaReport.addItem("Post con meno commenti");
	}
	public void setCbSelezionaGruppo(LinkedList<Gruppo> gruppi) {
		for(Gruppo g:gruppi)
		{
			this.cbSelezionaGruppo.addItem(g.getNome());
		}
	}
	public void mostraMessaggioDiDialogo(String testo, String titolo) {
		JOptionPane.showMessageDialog(this, testo, titolo, JOptionPane.INFORMATION_MESSAGE);
	}
}
