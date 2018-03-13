package model;

import java.util.ArrayList;

public class Queen extends Piece {

	public Queen(Player colour) {
		super(colour, "Queen");
	}

	@Override
	public ArrayList<Square> possibleMoves(Square location) {
		ArrayList<Square> possibleMoves = new ArrayList<Square>();
		
		// north
		possibleMoves.addAll(checkDirection(location, 0, -1));
		// north-east
		possibleMoves.addAll(checkDirection(location, 1, -1));
		// east
		possibleMoves.addAll(checkDirection(location, 1, 0));
		// south-east
		possibleMoves.addAll(checkDirection(location, 1, 1));
		// south
		possibleMoves.addAll(checkDirection(location, 0, 1));
		// south-west
		possibleMoves.addAll(checkDirection(location, -1, 1));
		// west
		possibleMoves.addAll(checkDirection(location, -1, 0));
		// north-west
		possibleMoves.addAll(checkDirection(location, -1, -1));
				
		return possibleMoves;
	}

}
