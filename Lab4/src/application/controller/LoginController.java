package application.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController implements EventHandler<ActionEvent> {

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
		System.out.println("Test");
		
	}

}
