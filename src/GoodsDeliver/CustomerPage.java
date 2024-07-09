package GoodsDeliver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerPage implements ActionListener {

    private JFrame frame;
    private JTextField nameField, emailField, phoneField, capacityField, startingPointField, destinationField;
    private JButton registerButton;
    private JComboBox<String> roleDropdown;
    private JLabel nameLabel, emailLabel, phoneLabel, capacityLabel, startingPointLabel, destinationLabel,
            startDeliveryDateLabel, estimatedDeliveryDateLabel;

    public CustomerPage() {
        frame = new JFrame("Customer Registration Page");
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        
        // Add components with proper alignment
        gbc.gridx = 0;
        gbc.gridy = 0;
        nameLabel = new JLabel("Name:");
        nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        nameField = new JTextField(20);
        nameField.setHorizontalAlignment(SwingConstants.LEFT);
        frame.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        emailLabel = new JLabel("Email:");
        emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        emailField = new JTextField(20);
        emailField.setHorizontalAlignment(SwingConstants.LEFT);
        frame.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(phoneLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        phoneField = new JTextField(20);
        phoneField.setHorizontalAlignment(SwingConstants.LEFT);
        frame.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        capacityLabel = new JLabel("Capacity(kg):");
        capacityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(capacityLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        capacityField = new JTextField(20);
        capacityField.setHorizontalAlignment(SwingConstants.LEFT);
        frame.add(capacityField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        startingPointLabel = new JLabel("Starting Point of Truck:");
        startingPointLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(startingPointLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        startingPointField = new JTextField(20);
        startingPointField.setHorizontalAlignment(SwingConstants.LEFT);
        frame.add(startingPointField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        destinationLabel = new JLabel("Destination:");
        destinationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(destinationLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        destinationField = new JTextField(20);
        destinationField.setHorizontalAlignment(SwingConstants.LEFT);
        frame.add(destinationField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        startDeliveryDateLabel = new JLabel("Start Delivery Date:");
        startDeliveryDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(startDeliveryDateLabel, gbc);

      
        gbc.gridx = 1;
        gbc.gridy = 8;
        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        frame.add(registerButton, gbc);

        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button click events
        if (e.getSource() == registerButton) {
            // Implement registration logic here
            // You may want to get values from text fields and perform registration
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CustomerPage());
    }
}
