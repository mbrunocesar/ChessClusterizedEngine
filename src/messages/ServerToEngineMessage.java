package messages;

import java.io.Serializable;

import board.Pieces;

public class ServerToEngineMessage implements GenericMessage, Serializable {
	private static final long serialVersionUID = -4273641957508964380L;

	Pieces[][] currentBoard;
	String lastMove;
	boolean isWhiteTurn;

	int currentEvaluation;
	

	public ServerToEngineMessage(Pieces[][] board, String move, boolean isWhite, int lastEvaluation) {
		currentBoard = board;
		lastMove = move;
		isWhiteTurn = isWhite;
		
		currentEvaluation = lastEvaluation;
	}

}
