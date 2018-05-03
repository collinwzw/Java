package assignment4Game;

import java.io.*;

public class Game {
	
	public static int play(InputStreamReader input){
		BufferedReader keyboard = new BufferedReader(input);
		Configuration c = new Configuration();
		int columnPlayed = 3; int player;
		
		// first move for player 1 (played by computer) : in the middle of the grid
		c.addDisk(firstMovePlayer1(), 1);
		c.print();

		int nbTurn = 1;
		
		while (nbTurn < 42){ // maximum of turns allowed by the size of the grid
			player = nbTurn %2 + 1;
			if (player == 2){
				columnPlayed = getNextMove(keyboard, c, 2);
			}
			if (player == 1){
				columnPlayed = movePlayer1(columnPlayed, c);
			}
			System.out.println(columnPlayed);
			c.addDisk(columnPlayed, player);
			if (c.isWinning(columnPlayed, player)){
				c.print();
				System.out.println("Congrats to player " + player + " !");
				return(player);
			}
			nbTurn++;
		}
		return -1;
	}
	
	public static int getNextMove(BufferedReader keyboard, Configuration c, int player){
		// ADD YOUR CODE HERE
		c.print();
		char number ='a';
		int coloumn = (int) number;
		System.out.println(coloumn);
		
		while (coloumn < 48 || coloumn > 54) {
			
			System.out.println("enter the coloumn number that you want to play");
		
			try {
				coloumn = keyboard.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		if (coloumn >= 48 && coloumn < 55 && c.available[coloumn-48] > 5) {
			coloumn = 'a';
			System.out.println("the coloumn you entered is full.");
		}
		}
				
		coloumn = coloumn - 48;
		//c.print();
		return coloumn; // DON'T FORGET TO CHANGE THE RETURN
	}
	
	public static int firstMovePlayer1 (){
		return 3;
	}
	
	public static int movePlayer1 (int columnPlayed2, Configuration c){
		// ADD YOUR CODE HERE
		//c.print();
		int player = 1;
		int move = 0;
		if(!c.spaceLeft)		System.out.println("the configuartion is full");
		if (c.canWinNextRound(player) !=  -1) {
			move = c.canWinNextRound(player);
			//System.out.println("the player can win in next.");
			return move;
		}
		//System.out.println("play can win in next is " + c.canWinNextRound(player));

		//System.out.println("play can win in two is " + c.canWinTwoTurns(player));
		//System.out.println("coloum available is  " + c.available[columnPlayed2]);

		if ((c.canWinTwoTurns(player)) != -1) {
			move = c.canWinTwoTurns(player);
			//System.out.println("the player can win in two.");
			return move;
		}
		
		if (c.available[columnPlayed2] < 6 ) {
			//System.out.println("there is still space in played coloumn");

			return columnPlayed2;
		}
		
		if (c.available[columnPlayed2] == 6 && c.spaceLeft  ) {
			//System.out.println("there is nol space in played coloumn");
			int i = columnPlayed2;
			int j = 1;
			while (i <  7 &&  i >= 0) {
				if ( i-j >= 0 && c.available[i-j] < 6) {
					
					return i-j;
				}
				if ( i+j < 7 && c.available[i+j] < 6) {
					
					return i+j;
				}
				j++;
			}	
		}
		
		return -1; // DON'T FORGET TO CHANGE THE RETURN
	}
	
}
