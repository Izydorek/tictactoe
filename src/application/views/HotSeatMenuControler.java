package application.views;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import aplication.model.Cell;
import application.Main;

public class HotSeatMenuControler {

	@FXML
	private TextField name1;
	
	@FXML
	private TextField name2;
	
	@FXML
	private ToggleGroup whoStartsGroup;

	private Main main;
	
	@FXML
	private Toggle toggle1;
	
	@FXML
	private Toggle toggle2;
	
	@FXML
	public void startGame(){
		
		System.out.println("Starting game");

		System.out.println("Username1: " + name1.getText());
		System.out.println("Username2: " + name2.getText());
		
		Cell whoStarts = null;
		

		if(whoStartsGroup.getSelectedToggle() == toggle1) {
			whoStarts = Cell.CIRCLE;	
		} else if (whoStartsGroup.getSelectedToggle() == toggle2){
			whoStarts = Cell.CROSS;
		}
		
	main.startGame(name1.getText(), name2.getText(), whoStarts);
	}

	public void setMain(Main main) {
		this.main = main;
		
	}
	
}
