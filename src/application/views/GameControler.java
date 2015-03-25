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
	
	private void clear(GraphicsContext g){
		g.clearRect(0, 0, 240, 240);
		g.strokeRect(0, 0, 240, 240);
	}
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
		System.out.println(event.getX() + "," + event.get-Y());
		
		int row = (int) (event.getY() / 80);
		int col = (int) (event.getX() / 80);
		
		draw(canvas.getGraphicsContext2D());
		
		drawCross(canvas.getGraphicsContext2D(), row, col);
	}
	
	private void draw(GraphicsContext g) {

		clear(g);
		drawBoard(g);
		
		drawBoard(g);
		
	}

	
	private void drawCross(GraphicsContext g, int row, int col) {
		g.strokeLine(col * 40, row * 40, (col + 1) * 40, (row + 1) * 40);
		g.strokeLine(col * 40, (row + 1) * 40, (col + 1) * 40, row * 40);
	}

	private void drawCircle(GraphicsContext g, int row, int col) {
		g.strokeOval(40 * row, 40 * col, 40, 40);
		
	}

	private void drawBoard(GraphicsContext g) {
		g.strokeLine(0 , 0, 120, 0);	
		g.strokeLine(0 , 120, 120, 120);
		g.strokeLine(120 , 0, 120, 120);
		g.strokeLine(0 , 0, 0, 120);
		
		g.strokeLine(0 , 40, 120, 40);	
		g.strokeLine(0 , 80, 120, 80);
		g.strokeLine(80 , 0, 80, 120);
		g.strokeLine(40 , 0, 40, 120);
	}
	
}
