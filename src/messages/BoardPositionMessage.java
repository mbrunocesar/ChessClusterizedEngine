package messages;

import java.io.Serializable;

import board.Board;
import board.Pieces;

public class BoardPositionMessage implements GenericMessage, Serializable {
	private static final long serialVersionUID = -4273641957508964380L;

	Pieces[][] currentBoard;
	String lastMove;
	boolean isWhiteTurn;

	int currentEvaluation;
	

	public BoardPositionMessage(Pieces[][] board, String move, boolean isWhite, int lastEvaluation) {
		currentBoard = board;
		lastMove = move;
		isWhiteTurn = isWhite;
		
		currentEvaluation = lastEvaluation;
	}
	
	public BoardPositionMessage(Board board, String move, boolean isWhite, int lastEvaluation) {
		currentBoard = board.getBoard();
		lastMove = move;
		isWhiteTurn = isWhite;
		
		currentEvaluation = lastEvaluation;
	}
	
	public Pieces[][] getCurrentBoard() {
		return currentBoard;
	}
	
	public String getMove() {
		return lastMove;
	}
	
	public boolean isWhite() {
		return isWhiteTurn;
	}

}
