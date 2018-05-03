package assignment2;

public class Warehouse{

	protected Shelf[] storage;
	protected int nbShelves;
	public Box toShip;
	public UrgentBox toShipUrgently;
	static String problem = "problem encountered while performing the operation";
	static String noProblem = "operation was successfully carried out";
	
	public Warehouse(int n, int[] heights, int[] lengths){
		this.nbShelves = n;
		this.storage = new Shelf[n];
		for (int i = 0; i < n; i++){
			this.storage[i]= new Shelf(heights[i], lengths[i]);
		}
		this.toShip = null;
		this.toShipUrgently = null;
	}
	
	public String printShipping(){
		Box b = toShip;
		String result = "not urgent : ";
		while(b != null){
			result += b.id + ", ";
			b = b.next;
		}
		result += "\n" + "should be already gone : ";
		b = toShipUrgently;
		while(b != null){
			result += b.id + ", ";
			b = b.next;
		}
		result += "\n";
		return result;
	}
	
 	public String print(){
 		String result = "";
		for (int i = 0; i < nbShelves; i++){
			result += i + "-th shelf " + storage[i].print();
		}
		return result;
	}
	
 	public void clear(){
 		toShip = null;
 		toShipUrgently = null;
 		for (int i = 0; i < nbShelves ; i++){
 			storage[i].clear();
 		}
 	}
 	
 	/**
 	 * initiate the merge sort algorithm
 	 */
	public void sort(){
		mergeSort(0, nbShelves -1);
	}
	
	/**
	 * performs the induction step of the merge sort algorithm
	 * @param start
	 * @param end
	 */
	protected void mergeSort(int start, int end){
		//ADD YOUR CODE HERE
		int middle;
		if (start<end) {
			middle = (start + end)/2;
			mergeSort(start,middle);
			mergeSort(middle+1, end);
			merge(start,middle,end);
		}
	}
	
	/**
	 * performs the merge part of the merge sort algorithm
	 * @param start
	 * @param mid
	 * @param end
	 */
	protected void merge(int start, int mid, int end){
		//ADD YOUR CODE HERE
		int n1=mid - start+1;
		int n2=end - mid;
		Shelf[] L= new Shelf[n1+1];
		Shelf[] R=new Shelf[n2+1];
		
		for (int i=0;i<n1;i++) {
			L[i]=storage[start+i];
		}
		for(int j =0;j<n2; j++) {
			R[j]=storage[mid+j+1];
		}
		int j=0;
		int i=0;
		L[n1]=new Shelf (1000,15);
		R[n2]=new Shelf (1000,15);
		
		for (int k=start; k <=end; k++) {
			if (L[i].height <= R[j].height) {
				storage[k]=L[i];
				i=i+1;
			}
			else {
				storage[k]=R[j];
				j=j+1;
			}
		}
	}
	
	/**
	 * Adds a box is the smallest possible shelf where there is room available.
	 * Here we assume that there is at least one shelf (i.e. nbShelves >0)
	 * @param b
	 * @return problem or noProblem
	 */
	public String addBox (Box b){
		//ADD YOUR CODE HERE
		Box c;
		int i=0;
		//checking if there is a Box has same id with b.
		while(i<nbShelves) {			//go through first shelf to end
			c = storage[i].firstBox;
			if(c==null) {
				//shelves are empty and no need to check.
				//System.out.println("There is no box in this shelf");
			}
			else {			//shelves are not empty
				while(c!=null) {			// as long as c is not equal to null means there is still box in shelves.
					if (c.id.equals(b.id)) {   // if there is a box has the same id with the one we want to add
						return problem;			
					}
					else {
						c=c.next;			//keep checking
					}
				}
			//System.out.println("The"+i+"th shelf is checked");
			}
			i++;	
		}
		// start to add Box in this 
		i=0;
		while(i < nbShelves) {	// go through all shlef
			if (b.length<=storage[i].availableLength && b.height<=storage[i].height) {	//check if height and length satisfy the requirement of b
				storage[i].addBox(b);		// add this box to end of shelf
				return "noProblem";
			}
			else {
				i=i+1;		//move shelf number to next
			}
		}
		
		return"Problem";		// if look through all shelfs and can't find any position to place the Box b, return problem.
	}
	
