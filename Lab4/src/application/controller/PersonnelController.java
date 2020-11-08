package application.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import application.model.CrewMember;
import application.model.Fleet;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PersonnelController implements EventHandler<ActionEvent>{
	
	private Fleet fleet;
	private User currentUser = LoginController.loggedInUser;
	private List<CrewMember> crew = new ArrayList<CrewMember>();
	private List<String> order = new ArrayList<String>();
	private int shipIndex;
	private int userIndex;
	private String ship = "";
	private String registry = "";
	
	@FXML
	private Button logoutButton;
	@FXML
	private Label nameLabel;
	@FXML
	private Label shipLabel;
	@FXML 
	private Label imgLabel1, imgLabel2, imgLabel3, imgLabel4, imgLabel5, imgLabel6, imgLabel7, imgLabel8;
	@FXML
	private ImageView img1, img2, img3, img4, img5, img6, img7, img8;

	
	@Override
	public void handle(ActionEvent event) {
		Stage stage = (Stage) logoutButton.getScene().getWindow();
		stage.close();
		
	}
	
	//TODO
	//match crew to captain ship, GUI representation, logout button
	
	@FXML
	void initialize() {
		try {
			fleet = Fleet.loadData();
		} catch (IOException e) { e.printStackTrace(); }
		
		for(int x = 0; x < fleet.getShips().size(); x++) {
			for(int y = 0; y < fleet.getShips().get(x).getCrewMembers().size(); y++) {
				if(fleet.getShips().get(x).getCrewMembers().get(y).getName().toLowerCase().contains(currentUser.getUsername())) {
					shipIndex = x;
					userIndex = y;
					ship = fleet.getShips().get(x).getName();
					registry = fleet.getShips().get(x).getRegistry();
				}
			}
		}
		
		crew = fleet.getShips().get(shipIndex).getCrewMembers();
		
		
		if(!(crew.size() <= 0)) {
			nameLabel.setText(nameLabel.getText() + crew.get(userIndex).getRank() + " " + crew.get(userIndex).getName().substring(crew.get(userIndex).getName().lastIndexOf(" ") +1));
			shipLabel.setText(ship + " " + registry);	
			
			for(CrewMember c : crew) {
				switch(c.getPosition()) {
				case "Commanding Officer":
					img1.setImage(new Image(c.getPicture().toURI().toString()));
					imgLabel1.setText(c.getPosition() + "\n" + c.getRank() + " " + c.getName());
					break;
				case "First Officer":
					img2.setImage(new Image(c.getPicture().toURI().toString()));
					imgLabel2.setText(c.getPosition() + "\n" + c.getRank() + " " + c.getName());
					break;
				case "Communications Officer":
					img3.setImage(new Image(c.getPicture().toURI().toString()));
					imgLabel3.setText(c.getPosition() + "\n" + c.getRank() + " " + c.getName());
					break;
				case "Counselor":
					img3.setImage(new Image(c.getPicture().toURI().toString()));
					imgLabel3.setText(c.getPosition() + "\n" + c.getRank() + " " + c.getName());
					break;
				case "Chief Engineering Officer":
					img4.setImage(new Image(c.getPicture().toURI().toString()));
					imgLabel4.setText(c.getPosition() + "\n" + c.getRank() + " " + c.getName());
					break;
				case "Helmsman":
					img5.setImage(new Image(c.getPicture().toURI().toString()));
					imgLabel5.setText(c.getPosition() + "\n" + c.getRank() + " " + c.getName());
					break;
				case "Chief Operations Officer": 
					img6.setImage(new Image(c.getPicture().toURI().toString()));
					imgLabel6.setText(c.getPosition() + "\n" + c.getRank() + " " + c.getName());
					break;
				case "Navigator":
					img6.setImage(new Image(c.getPicture().toURI().toString()));
					imgLabel6.setText(c.getPosition() + "\n" + c.getRank() + " " + c.getName());
					break;
				case "Chief Medical Officer":
					img7.setImage(new Image(c.getPicture().toURI().toString()));
					imgLabel7.setText(c.getPosition() + "\n" + c.getRank() + " " + c.getName());
					break;
				case "Nurse":
					img8.setImage(new Image(c.getPicture().toURI().toString()));
					imgLabel8.setText(c.getPosition() + "\n" + c.getRank() + " " + c.getName());
					break;
				case "Chief Security Officer":
					img8.setImage(new Image(c.getPicture().toURI().toString()));
					imgLabel8.setText(c.getPosition() + "\n" + c.getRank() + " " + c.getName());
					break;
				default:
					break;
				}	
			}
		}
		else {
			nameLabel.setText("You are not assigned to a ship.");
		}
		
	}
}
