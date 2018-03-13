package model;

import java.util.ArrayList;

public class Square {
	
	private ArrayList<Square> neighbours = new ArrayList<Square>();
	private int x, y;
	private Piece piece;
	
	public Square(int x, int y, Piece piece) {
		this.x = x;
		this.y = y;
		this.piece = piece;
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public Piece removePiece() {
		Piece p = piece;
		piece = null;
		return p;
	}
	
	public String toString() {
		return piece + "";
	}
	
	public void addNeighbour(Square square) {
		neighbours.add(square);
	}
	
	public ArrayList<Square> getNeighbours() {
		return neighbours;
	}
	
	public Square getNeighbour(int xDirection, int yDirection) {
		for (Square square : neighbours) {
			if (x + xDirection == square.getX() && y + yDirection == square.getY()) {
				return square;
			}
		}
		return null;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isEmpty() {
		return piece == null;
	}
	
	public boolean isOpponent(Player player) {
		return !isEmpty() && !piece.getOwner().equals(player);
	}
	
	public boolean isOwner(Player player) {
		return !isEmpty() && piece.getOwner().equals(player);
	}
	
}
