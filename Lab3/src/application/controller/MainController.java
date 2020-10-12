package application.controller;

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
		// TODO Auto-generated method stub
		System.out.println("BUtton");
	}

}
