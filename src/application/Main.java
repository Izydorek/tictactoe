package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import aplication.model.Cell;
import application.views.GameControler;
import application.views.HotSeatMenuControler;
import application.views.MenuControler;




public class Main extends Application {
	

	private BorderPane root;

	public Main() {
		super();
		
		
	}
	
	
	public void start(Stage primaryStage) {
		
		try {
			primaryStage.setTitle("tictactoe");
			root = new BorderPane();
			Canvas canvas = new Canvas(120,120);
		//	draw(canvas.getGraphicsContext2D());
		//	root.setCenter(canvas);
		//	BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 600, 400);
			BorderPane menuPane = createMenuPane();
		//	AnchorPane HotSeatMenu = createHotSeatMenu();
			//root.setCenter(HotSeatMenu);
			root.setCenter(menuPane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private BorderPane createMenuPane() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/Menu.fxml"));
		try {
			BorderPane menu = loader.load();
			MenuControler controller = loader.getController();
			controller.setMain(this);
			return menu;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public AnchorPane createHotSeatMenu() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/HotSeatMenu.fxml"));
		try {
			AnchorPane menu = loader.load();
			HotSeatMenuControler controller = loader.getController();
			controller.setMain(this);
			return menu;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public AnchorPane createComputerMenu() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/ComputerMenu.fxml"));
		try {
			AnchorPane menu = loader.load();
			return menu;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	
	public void startGame(String name1, String name2, Cell whoStarts){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/Game.fxml"));
		try {
			BorderPane game = (BorderPane) loader.load();
			GameControler controller = loader.getController();
			controller.setMain(this);
			controller.startGame(name1, name2, whoStarts);
			
			root.setCenter(game);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private void drawCross(GraphicsContext g, int row, int col) {
		g.strokeLine(col * 40, row * 40, (col + 1) * 40, (row + 1) * 40);
		g.strokeLine(col * 40, (row + 1) * 40, (col + 1) * 40, row * 40);
	}

	private void drawCircle(GraphicsContext g, int row, int col) {
		g.strokeOval(40 * row, 40 * col, 40, 40);
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
