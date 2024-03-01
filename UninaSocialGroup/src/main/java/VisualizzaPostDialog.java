import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.LinkedList;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class VisualizzaPostDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private String descrizione;
	private GestoreApplicazione controller;

	public void setDescrizione(String descrizione)
	{
		this.descrizione=descrizione;
	}
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public VisualizzaPostDialog(GestoreApplicazione gestore) {
		controller=gestore;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(115, 209, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{166, 171, 118, 0};
		gbl_contentPanel.rowHeights = new int[]{21, 20, 20, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblAutore = new JLabel("Autore del post:");
			lblAutore.setForeground(new Color(255, 255, 255));
			lblAutore.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblAutore = new GridBagConstraints();
			gbc_lblAutore.insets = new Insets(0, 0, 5, 5);
			gbc_lblAutore.anchor = GridBagConstraints.EAST;
			gbc_lblAutore.gridx = 0;
			gbc_lblAutore.gridy = 1;
			contentPanel.add(lblAutore, gbc_lblAutore);
		}
		{
			JLabel lblNomeAutore = new JLabel("");
			lblNomeAutore.setForeground(new Color(255, 255, 255));
			lblNomeAutore.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblNomeAutore = new GridBagConstraints();
			gbc_lblNomeAutore.insets = new Insets(0, 0, 5, 5);
			gbc_lblNomeAutore.gridx = 1;
			gbc_lblNomeAutore.gridy = 1;
			contentPanel.add(lblNomeAutore, gbc_lblNomeAutore);
		}
		{
			JLabel lblDescrizione = new JLabel("Descrizione");
			lblDescrizione.setForeground(new Color(255, 255, 255));
			lblDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblDescrizione = new GridBagConstraints();
			gbc_lblDescrizione.anchor = GridBagConstraints.NORTHEAST;
			gbc_lblDescrizione.insets = new Insets(0, 0, 5, 5);
			gbc_lblDescrizione.gridx = 0;
			gbc_lblDescrizione.gridy = 2;
			contentPanel.add(lblDescrizione, gbc_lblDescrizione);
		}
		{
			JTextArea taDescrizione = new JTextArea();
			taDescrizione.setEditable(false);
			taDescrizione.setRows(8);
			taDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 13));
			GridBagConstraints gbc_taDescrizione = new GridBagConstraints();
			gbc_taDescrizione.insets = new Insets(0, 0, 5, 5);
			gbc_taDescrizione.fill = GridBagConstraints.BOTH;
			gbc_taDescrizione.gridx = 1;
			gbc_taDescrizione.gridy = 2;
			contentPanel.add(taDescrizione, gbc_taDescrizione);
		}
		{
			JLabel lblInterazioni = new JLabel("");
			lblInterazioni.setForeground(new Color(255, 255, 255));
			lblInterazioni.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblInterazioni = new GridBagConstraints();
			gbc_lblInterazioni.insets = new Insets(0, 0, 5, 5);
			gbc_lblInterazioni.anchor = GridBagConstraints.EAST;
			gbc_lblInterazioni.gridx = 0;
			gbc_lblInterazioni.gridy = 3;
			contentPanel.add(lblInterazioni, gbc_lblInterazioni);
		}
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 3;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
	}
	
	public void mostraMessaggioDiDialogo(String testo, String titolo) {
		JOptionPane.showMessageDialog(this, testo, titolo, JOptionPane.INFORMATION_MESSAGE);
	}
}
