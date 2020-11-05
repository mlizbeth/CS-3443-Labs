package application.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController implements EventHandler<ActionEvent> {

	private List<User> users = new ArrayList<User>();
	private final String SPLIT = ",";
	@FXML
	private Button loginButton;
	@FXML
	private TextField usernameField;
	@FXML
	private TextField passwordField;
	
	/*
	 * TODO
	 * On login, validate username and password by reading users.csv, if valid, proceed to the next view.
	 * GUI Stuff
	 * password mask
	 */
	
	@Override
	public void handle(ActionEvent event) {
		try {
			User.validate(usernameField.getText(), passwordField.getText());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void loadUsers(String path) throws IOException {
		String line = "";
		BufferedReader reader = new BufferedReader(new FileReader(path));
		while((line = reader.readLine()) != null) {
			String[] data = line.split(SPLIT);
			users.add(new User(data[0], data[1]));
		}
		reader.close();
	}

}
