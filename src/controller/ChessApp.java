package controller;

import model.Board;
import model.Player;

public class ChessApp {

	private Player white, black;
	private Board board;
	
	public ChessApp() {
		init();
		play();
	}
	
	public void init() {
		// setup players
		white = new Player("white");
		black = new Player("black");
		
		// setup board
		board = new Board(black, white);
	}
	
	public void play() {
		while (true) {
			System.out.println(board);
			board.takeTurn(white);
			System.out.println(board);
			board.takeTurn(black);
		}
	}
	
	
	public static void main(String [] args) {
		new ChessApp();
	}
}
