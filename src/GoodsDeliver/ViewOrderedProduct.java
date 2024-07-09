package GoodsDeliver;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;

public class ViewOrderedProduct extends JFrame {
	
	

    private JTable userTable;
    private DefaultTableModel tableModel;

public ViewOrderedProduct() {
	   super("List Orders Page");

       // Create an instance of the Menu class
       MenuBar menu = new MenuBar();

       // Create a panel to hold the label and table
       JPanel mainPanel = new JPanel(new BorderLayout());

       // Create a label for the title
       JLabel titleLabel = new JLabel("Order Information");
       titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
       titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

       // Add the label to the panel
       mainPanel.add(titleLabel, BorderLayout.NORTH);

       // Create columns for the table
       String[] columns = {"ID", "Product Name", "Quantity", "Address of Delivery", "Delivery Date", "Order Status"};
       tableModel = new DefaultTableModel(null, columns);
       userTable = new JTable(tableModel);

       // Set the table header
       JTableHeader tableHeader = userTable.getTableHeader();
       tableHeader.setFont(new Font("Arial", Font.BOLD, 14)); // Adjust font for header
       tableHeader.setBackground(Color.LIGHT_GRAY); // Adjust background color for header

       userTable.setGridColor(Color.BLACK);
       userTable.setShowGrid(true);
       userTable.setIntercellSpacing(new Dimension(1, 1)); // Adjust spacing between cells

       JScrollPane scrollPane = new JScrollPane(userTable);

       // Add the table to the panel
       mainPanel.add(scrollPane, BorderLayout.CENTER);
       mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

       // Add the panel to the frame's content pane
       getContentPane().add(mainPanel);


       setJMenuBar(menu);
       // Set frame properties
       setSize(1000, 800);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);

       // Add static data to the table
       userOrderData();
   }

   private void userOrderData() {

       Vector<Vector<Object>> data = dBManagement.getUserOrders();
       for (Vector<Object> row : data) {
           tableModel.addRow(row);
       }
   }

}
