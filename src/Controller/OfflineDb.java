package Controller;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OfflineDb {
	private static final String LOGIN_STATUS_FILE = "login_status.txt";
	private static final String LOGIN_ID_FILE = "login_id.txt";
	private static boolean loggedIn = false;
	private static int loginId=0;
	
	public void saveLoginStatus(boolean loggedIn) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOGIN_STATUS_FILE))) {
            writer.write(Boolean.toString(loggedIn));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public boolean loadLoginStatus() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOGIN_STATUS_FILE))) {
            String line = reader.readLine();
            if (line != null && !line.isEmpty()) {
                loggedIn = Boolean.parseBoolean(line);                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loggedIn;
    }
	
	public void saveLoginID(int loginID) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOGIN_ID_FILE))) {
            writer.write(String.valueOf(loginID) );
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public int loadLoginId() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOGIN_ID_FILE))) {
            String line = reader.readLine();
            if (line != null && !line.isEmpty()) {
            	loginId = Integer.parseInt(line);                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loginId;
    }
}