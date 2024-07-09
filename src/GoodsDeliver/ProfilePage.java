package GoodsDeliver;



import javax.swing.*;

import Controller.OfflineDb;
import Model.UserModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class ProfilePage extends JFrame  implements ActionListener {
    JTextField Name,email, phoneNumber, truckNumber, truckCapacity;
    JLabel NameLabel, emailLabel,phoneNumberLabel, roleFieldLabel, truckNumberLabel, truckCapacityLabel, loginButtonLabel, titleLabel;


    JComboBox<String> roles;

    JButton registerButton;
    
    

    public ProfilePage(){
        super("Profile Page");
        
        
        dBManagement dbManagement = new dBManagement();
		OfflineDb offlineDB = new OfflineDb();
		UserModel userModel = null;
		
			try {
				userModel=dbManagement.getUserDetails(offlineDB.loadLoginId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		

        
        // Create an instance of the Menu class
        MenuBar menu = new MenuBar();
        // Add the components to the frame
        JPanel contentPane = new JPanel();

         NameLabel = new JLabel("Name:");
         NameLabel.setBounds(10, 50, 100, 50);
         

         emailLabel = new JLabel("Email:");
         emailLabel.setBounds(10, 100, 120, 50);


        roleFieldLabel = new JLabel("Role: ");
        roleFieldLabel.setBounds(10, 150, 150, 50);



        truckNumberLabel = new JLabel("Truck Number: ");
        truckNumberLabel.setBounds(10, 200, 170, 50);
        truckNumberLabel.setVisible(false);


        truckCapacityLabel = new JLabel("Truck Capacity: ");
        truckCapacityLabel.setBounds(10, 250, 190, 50);
        truckCapacityLabel.setVisible(false);


        contentPane.add(NameLabel);
        contentPane.add(emailLabel);
        contentPane.add(roleFieldLabel);
        contentPane.add(truckNumberLabel);
        contentPane.add(truckCapacityLabel);


        Name = new JTextField();
        Name.setBounds(120, 50, 250, 50);
        Name.setText(userModel.getName());
        Name.setEditable(false);

        email = new JTextField();
        email.setBounds(120, 100, 250, 50);
        email.setText(userModel.getEmail());
        email.setEditable(false);
        
 
        String[] rolesList = { "Customer", "Scheduler", "Driver" };

        roles = new JComboBox<>(rolesList);
        roles.setBounds(120, 150, 250, 50);
        roles.setSelectedItem(userModel.getRole());
        roles.setEnabled(false);
        roles.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setText(value.toString());
                return this;
            }
        });

        System.out.println(userModel.getRole());
        if (userModel.getRole().equals("Driver")) {
        	System.out.println("corret");
            truckNumberLabel.setVisible(true);
            truckNumber = new JTextField();
            truckNumber.setBounds(120, 200, 250, 50);
            truckNumber.setText(userModel.getTrucknumber());
            truckNumber.setVisible(true);
            truckNumber.setEditable(false);

            truckCapacityLabel.setVisible(true);
            truckCapacity = new JTextField();
            truckCapacity.setBounds(120, 250, 250, 50);
            truckCapacity.setText(String.valueOf(userModel.getCapacity()));
            truckCapacity.setVisible(true);
            truckCapacity.setEditable(false);
            contentPane.add(truckNumber);
            contentPane.add(truckCapacity);
        }



        truckNumber = new JTextField();
        truckNumber.setBounds(120, 250, 250, 50);
        truckNumber.setVisible(false);

        truckCapacity = new JTextField();
        truckCapacity.setBounds(120, 250, 250, 50);
        truckCapacity.setVisible(false);



        contentPane.add(Name);
        contentPane.add(email);
        contentPane.add(roles);
        contentPane.add(truckNumber);
        contentPane.add(truckCapacity);
 



        setContentPane(contentPane);
        contentPane.setLayout(null);
        setJMenuBar(menu);

        setVisible(true);
        pack();
        setSize(800, 460);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {


    }
    



}