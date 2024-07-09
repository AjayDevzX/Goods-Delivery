package Model;

public class UserModel {
	
	private int id,capacity;
	private String name,email,pass,role,trucknumber;
	
	
	public UserModel(int capacity, String name, String email, String pass, String role, String trucknumber) {
		super();
		
		this.capacity = capacity;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.role = role;
		this.trucknumber = trucknumber;
	}
	
	public UserModel(int capacity, String name, String email, String role, String trucknumber) {
		
		this.capacity = capacity;
		this.name = name;
		this.email = email;
		this.role = role;
		this.trucknumber = trucknumber;
	}
	
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTrucknumber() {
		return trucknumber;
	}
	public void setTrucknumber(String trucknumber) {
		this.trucknumber = trucknumber;
	}
	
	
	
	 
}
