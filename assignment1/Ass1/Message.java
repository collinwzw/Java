package assignment1;

public class Message {
	
	public String message;
	public int lengthOfMessage;

	public Message (String m){
		message = m;
		lengthOfMessage = m.length();
		this.makeValid();
	}
	
	public Message (String m, boolean b){
		message = m;
		lengthOfMessage = m.length();
	}
	
	/**
	 * makeValid modifies message to remove any character that is not a letter and turn Upper Case into Lower Case
	 */
	public void makeValid(){
		//INSERT YOUR CODE HERE
		
		String newString = "";
		 for (int i =0; i<lengthOfMessage;i++) {
			 
			 char character = message.charAt(i);
			 int ascill= (int) character;

			 if (ascill>=65 && ascill<=90) {		// convert upper case to lower
				 ascill= ascill+(97-65);
				 character = (char) ascill;		
				 newString = newString + character;

			 }
			 else if (ascill >= 97 && ascill <= 122) {		
				 newString = newString + character;
			 }	 
		 }
		message = newString;
		lengthOfMessage = message.length();
	}
	
	/**
	 * prints the string message
	 */
	public void print(){
		System.out.println(message);
	}
	/**
	 * tests if two Messages are equal
	 */
	public boolean equals(Message m){
		if (message.equals(m.message) && lengthOfMessage == m.lengthOfMessage){
			return true;
		}
		return false;
	}
	
	/**
	 * caesarCipher implements the Caesar cipher : it shifts all letter by the number 'key' given as a parameter.
	 * @param key
	 */
	public void caesarCipher(int key){
		// INSERT YOUR CODE HERE
		
		String newString = "";
		if(key> (122-97)|| key < 97-122) {
			//System.out.println("the key is invaild ");
			key=key%26;
		}
		for (int i =0; i<lengthOfMessage;i++) {
			 
			 char character = message.charAt(i);
			 int ascill= (int) character;
			 		
			 if (ascill+key<=122 && ascill +key >= 97) {
				 ascill= ascill+key;
				 
			 }
			 else if (key > 0){ 
				 ascill = ascill + key - (122-97)-1;
			 }
			 else {
				 ascill = ascill + key + (122-97)+1;
			 }
			 
			 character = (char) ascill;
			 newString = newString + character;
		}

		message = newString;
		lengthOfMessage = message.length();
	}
	
	public void caesarDecipher(int key){
		this.caesarCipher(- key);
	}
	
	/**
	 * caesarAnalysis breaks the Caesar cipher
	 * you will implement the following algorithm :
	 * - compute how often each letter appear in the message
	 * - compute a shift (key) such that the letter that happens the most was originally an 'e'
	 * - decipher the message using the key you have just computed
	 */
	public void caesarAnalysis(){
		// INSERT YOUR CODE HERE
		
		int []ascillarray= new int[2000];
		int[] count=new int[27];
		char character;
		int ascill;

		for (int i =0; i<lengthOfMessage;i++) { // put all numbers as intger and store in an array
			 
			 character = message.charAt(i);
			 ascill= (int) character;
			 ascillarray[i]=ascill;
		}
		for (int ascillchar=97; ascillchar<=122; ascillchar++) {
		int c=0;
		for (int j=0;j<lengthOfMessage; j++) {
			
			if (ascillarray[j]==ascillchar) {
				c = c +1;
			}
		}
		count[(ascillchar -97)] = c;
		
		}
			
		int max=0;
		int maxindex=0;
		for(int j=0; j<=26;j++) {  //finding max 
			
			if (count[j]>max) {
				max = count[j];
				maxindex=j;
			}
		}
		ascill = 97+maxindex;
		character = (char) ascill;
		
		int key = 101-ascill;
		caesarCipher(key);
	}
	