	/**
	 * Adds a box to its corresponding shipping list and updates all the fields
	 * @param b
	 * @return problem or noProblem
	 */
	public String addToShip (Box b){
		//ADD YOUR CODE HERE
		if (b instanceof Box ==true && b instanceof UrgentBox == true ) {		// check if the box is urgent or not
			if (toShipUrgently==null) {					// if the Ubox List is empty
			this.toShipUrgently= (UrgentBox) b;			// put box b into the Ubox list
			}
			else {
				toShipUrgently.previous = (UrgentBox) b;		//link the box inside of Ubox list to b Box.
				b.next = toShipUrgently;						// link b.next to current first box in Ubox list.
				toShipUrgently=(UrgentBox) b;				// finnaly assign first box in Ulist to box b.
			}
		}
		else {					// if the box is not Urgent, which means normal box.
			if (toShip==null) {
				this.toShip=  b;
				}
				else {
					toShip.previous = b;
					b.next = toShip;
					toShip= b;
				}
		}
		return noProblem;
	}
	
	/**
	 * Find a box with the identifier (if it exists)
	 * Remove the box from its corresponding shelf
	 * Add it to its corresponding shipping list
	 * @param identifier
	 * @return problem or noProblem
	 */
	public String shipBox (String identifier){
		//ADD YOUR CODE HERE
		Box c = null;
		int i=0;
		
		outerloop:				//outerloop checks every shelves in warehose
		while(i<nbShelves) {
			c = storage[i].firstBox;
			if(storage[i].firstBox==null) {
				//shelves are empty and no need to check.
			}
			else {			//shelves are not empty
				while(c!=null) {			// as long as c is not equal to null means there is still box in shelves.
					if (c.id.equals(identifier)) {	// found the box and jump out the outerloop with c pointing to founded box
						break outerloop;
					}
					else {
						if (i==nbShelves-1 && c == storage[nbShelves-1].lastBox) {
						return problem;		// didnt find this box.
						}
						c=c.next;		
					}
				}
			}
			i++;
		}		// end of outerloop
		
		if (i==nbShelves) return problem;		//condition check, if i is out of index which means didnt find the box.
		this.storage[i].removeBox(c.id);			// if found the box, remove this box from shelf.
		addToShip(c);							// add this box to ship list
		return noProblem;
	}
	
	/**
	 * if there is a better shelf for the box, moves the box to the optimal shelf.
	 * If there are none, do not do anything
	 * @param b
	 * @param position
	 */
	public void moveOneBox (Box b, int position){
		//ADD YOUR CODE HERE
		Box c;
		//find box first
		c=storage[position].firstBox;	
		if(storage[position].firstBox==null) {
			//shelves are empty and no need to check.
			//System.out.println("no box in this shelf, can't find the box in this shelf");
		}
		else {			//shelves are not empty
			outerloop:
			while(c!=null) {			// as long as c is not equal to null means there is still box in shelves.
				if (position==0) break outerloop; // if the position is already 0, which means in #0 shelf. no need to move, break outerloop
				if (c.id.equals(b.id)) {	// if find this box
					int i;
					for(i=0;i<position;i++) {	// check the shelf
						if(storage[i].availableLength>=b.length&& storage[i].height>=b.height) {	//if there is a space before the shelf that box located
							this.storage[position].removeBox(b.id);
							storage[i].addBox(b);
							break outerloop;
						}
					}
				}
				else {		// current box is not equal to the box we want to find.
					if ( c == storage[position-1].lastBox) {	//checked all shelf that before the shelf the box located
						break outerloop;				// no space for box to relocated and break outerloop
						//System.out.println("the box id with"+identifier+"is not found in warehouse");
						//System.out.println("can't find the box in this shelf");
					}
				}
					c=c.next;		// keep increment.
			}		// end of outerloop
		}
	}
	
	/**
	 * reorganize the entire warehouse : start with smaller shelves and first box on each shelf.
	 */
	public void reorganize (){
		//ADD YOUR CODE HERE
		Box c = null;
		int i=0;			
		while(i<nbShelves) {
			c = storage[i].firstBox;
			if(storage[i].firstBox==null) {
				//shelves are empty and no need to check.
				//System.out.println("there is nothing in "+i+ "shelf");
			}
			else {			//shelves are not empty
				while(c!=null) {			// as long as c is not equal to null means there is still box in shelves.
					if (c==storage[i].firstBox) {	// if the box is the first box in the shelf
					//System.out.println("the box " + c.id+ "is being reorganize" );
					moveOneBox(c, i);			//relocate the box
					//System.out.println("the box " + c.id+ "is being reorganize" );
					if (c==storage[i].firstBox && c==storage[i].lastBox)  break;	// if the box didnt moved after relocation and this box is only box in this shelf. jump out this shelf.
					else if(c==storage[i].firstBox&& c!=storage[i].lastBox) c=c.next;	// if the box didnt moved after relocation and there are more box in this shelf . go to next box
					else c= storage[i].firstBox;			// the box moved and we want to current box pointing to the modyfied firstbox in this shelf		
					}
					else {
						moveOneBox(c, i);
						c=c.next;
					}
				}
			}
			i++;
		}
	}
}