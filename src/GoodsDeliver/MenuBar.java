package GoodsDeliver;

import javax.swing.*;

import Controller.OfflineDb;
import Model.UserModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MenuBar extends JMenuBar implements ActionListener {

    JMenu homeMenu,profileMenu,ordersMenu,missionOverviewMenu, driversMenu, logoutMenu, productsMenu;
    JMenuItem viewProfile, editProfile,viewOrders, createOrders, viewDeliverables, completeDeliverable, generateReport, assignOrdersToDrivers , viewAssignedOrders , addProduct, viewProducts, homeMenuItems, changePasswordItem, logoutMenuItems;
    Box horizontalBox;
   // SessionData sessionData = SessionManagerMain.loadUserFromFile();

    public MenuBar(){


        homeMenu = new JMenu("Home");
        profileMenu = new JMenu("Profile");


        ordersMenu = new JMenu("Orders");
     

        createOrders = new JMenuItem("Create Orders");
        viewOrders = new JMenuItem("View Orders");


        viewDeliverables = new JMenuItem("View Deliverables");

        completeDeliverable = new JMenuItem("Completed Deliverables");

        viewProfile = new JMenuItem("View Profile");
        editProfile = new JMenuItem("Edit Profile");
        generateReport = new JMenuItem("");
      

        homeMenuItems = new JMenuItem("Home");
        logoutMenuItems = new JMenuItem("Logout");


        viewProfile.addActionListener(this);
        editProfile.addActionListener(this);
      

        createOrders.addActionListener(this);
        viewOrders.addActionListener(this);

        profileMenu.add(viewProfile);
        profileMenu.add(editProfile);
        


        ordersMenu.add(createOrders);
        ordersMenu.add(viewOrders);
      
 
        homeMenu.add(homeMenuItems);
        homeMenuItems.addActionListener(this);

        logoutMenu = new JMenu("Logout");

        logoutMenu.add(logoutMenuItems);

             logoutMenuItems.addActionListener(this);


        dBManagement dbManagement = new dBManagement();
		OfflineDb offlineDB = new OfflineDb();
		UserModel userModel = null;
		
			try {
				userModel=dbManagement.getUserDetails(offlineDB.loadLoginId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			
        
        String userRole = userModel.getRole();
        if (userRole.equals("customer")){
            profileMenu.setVisible(true);
            ordersMenu.setVisible(true);
          
        }
        if (userRole.equals("scheduler")){
            profileMenu.setVisible(true);
            ordersMenu.setVisible(false);
            createOrders.setVisible(false);

        }

        if (userRole.equals("driver")){
            profileMenu.setVisible(true);
            createOrders.setVisible(false);
            ordersMenu.setVisible(false);


        }
        add(homeMenu);
        add(profileMenu);
        add(ordersMenu);

       add(logoutMenu);


    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == homeMenuItems){
            disposeCurrentFrame();
         //   new HomeGui();
        }
//
        if (e.getSource() == viewProfile) {
            disposeCurrentFrame();
           new ProfilePage();
        }

        if (e.getSource() == editProfile) {
            disposeCurrentFrame();
              new EditCustomer();
        }

        if (e.getSource() == createOrders) {
            try {
	            disposeCurrentFrame();
				new CreateOrder();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        
        if(e.getSource() == viewOrders) {
        	
        	   disposeCurrentFrame();
            new ViewOrderedProduct();
        }


        if (e.getSource() == viewProducts) {
         
       
        }

      

        if (e.getSource() == logoutMenuItems){
        	
        	 OfflineDb offlineDB = new OfflineDb();             
        	offlineDB.saveLoginStatus(false);
                JOptionPane.showMessageDialog(this, "User successfully logged out.", "User successfully logged out", JOptionPane.INFORMATION_MESSAGE);
                disposeCurrentFrame();
         
            }
        


    }

    private void disposeCurrentFrame() {
        SwingUtilities.getWindowAncestor(this).dispose();
    }

}