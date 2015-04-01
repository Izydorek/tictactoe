package application.views;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import aplication.model.Board;
import aplication.model.Cell;
import application.Main;

public class GameControler {
	
	private Main main;
	
	private Board board;
	
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
	
	public void startGame(String name1, String name2, Cell whoStarts){
		this.name1.setText(name1);
		this.name2.setText(name2);
		this.score1.setText("0");
		this.score2.setText("0");
		this.nowMove.setText("Kó³ka");
		this.winner.setText("");
		
		this.board = new Board(whoStarts);
		draw(canvas.getGraphicsContext2D());

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
		
		int row = (int) (event.getY() / 80);
		int col = (int) (event.getX() / 80);
		System.out.println(event.getX() + ":" + row + "," + col);
		
		Cell nextCell = board.getNextMove();
		board.fillCell(nextCell, row, col);
		if(board.getNextMove() == Cell.CIRCLE){
			nowMove.setText("kó³ka");
		} else if (board.getNextMove() == Cell.CROSS){
			nowMove.setText("krzy¿yki");
			}
		if (board.checkWinner() != null){
			winner.setText(board.checkWinner().name());
		}
		draw(canvas.getGraphicsContext2D());
	}
	
	private void draw(GraphicsContext g) {

		clear(g);
		drawBoard(g);
		
		Cell[][] table = board.getTable();
		
		for (int i = 0; i < table.length; i++){
			for(int j = 0; j < table[i].length; j++){
				
				Cell cell = table[i][j];
				
				if(cell == Cell.CIRCLE){
					drawCircle(g, i, j);
				} else if (cell == Cell.CROSS){
					drawCross(g, i, j);
				
				}
			}
		}
		
	}

	
	private void drawCross(GraphicsContext g, int row, int col) {
		g.strokeLine(col * 80, row * 80, (col + 1) * 80, (row + 1) * 80);
		g.strokeLine(col * 80, (row + 1) * 80, (col + 1) * 80, row * 80);
	}

	private void drawCircle(GraphicsContext g, int row, int col) {
		g.strokeOval(80 * col, 80 * row, 80, 80);
		
	}

	private void drawBoard(GraphicsContext g) {
		g.strokeLine(0 , 0, 240, 0);	
		g.strokeLine(0 , 240, 240, 240);
		g.strokeLine(240 , 0, 240, 240);
		g.strokeLine(0 , 0, 0, 240);
		
		g.strokeLine(0 , 80, 240, 80);	
		g.strokeLine(0 , 160, 240, 160);
		g.strokeLine(160 , 0, 160, 240);
		g.strokeLine(80 , 0, 80, 240);
	}
	
}
