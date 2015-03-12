package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;




public class Main extends Application {
	
	

	public Main() {
		super();
		
		
	}
	
	
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("tictactoe");
			BorderPane root = new BorderPane();
			Canvas canvas = new Canvas(120,120);
			draw(canvas.getGraphicsContext2D());
			
		//	root.setCenter(canvas);
		//	BorderPane root = new BorderPane();
			Scene scene = new Scene(root,500, 300);
			AnchorPane menuPane = createMenuPane();
			AnchorPane HotSeatMenu = createHotSeatMenu();
			root.setCenter(HotSeatMenu);
		//	root.setCenter(menuPane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private AnchorPane createMenuPane() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/Menu.fxml"));
		try {
			AnchorPane menu = loader.load();
			return menu;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private AnchorPane createHotSeatMenu() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/HotSeatMenu.fxml"));
		try {
			AnchorPane menu = loader.load();
			return menu;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


	private void draw(GraphicsContext g) {
//	
//		g.strokeLine(0, 0, 120, 120);
//		
//		g.strokeOval(60, 60, 10, 10);
//		
//		g.setStroke(Paint.valueOf("red"));
//		
//		g.strokeRect(50, 50, 20, 20);
		
		g.strokeLine(30, 60, 90, 60);		
		
//		g.clearRect(0, 0, 120, 120);
	
		
		drawBoard(g);
		drawCircle(g, 0, 0);
		drawCross(g, 1, 1);
	
		g.setStroke(Paint.valueOf("white"));
	}
	
	
	
	

	private void drawCross(GraphicsContext g, int i, int j) {
		
		
	}

	private void drawCircle(GraphicsContext g, int i, int j) {
		
		
	}

	private void drawBoard(GraphicsContext g) {
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
