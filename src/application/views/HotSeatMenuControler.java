package application.views;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
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

		if(whoStartsGroup.getSelectedToggle() == toggle1) {
			System.out.println("Zaczynaj¹ Kó³ka");			
		} else if (whoStartsGroup.getSelectedToggle() == toggle2){
			System.out.println("Zaczynaj¹ Krzy¿yki");
		}
		
	main.startGame(name1.getText(), name2.getText());
	}

	public void setMain(Main main) {
		this.main = main;
		
	}
	
}
