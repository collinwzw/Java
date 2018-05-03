/*
package assignment2;
public class Tester {
		/**
		 * This tester includes a bigger storage size, a total of 15 boxes.
		 * Examples of special operations include:
		 * -Adding boxes that fit perfectly in a shelf
		 * -Adding boxes that are bigger than the total shelf length
		 * -Adding boxes that are taller than the max shelf height
		 * -Adding boxes that were already added to the warehouse. (e.g.: adding box 2 twice)
		 * -Adding boxes that were already shipped
		 * -Shipping boxes that aren't in the warehouse
		 * -Shipping boxes that are already shipped
		 * @param args
		 */
/*
		public static void main(String[] args) {
			boolean passAllTest=true;
			int[] heights = new int[] {4 , 3, 1, 5, 6, 3, 4};
			int[] lengths = new int[] {20,20,20,20,20,20,20};
			Warehouse warehouse = new Warehouse(heights.length,heights, lengths);
			warehouse.sort();
			String testSort="0-th shelf ( 1 - 20 ) : \n1-th shelf ( 3 - 20 ) : \n2-th shelf ( 3 - 20 ) : \n3-th shelf ( 4 - 20 ) : \n4-th shelf ( 4 - 20 ) : \n5-th shelf ( 5 - 20 ) : \n6-th shelf ( 6 - 20 ) : \n";
			if (warehouse.print().equals(testSort)){
				System.out.println("GOOD: Merge Sort seems to work");
			}
			else{
				passAllTest=false;
				System.out.println("BAD: Merge Sort doesn't work");
				System.out.println(warehouse.print());
				System.out.println(testSort);
				System.exit(0);
			}
			

			Box b1 = new Box(2, 4, "Box 1");
			Box b2 = new Box(4, 10, "Box 2");
			Box b3 = new Box(2, 10, "Box 3");
			Box b4 = new UrgentBox(2, 10, "Box 4");
			Box b5 = new UrgentBox(7,1,"Box 5");
			Box b6 = new UrgentBox(3,10,"Box 6");
			Box b7 = new UrgentBox(4,21,"Box 7");
			Box b8 = new UrgentBox(5,20,"Box 8");
			Box b9 = new UrgentBox(6,15,"Box 9");
			Box b10 = new UrgentBox(6,6,"Box 10");
			Box b11 = new Box(1,4,"Box 11");
			Box b12 = new UrgentBox(1,4,"Box 12");
			Box b13 = new UrgentBox(1,4,"Box 13");
			Box b14 = new Box(1,4,"Box 14");
			Box b15 = new UrgentBox(1,4,"Box 15");
			
			
			// TESTING ADDBOX
			String testAddShelf = "0-th shelf ( 1 - 20 ) : \n1-th shelf ( 3 - 20 ) : \n2-th shelf ( 3 - 20 ) : \n3-th shelf ( 4 - 20 ) : \n4-th shelf ( 4 - 2 ) : Box 2, Box 1, Box 15, \n5-th shelf ( 5 - 20 ) : \n6-th shelf ( 6 - 20 ) : \n";
			warehouse.storage[4].addBox(b2);
			warehouse.storage[4].addBox(b1);
			warehouse.storage[4].addBox(b15);
			if (warehouse.print().equals(testAddShelf)){
				System.out.println("GOOD: Adding a box on a shelf seems to work");
			}
			else{
				passAllTest=false;
				System.out.println("BAD: Adding a box on a shelf FAILED");
				System.out.println(warehouse.print());
				System.out.println(testAddShelf);
				System.exit(0);
			}
			warehouse.clear();
			
			String testAddW = "0-th shelf ( 1 - 0 ) : Box 11, Box 12, Box 13, Box 14, Box 15, \n1-th shelf ( 3 - 6 ) : Box 1, Box 3, \n2-th shelf ( 3 - 0 ) : Box 4, Box 6, \n3-th shelf ( 4 - 10 ) : Box 2, \n4-th shelf ( 4 - 20 ) : \n5-th shelf ( 5 - 0 ) : Box 8, \n6-th shelf ( 6 - 5 ) : Box 9, \n";
			warehouse.addBox(b1);
			warehouse.addBox(b1);
			warehouse.addBox(b2);
			warehouse.addBox(b3);
			warehouse.addBox(b4);
			warehouse.addBox(b5);
			warehouse.addBox(b6);
			warehouse.addBox(b7);
			warehouse.addBox(b8);
			warehouse.addBox(b9);
			warehouse.addBox(b10);
			warehouse.addBox(b11);
			warehouse.addBox(b12);
			warehouse.addBox(b13);
			warehouse.addBox(b14);
			warehouse.addBox(b15);
			//System.out.println(warehouse.print());
			if (warehouse.print().equals(testAddW) & b3.previous == b1){
				System.out.println("GOOD: Adding a box in the warehouse seems to work");
			}
			else{
				passAllTest=false;
				System.out.println("BAD: Adding a box in the Warehouse doesn't work");
				System.out.println(warehouse.print());
				System.out.println(testAddW);
				System.exit(0);
			}
			//System.out.println(warehouse.print());

			
			// TESTING REMOVEBOX
			String testremoveBox = "0-th shelf ( 1 - 4 ) : Box 11, Box 12, Box 14, Box 15, \n1-th shelf ( 3 - 10 ) : Box 3, \n2-th shelf ( 3 - 0 ) : Box 4, Box 6, \n3-th shelf ( 4 - 20 ) : \n4-th shelf ( 4 - 20 ) : \n5-th shelf ( 5 - 0 ) : Box 8, \n6-th shelf ( 6 - 5 ) : Box 9, \n";
			warehouse.storage[1].removeBox("Box 1");
			//System.out.println(warehouse.print());
			//System.out.println(warehouse.storage[2].print());
			warehouse.storage[0].removeBox("Box 13");
			warehouse.storage[0].removeBox("Box 13");
			warehouse.storage[3].removeBox("Box 2");
			warehouse.storage[5].removeBox("Box 2");
			warehouse.storage[6].removeBox("Box 2");
			warehouse.storage[2].removeBox("Box 2");
			//System.out.println(warehouse.print());
			if (warehouse.print().equals(testremoveBox) && b3.previous == null && b3.next == null && b1.previous == null && b1.next == null && b2.previous == null && b2.next== null){
				System.out.println("GOOD: Removing a box from a shelf seems to work");
			}
			else{
				passAllTest=false;
				System.out.println("BAD: Removing a box from a shelf doesn't work");
				System.out.println(warehouse.print());
				System.out.println(testremoveBox);
				System.exit(0);
			}

				
			warehouse.clear();
			
			// TESTING SHIPBOX
			warehouse.addBox(b1);
			warehouse.addBox(b3);
			warehouse.addBox(b4);
			warehouse.addBox(b5);
			warehouse.addBox(b6);
			warehouse.addBox(b7);
			warehouse.addBox(b8);
			warehouse.addBox(b9);
			warehouse.addBox(b10);
			warehouse.addBox(b11);
			warehouse.addBox(b12);
			warehouse.addBox(b13);
			warehouse.addBox(b14);
			warehouse.addBox(b15);
			//System.out.println(warehouse.print());
			//System.out.println(warehouse.storage[6].print());

			Boolean testShip2 = warehouse.shipBox("Box 2") == Warehouse.problem;
			Boolean testShip3 = warehouse.shipBox("Box 3") == Warehouse.noProblem;
			Boolean testShip4 = warehouse.shipBox("Box 4") == Warehouse.noProblem;
			Boolean testShip5 = warehouse.shipBox("Box 5") == Warehouse.problem;
			Boolean testShip6 = warehouse.shipBox("Box 2") == Warehouse.problem;
			Boolean testShip7 = warehouse.shipBox("Box 4") == Warehouse.problem;
			Boolean testShip8 = warehouse.shipBox("Box 8") == Warehouse.noProblem;
			
			//System.out.println(warehouse.print());
			//System.out.println(warehouse.printShipping());
			String testShip = "0-th shelf ( 1 - 0 ) : Box 11, Box 12, Box 13, Box 14, Box 15, \n1-th shelf ( 3 - 16 ) : Box 1, \n2-th shelf ( 3 - 10 ) : Box 6, \n3-th shelf ( 4 - 20 ) : \n4-th shelf ( 4 - 20 ) : \n5-th shelf ( 5 - 20 ) : \n6-th shelf ( 6 - 5 ) : Box 9, \n";
			String testShipping = "not urgent : Box 3, \nshould be already gone : Box 8, Box 4, \n";
			if (warehouse.print().equals(testShip) && warehouse.printShipping().equals(testShipping)){
				if (testShip2 & testShip4 & testShip3 & testShip5 & testShip6 & testShip7 &testShip8 ){
					System.out.println("GOOD: Shipping a box seems to work");
				}
				else{
					System.out.println("BAD: Use the strings of the class warehouse for shipping a box");
					System.exit(0);
				}
			}
			else{				passAllTest=false;
				System.out.println("BAD: Shipping a box doesn't work");
				System.out.println(warehouse.print());
				System.out.println(testShip);
				System.out.println(warehouse.printShipping());
				System.out.println(testShipping);
			
				System.exit(0);
			}
			//System.out.println(warehouse.print());
			
			Boolean testShip9 = warehouse.shipBox("Box 11") == Warehouse.noProblem;
			Boolean testShip10 = warehouse.shipBox("Box 12") == Warehouse.noProblem;
			Boolean testShip11 = warehouse.shipBox("Box 15") == Warehouse.noProblem;
			Boolean testShip12 = warehouse.shipBox("Box 14") == Warehouse.noProblem;
			Boolean testShip13 = warehouse.shipBox("Box 14") == Warehouse.problem;
			warehouse.addBox(b2);
			//System.out.println(warehouse.print());

			Boolean testAdd1 = warehouse.addBox(b2)==Warehouse.problem;
			Boolean testAdd2 = warehouse.addBox(b1)==Warehouse.problem;		
			
			
			
			//System.out.println(warehouse.printShipping());
			testShip = "0-th shelf ( 1 - 16 ) : Box 13, \n1-th shelf ( 3 - 16 ) : Box 1, \n2-th shelf ( 3 - 10 ) : Box 6, \n3-th shelf ( 4 - 10 ) : Box 2, \n4-th shelf ( 4 - 20 ) : \n5-th shelf ( 5 - 20 ) : \n6-th shelf ( 6 - 5 ) : Box 9, \n";
			testShipping = "not urgent : Box 14, Box 11, Box 3, \nshould be already gone : Box 15, Box 12, Box 8, Box 4, \n";
		
			if (warehouse.print().equals(testShip) && warehouse.printShipping().equals(testShipping)){
				if ( testShip9 & testShip10 & testShip11 & testShip12 & testAdd1 & testAdd2 &testShip13){
					System.out.println("GOOD: Shipping a box #2 seems to work");
				}
				else{
					System.out.println("BAD: Use the strings of the class warehouse for shipping a box");
				}
			}
			else{				passAllTest=false;
				System.out.println("BAD: Shipping a box #2 doesn't work");
			}
			
			warehouse.clear();
			
			//TESTING MOVE ONE BOX
			warehouse.storage[4].addBox(b1);
			warehouse.addBox(b3);
			//System.out.println(warehouse.print());
			warehouse.moveOneBox(b1, 6);
			warehouse.moveOneBox(b2, 6);
			warehouse.moveOneBox(b1, 4);
			
			//System.out.println(warehouse.print());
			String testMove = "0-th shelf ( 1 - 20 ) : \n1-th shelf ( 3 - 6 ) : Box 3, Box 1, \n2-th shelf ( 3 - 20 ) : \n3-th shelf ( 4 - 20 ) : \n4-th shelf ( 4 - 20 ) : \n5-th shelf ( 5 - 20 ) : \n6-th shelf ( 6 - 20 ) : \n";
			if (warehouse.print().equals(testMove)){
				System.out.println("GOOD: Moving a box from a shelf seems to work");
			}
			else{
				passAllTest=false;
				System.out.println("BAD: Moving a box from a shelf doesn't work");
			}
			warehouse.clear();
			
			//System.out.println(warehouse.print());

			//TESTING REORGANIZE
			warehouse.storage[4].addBox(b1);
			//System.out.println(warehouse.print());

			warehouse.storage[6].addBox(b2);
			//System.out.println(warehouse.print());

			warehouse.storage[3].addBox(b3);
			//System.out.println(warehouse.print());

			warehouse.storage[1].addBox(b4);
			
			warehouse.storage[6].addBox(b8);

			warehouse.storage[4].addBox(b6);

			warehouse.storage[3].addBox(b11);
			
			warehouse.addBox(b1);
			warehouse.addBox(b3);
			warehouse.addBox(b4);
			warehouse.addBox(b5);
			warehouse.addBox(b6);
			warehouse.addBox(b7);
			warehouse.addBox(b8);
			warehouse.addBox(b9);
			warehouse.addBox(b10);
			warehouse.addBox(b11);
			warehouse.addBox(b12);
			warehouse.addBox(b13);
			warehouse.addBox(b14);
			warehouse.addBox(b15);
			//System.out.println(warehouse.print());


			warehouse.reorganize();
			//System.out.println("after reorganize");
			//System.out.println(warehouse.print());

			warehouse.addBox(b1);
			warehouse.addBox(b3);
			warehouse.addBox(b4);
			warehouse.addBox(b5);
			warehouse.addBox(b6);
			warehouse.addBox(b7);
			warehouse.addBox(b8);
			warehouse.addBox(b9);
			warehouse.addBox(b10);
			warehouse.addBox(b11);
			warehouse.addBox(b12);
			warehouse.addBox(b13);
			warehouse.addBox(b14);
			warehouse.addBox(b15);
			
			
			//System.out.println(warehouse.print());

			warehouse.reorganize();
			//System.out.println(warehouse.print());
			
			String testReorganize = "0-th shelf ( 1 - 0 ) : Box 12, Box 13, Box 14, Box 15, Box 11, \n1-th shelf ( 3 - 0 ) : Box 4, Box 3, \n2-th shelf ( 3 - 6 ) : Box 1, Box 6, \n3-th shelf ( 4 - 10 ) : Box 2, \n4-th shelf ( 4 - 20 ) : \n5-th shelf ( 5 - 0 ) : Box 8, \n6-th shelf ( 6 - 5 ) : Box 9, \n";
			if (warehouse.print().equals(testReorganize)){
				System.out.println("GOOD: Reorganizing the warehouse seems to work");
			}
			else{
				passAllTest=false;
				System.out.println("BAD: Reorganizing the warehouse doesn't work");
			}
			if (passAllTest)System.out.println("You did it!\n #* ~(^.^)~ *#");
			 
		}
	}

*/




