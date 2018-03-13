package model;

import java.util.ArrayList;

public class Pawn extends Piece {
	
	public Pawn(Player owner) {
		super(owner, "Pawn");
	}

	@Override
	public ArrayList<Square> possibleMoves(Square location) {
		ArrayList<Square> possibleMoves = new ArrayList<Square>();
		int direction = owner.getColour().equals("white") ? 1 : -1;
		
		Square ahead = location.getNeighbour(0, direction);
		if (ahead != null && ahead.isEmpty())
			possibleMoves.add(ahead);
		
		if (!hasMoved && ahead.getNeighbour(0, direction).isEmpty())
			possibleMoves.add(ahead.getNeighbour(0, direction));
		
		Square aheadLeft = ahead.getNeighbour(-1, 0); 
		if (aheadLeft != null && aheadLeft.isOpponent(owner))
			possibleMoves.add(aheadLeft);
		
		Square aheadRight = ahead.getNeighbour(1, 0);
		if (aheadRight != null && aheadRight.isOpponent(owner))
			possibleMoves.add(aheadRight);
		
		return possibleMoves;
	}

}
