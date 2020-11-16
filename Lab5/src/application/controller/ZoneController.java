package application.controller;

import application.model.Dinosaur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ZoneController implements EventHandler<ActionEvent> {
	
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
		// TODO Auto-generated method stub
		
	}

}
