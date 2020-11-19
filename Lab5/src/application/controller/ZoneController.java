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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ZoneController implements EventHandler<ActionEvent> {
		
	private Scene mainScene;
	private Stage primaryStage;
	
	@FXML
	private Label carnivoreLabel, addDinoNameLabel, addDinoTypeLabel, relocationMessage, zoneLabel, dinoLabel, riskLabel, riskLabelText, dinoLabelText, relocateNameLabel, zoneCodeLabel;
	@FXML
	private Button homeButton, addButton, relocateButton;
	@FXML
	private ListView<Dinosaur> dinoList;
	@FXML
	private TextField addDinoNameField, addDinoTypeField, relocateDinoNameField, relocateZoneField;
	@FXML
	private RadioButton isCarnivorousButton, isNotCarnivorousButton;
	private final ToggleGroup group = new ToggleGroup();
	private Alert alert = new Alert(AlertType.ERROR);

	@Override
	public void handle(ActionEvent event) {
		if(event.getSource().equals(homeButton)) {
			primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			primaryStage.setScene(mainScene);
		}
		
		if(event.getSource().equals(addButton)) {
			if((addDinoNameField.getText().equals("") || addDinoTypeField.getText().equals("")) || (!group.getToggles().get(0).isSelected() && !group.getToggles().get(1).isSelected())) {
				alert.setTitle("Error adding Dinosaur");
				alert.setHeaderText("Unable to add dinosaur to this zone!");
				alert.setContentText("Please ensure none of the fields are empty.");
				alert.showAndWait();
			}
			else {
				Dinosaur dinoToAdd = null;
				if(group.getToggles().get(0).isSelected()) {
					dinoToAdd = new Dinosaur(addDinoNameField.getText(), addDinoTypeField.getText(), false);
				}
				else {
					dinoToAdd = new Dinosaur(addDinoNameField.getText(), addDinoTypeField.getText(), true);
				}
				if(dinoToAdd != null) { 
					Main.jurassicPark.addDinosaur(dinoToAdd, MainController.zoneCode);
					refreshList();
					Main.jurassicPark.save();
					relocationMessage.setText("Successfully added " + dinoToAdd.getName() + " to Zone " + MainController.zoneCode);
					addDinoNameField.clear();
					addDinoTypeField.clear();
					group.getToggles().clear();
				}
			}
		}

		if(event.getSource().equals(relocateButton)) {
			//TODO
			//case insensitive comparisons on name/zone
			if(relocateDinoNameField.getText().equals("") || relocateZoneField.getText().equals("")) {
				alert.setTitle("Error relocating Dinosaur");
				alert.setHeaderText("Unable to move dinosaur out of this zone!");
				alert.setContentText("Please ensure none of the fields are empty.");
				alert.showAndWait();
			}
			else {
				Main.jurassicPark.relocate(MainController.zoneCode, relocateZoneField.getText(), relocateDinoNameField.getText());
				refreshList();
				Main.jurassicPark.save();
				relocationMessage.setText("Sucessfully moved " + relocateDinoNameField.getText() + " to Zone " + relocateZoneField.getText());
				relocateZoneField.clear();
				relocateDinoNameField.clear();
			}
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
				dinoLabelText.setText("" + Main.jurassicPark.getParkMap().get(parkZone).size());
				riskLabelText.setText(parkZone.getThreatLevel() + " risk");
				switch(parkZone.getThreatLevel()) {
				case "low":
					riskLabelText.setTextFill(Color.GREEN);
					break;
				case "high":
					riskLabelText.setTextFill(Color.RED);
					break;
				case "medium":
					riskLabelText.setTextFill(Color.ORANGE);
					break;
				case "critical":
					riskLabelText.setTextFill(Color.DARKRED);
					break;
				default:
					break;
				}
			}
		}
		isCarnivorousButton.setToggleGroup(group);
		isNotCarnivorousButton.setToggleGroup(group);
	}
	
	private void refreshList() {
		dinoList.getItems().clear();
		for(Zone zone : Main.jurassicPark.getParkMap().keySet()) {
			if(zone.getZoneCode().equals(MainController.zoneCode)) {
				for(Dinosaur dino : Main.jurassicPark.getParkMap().get(zone)) {
					dinoList.getItems().add(dino);
				}
				dinoLabelText.setText("" + Main.jurassicPark.getParkMap().get(zone).size());
			}
		}
	}
}
