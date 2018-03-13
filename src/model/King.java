package model;

import java.util.ArrayList;

public class King extends Piece {

	public King(Player colour) {
		super(colour, "King");
	}

	@Override
	public ArrayList<Square> possibleMoves(Square location) {
		ArrayList<Square> possibleMoves = new ArrayList<Square>();
		
		for (Square neighbour : location.getNeighbours()) {
			if (neighbour.isEmpty() || neighbour.isOpponent(owner)) {
				possibleMoves.add(neighbour);
			}
		}
		
		return possibleMoves;
	}

}
