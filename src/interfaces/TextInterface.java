package interfaces;

import java.util.Scanner;

import inf101.v18.fourinarow.AI;
import inf101.v18.fourinarow.IBoard;
import inf101.v18.fourinarow.AbstractPlayer;
import inf101.v18.fourinarow.Human;
import inf101.v18.fourinarow.Rules;
import inf101.v18.fourinarow.Token;

public class TextInterface {
	private IBoard board;
	private boolean won;
	private Scanner inn = new Scanner(System.in);
	
	public TextInterface(IBoard board) {
		this.board = board;
		//startGame();
		printBoard();
	}
	
	private void printBoard() {

		for(int i = 0; i < board.getWidth(); i++) {
			System.out.print(i+1 + " ");
		}
		for(int y = 0; y < board.getHeight()+1; y++) {
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
		AbstractPlayer red = new Human(Token.RED);
		AbstractPlayer yellow = new Human(Token.YELLOW);
		
		AbstractPlayer turn = red;
		printBoard();
		while(!won) {
			int tall = inn.nextInt();
			System.out.println(tall);
			board.placeToken(tall-1, turn.getToken());
			if(Rules.hasWonFour(board, turn.getToken())) {
				System.out.println(turn.getToken() + " HAS WON!!!!!!!!!!!!!!!!!!!");
			}
			if(turn == red) {
				turn = yellow;
			} else {
				turn = red;
			}
			
			printBoard();
		}
	}
}
