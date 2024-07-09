package GoodsDeliver;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Controller.OfflineDb;
import Model.UserModel;


public class EditCustomer extends JFrame implements ActionListener {
	JLabel  emailLabel, passwordLabel, NameLabel, phoneNumberLabel, roleLabel,
			registrationNoLabel, capacityLabel,   errorEmailLabel, errorPasswordLabel,
			errorFirstNameLabel, errorLastNameLabel, errorPhoneNumberLabel, errorRegNoLabel, errorCapacityLabel;
	JTextField emailTextField, passwordTextField, firstNameTextField, lastNameTextField, phoneNumberTextField,
			registerationNoTextField, capacityTextField;
	JButton submitButton;
	String[] choices = { "Customer", "Schedular", "Driver" };
	JComboBox<String> roleComboBox;
	JPanel registrationNumberPanel;
	JPanel capacityPanel;

	public EditCustomer() {
		
		MenuBar menuBar =new MenuBar();
		
		
		 
		
		emailLabel = new JLabel("Email :");
		emailLabel.setFont(new Font("Serif", Font.PLAIN, 13));
		passwordLabel = new JLabel("Password :");
		passwordLabel.setFont(new Font("Serif", Font.PLAIN, 13));
		passwordLabel.setBorder(new EmptyBorder(10, 0, 0, 0));

		NameLabel = new JLabel("Name :");
		NameLabel.setFont(new Font("Serif", Font.PLAIN, 13));


		roleLabel = new JLabel("Role :");
		roleLabel.setFont(new Font("Serif", Font.PLAIN, 13));

		registrationNoLabel = new JLabel("Registration Number :");
		registrationNoLabel.setFont(new Font("Serif", Font.PLAIN, 13));

		capacityLabel = new JLabel("Capacity (in KG) :");
		capacityLabel.setFont(new Font("Serif", Font.PLAIN, 13));

		errorEmailLabel = new JLabel("");
		errorEmailLabel.setFont(new Font("Serif", Font.PLAIN, 11));
		errorEmailLabel.setForeground(Color.red);
		errorPasswordLabel = new JLabel("");
		errorPasswordLabel.setFont(new Font("Serif", Font.PLAIN, 11));
		errorPasswordLabel.setForeground(Color.red);
		errorFirstNameLabel = new JLabel("");
		errorFirstNameLabel.setFont(new Font("Serif", Font.PLAIN, 11));
		errorFirstNameLabel.setForeground(Color.red);
		errorLastNameLabel = new JLabel("");
		errorLastNameLabel.setFont(new Font("Serif", Font.PLAIN, 11));
		errorLastNameLabel.setForeground(Color.red);
		errorPhoneNumberLabel = new JLabel("");
		errorPhoneNumberLabel.setFont(new Font("Serif", Font.PLAIN, 11));
		errorPhoneNumberLabel.setForeground(Color.red);
		errorRegNoLabel = new JLabel("");
		errorRegNoLabel.setFont(new Font("Serif", Font.PLAIN, 11));
		errorRegNoLabel.setForeground(Color.red);
		errorCapacityLabel = new JLabel("");
		errorCapacityLabel.setFont(new Font("Serif", Font.PLAIN, 11));
		errorCapacityLabel.setForeground(Color.red);

		emailTextField = new JTextField(20);
		Dimension textFieldSize = new Dimension(200, 30); // Set the desired size
		emailTextField.setMaximumSize(textFieldSize);
		emailTextField.setPreferredSize(textFieldSize);
		emailTextField.setMinimumSize(textFieldSize);

		firstNameTextField = new JTextField(20);
		textFieldSize = new Dimension(200, 30); // Set the desired size
		firstNameTextField.setMaximumSize(textFieldSize);
		firstNameTextField.setPreferredSize(textFieldSize);
		firstNameTextField.setMinimumSize(textFieldSize);

		lastNameTextField = new JTextField(20);
		textFieldSize = new Dimension(200, 30); // Set the desired size
		lastNameTextField.setMaximumSize(textFieldSize);
		lastNameTextField.setPreferredSize(textFieldSize);
		lastNameTextField.setMinimumSize(textFieldSize);

		passwordTextField = new JTextField(20);
		textFieldSize = new Dimension(200, 30); // Set the desired size
		passwordTextField.setMaximumSize(textFieldSize);
		passwordTextField.setPreferredSize(textFieldSize);
		passwordTextField.setMinimumSize(textFieldSize);

		phoneNumberTextField = new JTextField(20);
		textFieldSize = new Dimension(200, 30); // Set the desired size
		phoneNumberTextField.setMaximumSize(textFieldSize);
		phoneNumberTextField.setPreferredSize(textFieldSize);
		phoneNumberTextField.setMinimumSize(textFieldSize);

		registerationNoTextField = new JTextField(20);
		textFieldSize = new Dimension(200, 30); // Set the desired size
		registerationNoTextField.setMaximumSize(textFieldSize);
		registerationNoTextField.setPreferredSize(textFieldSize);
		registerationNoTextField.setMinimumSize(textFieldSize);

		capacityTextField = new JTextField(20);
		textFieldSize = new Dimension(200, 30); // Set the desired size
		capacityTextField.setMaximumSize(textFieldSize);
		capacityTextField.setPreferredSize(textFieldSize);
		capacityTextField.setMinimumSize(textFieldSize);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = 2;
		// gbc.insets = new Insets(0, 0, 0, 0); // Set insets to zero
		gbc.gridwidth = 1;

		// Create a new panel for email components with GridBagLayout
		JPanel emailPanel = new JPanel(new GridBagLayout());
		GridBagConstraints emailGbc = new GridBagConstraints();
		emailGbc.gridx = 0;
		emailGbc.gridy = 0;
		emailGbc.anchor = GridBagConstraints.WEST;
		emailPanel.add(emailLabel, emailGbc);

		emailGbc.gridy = 1;
		emailPanel.add(emailTextField, emailGbc);
		emailGbc.gridy = 2;
		errorEmailLabel.setVisible(false);
		emailPanel.add(errorEmailLabel, emailGbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(0, 0, 0, 0); 
		panel.add(emailPanel, gbc);

		JPanel passwordPanel = new JPanel(new GridBagLayout());
		GridBagConstraints passwordGbc = new GridBagConstraints();
		passwordGbc.gridx = 0;
		passwordGbc.gridy = 0;
		passwordGbc.anchor = GridBagConstraints.WEST;
		passwordPanel.add(passwordLabel, passwordGbc);
		passwordGbc.gridy = 1;
		passwordPanel.add(passwordTextField, passwordGbc);
		passwordGbc.gridy = 2;
		errorPasswordLabel.setVisible(false);
		passwordPanel.add(errorPasswordLabel, passwordGbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.insets = new Insets(0, 20, 10, 0); // Set insets t
		panel.add(passwordPanel, gbc);

		JPanel firstNamePanel = new JPanel(new GridBagLayout());
		GridBagConstraints firstNameGbc = new GridBagConstraints();
		firstNameGbc.gridx = 0;
		firstNameGbc.gridy = 0;
		firstNameGbc.anchor = GridBagConstraints.WEST;
		firstNamePanel.add(NameLabel, firstNameGbc);
		firstNameGbc.gridy = 1;
		firstNamePanel.add(firstNameTextField, firstNameGbc);
		firstNameGbc.gridy = 2;
		errorFirstNameLabel.setVisible(false);
		firstNamePanel.add(errorFirstNameLabel, firstNameGbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(0, 0, 0, 0); // Set insets to zero
		panel.add(firstNamePanel, gbc);

		

		

		roleComboBox = new JComboBox<String>(choices);
		roleComboBox.setBackground(Color.white);
		textFieldSize = new Dimension(200, 30); // Set the desired size
		roleComboBox.setMaximumSize(textFieldSize);
		roleComboBox.setPreferredSize(textFieldSize);
		roleComboBox.setMinimumSize(textFieldSize);
		roleComboBox.setVisible(true);
		roleComboBox.addActionListener(this);
		JPanel rolePanel = new JPanel(new GridBagLayout());
		GridBagConstraints roleGbc = new GridBagConstraints();
		roleGbc.gridx = 0;
		roleGbc.gridy = 0;
		roleGbc.anchor = GridBagConstraints.WEST;
		rolePanel.add(roleLabel, roleGbc);
		roleGbc.gridy = 1;
		rolePanel.add(roleComboBox, roleGbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.insets = new Insets(10, 20, 0, 0); // Set insets to zero
		panel.add(rolePanel, gbc);

		registrationNumberPanel = new JPanel(new GridBagLayout());
		GridBagConstraints registrationNumberGbc = new GridBagConstraints();
		registrationNumberGbc.gridx = 0;
		registrationNumberGbc.gridy = 0;
		registrationNumberGbc.anchor = GridBagConstraints.WEST;
		registrationNumberPanel.add(registrationNoLabel, registrationNumberGbc);
		registrationNumberGbc.gridy = 1;
		registrationNumberPanel.add(registerationNoTextField, registrationNumberGbc);
		registrationNumberGbc.gridy = 2;
		errorRegNoLabel.setVisible(false);
		registrationNumberPanel.add(errorRegNoLabel, registrationNumberGbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.insets = new Insets(10, 0, 0, 0); // Set insets to zero
		panel.add(registrationNumberPanel, gbc);

		capacityPanel = new JPanel(new GridBagLayout());
		GridBagConstraints capacityGbc = new GridBagConstraints();
		capacityGbc.gridx = 0;
		capacityGbc.gridy = 0;
		capacityGbc.anchor = GridBagConstraints.WEST;
		capacityPanel.add(capacityLabel, capacityGbc);
		capacityGbc.gridy = 1;
		capacityPanel.add(capacityTextField, capacityGbc);
		capacityGbc.gridy = 2;
		errorCapacityLabel.setVisible(false);
		capacityPanel.add(errorCapacityLabel, capacityGbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.insets = new Insets(10, 20, 0, 0); // Set insets to zero
		panel.add(capacityPanel, gbc);

		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		submitButton.setMargin(new Insets(5, 50, 5, 50));
		submitButton.setFocusPainted(false);
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.CENTER;
		JPanel buttonPanel = new JPanel(new GridBagLayout());
		GridBagConstraints buttonGbc = new GridBagConstraints();
		buttonGbc.gridx = 1;
		buttonGbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(20, 0, 0, 0); // Set insets to zero
		buttonGbc.anchor = GridBagConstraints.CENTER;
		buttonPanel.add(submitButton, buttonGbc);
		panel.add(buttonPanel, gbc);
		this.add(panel);
		
		dBManagement dbManagement = new dBManagement();
		OfflineDb offlineDB = new OfflineDb();
		UserModel usermodel = null;
		try {
			usermodel=dbManagement.getUserDetails(offlineDB.loadLoginId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(usermodel!=null) {
		emailTextField.setText(usermodel.getEmail());
		passwordTextField.setText(usermodel.getPass());
		firstNameTextField.setText(usermodel.getName());
		registerationNoTextField.setText(usermodel.getTrucknumber());
		capacityTextField.setText(String.valueOf(usermodel.getCapacity()));
		if(usermodel.getRole().contains("Customer")) {			
			roleComboBox.setSelectedIndex(0);
			registrationNumberPanel.setVisible(false);
			capacityPanel.setVisible(false);
		}else if(usermodel.getRole().contains("Schedular")) {
			roleComboBox.setSelectedIndex(1);
			registrationNumberPanel.setVisible(false);
			capacityPanel.setVisible(false);
		}else if(usermodel.getRole().contains("Driver")) {
			roleComboBox.setSelectedIndex(2);
			registrationNumberPanel.setVisible(true);
			capacityPanel.setVisible(true);
		}else {
			registrationNumberPanel.setVisible(false);
			capacityPanel.setVisible(false);
		}
		
		passwordTextField.setEditable(true);
		passwordTextField.setEnabled(true);
		roleComboBox.setEnabled(true);
		roleComboBox.setEditable(true);
		emailTextField.setEnabled(true);
		emailTextField.setEditable(true);
		}
		
		 setContentPane(panel);
	       // contentPane.setLayout(null);
	        setJMenuBar(menuBar);

	        setVisible(true);
	        pack();
	        setSize(800, 460);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String role = choices[roleComboBox.getSelectedIndex()];
		if (e.getSource() == roleComboBox) {
			if (role == "Driver") {
				registrationNumberPanel.setVisible(true);
				capacityPanel.setVisible(true);
			} else {
				registrationNumberPanel.setVisible(false);
				capacityPanel.setVisible(false);
			}
		}
		if (e.getSource() == submitButton ) {

			
				System.out.println("HEREEE");

				errorEmailLabel.setVisible(false);
				errorPasswordLabel.setVisible(false);
				errorFirstNameLabel.setVisible(false);
				errorLastNameLabel.setVisible(false);
				errorPhoneNumberLabel.setVisible(false);
				errorRegNoLabel.setVisible(false);
				errorCapacityLabel.setVisible(false);
//				dBManagement dbManagementment = new dBManagement();
				String email = emailTextField.getText();
				String name = firstNameTextField.getText();
				String trucknumber = "";
				int capacity = 0;
				if (role == "Driver") {
					trucknumber = registerationNoTextField.getText();
					capacity = Integer.parseInt(capacityTextField.getText());
				}
				UserModel usermodel = new UserModel(capacity,name, email,role, trucknumber);
				System.out.println(usermodel);

				try {
			
					boolean check = dBManagement.editProfile(usermodel);
					
					if(check) {
						JOptionPane.showMessageDialog(this, "Update is sucessful", "Success", JOptionPane.INFORMATION_MESSAGE);
					
					}else {
						JOptionPane.showMessageDialog(this, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
					
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
	}
	}
	
}