package application.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController implements EventHandler<ActionEvent> {
	
	private Scene zoneScene;
	private Stage primaryStage;
	protected static String zoneCode = "";
	
	@FXML
	private Button bZone, dZone, gZone, rZone, trZone, tyZone, xZone;

	@Override
	public void handle(ActionEvent event) {
		switch(event.getSource().toString().substring(event.getSource().toString().indexOf('\'') +1, event.getSource().toString().lastIndexOf('\''))) {
		case "B":
			zoneCode = "B";
			break;
		case "D":
			zoneCode = "D";
			break;
		case "G":
			zoneCode = "G";
			break;
		case "R":
			zoneCode = "R";
			break;
		case "TR":
			zoneCode = "TR";
			break;
		case "TY":
			zoneCode = "TY";
			break;
		case "X":
			zoneCode = "X";
			break;
		default: 
			System.out.println("How did you even get here?");
			break;
		}
		try {
			FXMLLoader zoneLoader = new FXMLLoader(getClass().getResource("/application/view/Zone.fxml"));
			Parent zoneRoot = zoneLoader.load();
			zoneScene = new Scene(zoneRoot);
		} catch(IOException e) { e.printStackTrace(); }
		primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		if(!zoneCode.equals("")) {
			switchScene();
		}
	}
	
	public void setZoneScene(Scene zoneScene) {
		this.zoneScene = zoneScene;
	}
	
	private void switchScene() {
		primaryStage.setScene(zoneScene);
	}
}
