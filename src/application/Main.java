package application;
	
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;




public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("tictactoe");
			Group root = new Group();
			Canvas canvas = new Canvas(120,120);
			draw(canvas.getGraphicsContext2D());
			root.getChildren().add(canvas);
		//	BorderPane root = new BorderPane();
			Scene scene = new Scene(root,120,120);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
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
	
		g.strokeOval(30, 90, 20, 20);
		g.strokeOval(60, 90, 20, 20);
		g.strokeLine(50, 95, 50, 0);
		g.strokeLine(60, 95, 60, 0);
		
		
//		g.clearRect(0, 0, 120, 120);
	
		
		drawBoard(g);
		drawCircle(g, 0, 0);
		drawCross(g, 1, 1);
	
		g.setStroke(Paint.valueOf("white"));
	}
	
	
	
	

	private void drawCross(GraphicsContext g, int i, int j) {
		// TODO Auto-generated method stub
		
	}

	private void drawCircle(GraphicsContext g, int i, int j) {
		
		
	}

	private void drawBoard(GraphicsContext g) {
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
