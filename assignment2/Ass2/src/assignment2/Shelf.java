package assignment2;

public class Shelf {
	
	protected int height;
	protected int availableLength;
	protected int totalLength;
	protected Box firstBox;
	protected Box lastBox;

	public Shelf(int height, int totalLength){
		this.height = height;
		this.availableLength = totalLength;
		this.totalLength = totalLength;
		this.firstBox = null;
		this.lastBox = null;
	}
	
	protected void clear(){
		availableLength = totalLength;
		firstBox = null;
		lastBox = null;
	}
	
	public String print(){
		String result = "( " + height + " - " + availableLength + " ) : ";
		Box b = firstBox;
		while(b != null){
			result += b.id + ", ";
			b = b.next;
		}
		result += "\n";
		return result;
	}
	
	/**
	 * Adds a box on the shelf. Here we assume that the box fits in height and length on the shelf.
	 * @param b
	 */
	public void addBox(Box b){
		//ADD YOUR CODE HERE
		b.next=null;			//reset all Box's link.
		b.previous=null;
		
		if (firstBox==null) {		// no box in shelf, add b to firstBox and also it's lastBox
		firstBox=b;
		lastBox=b;
		}
		else {
			lastBox.next=b;		//there is a box inside of shelf and add b to lastBox.next.
			b.previous=lastBox;		
			lastBox=b;
		}
		this.availableLength = availableLength - b.length;	//modify the available length
	}
	
	/**
	 * If the box with the identifier is on the shelf, remove the box from the shelf and return that box.
	 * If not, do not do anything to the Shelf and return null.
	 * @param identifier
	 * @return
	 */
	public Box removeBox(String identifier){
		//ADD YOUR CODE HERE	
		Box c = firstBox;			//initialize a current Box
			if (firstBox==null) {	// if firstBox==null means no Box in this shlef.
				return null;
			}
			else if (firstBox.id.equals(identifier)) {		//if firstBox.id = identifier  the Box is found
				this.availableLength = availableLength + firstBox.length;		//modify the available length
				if (firstBox==lastBox) {			//check if this Box is the only one in shelf
					firstBox=null;				// if it is, initialize the shelf to empty
					lastBox=null;
				}
				else {							// if not, reinitialize the firstBox to nextBox inside of shelf
				firstBox = firstBox.next;		
				firstBox.previous=null;			//remove the original nextBox.previous to null.
				}
				c.next=null;						//remove the link for founded Box.
				return c;
			}
			else {								// if the firstBox is not the Box we want.
				c=c.next;						// move current Box to next Box in shelf.
			while(c!=null) {						// check Box until the end

				if (c.id.equals(identifier)) {		//if the current Box is the Box we want
					if (c==lastBox) {				//condition check: if this current Box is the last Box
					lastBox= c.previous;				//reinitialize the lastBox to the one before lastBox in shelf
					lastBox.next=null;				//remove the link
					}
					else {							// if the current box is not the last box in shelf
					c.next.previous= c.previous;		//reassign the link between the box
					c.previous.next=c.next;
					}
					c.previous=null;					//finally remove all links for founded Box
					c.next=null;
					availableLength = availableLength + c.length;		//modify the length
					return c;
				}
				c=c.next;
			}
			}
		return null;
	}
	
}
