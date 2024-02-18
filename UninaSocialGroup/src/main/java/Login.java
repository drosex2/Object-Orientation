
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.Window.Type;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 804, 562);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(900,700);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 278, 663);
		panel.setBackground(new Color(0, 103, 153));
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 96, 278, 271);
	//	BufferedImage bufferedImage = ImageIO.read(new File("C:\\Users\\luigi\\eclipse-workspace\\gui\\imagines\\Napoli_university_seal_alfachannel.png"));
	 //   Image image = bufferedImage.getScaledInstance(600, 400, Image.SCALE_DEFAULT);
		//ImageIcon icon = new ImageIcon(image);
		ImageIcon icon= new ImageIcon(this.getClass().getResource("/png-transparent-university-of-naples-federico-ii-university-of-salerno-universita-degli-studi-di-napoli-federico-ii-professor-university.png"));
		lblNewLabel_2.setIcon(icon);
		panel.add(lblNewLabel_2);

		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(277, 0, 609, 663);
		panel_1.setBackground(new Color(115, 209, 255));
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(144, 207, 411, 44);
		panel_1.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(144, 307, 411, 44);
		panel_1.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(45, 208, 121, 36);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(45, 308, 249, 44);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(286, 363, 140, 36);
		panel_1.add(btnNewButton);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panel);
		frame.getContentPane().add(panel_1);
	}
}
