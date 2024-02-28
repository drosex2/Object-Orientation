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
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsername;
	private JLabel lblIcon;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JLabel lblSignIn;
	private JPasswordField tfPassword;
	private GestoreApplicazione controller;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginPage frame = new LoginPage();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public LoginPage(GestoreApplicazione gestore) {
		controller=gestore;
		setTitle("Login");
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
		gbl_panelRight.columnWidths = new int[]{0, 81, 186, 0};
		gbl_panelRight.rowHeights = new int[]{5, 5, 5, 52, 36, 36, 9, 97, 5, 5, 0};
		gbl_panelRight.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelRight.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panelRight.setLayout(gbl_panelRight);
		
		lblSignIn = new JLabel("Sign In");
		lblSignIn.setForeground(new Color(255, 255, 255));
		lblSignIn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblSignIn = new GridBagConstraints();
		gbc_lblSignIn.anchor = GridBagConstraints.SOUTH;
		gbc_lblSignIn.insets = new Insets(0, 0, 5, 0);
		gbc_lblSignIn.gridx = 2;
		gbc_lblSignIn.gridy = 3;
		panelRight.add(lblSignIn, gbc_lblSignIn);
		
		lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.fill = GridBagConstraints.VERTICAL;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 4;
		panelRight.add(lblUsername, gbc_lblUsername);
		
		tfUsername = new JTextField();
		tfUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfUsername.setColumns(14);
		GridBagConstraints gbc_tfUsername = new GridBagConstraints();
		gbc_tfUsername.fill = GridBagConstraints.VERTICAL;
		gbc_tfUsername.ipady = 4;
		gbc_tfUsername.insets = new Insets(0, 0, 5, 0);
		gbc_tfUsername.gridx = 2;
		gbc_tfUsername.gridy = 4;
		panelRight.add(tfUsername, gbc_tfUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.VERTICAL;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 5;
		panelRight.add(lblPassword, gbc_lblPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setToolTipText("Sign In");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(0, 128, 192));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usernameInserito=tfUsername.getText();
				String passwordInserita=new String(tfPassword.getPassword());
				if (usernameInserito.isEmpty())
				{
					mostraMessageDialog("Inserire un username!","ATTENZIONE");
				}
				else if(passwordInserita.isEmpty())
				{
					mostraMessageDialog("Inserire una password!","ATTENZIONE");
				}
				else
				{	
					boolean esitoLogin=controller.controllaLogin(usernameInserito, passwordInserita);
					if(!esitoLogin)
					{
						mostraMessageDialog("Account non esistente! Username e/o password errati!","ATTENZIONE");
					}
					else
					{
						tfUsername.setText(null);
						tfPassword.setText(null);
					}
				}
					
			}
		});
		
		tfPassword = new JPasswordField();
		tfPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfPassword.setColumns(14);
		GridBagConstraints gbc_tfPassword = new GridBagConstraints();
		gbc_tfPassword.fill = GridBagConstraints.VERTICAL;
		gbc_tfPassword.insets = new Insets(0, 0, 5, 0);
		gbc_tfPassword.gridx = 2;
		gbc_tfPassword.gridy = 5;
		panelRight.add(tfPassword, gbc_tfPassword);
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.ipadx = 30;
		gbc_btnLogin.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogin.gridx = 2;
		gbc_btnLogin.gridy = 6;
		panelRight.add(btnLogin, gbc_btnLogin);
	}
	private void mostraMessageDialog(String testo, String titolo) {
		JOptionPane.showMessageDialog(this, testo, titolo, JOptionPane.INFORMATION_MESSAGE);
	}
}
