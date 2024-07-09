package GoodsDeliver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;




 public class OrderPage extends JFrame implements ActionListener {

    public JTextField nameField, emailField, quantityField, addressField;
    public JComboBox<String> productDropdown;
    public JButton orderButton;
 //   public JDatePickerImpl datePicker;

    public OrderPage() {
        super("Order Page");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        nameField = new JTextField(20);
        add(nameField, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        emailField = new JTextField(20);
        add(emailField, gbc);

        // Product
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Product:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        String[] products = {"Product A", "Product B", "Product C"};
        productDropdown = new JComboBox<>(products);
        add(productDropdown, gbc);

        // Quantity
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Quantity (Kg):"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        quantityField = new JTextField(20);
        add(quantityField, gbc);

        // Address
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Address:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        addressField = new JTextField(20);
        add(addressField, gbc);

        // Delivery Date
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Delivery Date:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
      //  datePicker = Utility.createDatePicker(); // Assume you have a utility method for creating JDatePicker
       // add(datePicker, gbc);

        // Order Button
        gbc.gridx = 1;
        gbc.gridy = 6;
        orderButton = new JButton("Place Order");
        add(orderButton, gbc);
        orderButton.addActionListener(this);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == orderButton) {
            placeOrder();
        }
    }

    private void placeOrder() {
        // Get user input
        String name = nameField.getText();
        String email = emailField.getText();
        String product = productDropdown.getSelectedItem().toString();
        double quantity = Double.parseDouble(quantityField.getText());
        String address = addressField.getText();
    //    Date deliveryDate = (Date) datePicker.getModel().getValue();

        // Process the order (you can perform further actions here)
        // For now, display the order information
      //  String orderDetails = String.format("Name: %s\nEmail: %s\nProduct: %s\nQuantity: %.2f Kg\nAddress: %s\nDelivery Date: %s",
       //         name, email, product, quantity, address, new SimpleDateFormat("dd-MM-yyyy").format(deliveryDate));

       // JOptionPane.showMessageDialog(this, orderDetails, "Order Details", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(OrderPage::new);
    }
}
