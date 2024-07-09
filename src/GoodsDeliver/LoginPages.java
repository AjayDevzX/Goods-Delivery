package GoodsDeliver;

import java.awt.BorderLayout;
import GoodsDeliver.RegistrationPage;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Controller.OfflineDb;


public class LoginPages extends JFrame implements ActionListener{

	public JFrame frame;
	public JTextField emailField,passwordField;	
	public JLabel emailLabel,passwordLabel;	
	public JButton loginButton, registerButton;
	
	public LoginPages(){
		
		
		
		frame = new JFrame("Login Page");
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

		gbc.gridx = 0;
        gbc.gridy = 0;
        emailLabel = new JLabel("Email ");
        frame.add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        emailField = new JTextField(20);
        frame.add(emailField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        passwordLabel = new JLabel("password ");
        frame.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        passwordField = new JTextField(20);
        frame.add(passwordField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        loginButton = new JButton("Login");
        frame.add(loginButton, gbc);
        loginButton.addActionListener(this);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        registerButton = new JButton("Register");
        frame.add(registerButton, gbc);
        registerButton.addActionListener(this);

       // frame.setSize(400, 300);
        frame.setSize(800, 460);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	
        
		
   this.setLayout(new FlowLayout());	
	}
public static void main(String args[]) {
    SwingUtilities.invokeLater(() -> new LoginPages());
}

@Override
public void actionPerformed(ActionEvent e) {
        
	 if (e.getSource() == loginButton){
		    validation();
		    
		    try {
				String response = LoginDatabase.LoginPages(emailField.getText(),  passwordField.getText());
				if (response.equals("Login Successfull")) {
	                // Show success message
	               JOptionPane.showMessageDialog(null, response, "Success", JOptionPane.INFORMATION_MESSAGE);
	             
	               
	               OfflineDb offlineDB = new OfflineDb();
	               offlineDB.saveLoginStatus(true);

	                new HomePage();
	                
	                
	                // Close the current screen
	               dispose();
	            } else {
	            	JOptionPane.showMessageDialog(null, response, "Error", JOptionPane.INFORMATION_MESSAGE);
	                
	                dispose();
	            	
	            }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	       
	  } else if (e.getSource() == registerButton) {
	        frame.setVisible(false); 
	        new RegistrationPage();
	  }
	 
	 
    }


public void validation() {
	
	if (emailField.getText().isEmpty() || passwordField.getText().isEmpty()) {
		JOptionPane.showMessageDialog(this, "All Fields Are Required");
	}

	
}



}


