package assignment4Game;


public class Configuration {
	
	public int[][] board;
	public int[] available;
	boolean spaceLeft;
	
	public Configuration(){
		board = new int[7][6];
		available = new int[7];
		spaceLeft = true;
	}
	
	public void print(){
		System.out.println("| 0 | 1 | 2 | 3 | 4 | 5 | 6 |");
		System.out.println("+---+---+---+---+---+---+---+");
		for (int i = 0; i < 6; i++){
			System.out.print("|");
			for (int j = 0; j < 7; j++){
				if (board[j][5-i] == 0){
					System.out.print("   |");
				}
				else{
					System.out.print(" "+ board[j][5-i]+" |");
				}
			}
			System.out.println();
		}
	}
	
	public void addDisk (int index, int player){
		// ADD YOUR CODE HERE
		
		if (index > 6 || !this.spaceLeft || this.available[index] > 5) {
			System.out.println("the coloumn is full or board is full");	
			System.out.println("the disk is not added");
			return;
		}
		
		else if (this.available[index] <6) {
			//System.out.println("the coloumn is not full and the available is " + this.available[index]);	

			this.board[index][this.available[index]] = player;
			this.available[index] = this.available[index] + 1;
		}
		//System.out.println("after the adding disk, the available is " + this.available[index]);
		int count = 0;
		
		if(this.available[index] == 6) {
			for (int i=0; i < 7; i++) {
				if (this.available[i] == 6)	count = count + 1;	
			}
			if (count == 7) {
				this.spaceLeft = false;
			}
		}
		
	}
	
	public boolean isWinning (int lastColumnPlayed, int player){
		// ADD YOUR CODE HERE
		
		// checking the vertical
		int winingcheck = 0;
		int bound;
		if ((this.available[ lastColumnPlayed ] - 5) >=0) bound = (this.available[ lastColumnPlayed ] - 5);
		else bound = 0;
		for (int i = this.available[lastColumnPlayed] - 1; i > bound; i--) {
			if (this.board[lastColumnPlayed][i] == player)  winingcheck = winingcheck + 1;
			
		}
		if (winingcheck == 4)	return true;
		
		// checking for horizontal
		winingcheck = 0;
		for ( int i = 0; i <  7 ; i++) {
			if (this.board[i][this.available[lastColumnPlayed]-1] == player) {
				winingcheck = winingcheck + 1;
				if (winingcheck == 4)	return true;
			}
			else winingcheck = 0;
		}
		
		// checking diagonal
		winingcheck = 0;
		
		int startcolumn = 0;
		int startrow = 0;
		if (lastColumnPlayed - (this.available[lastColumnPlayed]-1) < 0 ) {
			startcolumn = 0;
			startrow = (this.available[lastColumnPlayed]-1) - lastColumnPlayed;
		}
		else {
			startrow = 0;
			startcolumn = lastColumnPlayed - (this.available[lastColumnPlayed]-1);
		}
		
		int i = startrow;
		int j = startcolumn;
		
		while(i < 6 && j < 7 ) {	
			//System.out.println("row number is " + i);
			//System.out.println("coloumn number is " +j);

			if (this.board[j][i] == player) {
				winingcheck = winingcheck + 1;
				if (winingcheck == 4)	return true;
			}
			else  winingcheck = 0;
			
			i++;
			j++;
		}
		
		winingcheck = 0;

		if (lastColumnPlayed + (this.available[lastColumnPlayed]-1) > 5 ) {
			startcolumn = lastColumnPlayed + (this.available[lastColumnPlayed]-1) -5;
			startrow = 5;
		}
		else {
			startrow = lastColumnPlayed + (this.available[lastColumnPlayed]-1);
			startcolumn = 0;
		}
		
		i = startrow;
		j = startcolumn;
		
		while(i >= 0 && j < 7 ) {	
			if (this.board[j][i] == player) {
				winingcheck = winingcheck + 1;
				if (winingcheck == 4)	return true;
				
			}
			else  winingcheck = 0;
			i--;
			j++;
		}
		return false; // DON'T FORGET TO CHANGE THE RETURN
	}
	
	public int canWinNextRound (int player){
		// ADD YOUR CODE HERE
		if (!this.spaceLeft)	return -1;
		for (int i=0; i<7; i++) {
			if (this.available[i] < 6) {
			//this.print();
			//System.out.println("before the adding is " + this.available[i]);
			this.addDisk(i, player);
			if (this.isWinning(i, player)) {
			 this.board[i][(this.available[i]-1)] = 0 ;
			 this.available[i] = this.available[i] -1;
			 //System.out.println("after the adding is " + this.available[i]);
				return i;
			}
			this.board[i][(this.available[i]-1)] = 0 ;
			this.available[i] = this.available[i] -1;
			//System.out.println("after the adding is " + this.available[i]);
		}
		}
		return -1; // DON'T FORGET TO CHANGE THE RETURN
	}
	
	public int canWinTwoTurns (int player){
		// ADD YOUR CODE HERE
		//this.print();

		int wintwocheck = 0;
		int player2 = 0;
		if (player == 1)	player2 = 2;
		else	 player2 = 1;
		
		if (canWinNextRound(player) == -1) {		
			for (int i = 0; i < 7 ; i++) {
				if (this.spaceLeft && this.available[i] < 6) {
				this.addDisk(i,player);
				if (!this.spaceLeft) return -1;
		player2loop:	for(int j = 0; j <7; j++) {
					if (this.spaceLeft && this.canWinNextRound(player2) != -1) break player2loop;
					if (this.spaceLeft && this.available[j] <6 ) {
					this.addDisk(j, player2);
					//this.print();
					if (this.spaceLeft && this.canWinNextRound(player) != -1)	wintwocheck++;
					//System.out.println(wintwocheck);
					this.board[j][this.available[j]-1] = 0 ;
					this.available[j] = this.available[j] -1;
					}
				}
				
				this.board[i][this.available[i]-1] = 0 ;
				this.available[i] = this.available[i] -1;
				if (wintwocheck == 7 )	return i;
				wintwocheck = 0;
			}
			}
		}
		return -1; // DON'T FORGET TO CHANGE THE RETURN
	}
	
}
//33321142100055666544