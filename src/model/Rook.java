package model;

import java.util.ArrayList;

public class Rook extends Piece {

	public Rook(Player colour) {
		super(colour, "Rook");
	}

	@Override
	public ArrayList<Square> possibleMoves(Square location) {
		ArrayList<Square> possibleMoves = new ArrayList<Square>();
		
		// north
		possibleMoves.addAll(checkDirection(location, 0, -1));
		// east
		possibleMoves.addAll(checkDirection(location, 1, 0));
		// south
		possibleMoves.addAll(checkDirection(location, 0, 1));
		// west
		possibleMoves.addAll(checkDirection(location, -1, 0));
		
		return possibleMoves;
	}

}
