package aplication.model;

public class Board {

	private Cell[][] table = new Cell[3][];
	private Cell nextMove;
	
	public Board(Cell whoIsFirst) {
		this.table[0] = new Cell[3];
		this.table[1] = new Cell[3];
		this.table[2] = new Cell[3];
		
		this.nextMove = whoIsFirst;
		
	}
	
	public Cell[][] getTable() {
		return table;
	}

	public Cell getNextMove() {
		return nextMove;
	}

	public void fillCell(Cell cell, int row, int col) {
		if(cell != nextMove){
			System.out.println("Teraz ruch " + nextMove );
			return;
		}
		
		if(table[row][col] == null){
			table[row][col] = cell;
			if(nextMove == Cell.CIRCLE){
				nextMove = Cell.CROSS;
			} else{
				nextMove = Cell.CIRCLE;
			}
		} else {
			System.out.println("cell " + row + "," + col + " is already filled");
			
		}
	

	}

	public void fillCellByText(String text) {
		if (isTextReal(text)) {
			Cell cell = charToCell(text.charAt(0));
			int row = Character.digit(text.charAt(1), 10); // /////////////////////////////////////////
															// radix?
			int col = Character.digit(text.charAt(2), 10);
			fillCell(cell, row, col);
		} else {
			System.out.println("Bad cell format " + text);
		}
	}


	public static boolean isTextReal(String fillCellByText) {
		if ((fillCellByText.charAt(0) != 'X'
				&& fillCellByText.charAt(0) != 'O')
				|| Character.digit(fillCellByText.charAt(1), 10) < 0
				|| Character.digit(fillCellByText.charAt(1), 10) > 3
				|| Character.digit(fillCellByText.charAt(2), 10) < 0
				|| Character.digit(fillCellByText.charAt(2), 10) > 3
				|| fillCellByText.length() > 3 || fillCellByText.length() == 0) {
			return false;
		} else {
			return true;
		}

	}

	public static void main(String[] args) {

		isTextReal("X01");
		
		Board board = new Board(Cell.CIRCLE);
		Board board2 = board;
		Board board3 = new Board(Cell.CIRCLE);

		board.print();
		board2.print();
		board3.print();

		board.fillCell(Cell.CIRCLE, 0, 0);
		board.fillCellByText("X02");
		board.fillCellByText("O02");
		board.fillCellByText("X00");
		board.fillCellByText("O12");
		board.fillCellByText("O11");
		board.fillCellByText("O22");
		board.fillCellByText("X10");
		board.fillCellByText("X21");
		board.fillCellByText("O20");

		board.print();
	}


	public void print() {
		// if (isTextReal() == false){
		// System.out.println("!**Error wit your type**!");
		// /////////////////////////////////////////////////////////
		// } else {
	//	System.out.println("*****");
		for (int i = 0; i < 3; i++) {
			//System.out.print("*");
			for (int j = 0; j < 3; j++) {
				char c = cellToChar(this.table[i][j]);
				System.out.print(c);
			}
		System.out.println();
		}
//		System.out.println("*****");

//		System.out.println("The winner is: " + checkWinner());

		System.out.println();
		// }

	}

	public static char cellToChar(Cell cell) {
		if (cell == null) {
			return '-';
		}
		if (cell == Cell.CIRCLE) {
			return 'O';
		} else {
			return 'X';
		}
	}

	public static Cell charToCell(char c) {

		if (c == 'O') {
			return Cell.CIRCLE;
		}
		if (c == 'X') {
			return Cell.CROSS;
		} else {
			return null;
		}

	}

	public Cell checkWinner() {

		if (isWinner(Cell.CROSS) == true) {
			return Cell.CROSS;
		} else if (isWinner(Cell.CIRCLE) == true) {
			return Cell.CIRCLE;
		} else {
			return null;
		}

	}

	public boolean isWinner(Cell cell) {

		if (table[0][0] == cell && table[0][1] == cell && table[0][2] == cell) {
			return true;
		}

		if (table[1][0] == cell && table[1][1] == cell && table[1][2] == cell) {
			return true;
		}

		if (table[2][0] == cell && table[2][1] == cell && table[2][2] == cell) {
			return true;
		}

		if (table[0][0] == cell && table[1][0] == cell && table[2][0] == cell) {
			return true;
		}

		if (table[0][1] == cell && table[1][1] == cell && table[2][1] == cell) {
			return true;
		}

		if (table[1][2] == cell && table[1][2] == cell && table[2][2] == cell) {
			return true;
		}
		if (table[0][0] == cell && table[0][1] == cell && table[0][2] == cell) {
			return true;
		}

		if (table[0][0] == cell && table[1][1] == cell && table[2][2] == cell) {
			return true;
		}

		if (table[0][2] == cell && table[1][1] == cell && table[2][0] == cell) {
			return true;
		} else {
			return false;
		}

	}

	
}
