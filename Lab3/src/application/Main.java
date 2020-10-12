package application;

import java.io.IOException;

import application.model.Fleet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		VBox root = new VBox();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/Main.fxml"));
		root = loader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

		
		Fleet f = new Fleet("Cook-ers");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
