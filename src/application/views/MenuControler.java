package application.views;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import application.Main;

public class MenuControler {

	@FXML
	private Pane leftPane;
	
	private Main main;
	public void setMain(Main main) {
		this.main = main;
	}
	
	
	@FXML
	public void handleHotSeatButton() {		
		
		AnchorPane hotSeatPane = main.createHotSeatMenu();
		leftPane.getChildren().clear();
		leftPane.getChildren().add(hotSeatPane);
	}
	
	@FXML
	public void handleComputerButton() {
		
		
		AnchorPane computerMenu = main.createComputerMenu();
		leftPane.getChildren().clear();
		leftPane.getChildren().add(computerMenu);
	}
	
	
}
