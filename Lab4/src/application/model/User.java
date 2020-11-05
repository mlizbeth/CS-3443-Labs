package application.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class User {

	private String username, password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	//TODO
	public static User validate(String username, String password) throws IOException {
		String line = "";
		User temp;
		BufferedReader reader = new BufferedReader(new FileReader("data/users.csv"));
		while((line = reader.readLine()) != null) {
			String[] data = line.split(",");
			if(data[0].equals(username)) {
				temp = new User(data[0], data[1]);
				if(data[1].equals(password)) {
					reader.close();
					return temp;
				}
			}
		}
		reader.close();
		return null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
}
