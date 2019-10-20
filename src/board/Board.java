package board;

public class Board {
	static Pieces[][] initialBoard = {
		{
			Pieces.WhiteRock, Pieces.WhiteKnight, Pieces.WhiteBishop, Pieces.WhiteQueen,
			Pieces.WhiteKing, Pieces.WhiteBishop, Pieces.WhiteKnight, Pieces.WhiteRock
		},
		{
			Pieces.WhitePawn, Pieces.WhitePawn, Pieces.WhitePawn, Pieces.WhitePawn,
			Pieces.WhitePawn, Pieces.WhitePawn, Pieces.WhitePawn, Pieces.WhitePawn
		},
		{
			Pieces.Empty, Pieces.Empty, Pieces.Empty, Pieces.Empty,
			Pieces.Empty, Pieces.Empty, Pieces.Empty, Pieces.Empty
		},
		{
			Pieces.Empty, Pieces.Empty, Pieces.Empty, Pieces.Empty,
			Pieces.Empty, Pieces.Empty, Pieces.Empty, Pieces.Empty
		},
		{
			Pieces.Empty, Pieces.Empty, Pieces.Empty, Pieces.Empty,
			Pieces.Empty, Pieces.Empty, Pieces.Empty, Pieces.Empty
		},
		{
			Pieces.Empty, Pieces.Empty, Pieces.Empty, Pieces.Empty,
			Pieces.Empty, Pieces.Empty, Pieces.Empty, Pieces.Empty
		},
		{
			Pieces.BlackPawn, Pieces.BlackPawn, Pieces.BlackPawn, Pieces.BlackPawn,
			Pieces.BlackPawn, Pieces.BlackPawn, Pieces.BlackPawn, Pieces.BlackPawn
		},
		{
			Pieces.BlackRock, Pieces.BlackKnight, Pieces.BlackBishop, Pieces.BlackQueen,
			Pieces.BlackKing, Pieces.BlackBishop, Pieces.BlackKnight, Pieces.BlackRock
		}
	};

	public static Pieces[][] getInitialBoard() {
		return initialBoard;
	}
	
}
