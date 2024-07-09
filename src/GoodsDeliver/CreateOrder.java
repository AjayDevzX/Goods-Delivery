package GoodsDeliver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.toedter.calendar.JDateChooser;

import Model.OrderInformation;


 public class CreateOrder extends JFrame implements ActionListener {

    public JTextField nameField, emailField, quantityField, addressField;
    public JComboBox<String> productDropdown;
    public JButton orderButton;
    public JDateChooser date;
 //   public JDatePickerImpl datePicker;

    public CreateOrder() throws SQLException {
        super("Order Page");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);


        MenuBar menu = new MenuBar();

        // Product
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Product:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        
       
		Map<Integer, String> productMap =  dBManagement.getProducts();
		
        
        String[] productNames = productMap.values().toArray(new String[0]);

        productDropdown = new JComboBox<>(productNames);
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
        date = new JDateChooser();
        add(date, gbc);
   

        // Order Button
        gbc.gridx = 1;
        gbc.gridy = 6;
        orderButton = new JButton("Place Order");
        add(orderButton, gbc);
        orderButton.addActionListener(this);
        
        setJMenuBar(menu);

        setSize(800, 460);
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
    	
    	boolean valid = validation();
    	if(!valid) {
    		return;
    	}
    	
    	//get product id 
    	  int productId;
		try {
			productId = dBManagement.getProductByName(String.valueOf(productDropdown.getSelectedItem()));
			 if (productId == 0) {
	              JOptionPane.showMessageDialog(this, "Product not found", "Error", JOptionPane.ERROR_MESSAGE);
	              return;
	          }
			 
			 int quantity = Integer.parseInt(quantityField.getText());
		        String address = addressField.getText();
		        String deliveryDate = getDateFormatted(date.getDate());
		        
		        
		        OrderInformation orderInformation = new OrderInformation(productId,quantity,address, deliveryDate);
		        
		        String responseInfo = (String) dBManagement.orderProductIntoDB(orderInformation);
		        
		        if(responseInfo.equals("order created successfully")) {
		              JOptionPane.showMessageDialog(this, "Order Created Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
		        }else {
		              JOptionPane.showMessageDialog(this,responseInfo, "Error", JOptionPane.ERROR_MESSAGE);

		        }
		        
		        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
    
    
    
    public boolean validation() {
        boolean isValid = true;
        StringBuilder errorMessage = new StringBuilder();
        System.out.println(date.getDate());

        if (quantityField.getText().isEmpty() || addressField.getText().isEmpty() || date.getDate() == null || productDropdown.getSelectedItem() == null) {
            errorMessage.append("All Fields Are Required\n");
            isValid = false;
        }

        if (productDropdown.getSelectedItem() == null) {
            errorMessage.append("You need to select a product\n");
            isValid = false;
        }

        if (addressField.getText().isEmpty()) {
            errorMessage.append("Address is required\n");
            isValid = false;
        }

        if (quantityField.getText().isEmpty()) {
            errorMessage.append("Quantity is required\n");
            isValid = false;
        }

        if (date.getDate() == null) {
            errorMessage.append("Date is required\n");
            isValid = false;
        }

        


        // Display the first error encountered, if any
        if (!isValid) {
            JOptionPane.showMessageDialog(this, errorMessage.toString().trim(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return isValid;

    }

    
    public static String  getDateFormatted(Date $date) {
        String pattern = "yyyy-MM-dd HH:mm:ss"; // Example pattern, adjust as needed
        
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);


        return dateFormat.format($date);
    }
    
    
}
