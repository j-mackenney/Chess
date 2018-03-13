package model;

import java.util.ArrayList;

public class Knight extends Piece {

	public Knight(Player colour) {
		super(colour, "Knight");
	}

	@Override
	public ArrayList<Square> possibleMoves(Square location) {
		ArrayList<Square> possibleMoves = new ArrayList<Square>(); 
		
		// up 2 left and right
		possibleMoves.add(location.getNeighbour(0, -1).getNeighbour(0, -1).getNeighbour(-1, 0));
		possibleMoves.add(location.getNeighbour(0, -1).getNeighbour(0, -1).getNeighbour(1, 0));
		// right 2 top and bottom
		possibleMoves.add(location.getNeighbour(1, 0).getNeighbour(1, 0).getNeighbour(0, -1));
		possibleMoves.add(location.getNeighbour(1, 0).getNeighbour(1, 0).getNeighbour(0, 1));
		// down 2 left and right
		possibleMoves.add(location.getNeighbour(0, 1).getNeighbour(0, 1).getNeighbour(-1, 0));
		possibleMoves.add(location.getNeighbour(0, 1).getNeighbour(0, 1).getNeighbour(1, 0));
		// left 2 top and bottom
		possibleMoves.add(location.getNeighbour(-1, 0).getNeighbour(-1, 0).getNeighbour(0, -1));
		possibleMoves.add(location.getNeighbour(-1, 0).getNeighbour(-1, 0).getNeighbour(0, -1));
		
		/*
		 * [ ][x][ ][x][ ]
		 * [x][ ][ ][ ][x]
		 * [ ][ ][K][ ][ ]
		 * [x][ ][ ][ ][x]
		 * [ ][x][ ][x][ ]
		 * 
		 */
		
		
		return possibleMoves;
	}

}
