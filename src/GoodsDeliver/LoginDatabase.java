package GoodsDeliver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Controller.OfflineDb;

public class LoginDatabase {
	
	public static String LoginPages(String email,String pass) throws SQLException {

		System.out.println("Getting data from a DB");
		String url = "jdbc:MySQL://localhost:3306/"; 
		String dbname="goodsdeviler";
		String user ="root";                                                  
		String password = "root";
		//1. Create the connection			
			  try (Connection connection = DriverManager.getConnection(url+dbname,user,password)) {
		            // Check user credentials against the database
		            String query = "SELECT * FROM registration WHERE email = ? AND pass = ?";
		            try (PreparedStatement statement = connection.prepareStatement(query)) {
		                statement.setString(1, email);
		                statement.setString(2, new String(pass));
		                ResultSet resultSet = statement.executeQuery();

		                if (resultSet.next()) {
		                    // Login successful
		                	OfflineDb offlineDB = new OfflineDb();
		        			offlineDB.saveLoginStatus(true);
		        			offlineDB.saveLoginID(resultSet.getInt("id"));
		                	
		                	return "Login Successfull";
		                } else {
		                    // Login failed
		                	return "Invalid email or password";
		                	
		                	
		                }
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            return "Database error";
		        }
	}	

}
