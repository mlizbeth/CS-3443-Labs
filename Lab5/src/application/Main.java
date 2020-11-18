package application;

import application.model.Park;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	public static Park jurassicPark = new Park("Jurassic Park");
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/application/view/Main.fxml"));
		Parent mainRoot = mainLoader.load();
		Scene mainScene = new Scene(mainRoot);
		
		primaryStage.setScene(mainScene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Jurassic Park Viewer");
		primaryStage.getIcons().add(new Image("file:img/logo.png"));
		primaryStage.show();
		
		/* Turns out these had unintended consequences since initialization happens before
		 * any sort of buttons are clicked
		FXMLLoader zoneLoader = new FXMLLoader(getClass().getResource("/application/view/Zone.fxml"));
		Parent zoneRoot = zoneLoader.load();
		Scene zoneScene = new Scene(zoneRoot);
		
		MainController mainController = (MainController) mainLoader.getController();
		mainController.setZoneScene(zoneScene);
		
		ZoneController zoneController = (ZoneController) zoneLoader.getController();
		zoneController.setMainScene(mainScene);
		 */
		
	}
}
