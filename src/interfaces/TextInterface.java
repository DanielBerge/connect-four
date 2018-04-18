package interfaces;

import java.util.Scanner;

import inf101.v18.fourinarow.AI;
import inf101.v18.fourinarow.IBoard;
import inf101.v18.fourinarow.Player;
import inf101.v18.fourinarow.Rules;
import inf101.v18.fourinarow.Token;

public class TextInterface {
	private IBoard board;
	private boolean won;
	private Scanner inn = new Scanner(System.in);
	
	public TextInterface(IBoard board) {
		this.board = board;
		//startGame();
		startAiGame();
	}
	
	private void printBoard() {
		for(int i = 0; i<board.getWidth(); i++) {
			System.out.print(i+1 + " ");
		}
		for(int y = 0; y < board.getHeight(); y++) {
			System.out.println();
			for(int x = 0; x < board.getWidth(); x++) {
				if(board.getToken(x, y) == Token.BLANK) {
					System.out.print("# ");
				} else if(board.getToken(x, y) == Token.YELLOW) {
					System.out.print("x ");
				} else if(board.getToken(x, y) == Token.RED) {
					System.out.print("O ");
				}
			}
		}
	}
	
	private void startGame() {
		Player red = new Player(Token.RED, "Bjarne");
		Player yellow = new Player(Token.YELLOW, "Arne");
		Rules rules = new Rules();
		
		Player turn = red;
		printBoard();
		while(!won) {
			int tall = inn.nextInt();
			System.out.println(tall);
			board.placeToken(tall-1, turn.getToken());
			if(rules.hasWonFour(board, turn.getToken())) {
				System.out.println(turn.getName() + " HAS WON!!!!!!!!!!!!!!!!!!!");
			}
			if(turn == red) {
				turn = yellow;
			} else {
				turn = red;
			}
			
			printBoard();
		}
	}
	
	private void startAiGame() {
		Player red = new Player(Token.RED, "Bjarne");
		AI yellow = new AI(Token.YELLOW);
		Rules rules = new Rules();
		Token turn = red.getToken();
		
		printBoard();
		while(!won) {
			int tall = 0;
			if(turn == red.getToken()) {
				tall = inn.nextInt();
				System.out.println(tall);
			} else if (turn == yellow.getToken()) {
				tall = yellow.getMove(board);
				System.out.println(tall);
			}
			board.placeToken(tall-1, turn);

			if(rules.hasWonFour(board, turn)) {
				System.out.println(turn.toString() + " HAS WON!!!!!!!!!!!!!!!!!!!");
				won = true;
			}
			
			if(turn == red.getToken()) {
				turn = yellow.getToken();
			} else {
				turn = red.getToken();
			}
			
			printBoard();
		}
	}
}
