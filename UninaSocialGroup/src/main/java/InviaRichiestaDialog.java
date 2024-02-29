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

public class InviaRichiestaDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> cbSelezionaGruppo;
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
	public InviaRichiestaDialog(GestoreApplicazione gestore) {
		controller=gestore;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(115, 209, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{166, 124, 118, 0};
		gbl_contentPanel.rowHeights = new int[]{21, 20, 20, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblSelezionaGruppo = new JLabel("Seleziona Gruppo");
			lblSelezionaGruppo.setForeground(new Color(255, 255, 255));
			lblSelezionaGruppo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblSelezionaGruppo = new GridBagConstraints();
			gbc_lblSelezionaGruppo.insets = new Insets(0, 0, 5, 5);
			gbc_lblSelezionaGruppo.anchor = GridBagConstraints.EAST;
			gbc_lblSelezionaGruppo.gridx = 0;
			gbc_lblSelezionaGruppo.gridy = 3;
			contentPanel.add(lblSelezionaGruppo, gbc_lblSelezionaGruppo);
		}
		{
			cbSelezionaGruppo = new JComboBox();
			cbSelezionaGruppo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_cbSelezionaGruppo = new GridBagConstraints();
			gbc_cbSelezionaGruppo.fill = GridBagConstraints.BOTH;
			gbc_cbSelezionaGruppo.insets = new Insets(0, 0, 5, 5);
			gbc_cbSelezionaGruppo.gridx = 1;
			gbc_cbSelezionaGruppo.gridy = 3;
			contentPanel.add(cbSelezionaGruppo, gbc_cbSelezionaGruppo);
		}
		{
			JButton btnNewButton = new JButton("Invia");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String nomeGruppo=(String)cbSelezionaGruppo.getSelectedItem();
					boolean inserito=controller.inviaRichiesta(descrizione,nomeGruppo);
					if(inserito)
					{
						mostraMessaggioDiDialogo("Richiesta inserita con successo", "Messaggio");
					}
					else
					{
						mostraMessaggioDiDialogo("Richiesta già inviata!", "Errore!");
					}
				}
			});
			btnNewButton.setBackground(new Color(0, 128, 192));
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
			gbc_btnNewButton.gridx = 1;
			gbc_btnNewButton.gridy = 4;
			contentPanel.add(btnNewButton, gbc_btnNewButton);
		}
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
