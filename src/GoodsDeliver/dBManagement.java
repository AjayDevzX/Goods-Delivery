package GoodsDeliver;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import Controller.OfflineDb;
import Model.OrderInformation;
import Model.UserModel;

public class dBManagement {


	public static void insertRegistration(String name,String email,String pass,String role,int capacity,String trucknumber) throws SQLException {
		System.out.println("Inserting DATA");
		String url = "jdbc:MySQL://localhost:3306/"; 
		String dbname="goodsdeviler";
		String user ="root";                                                  
		String password = "root";
		//1. Create the connection
		Connection conn = DriverManager.getConnection(url+dbname,user,password);
		//2. Create The statement
		Statement stmt = conn.createStatement();
		//3. Prepare The Query
		String sql = "insert registration (name,email,pass,role,capacity,trucknumber) VALUES ( "
					+"'"+name+"','"+email+"','"+pass+"','"+role+"',"+capacity+",'"+trucknumber+"')";
		//4. Execute The Query
		stmt.executeUpdate(sql);
		System.out.println("1 row affected.");

         //5. Close the connection
			conn.close();
			
			}
	
	
	public static void main(String email,String pass) throws SQLException {

		System.out.println("Getting data from a DB");
		String url = "jdbc:MySQL://localhost:3306/"; 
		String dbname="goodsdeviler";
		String user ="root";                                                  
		String password = "root";
		//1. Create the connection
		Connection conn = DriverManager.getConnection(url+dbname,user,password);
		//2. Create The statement
		Statement stmt = conn.createStatement();
		//3. Prepare The Query
		String sql = "select * from registration where email= AND ";
		//4. Execute The Query
		ResultSet rs=stmt.executeQuery(sql);
		//5. Displaying the Result
      while(rs.next())
    	  
      {
     	 int Id=rs.getInt("ID");
     	 String name=rs.getString("name");
     	 int salary=rs.getInt("salary");
     	 System.out.println("[ID= "+Id+" ,Name= "+name+", Salary= "+salary+" ]");
      }	 
     	 
     	 
		//4. Close connection
			conn.close();
			}	
	
	
	public UserModel getUserDetails(int userID) throws SQLException {
		System.out.println("Getting data from a DB");
		String url = "jdbc:MySQL://localhost:3306/";
		String dbname = "goodsdeviler";
		String user = "root";
		String password = "root";
		// 1. Create the connection
		Connection conn = DriverManager.getConnection(url + dbname, user, password);
		// 2. Create The statement
		Statement stmt = conn.createStatement();
		// 3. Prepare The Query
		String sql = "select * from registration where id=" + userID + "";
		// 4. Execute The Query
		ResultSet rs = stmt.executeQuery(sql);
		UserModel userModel = null;
		// 5. Displaying the Result
		while (rs.next()) {
			String email = rs.getString("email");
			String pass = rs.getString("pass");
			String name = rs.getString("name");
			String role = rs.getString("role");
			String trucknumber = rs.getString("trucknumber");
			int capacity = rs.getInt("capacity");
			userModel = new UserModel(capacity,name,email,pass,role,trucknumber);

		}

		// 4. Close connection
		conn.close();
		return userModel;
	}
	
	
	public static Map<Integer, String>  getProducts() throws SQLException {
        Map<Integer, String> productMap = new HashMap<>();

		
		System.out.println("Getting data from a DB");
		String url = "jdbc:MySQL://localhost:3306/";
		String dbname = "goodsdeviler";
		String user = "root";
		String password = "root";
		// 1. Create the connection
		Connection conn = DriverManager.getConnection(url + dbname, user, password);
		// 2. Create The statement
		Statement stmt = conn.createStatement();
		// 3. Prepare The Query
		String sql = "select * from products";
		// 4. Execute The Query
		ResultSet rs = stmt.executeQuery(sql);
		// 5. Displaying the Result
		while (rs.next()) {
			  int id = rs.getInt("id");
              String productName = rs.getString("product_name");

              // Add the data to the collection
              productMap.put(id, productName);

		}

		// 4. Close connection
		conn.close();
		return productMap;
	}
			
	public static Integer getProductByName(String name) throws SQLException {
	    int productId = 0;

	    System.out.println("Getting data from a DB");

	    String url = "jdbc:MySQL://localhost:3306/";
	    String dbname = "goodsdeviler";
	    String user = "root";
	    String password = "root";

	    // Use try-with-resources to automatically close resources (Connection, Statement, ResultSet)
	    try (Connection conn = DriverManager.getConnection(url + dbname, user, password);
	         PreparedStatement pstmt = conn.prepareStatement("SELECT id FROM products WHERE product_name = ?");
	    ) {
	        // Set parameter to avoid SQL injection
	        pstmt.setString(1, name);

	        // Execute the query
	        try (ResultSet rs = pstmt.executeQuery()) {
	            // Displaying the result
	            while (rs.next()) {
	                productId = rs.getInt("id");
	            }
	        }
			conn.close();

	    }

	    return productId;
	}

