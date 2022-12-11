package al.errvini.restaurantapp.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JMenu;
import javax.swing.border.CompoundBorder;

public class LoginView {

	private JFrame frame;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
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
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(192, 192, 192));
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 794, 635);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 768, 596);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		user = new JTextField();
		user.setBounds(174, 66, 183, 26);
		panel_1.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(174, 123, 183, 26);
		panel_1.add(pass);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setBounds(66, 72, 79, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(66, 129, 66, 14);
		panel_1.add(lblNewLabel_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(UIManager.getColor("SplitPane.background"));
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get text from user
				//get text from pasword
				String un=user.getText();
				String pas=pass.getText();
				if(un.equals("admin")&& pas.equals("123")) {
				JOptionPane.showMessageDialog(null, "Login Successful");
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Username or Password");
					
					
				}
				
					
				
			}
			
		});
		btnLogin.setBounds(219, 184, 89, 23);
		panel_1.add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\Java project\\RestaurantErviniApp\\images\\korab.jpg"));
		lblNewLabel_2.setBounds(0, 0, 780, 596);
		panel_1.add(lblNewLabel_2);
		ImageIcon icon =new ImageIcon(this.getClass().getResource("/korab.jpg"));
		
		
	}
}