	/**
	 * vigenereCipher implements the Vigenere Cipher : it shifts all letter from message by the corresponding shift in the 'key'
	 * @param key
	 */
	public void vigenereCipher (int[] key){
		// INSERT YOUR CODE HERE

		int keylength=key.length;
		String newString = "";
		
		for (int j=0; j < key.length; j++) {
		if(key[j]> (122-97)|| key[j] < 97-122) {
			//System.out.println("the key is invaild ");
				key[j]=key[j]%26;
			}

		}
		
		for (int i =0; i<lengthOfMessage;i++) {
			 
			 char character = message.charAt(i);
			 int ascill= (int) character;
			 		
			 if (ascill+key[i%keylength]<=122 && ascill +key[i%keylength] >= 97) {
				 ascill= ascill+key[i%keylength];
				 
			 }
			 else if (key[i%keylength] > 0){ 
				 ascill = ascill + key[i%keylength] - (122-97)-1;
			 }
			 else {
				 ascill = ascill + key[i%keylength] + (122-97)+1;
			 }
			 
			 character = (char) ascill;
			 newString = newString + character;
				 
		}
		message = newString;
		lengthOfMessage = message.length();
		
	}

	/**
	 * vigenereDecipher deciphers the message given the 'key' according to the Vigenere Cipher
	 * @param key
	 */
	public void vigenereDecipher (int[] key){
		// INSERT YOUR CODE HERE
		int keylength=key.length;
		String newString = "";
		for (int j=0; j < key.length; j++) {
			if(key[j]> (122-97)|| key[j] < 97-122) {
				//System.out.println("the key is invaild ");
					key[j]=key[j]%26;
				}

			}
		
		int ascill;
		char character;
		for (int i=0; i<lengthOfMessage; i++) {
			character = message.charAt(i);
			ascill = (int) character;
			
			if (ascill-key[i%keylength]<=122 && ascill -key[i%keylength] >= 97) {
				 ascill= ascill-key[i%keylength];
				 
			 }
			 else if (key[i%keylength] > 0){ 
				 ascill = ascill - key[i%keylength] + 26;
			 }
			 else {
				 ascill = ascill - key[i%keylength] - 26;
			 }
			character = (char) ascill;
			newString = newString+character;
		}
		message = newString;
		lengthOfMessage = message.length();
	}
	
	/**
	 * transpositionCipher performs the transition cipher on the message by reorganizing the letters and eventually adding characters
	 * @param key
	 */
	public void transpositionCipher (int key){
		// INSERT YOUR CODE HERE

		int row= lengthOfMessage /key;
		if (lengthOfMessage%key != 0) {
			row = row + 1; 
		}

		char[][] array = new char[row][key];
		int count=0;
		
		//reading
		for (int i =0; i < row; i++) {
			for ( int j =0; j< key; j++) {
				
				if (count >= lengthOfMessage) {
					array[i][j] = '*';
				}
				else {
				char character = message.charAt(count);
				array[i][j] = character;
				count++;
				
				}
			}
		}
		
		//writing
		char []newmessage = new char[row* key];
		count=0;
		for (int j =0; j < key; j++) {
			for ( int i =0; i< row; i++) {
				
				newmessage[count] = array[i][j];
				count++;
			}
		}
		message = new String(newmessage);
		lengthOfMessage = count;

	}
	
	/**
	 * transpositionDecipher deciphers the message given the 'key'  according to the transition cipher.
	 * @param key
	 */
	public void transpositionDecipher (int key){
		// INSERT YOUR CODE HERE
		int row= lengthOfMessage /key;

		char[][] array = new char[row][key];
		int count=0;
		
		//read
		for (int j =0; j < key; j++) {
			for ( int i =0; i< row; i++) {
				char character = message.charAt(count);
				array[i][j] = character;
				count++;
				if(array[i][j]== '*') {
				}
				
			}
		}
		//wirte
		String newString = "";
	
		for (int i =0; i < row; i++) {
			for ( int j =0; j< key; j++) {
				if (array[i][j]!='*') {
					 newString = newString + array[i][j];
					
				}
			}
		}

		message = newString;
		lengthOfMessage = message.length();
	}
}
