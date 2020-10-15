package application.controller;

import java.io.IOException;
import application.model.Fleet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController implements EventHandler<ActionEvent> {
	
	@FXML
	private Button button;
	@FXML
	private TextField textField;
	@FXML
	private TextArea textArea;

	@Override
	public void handle(ActionEvent event) {
		try {
			Fleet temp = Fleet.loadData();
			String temp2 = "";
			for(int x = 0; x < temp.getShips().size(); x++) {
				if(temp.getShips().get(x).getName().contains(textField.getText())) {
					temp2 += temp.getShips().get(x).toString() + "\n";
				}
			}
			textArea.setText(temp2);
		} catch (IOException e) {e.printStackTrace();}
	}
}
