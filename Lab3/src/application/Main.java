package application;

import java.io.IOException;

import application.model.Fleet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class responsible for creating and running the JavaFX Application
 * 
 * @author Madeline Kotara - duk128
 * @version 1.0
 * @since 10-15-2020
 *
 */

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Main.fxml"));
		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
