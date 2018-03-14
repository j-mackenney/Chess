package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	
	private Scanner in = new Scanner(System.in);
	
	private final int [] [] BOARD = {
		{5, 4, 3, 2, 1, 3, 4, 5},
		{6, 6, 6, 6, 6, 6, 6, 6},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{6, 6, 6, 6, 6, 6, 6, 6},
		{5, 4, 3, 2, 1, 3, 4, 5}
	};
	
	private Square [] [] board = new Square [8] [8];
	
	public Board(Player black, Player white) {
		setup(black, white);
	}
	
	private void setup(Player black, Player white) {
		Player colour = white;
		for (int row = 0; row < BOARD.length; row++) { 
			for (int col = 0; col < BOARD[row].length; col++) {
				Piece piece = createPiece(BOARD[row][col], colour);
				Square square = new Square(col, row, piece);
				board [row] [col] = square;
				
				if (row > 3 && colour.equals(white))
					colour = black;
			
			}
		}
		
		// setup the neighbours for each square
		for (Square [] row : board) {
			for (Square square : row) {
				setNeighbours(square);
			}
		}
		
	}
	
	private void setNeighbours(Square square) {
		int x = square.getX();
		int y = square.getY();
		
		for (int yOffset = -1; yOffset <= 1; yOffset++) {
			for (int xOffset = -1; xOffset <= 1; xOffset++) {
				if (yOffset == 0 && xOffset == 0)
					continue;
				int xPos = x + xOffset;
				int yPos = y + yOffset;
				if (yPos >= 0 && xPos >= 0 && yPos < board.length && xPos < board[yPos].length) {
					square.addNeighbour(board[yPos][xPos]);
				}
				
			}
		}
		
	}
	
	private Piece createPiece(int id, Player colour) {
		switch (id) {
			case 1 : return new King(colour); // King
			case 2 : return new Queen(colour); // Queen
			case 3 : return new Bishop(colour); // Bishop
			case 4 : return new Knight(colour); // Knight
			case 5 : return new Rook(colour); // Rook
			case 6 : return new Pawn(colour); // Pawn
			default : return null;
		}
	}
	
	public void takeTurn(Player player) {
		System.out.println(player.getColour() + "'s turn!");
		
		Square source = selectSquare("Select source");
		while (!source.isOwner(player)) {
			source = selectSquare("Select source");
		}
		
		Square target = selectSquare("Select target");
		while (!source.getPiece().possibleMoves(source).contains(target)) {
			if (target.isOwner(player))
				source = target;
			// check for check
			target = selectSquare("Select target");
		}
		
		movePiece(source, target);
	}
	
	private void movePiece(Square source, Square target) {
		Piece piece = source.removePiece();
		target.setPiece(piece);
		piece.move();
	}
	
	private Square selectSquare(String message) {
		Square square;
		do { 
			System.out.print(message + ": ");
			square = convertInput(in.nextLine()); 
		}
		while (square == null);
		return square;
	}
	
	private Square convertInput(String input) {
		String columns = "abcdefgh";
		try {
			if (input.length() != 2)
				throw new Exception();
			int col = columns.indexOf(input.charAt(0));
			int row = Character.getNumericValue(input.charAt(1) -1);
			return board[row][col];
		} catch (Exception e) {
			return null;
		}
	}
	
	public String toString() {
		String s = "";
		s += "     [ a ][ b ][ c ][ d ][ e ][ f ][ g ][ h ]\n";
		for (int row = 0; row < board.length; row++) {
			s += "[ " + (row+1) + " ]";
			for (int col = 0; col < board[row].length; col++) {
				s += "[" + board[row][col].toString().substring(0, 3) + "]";
			}
			s += "\n";
		}
		
		return s;
	}
	
	private ArrayList<Square> getOpponentPieces(Player player) {
		ArrayList<Square> pieces = new ArrayList<Square>();
		for (Square [] row : board) {
			for (Square square : row) {
				if (square.isOpponent(player))
					pieces.add(square);
			}
		}
		return pieces;
	}
	
	private boolean isInCheck(Square king) {
		ArrayList<Square> moveList = new ArrayList<Square>();
		for (Square square : getOpponentPieces(king.getPiece().getOwner())) {
			moveList.addAll(square.getPiece().possibleMoves(square));
		}
		return moveList.contains(king);
	}
	
	private Square findKing(Player player) {
		for (Square [] row : board) {
			for (Square square : row) {
				if (square.getPiece().getName().equals("King") && square.isOwner(player))
					return square;
			}
		}
		return null;
	}
	
}
