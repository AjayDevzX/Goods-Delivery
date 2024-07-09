package GoodsDeliver;

import javax.swing.*;
import GoodsDeliver.LoginPages;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;


public class RegistrationPage extends JFrame implements ActionListener {

    
    public JTextField nameField, emailField, passwordField, capacityField, truckNoField;
    public JButton registerButton;
    public JComboBox<String> roleDropdown;
    public JLabel nameLabel, emailLabel, passwordLabel, capacityLabel, truckNoLabel;
    String[] roleItems = {"Driver", "Scheduler", "Customer"};
    public RegistrationPage () {
    	super("Registration Page");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

       
        gbc.gridx = 0;
        gbc.gridy = 0;
        nameLabel = new JLabel("Name:");
        add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        nameField = new JTextField(20);
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        emailLabel = new JLabel("Email:");
        add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        emailField = new JTextField(20);
        add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        passwordLabel = new JLabel("Password:");
        add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        passwordField = new JTextField(20);
        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Role:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
       
        roleDropdown = new JComboBox<>(roleItems);
        roleDropdown.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // Show/hide fields based on selected role
                handleRoleDropdownChange(e);
            }
        });
        add(roleDropdown, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        capacityLabel = new JLabel("Capacity:");
        add(capacityLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        capacityField = new JTextField(20);
        add(capacityField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        truckNoLabel = new JLabel("Truck No:");
        add(truckNoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        truckNoField = new JTextField(20);
        add(truckNoField, gbc);

      

        gbc.gridx = 1;
        gbc.gridy = 6;
        registerButton = new JButton("Register");
        add(registerButton, gbc);
        registerButton.addActionListener(this);
        
        
        Button hyperlinkButton = new Button("Click me!");

       // frame.setSize(400, 300);
        setSize(800, 460);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
    }

    private void handleRoleDropdownChange(ItemEvent e) {
        // Use toString() to get the string representation of the selected item
        String selectedRole = e.getItem().toString();

        if ("Driver".equals(selectedRole)) {
            // Show the "capacity" and "truckNo" fields
            capacityField.setVisible(true);
            truckNoField.setVisible(true);

            // Enable the corresponding labels
            capacityLabel.setVisible(true);
            truckNoLabel.setVisible(true);
        } else {
            // Hide the "capacity" and "truckNo" fields
            capacityField.setVisible(false);
            truckNoField.setVisible(false);

            // Disable the corresponding labels
            capacityLabel.setVisible(false);
            truckNoLabel.setVisible(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrationPage());
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == registerButton) {
			
			validation();
			
			String name,email,pass,role,trucknumber;
			int capacity;
			name=nameField.getText();
			email=emailField.getText();
			pass=passwordField.getText();
			role=roleItems[roleDropdown.getSelectedIndex()];	
			if (role.equals("Driver")) {
				capacity = Integer.parseInt(capacityField.getText());
				trucknumber=truckNoField.getText();
			}else {
				capacity = 0;
				trucknumber = "";
			}
			
			
			
			JOptionPane.showMessageDialog(this, "Successfully Registered");
			
			try {
				dBManagement.insertRegistration(name, email, pass,role, capacity, trucknumber);
				
			    new LoginPages();
			    dispose();
			    
					
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}          
		         
			
            }
		
		// TODO Auto-generated method stub
		
	}
	
	
	public void validation() {
		
		if (nameField.getText().isEmpty() || passwordField.getText().isEmpty() || emailField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "All Fields Are Required");
		}
		
		if
		(roleDropdown.getSelectedItem().equals("Driver")
		&& (truckNoField.getText().isEmpty() || capacityField.getText().isEmpty())){
			
		}
				
		
		if (roleDropdown.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(this, "You have to select one degree input");
		}


		
	}

}

