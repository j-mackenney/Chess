package model;

import java.util.ArrayList;

public class Bishop extends Piece {

	public Bishop(Player colour) {
		super(colour, "Bishop");
	}

	@Override
	public ArrayList<Square> possibleMoves(Square location) {
		ArrayList<Square> possibleMoves = new ArrayList<Square>();
				
		// north-east
		possibleMoves.addAll(checkDirection(location, 1, -1));
		// south-east
		possibleMoves.addAll(checkDirection(location, 1, 1));
		// south-west
		possibleMoves.addAll(checkDirection(location, -1, 1));
		// north-west
		possibleMoves.addAll(checkDirection(location, -1, -1));
		
		return possibleMoves;
	}

}
