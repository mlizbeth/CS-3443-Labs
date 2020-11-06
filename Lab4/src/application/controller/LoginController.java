package application.controller;

import java.io.IOException;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements EventHandler<ActionEvent> {
	
	protected static User loggedInUser;
	@FXML
	private Button loginButton;
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
		
	
	//TODO hide old stage and show new one
	@Override
	public void handle(ActionEvent event) {
		try {
			loggedInUser = User.validate(usernameField.getText(), passwordField.getText());
			if(loggedInUser.exists()) {
				usernameField.setText("");
				passwordField.setText("");
				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/Personnel.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.setResizable(false);
				primaryStage.show();
			}
		} catch (IOException e) { e.printStackTrace(); }
	}
}
