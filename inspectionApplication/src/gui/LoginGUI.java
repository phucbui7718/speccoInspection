package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginGUI {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField usernameText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
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
	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 250, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Login");
		frame.setResizable(false);
		JLabel empLoginLabel = new JLabel("Specco Employee Login");
		empLoginLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		empLoginLabel.setBounds(33, 31, 191, 25);
		frame.getContentPane().add(empLoginLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(104, 113, 95, 20);
		frame.getContentPane().add(passwordField);
		
		usernameText = new JTextField();
		usernameText.setBounds(104, 82, 95, 20);
		frame.getContentPane().add(usernameText);
		usernameText.setColumns(10);
		
		JLabel userNameLabel = new JLabel("Username");
		userNameLabel.setBounds(33, 85, 71, 14);
		frame.getContentPane().add(userNameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(33, 116, 58, 14);
		frame.getContentPane().add(passwordLabel);
		
		JLabel lblForgotYourPassword = new JLabel("Forgot your password?");
		lblForgotYourPassword.setToolTipText("Please come to come to office to get a new password!");
		lblForgotYourPassword.setBounds(56, 175, 134, 25);
		frame.getContentPane().add(lblForgotYourPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char[] passChar = passwordField.getPassword();
				String passStr = new String(passChar);
			if (usernameText.getText().equals("justinoferrer") && passStr.equals("specco")){
				JOptionPane.showMessageDialog(null, "Login sucessfully!", "Login Success", JOptionPane.INFORMATION_MESSAGE);
				frame.dispose();
				InspectionGUI inspFrame = new InspectionGUI();
				inspFrame.inspectionJFrame.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null,"Incorrect pass/username. Please check again!" , "Login Error!", JOptionPane.ERROR_MESSAGE);
			}
			}
		});
		btnNewButton.setBounds(70, 144, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