	public static boolean editProfile(UserModel userModel) throws SQLException {
		boolean check = false;
		System.out.println("Inserting DATA");
		String url = "jdbc:MySQL://localhost:3306/";
		String dbname = "goodsdeviler";
		String user = "root";
		String password = "root";
		// 1. Create the connection
		Connection conn = DriverManager.getConnection(url + dbname, user, password);
		// 2. Create The statement
		Statement stmt = conn.createStatement();
		OfflineDb offlineDB = new OfflineDb();
		// 3. Prepare The Query
		String sql = "update registration SET " + "email='" + userModel.getEmail() + "',pass= '"
				+ userModel.getPass() + "',name= '" + userModel.getName() +  "',role= '"
				+ userModel.getRole() + "',trucknumber= '" + userModel.getTrucknumber() + "',capacity= "
				+ userModel.getCapacity() + "" + " where id=" + offlineDB.loadLoginId() + "";
		System.out.println(sql);
		// 4. Execute The Query
		stmt.executeUpdate(sql);
		// ResultSet rs = stmt.executeQuery(sql);
		System.out.println("1 row affected.");
		// while (rs.next()) {
		check = true;

		// }
		// 5. Close the connection
		conn.close();
		return check;
	}
	
	
	
	

	public static String orderProductIntoDB(OrderInformation orderInformation) throws SQLException {
	    int status = 0;
	    System.out.println("Inserting DATA");

	    String url = "jdbc:MySQL://localhost:3306/";
	    String dbname = "goodsdeviler";
	    String user = "root";
	    String password = "root";

	    // Use try-with-resources to automatically close resources (Connection, Statement)
	    try (Connection conn = DriverManager.getConnection(url + dbname, user, password)) {
	        // Prepare the query with parameters
	        String sql = "INSERT INTO `orders` (product_id, quantity, user_id, delivery_address, delivery_date, status, date_created) VALUES (?, ?, ?, ?, ?, ?,?)";
	        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	    		OfflineDb offlineDB = new OfflineDb();

	            // Set parameters to avoid SQL injection
	            pstmt.setInt(1, orderInformation.getProductId());
	            pstmt.setInt(2, orderInformation.getQuantity());
	            pstmt.setInt(3, offlineDB.loadLoginId());
	            pstmt.setString(4, orderInformation.getDeliveryAddress());
	            pstmt.setString(5, orderInformation.getDeliveryDate());
	            pstmt.setString(6, "ordered");
	            pstmt.setTimestamp(7,  new Timestamp(System.currentTimeMillis()));

	            // Execute the update
	            int count = pstmt.executeUpdate();
	            if (count > 0) {
	           
	                status = 1;
	                return "order created successfully";
	            } else {
	                System.out.println("No rows affected.");
	                return "something went wrong try again";

	            }
	        }

	    }


	}
	
	
	   public static Vector<Vector<Object>> getUserOrders() {
	        Vector<Vector<Object>> orderData = new Vector<>();
	        

		    String url = "jdbc:MySQL://localhost:3306/";
		    String dbname = "goodsdeviler";
		    String user = "root";
		    String password = "root";

	        try (Connection connection = DriverManager.getConnection(url + dbname, user, password)) {
	            // Prepare the SQL statement with placeholders

	            String selectOrdersSql =  "SELECT o.*, p.product_name " +
	                    "FROM orders o " +
	                    "INNER JOIN products p ON o.product_id = p.id " +
	                    "WHERE o.user_id = ? " + "ORDER BY o.date_created DESC";

	            PreparedStatement selectStatement = connection.prepareStatement(selectOrdersSql);
	            try (selectStatement) {
		    		OfflineDb offlineDB = new OfflineDb();

	                // Set values for the placeholders
	                selectStatement.setInt(1, offlineDB.loadLoginId());
	                ResultSet resultSetUserOrders = selectStatement.executeQuery();
	                try (resultSetUserOrders) {
	                    while (resultSetUserOrders.next()) {
	                        // Extract data from the result set
	                        int orderId = resultSetUserOrders.getInt("id");
	                        String productName = resultSetUserOrders.getString("product_name");
	                        String deliveryAddress = resultSetUserOrders.getString("delivery_address");
	                        String deliveryDate = resultSetUserOrders.getString("delivery_date");
	                        String orderStatus = resultSetUserOrders.getString("status");
	                        int quantity = resultSetUserOrders.getInt("quantity");
	                        Timestamp dateCreated = resultSetUserOrders.getTimestamp("date_created");

	                        // Add the data to the collection
	                        Vector<Object> row = new Vector<>();
	                        row.add(orderId);
	                        row.add(productName);
	                        row.add(quantity);
	                        row.add(deliveryAddress);
	                        row.add(deliveryDate);
	                        row.add(orderStatus);
	                        row.add(dateCreated);
	                        orderData.add(row);
	                    }

	                    if (orderData.isEmpty()) {
	                        System.out.println("No Order found");
	                    }
	                    return orderData;
	                }
	            }
	        } catch (SQLException e) {
	            System.out.println("Error: " + e.getMessage());
	            return null; // or return an empty Vector if you prefer
	        }
	    }
	

	
}