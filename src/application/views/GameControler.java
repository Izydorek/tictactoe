package application.views;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import application.Main;

public class GameControler {
	
	private Main main;

	@FXML
	private Label name1;
	@FXML
	private Label score1;
	@FXML
	private Label name2;
	@FXML
	private Label score2;
	@FXML
	private Label nowMove;
	
	@FXML
	private Label winner;
	
	@FXML
	private Canvas canvas;
	
	public void setMain(Main main){
		this.main = main;
	}
	
	public void startGame(String name1, String name2){
		this.name1.setText(name1);
		this.name2.setText(name2);
		this.score1.setText("0");
		this.score2.setText("0");
		this.nowMove.setText("Kó³ka");
		this.winner.setText("");
	}
	
	@FXML
	public void endGame(){
		System.out.println("End Game");
	}
	
	@FXML
	public void nextMach(){
		System.out.println("Next match");
		
	}
	
	@FXML
	public void boardClicked(MouseEvent event){
		System.out.println(event.getX() + "," + event.getY());
	}
	
	private void draw(GraphicsContext g) {
	//	
//			g.strokeLine(0, 0, 120, 120);
//			
//			g.strokeOval(60, 60, 10, 10);
//			
//			g.setStroke(Paint.valueOf("red"));
//			
//			g.strokeRect(50, 50, 20, 20);
			
//			g.clearRect(0, 0, 120, 120);
		
			
			drawBoard(g);
//			drawCircle(g, 0, 0);
//			drawCircle(g, 0, 1);
//			drawCircle(g, 2, 0);
//			drawCircle(g, 0, 2);
//			drawCircle(g, 2, 2);
			
			drawCross(g, 1, 1);
			drawCross(g, 2, 2);
			drawCross(g, 2, 0);
			drawCross(g, 0, 2);
			
		}

		
		private void drawCross(GraphicsContext g, int row, int col) {
			g.strokeLine(col * 40, row * 40, (col + 1) * 40, (row + 1) * 40);
			g.strokeLine(col * 40, (row + 1) * 40, (col + 1) * 40, row * 40);
		}

		private void drawCircle(GraphicsContext g, int row, int col) {
			g.strokeOval(40 * row, 40 * col, 40, 40);
			
			
		}
	
}
