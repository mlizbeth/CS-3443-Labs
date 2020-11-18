package application.controller;

import java.io.IOException;
import application.Main;
import application.model.Dinosaur;
import application.model.Zone;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ZoneController implements EventHandler<ActionEvent> {
	
	private Scene mainScene;
	private Stage primaryStage;
	
	@FXML
	private Label carnivoreLabel, addDinoNameLabel, addDinoTypeLabel, relocationMessage, zoneLabel, dinoLabel, riskLabel, relocateNameLabel, zoneCodeLabel;
	@FXML
	private Button homeButton, addButton, relocateButton;
	@FXML
	private ListView<Dinosaur> dinoList;
	@FXML
	private TextField addDinoNameField, addDinoTypeField, relocateDinoNameField, relocateZoneField;

	@Override
	public void handle(ActionEvent event) {
		if(event.getSource().equals(homeButton)) {
			primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			primaryStage.setScene(mainScene);
		}
	}
	
	public void setMainScene(Scene mainScene) {
		this.mainScene = mainScene;
	}
	
	@FXML
	void initialize() {
		try {
			FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/application/view/Main.fxml"));
			Parent mainRoot = mainLoader.load();
			mainScene = new Scene(mainRoot);
		} catch(IOException e) { e.printStackTrace(); }
		
		for(Zone parkZone : Main.jurassicPark.getParkMap().keySet()) {
			if(parkZone.getZoneCode().equals(MainController.zoneCode)) {
				zoneLabel.setText(parkZone.getZoneName() + " Zone " + "(" + parkZone.getZoneCode() + ")");
				for(Dinosaur dino : Main.jurassicPark.getParkMap().get(parkZone)) {
					dinoList.getItems().add(dino);
				}
				dinoLabel.setText(dinoLabel.getText() + " " + Main.jurassicPark.getParkMap().get(parkZone).size());
				riskLabel.setText(riskLabel.getText() + parkZone.getThreatLevel() + " " + "risk");
			}
		}

		System.out.println(MainController.zoneCode);
	}
}