package assignment2;

public class Tester {

	public static void main(String[] args) {

		int[] lengths = new int[] {4, 3, 1,5, 6};
		Warehouse warehouse = new Warehouse(5,lengths, new int[] {15,15,15,15,15});
		
		//TESTING SORT
		warehouse.sort();
		String testSort = "0-th shelf ( 1 - 15 ) : \n1-th shelf ( 3 - 15 ) : \n2-th shelf ( 4 - 15 ) : \n3-th shelf ( 5 - 15 ) : \n4-th shelf ( 6 - 15 ) : \n";
		if (warehouse.print().equals(testSort)){
			System.out.println("Merge Sort seems to work");
		}
		else{
			System.out.println("Merge Sort does not work");
		}
		
		Box b1 = new Box(2, 4, "Box 1");
		Box b2 = new Box(4, 10, "Box 2");
		Box b3 = new Box(2, 10, "Box 3");
		Box b4 = new UrgentBox(2, 10, "Box 4");

		// TESTING ADDBOX
		String testAddShelf = "0-th shelf ( 1 - 15 ) : \n1-th shelf ( 3 - 15 ) : \n2-th shelf ( 4 - 15 ) : \n3-th shelf ( 5 - 15 ) : \n4-th shelf ( 6 - 5 ) : Box 2, \n";
		warehouse.storage[4].addBox(b2);
		if (warehouse.print().equals(testAddShelf)){
			System.out.println("Adding a box on a shelf seems to work");
		}
		else{
			System.out.println("Adding a box on a shelf does not work");
			System.out.println(warehouse.print());
			System.out.println(testAddShelf);
		}
		
		String testAddW = "0-th shelf ( 1 - 15 ) : \n1-th shelf ( 3 - 1 ) : Box 1, Box 3, \n2-th shelf ( 4 - 15 ) : \n3-th shelf ( 5 - 15 ) : \n4-th shelf ( 6 - 5 ) : Box 2, \n";
		warehouse.addBox(b1);
		warehouse.addBox(b3);
		if (warehouse.print().equals(testAddW) & b3.previous == b1){
			System.out.println("Adding a box in the warehouse seems to work");
		}
		else{
			System.out.println("Adding a box in the Warehouse does not work");
			System.out.println(warehouse.print());
			System.out.println(testAddW);
		}
	
		// TESTING REMOVEBOX
		String testremoveBox = "0-th shelf ( 1 - 15 ) : \n1-th shelf ( 3 - 5 ) : Box 3, \n2-th shelf ( 4 - 15 ) : \n3-th shelf ( 5 - 15 ) : \n4-th shelf ( 6 - 5 ) : Box 2, \n";
		warehouse.storage[1].removeBox("Box 1");
		warehouse.storage[2].removeBox("Box 2");
		if (warehouse.print().equals(testremoveBox) && b3.previous == null && b3.next == null && b1.previous == null && b1.next == null && b2.previous == null && b2.next== null){
			System.out.println("Removing a box from a shelf seems to work");
		}
		else{
			System.out.println("Removing a box from a shelf does not work");
			System.out.println(warehouse.print());
			System.out.println(testremoveBox);
		}
		
		warehouse.clear();
		
		// TESTING SHIPBOX
		warehouse.addBox(b1);
		warehouse.addBox(b2);
		warehouse.addBox(b3);
		warehouse.addBox(b4);
		//warehouse.addToShip(b4);
		//System.out.println("after the add to ship the warehouse is"+warehouse.print());
		Boolean testShip2 = warehouse.shipBox("Box 2") == Warehouse.noProblem;
		Boolean testShip4 = warehouse.shipBox("Box 4") == Warehouse.noProblem;
		Boolean testShip3 = warehouse.shipBox("Box 3") == Warehouse.noProblem;
		Boolean testShip5 = warehouse.shipBox("Box 5") == Warehouse.problem;
		String testShip = "0-th shelf ( 1 - 15 ) : \n1-th shelf ( 3 - 11 ) : Box 1, \n2-th shelf ( 4 - 15 ) : \n3-th shelf ( 5 - 15 ) : \n4-th shelf ( 6 - 15 ) : \n";
		String testShipping = "not urgent : Box 3, Box 2, \nshould be already gone : Box 4, \n";
		if (warehouse.print().equals(testShip) && warehouse.printShipping().equals(testShipping)){
			if (testShip2 & testShip4 & testShip3 & testShip5){
				System.out.println("Shipping a box seems correct");
			}
			else{
				System.out.println("Use the strings of the class warehouse for shipping a box");
			}
		}
		else{
			System.out.println("Shipping a box does not work");
			System.out.println(warehouse.printShipping());
			System.out.println(testShipping);
		}
		
		warehouse.clear();
	
		//TESTING MOVE ONE BOX
		warehouse.storage[4].addBox(b1);
		warehouse.addBox(b3);
		warehouse.moveOneBox(b1, 4);
		String testMove = "0-th shelf ( 1 - 15 ) : \n1-th shelf ( 3 - 1 ) : Box 3, Box 1, \n2-th shelf ( 4 - 15 ) : \n3-th shelf ( 5 - 15 ) : \n4-th shelf ( 6 - 15 ) : \n";
		if (warehouse.print().equals(testMove)){
			System.out.println("Moving a box from a shelf seems to work");
		}
		else{
			System.out.println("Moving a box from a shelf does not work");
		}
		
		warehouse.clear();
		
		//TESTING REORGANIZE
		
		/*
		 * Box b1 = new Box(2, 4, "Box 1");
		Box b2 = new Box(4, 10, "Box 2");
		Box b3 = new Box(2, 10, "Box 3");
		Box b4 = new UrgentBox(2, 10, "Box 4");
		 */

		warehouse.storage[4].addBox(b1);
		warehouse.storage[2].addBox(b2);
		warehouse.storage[3].addBox(b3);
		warehouse.storage[1].addBox(b4);
		Box b5 = new Box (1, 1, "Box 5");
		Box b6 = new Box (4, 2, "Box 6");
		Box b7 = new Box (5, 4, "Box 7");
		warehouse.storage[4].addBox(b7);
		warehouse.storage[4].addBox(b6);
		warehouse.storage[3].addBox(b5);
		
		warehouse.reorganize();
		
		String testReorganize = "0-th shelf ( 1 - 14 ) : Box 5, \n1-th shelf ( 3 - 1 ) : Box 4, Box 1, \n2-th shelf ( 4 - 3 ) : Box 2, Box 6, \n3-th shelf ( 5 - 1 ) : Box 3, Box 7, \n4-th shelf ( 6 - 15 ) : \n";
		if (warehouse.print().equals(testReorganize)){
			System.out.println("Reorganizing the warehouse seems to work, congrats you are done :)");
		}
		else{
			System.out.println("Reorganizing the warehouse does not work");
			//System.out.println(warehouse.print());
			//System.out.println(testReorganize);
		}
	}

}

