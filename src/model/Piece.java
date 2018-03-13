package model;

import java.util.ArrayList;

public abstract class Piece {

	protected Player owner;
	protected String name;
	protected boolean hasMoved;
	
	public Piece(Player owner, String name) {
		this.owner = owner;
		this.name = name;
	}
	
	public String toString() {
		return (owner + " ").substring(0, 1) + name;
	}
	
	abstract public ArrayList<Square> possibleMoves(Square location);
	
	public Player getOwner() {
		return owner;
	}
	
	protected ArrayList<Square> checkDirection(Square location, int xDirection, int yDirection) {
		ArrayList<Square> possibleMoves = new ArrayList<Square>();
		Square current = location;
		
		while ((current = current.getNeighbour(yDirection, xDirection)) != null && !current.isOwner(owner)) {
			possibleMoves.add(current);
			if (current.isOpponent(owner))
				break;
		}
		
		return possibleMoves;
	}
	
	public void move() {
		hasMoved = true;
	}
	
}
