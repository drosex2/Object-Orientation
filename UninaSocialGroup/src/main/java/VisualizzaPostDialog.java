import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class VisualizzaPostDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Controller controller;
    private JLabel lblAutore;
    private JLabel lblNomeAutore;
    private JLabel lblNumInterazioni;
    private JLabel lblInterazioni;
    private Post postReport;
    private int numeroInterazioni;
    
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public VisualizzaPostDialog(Controller gestore,Post post,int numInterazioni) {
		
		controller=gestore;
		postReport=post;
		numeroInterazioni=numInterazioni;
		setModal(true);
		setTitle("Visualizza Post");
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
			lblAutore = new JLabel("Autore del post:");
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
			JLabel lblNomeAutore = new JLabel(post.getUtenteAutore().getUsername());
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
			taDescrizione.setText(post.getTesto());
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
			lblInterazioni = new JLabel("Numero interazioni:");
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
			lblNumInterazioni = new JLabel();
			lblNumInterazioni.setText(String.valueOf(numeroInterazioni));
			lblNumInterazioni.setForeground(new Color(255, 255, 255));
			lblNumInterazioni.setFont(new Font("Tahoma", Font.PLAIN, 16));
			GridBagConstraints gbc_lblNumInterazioni = new GridBagConstraints();
			gbc_lblNumInterazioni.insets = new Insets(0, 0, 5, 5);
			gbc_lblNumInterazioni.gridx = 1;
			gbc_lblNumInterazioni.gridy = 3;
			contentPanel.add(lblNumInterazioni, gbc_lblNumInterazioni);
		}
	}
	

}
