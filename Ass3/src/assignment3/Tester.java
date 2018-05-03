/*
package assignment3;

//import java.util.Arrays;

public class Tester{
	  public static void main(String[] args) {
	    
	    OneBuilding ob1 =  new OneBuilding("Building 1", 1987, 50, 2025, 35);
	    OneBuilding ob2 = new OneBuilding("Building 2", 1988, 60, 2023, 50);
	    OneBuilding ob3 = new OneBuilding("Building 3", 1987, 55, 2024, 23);
	    OneBuilding ob4 = new OneBuilding("Building 4", 1985, 50, 2022, 5);
	    OneBuilding ob5 = new OneBuilding("Building 5", 1985, 45, 2021, 42);
	    OneBuilding ob6 = new OneBuilding("Building 6", 1985, 60, 2024, 26);
	    OneBuilding ob7 = new OneBuilding("Building 7", 1986, 55, 2024, 11);
	    OneBuilding ob8 = new OneBuilding("Building 8", 1995, 55, 2019, 46);
	    OneBuilding ob9 = new OneBuilding("Building 9", 1987, 55, 2025, 22);
	    OneBuilding ob10 = new OneBuilding("Building 10", 1993, 55, 2025, 9);
	    OneBuilding ob11 = new OneBuilding("Building 11", 1985, 47, 2018, 10);
	    Building b1 = new Building(ob1);
	    
	    b1 = b1.addBuilding(ob5);
	    b1 = b1.addBuilding(ob4);
	    //System.out.println(b1.toString());
	    System.out.println("**** Testing addBuilding **** /n");    
	    b1 = b1.addBuilding(ob2);
	    System.out.println(b1.data.name + " should be Building 1 ");
	    b1 = b1.addBuilding(ob3);    
	    System.out.println(b1.data.name + " should be Building 3 ");
	    System.out.println(b1.same.data.name + " should be Building 1" );
	    b1 = b1.addBuilding(ob9);
	    //System.out.println(b1.toString());
	    
	    System.out.println(b1.data.name + " should be Building 3 ");
	    System.out.println(b1.same.data.name + " should be Building 9");
	    System.out.println(b1.same.same.data.name + " should be Building 1");
	    System.out.println(b1.younger.data.name + " should be Building 2");
	    System.out.println(b1.older.data.name + " should be Building 4");
	    System.out.println(b1.older.same.data.name + " should be Building 5");
	    b1 = b1.addBuilding(ob6);
	    b1 = b1.addBuilding(ob7);
	    System.out.println(b1.older.data.name + " should be Building 6");
	    System.out.println(b1.older.younger.data.name + " should be Building 7");
	    b1 = b1.addBuilding(ob8);
	    b1 = b1.addBuilding(ob11);
	    b1 = b1.addBuilding(ob10);
	    System.out.println(b1.data.name + " should be Building 3 ");
	    System.out.println(b1.younger.younger.data.name + " should be Building 8");
	    System.out.println(b1.younger.younger.older.data.name + " should be Building 10");
	    System.out.println(b1.older.same.same.data.name + " should be Building 11");
	    
	    OneBuilding ob12 = new OneBuilding("Building 12", 1987, 70, 2025, 10);
	    OneBuilding ob13 = new OneBuilding("Building 13", 1988, 70, 2024, 10);
	    OneBuilding ob14 = new OneBuilding("Building 14", 1985, 70, 2023, 10);
	    OneBuilding ob15 = new OneBuilding("Building 15", 1987, 65, 2022, 10);
	    OneBuilding ob16 = new OneBuilding("Building 16", 1991, 70, 2021, 10);
	    OneBuilding ob17 = new OneBuilding("Building 17", 1983, 70, 2020, 10);
	    OneBuilding ob18 = new OneBuilding("Building 18", 1991, 65, 2020, 10);
	    OneBuilding ob19 = new OneBuilding("Building 19", 1985, 49, 2020, 10);
	    System.out.println("\n");
	    Building b2 = new Building(ob12);
	    //System.out.println(b1.toString());
	    b2 = b2.addBuilding(ob13);
	    b2 = b2.addBuilding(ob14);
	    b2 = b2.addBuilding(ob15);
	    b2 = b2.addBuilding(ob16);
	    b2 = b2.addBuilding(ob17);
	    b2 = b2.addBuilding(ob18);
	    b2 = b2.addBuilding(ob19);
	    System.out.println(b2.data.name + " should be Building 12");
	    System.out.println(b2.same.data.name + " should be Building 15");
	    System.out.println(b2.older.data.name + " should be Building 14");
	    System.out.println(b2.younger.data.name + " should be Building 13");
	    System.out.println(b2.younger.younger.data.name + " should be Building 16");
	    System.out.println(b2.older.older.data.name + " should be Building 17");
	    System.out.println(b2.younger.younger.same.data.name + " should be Building 18");
	    System.out.println(b2.older.same.data.name + " should be Building 19");
	    System.out.println(" \n *** Testing addBuildings *** \n ");
	    
	    b1 = b1.addBuildings(b2);
	    //System.out.println(b1.toString());
	    System.out.println(b1.data.name + " should be Building 12");
	    System.out.println(b1.same.data.name + " should be Building 15");
	    System.out.println(b1.same.same.data.name + " should be Building 3");
	    System.out.println(b1.same.same.same.data.name + " should be Building 9");
	    System.out.println(b1.same.same.same.same.data.name + " should be Building 1");
	    System.out.println(b1.older.data.name + " should be Building 14");
	    System.out.println(b1.older.same.data.name + " should be Building 6");
	    System.out.println(b1.older.same.same.data.name + " should be Building 4");
	    System.out.println(b1.older.same.same.same.data.name + " should be Building 19");
	    System.out.println(b1.older.same.same.same.same.data.name + " should be Building 11");
	    System.out.println(b1.older.same.same.same.same.same.data.name + " should be Building 5");
	    System.out.println(b1.older.older.data.name + " should be Building 17");
	    System.out.println(b1.younger.data.name + " should be Building 13");
	    System.out.println(b1.younger.same.data.name + " should be Building 2");
	    System.out.println(b1.younger.younger.data.name + " should be Building 8");
	    System.out.println(b1.younger.younger.older.data.name + " should be Building 10");
	    System.out.println(b1.younger.younger.older.older.data.name + " should be Building 16");
	    System.out.println(b1.younger.younger.older.older.same.data.name + " should be Building 18");
	    System.out.println(b1.older.younger.data.name + " should be Building 7");
	    
	    System.out.println("\n *** Testing RemoveBuilding *** \n");
	    b1 = b1.removeBuilding(b1.data);
	    System.out.println(b1.data.name + " should be Building 15");
	    System.out.println(b1.older.data.name + " should be Building 14");
	    b1 = b1.removeBuilding(b1.data);
	    System.out.println(b1.data.name + " should be Building 3");
	    System.out.println(b1.older.data.name + " should be Building 14");
	    b1 = b1.removeBuilding(b1.data);
	    b1 = b1.removeBuilding(b1.data);
	    System.out.println(b1.data.name + " should be Building 1");
	    System.out.println(b1.older.data.name + " should be Building 14");
	    b1 = b1.removeBuilding(b1.data);
	    System.out.println(b1.data.name + " should be Building 14");
	    System.out.println(b1.younger.data.name + " should be Building 7");//
	    System.out.println(b1.younger.younger.data.name + " should be Building 13");
	    //System.out.println(b1.toString());
	    b1 = b1.removeBuilding(b1.younger.younger.younger.data);
	    //System.out.println(b1.toString());
	    System.out.println(b1.younger.younger.younger.data.name + " should be Building 10");
	    System.out.println(b1.younger.younger.younger.older.data.name + " should be Building 16");
	    System.out.println(b1.younger.younger.younger.older.same.data.name + " should be Building 18");
	    b1 = b1.removeBuilding(b1.data);
	    System.out.println(b1.data.name + " should be Building 6");
	    System.out.println(b1.older.data.name + " should be Building 17");
	    b1 = b1.removeBuilding(b1.data);
	    System.out.println(b1.data.name + " should be Building 4");
	    System.out.println(b1.younger.data.name + " should be Building 7");
	    b1 = b1.removeBuilding(b1.data);
	    b1 = b1.removeBuilding(b1.younger.data);
	    System.out.println(b1.data.name + " should be Building 19");
	    System.out.println(b1.younger.data.name + " should be builing 13");
	    b1 = b1.removeBuilding(b1.data);
	    b1 = b1.removeBuilding(b1.younger.data);
	    System.out.println(b1.data.name + " should be Building 11");
	    System.out.println(b1.younger.data.name + " should be builing 2");
	    b1 = b1.removeBuilding(b1.data);
	    b1 = b1.removeBuilding(b1.younger.data);
	    System.out.println(b1.data.name + " should be Building 5");
	    System.out.println(b1.younger.data.name + " should be builing 10");
	    System.out.println(b1.younger.older.data.name + " should be builing 16");
	    b1 = b1.removeBuilding(ob16);
	    System.out.println(b1.younger.older.data.name + " should be builing 18");
	    b1 = b1.removeBuilding(ob5);
	    b1 = b1.removeBuilding(ob17);
	    System.out.println(b1.data.name + " should be Building 10");
	    b1 = b1.removeBuilding(ob10);
	    System.out.println(b1.data.name + " should be Building 18");
	    System.out.println(b1.same + " " + b1.older + " " + b1.younger + " should be null null null");
	    System.out.println(b1.toString());

	    b1 = b1.removeBuilding(ob18);
	    
	    
	    System.out.println("\n ***Testing oldest*** \n");
	    b1 = new Building(ob8);
	    System.out.println(b1.oldest()+ " should be 1995");
	    b1.addBuilding(ob5);
	    System.out.println(b1.oldest()+ " should be 1985");
	    b1 = b1.addBuilding(ob1);
	    b1 = b1.addBuilding(ob4);
	    b1 = b1.addBuilding(ob2);
	    b1 = b1.addBuilding(ob3);
	    b1 = b1.addBuilding(ob6);
	    b1 = b1.addBuilding(ob7);
	    b1 = b1.addBuilding(ob11);
	    b1 = b1.addBuilding(ob9);
	    b1 = b1.addBuilding(ob10);
	    b1 = b1.addBuildings(b2);
	    System.out.println(b1.oldest()+ " should be 1983");
	    
	    System.out.println("\n ***Testing highest*** \n");
	    System.out.println(b1.highest()+ " should be 70");
	    OneBuilding ob20 = new OneBuilding("Building 20 ", 1984, 80, 2020, 10);
	    b1  = b1.addBuilding(ob20);
	    
	    System.out.println(b1.highest()+ " should be 80");
	    
	    System.out.println(" \n ***Testing highest from year*** \n");
	    System.out.println(b2.toString());
	    System.out.println(b1.highestFromYear(1985).name + " should be building 14");
	    System.out.println(b1.highestFromYear(1987).name + " should be building 12");
	    System.out.println(b1.highestFromYear(1991).name + " should be building 16");
	    System.out.println(b1.highestFromYear(1980) + " should be null");
	 
	    System.out.println("\n ***Testing numberFromYears*** \n");
	    System.out.println(b1.numberFromYears(1900, 2000)+ " should be 20");
	    System.out.println(b1.numberFromYears(1985, 1985)+ " should be 6");
	    System.out.println(b1.numberFromYears(1984, 1985)+ " should be 7");
	    System.out.println(b1.numberFromYears(1983, 1985)+ " should be 8");
	    System.out.println(b1.numberFromYears(1983, 1988)+ " should be 16");
	    System.out.println(b1.numberFromYears(1983, 1993)+ " should be 19");
	    System.out.println(b1.numberFromYears(1995, 1993)+ " should be 0");
	    System.out.println(b1.numberFromYears(1995, 2000)+ " should be 1");
	    System.out.println(b1.numberFromYears(1996, 2000)+ " should be 0");
	    
	    System.out.println("\n ***Testing costPlanning*** \n");
	    int[] costs = b1.costPlanning(8);
	    for (int i = 0; i<costs.length; i++){
	      System.out.print(" " + costs[i] + " ");
	      
	    }
	    System.out.println(" should be 10 46 40 52 15 60 70 76");
	    costs = b1.costPlanning(9);
	    for (int i = 0; i<costs.length; i++){
	      System.out.print(" " + costs[i] + " ");
	      
	    }
	    System.out.println(" should be 10 46 40 52 15 60 70 76 0");
	    costs = b1.costPlanning(3);
	    for (int i = 0; i<costs.length; i++){
	      System.out.print(" " + costs[i] + " ");
	      
	    }
	    System.out.println(" should be 10 46 40 ");
	  }
	}

*/


/*
package assignment3;

import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {
		
		System.out.println("DISCLAIMER : Please check your code on additional examples that you design yourself as this tester only tests your code on very few examples !");
		System.out.println();
		OneBuilding ob1 =new OneBuilding("Building 1", 1987, 50, 2025, 35);
		Building b1 = new Building(ob1);
		OneBuilding ob2 = new OneBuilding("Building 2", 1988, 60, 2023, 50);
		OneBuilding ob3 = new OneBuilding("Building 3", 1987, 55, 2024, 23);
		OneBuilding ob4 = new OneBuilding("Building 4", 1985, 50, 2022, 5);
		OneBuilding ob5 = new OneBuilding("Building 5", 1985, 45, 2021, 42);
	    OneBuilding ob9 = new OneBuilding("Building 9", 1987, 55, 2025, 22);
	    OneBuilding ob10 = new OneBuilding("Building 10", 1993, 55, 2025, 9);
	    OneBuilding ob11 = new OneBuilding("Building 11", 1985, 47, 2018, 10);

		OneBuilding ob6 = new OneBuilding("Building 6", 1985, 60, 2024, 26);
		Building b6 = new Building(ob6);
		OneBuilding ob7 = new OneBuilding("Building 7", 1986, 55, 2024, 11);
		OneBuilding ob8 = new OneBuilding("Building 8", 1995, 55, 2019, 46);
		
		
		// TESTING ADDBUILDING
		b1 = b1.addBuilding(ob4);
		//System.out.println(b1.toString());

		b1 = b1.addBuilding(ob5);
		//System.out.println(b1.toString());

		b1 = b1.addBuilding(ob2);
		
		b1 = b1.addBuilding(ob3);
		//System.out.println(b1.toString());

		
		//System.out.println(b1.toString());
		
		System.out.println(b1.same.data.name + " should be Building 1" );
		System.out.println(b1.addBuilding(ob9).data.name + " should be Building 3 ");
		System.out.println(b1.same.data.name + " should be Building 9");
		System.out.println(b1.same.same.data.name + " should be Building 1");
		System.out.println(b1.younger.data.name + " should be Building 2");
	    System.out.println(b1.older.data.name + " should be Building 4");
	    System.out.println(b1.older.same.data.name + " should be Building 5");
	    b1 = b1.addBuilding(ob6);
	    b1 = b1.addBuilding(ob7);
	    System.out.println(b1.older.data.name + " should be Building 6");
	    System.out.println(b1.older.younger.data.name + " should be Building 7");
	    b1 = b1.addBuilding(ob8);
	    b1 = b1.addBuilding(ob11);
	    System.out.println(b1.addBuilding(ob10).data.name + " should be Building 3 ");
	    System.out.println(b1.younger.younger.data.name + " should be Building 8");
	    System.out.println(b1.younger.younger.older.data.name + " should be Building 10");
	    System.out.println(b1.older.same.same.data.name + " should be Building 11");
	    OneBuilding ob12 = new OneBuilding("Building 12 ", 1987, 70, 2025, 10);
	    OneBuilding ob13 = new OneBuilding("Building 13 ", 1988, 70, 2024, 10);
	    OneBuilding ob14 = new OneBuilding("Building 14 ", 1985, 70, 2023, 10);
	    OneBuilding ob15 = new OneBuilding("Building 15 ", 1987, 65, 2022, 10);
	    OneBuilding ob16 = new OneBuilding("Building 16 ", 1991, 70, 2021, 10);
	    OneBuilding ob17 = new OneBuilding("Building 17 ", 1983, 70, 2020, 10);
	    OneBuilding ob18 = new OneBuilding("Building 18 ", 1991, 65, 2020, 10);
	    OneBuilding ob19 = new OneBuilding("Building 19 ", 1985, 49, 2020, 10);
	    System.out.println("\n");
	    Building b2 = new Building(ob12);
	    b2 = b2.addBuilding(ob13);
	    b2 = b2.addBuilding(ob14);
	    b2 = b2.addBuilding(ob15);
	    b2 = b2.addBuilding(ob16);
	    b2 = b2.addBuilding(ob17);
	    b2 = b2.addBuilding(ob18);
	    b2 = b2.addBuilding(ob19);
		//System.out.println(b2.toString());

	    System.out.println(b2.data.name + " should be Building 12");
	    System.out.println(b2.same.data.name + " should be Building 15");
	    System.out.println(b2.older.data.name + " should be Building 14");
	    System.out.println(b2.younger.data.name + " should be Building 13");
	    System.out.println(b2.younger.younger.data.name + " should be Building 16");
	    System.out.println(b2.older.older.data.name + " should be Building 17");
	    System.out.println(b2.younger.younger.same.data.name + " should be Building 18");
	    System.out.println(b2.older.same.data.name + " should be Building 19");
	    System.out.println(" \n *** Testing addBuildings *** \n ");
		//b1 = b1.addBuilding(b6.data);
		//b1 = b1.addBuilding(ob7);
		//b1 = b1.addBuilding(ob8);
		
		
		//b1 = b1.addBuilding(ob9);
		//b1 = b1.addBuilding(ob10);
		//b1 = b1.addBuilding(ob11);
		//b1 = b1.addBuilding(ob12);
		
		b6 = b6.addBuilding(ob7);
		b6 = b6.addBuilding(ob8);
		
		
		String sol1 = "Building 3(1987 , 55)\n"+"older than Building 3(1987 , 55) :\n"+"Building 4(1985 , 50)\n";
		sol1 += "same age as Building 4(1985 , 50) :\n"+"Building 5(1985 , 45)\n"+"same age as Building 3(1987 , 55) :\n";
		sol1 += "Building 1(1987 , 50)\n"+"younger than Building 3(1987 , 55) :\n"+"Building 2(1988 , 60)\n";
		String sol2 = "Building 6(1985 , 60)\n"+"younger than Building 6(1985 , 60) :\n"+"Building 7(1986 , 55)\n";
		sol2 += "younger than Building 7(1986 , 55) :\n"+"Building 8(1995 , 55)\n";

		if (sol1.equals(b1.toString()) && sol2.equals(b6.toString())){
			System.out.println("AddBuilding seems to work, check it on more examples though");
		}
		else{
			System.out.println("AddBuilding does not work");
			//System.out.println(sol1);
			//System.out.println(b1.toString());

		}
	
		// TESTING ADDBUILDINGS
		b1 = b1.addBuildings(b2);
	    System.out.println(b1.data.name + " should be Building 12");
	    System.out.println(b1.same.data.name + " should be Building 15");
	    System.out.println(b1.same.same.data.name + " should be Building 3");
	    System.out.println(b1.same.same.same.data.name + " should be Building 9");
	    System.out.println(b1.same.same.same.same.data.name + " should be Building 1");
	    System.out.println(b1.older.data.name + " should be Building 14");
	    System.out.println(b1.older.same.data.name + " should be Building 6");
	    System.out.println(b1.older.same.same.data.name + " should be Building 4");
	    System.out.println(b1.older.same.same.same.data.name + " should be Building 19");
	    System.out.println(b1.older.same.same.same.same.data.name + " should be Building 11");
	    System.out.println(b1.older.same.same.same.same.same.data.name + " should be Building 5");
	    System.out.println(b1.older.older.data.name + " should be Building 17");
	    System.out.println(b1.younger.data.name + " should be Building 13");
	    System.out.println(b1.younger.same.data.name + " should be Building 2");
	    System.out.println(b1.younger.younger.data.name + " should be Building 8");
	    System.out.println(b1.younger.younger.older.data.name + " should be Building 10");
	    System.out.println(b1.younger.younger.older.older.data.name + " should be Building 16");
	    System.out.println(b1.younger.younger.older.older.same.data.name + " should be Building 18");
	    System.out.println(b1.older.younger.data.name + " should be Building 7");
		//b1 = b1.addBuildings(b6);
		
		String sol3 = "Building 3(1987 , 55)\n"+"older than Building 3(1987 , 55) :\n"+"Building 6(1985 , 60)\n";
		sol3 += "same age as Building 6(1985 , 60) :\n"+"Building 4(1985 , 50)\n"+"same age as Building 4(1985 , 50) :\n"+"Building 5(1985 , 45)\n";
		sol3 += "younger than Building 6(1985 , 60) :\n"+"Building 7(1986 , 55)\n"+"same age as Building 3(1987 , 55) :\n"+"Building 1(1987 , 50)\n";
		sol3 += "younger than Building 3(1987 , 55) :\n"+"Building 2(1988 , 60)\n"+"younger than Building 2(1988 , 60) :\n"+"Building 8(1995 , 55)\n";
		
		if (sol3.equals(b1.toString())){
			System.out.println("AddBuildings seems to work, check it on more examples though");
		}
		else{
			System.out.println("AddBuildings does not work");
			//System.out.println(sol3);
			//System.out.println(b1.toString());
		}
	
		// TESTING REMOVEBUILDING
	    System.out.println("\n *** Testing RemoveBuilding *** \n");
	    b1 = b1.removeBuilding(b1.data);
	    System.out.println(b1.data.name + " should be Building 15");
	    System.out.println(b1.older.data.name + " should be Building 14");
	    b1 = b1.removeBuilding(b1.data);
	    System.out.println(b1.data.name + " should be Building 3");
	    System.out.println(b1.older.data.name + " should be Building 14");
	    b1 = b1.removeBuilding(b1.data);
	    b1 = b1.removeBuilding(b1.data);
	    System.out.println(b1.data.name + " should be Building 1");
	    System.out.println(b1.older.data.name + " should be Building 14");
	    b1 = b1.removeBuilding(b1.data);
	    System.out.println(b1.data.name + " should be Building 14");
	    System.out.println(b1.younger.data.name + " should be Building 7");
	    System.out.println(b1.younger.younger.data.name + " should be Building 13");
	    b1 = b1.removeBuilding(b1.younger.younger.younger.data);
	    System.out.println(b1.younger.younger.younger.data.name + " should be Building 10");
	    System.out.println(b1.younger.younger.younger.older.data.name + " should be Building 16");
	    System.out.println(b1.younger.younger.younger.older.same.data.name + " should be Building 18");
	    b1 = b1.removeBuilding(b1.data);
	    System.out.println(b1.data.name + " should be Building 6");
	    System.out.println(b1.older.data.name + " should be Building 17");
	    b1 = b1.removeBuilding(b1.data);
	    System.out.println(b1.data.name + " should be Building 4");
	    System.out.println(b1.younger.data.name + " should be Building 7");
	    b1 = b1.removeBuilding(b1.data);
	    b1 = b1.removeBuilding(b1.younger.data);
	    System.out.println(b1.data.name + " should be Building 19");
	    System.out.println(b1.younger.data.name + " should be builing 13");
	    b1 = b1.removeBuilding(b1.data);
	    b1 = b1.removeBuilding(b1.younger.data);
	    System.out.println(b1.data.name + " should be Building 11");
	    System.out.println(b1.younger.data.name + " should be builing 2");
	    b1 = b1.removeBuilding(b1.data);
	    b1 = b1.removeBuilding(b1.younger.data);
	    System.out.println(b1.data.name + " should be Building 5");
	    System.out.println(b1.younger.data.name + " should be builing 10");
	    System.out.println(b1.younger.older.data.name + " should be builing 16");
	    b1 = b1.removeBuilding(ob16);
	    System.out.println(b1.younger.older.data.name + " should be builing 18");
	    b1 = b1.removeBuilding(ob5);
	    b1 = b1.removeBuilding(ob17);
	    System.out.println(b1.data.name + " should be Building 10");
	    b1 = b1.removeBuilding(ob10);
	    System.out.println(b1.data.name + " should be Building 18");
	    System.out.println(b1.same + " " + b1.older + " " + b1.younger + " should be null null null");
	    

	    //b1.addBuilding(ob4);
		
		b1 = b1.removeBuilding(ob5);
		//b1 = b1.removeBuilding(ob3);
		b1 = b1.removeBuilding(new OneBuilding("Building 3", 1987, 55, 2024, 23));
		
		b1 = b1.removeBuilding(new OneBuilding("Building 4", 1985, 50, 2024, 23)); // this OneBuilding cannot be removed as it is not in the tree (the fields do not correspond to ob4 !)
		
		//System.out.println(b1.toString());
		String sol4 = "Building 1(1987 , 50)\n"+"older than Building 1(1987 , 50) :\n"+"Building 6(1985 , 60)\n";
		sol4 += "same age as Building 6(1985 , 60) :\n"+"Building 4(1985 , 50)\n"+"younger than Building 6(1985 , 60) :\n"+"Building 7(1986 , 55)\n";
		sol4 += "younger than Building 1(1987 , 50) :\n"+"Building 2(1988 , 60)\n"+"younger than Building 2(1988 , 60) :\n"+"Building 8(1995 , 55)\n";
		if (sol4.equals(b1.toString())){
			System.out.println("RemoveBuilding seems to work, check it on more examples though");
		}
		else{
			System.out.println("RemoveBuilding does not work");
			//System.out.println(sol4);
			//System.out.println(b1.toString());
		}
		b1 = b1.removeBuilding(ob18);
		// TESTING OLDEST
		
		System.out.println("\n ***Testing oldest*** \n");
	    b1 = new Building(ob8);
	    System.out.println(b1.oldest()+ " should be 1995");
	    b1.addBuilding(ob5);
	    System.out.println(b1.oldest()+ " should be 1985");
	    b1 = b1.addBuilding(ob1);
	    b1 = b1.addBuilding(ob4);
	    b1 = b1.addBuilding(ob2);
	    b1 = b1.addBuilding(ob3);
	    b1 = b1.addBuilding(ob6);
	    b1 = b1.addBuilding(ob7);
	    b1 = b1.addBuilding(ob11);
	    b1 = b1.addBuilding(ob9);
	    b1 = b1.addBuilding(ob10);
	    b2 = b2.addBuilding(ob13);
	    b2 = b2.addBuilding(ob14);
	    b2 = b2.addBuilding(ob15);
	    b2 = b2.addBuilding(ob16);
	    b2 = b2.addBuilding(ob17);
	    b2 = b2.addBuilding(ob18);
	    b2 = b2.addBuilding(ob19);
		System.out.println(b2.toString());

	    b1 = b1.addBuildings(b2);
	    System.out.println(b1.oldest()+ " should be 1983");

		//b1 = b1.addBuilding(ob3);
		//b1 = b1.addBuilding(ob5);
		
		//if (b1.oldest() == 1985 && b1.younger.oldest() == 1988){
		//	System.out.println("oldest seems to work, check it on more examples though");
		//}
		//else{
		//	System.out.println("oldest does not work");
			
		//	System.out.println(b1.toString());
		//}
		
		// TESTING HIGHEST
	    System.out.println("\n ***Testing highest*** \n");
	    System.out.println(b1.highest()+ " should be 70");
	    OneBuilding ob20 = new OneBuilding("Building 20 ", 1984, 80, 2020, 10);
	    b1  = b1.addBuilding(ob20);
	    System.out.println(b1.highest()+ " should be 80");

		if (b1.highest() == 60 && b1.older.same.highest() == 50){
			System.out.println("highest seems to work, check it on more examples though");
		}
		else{
			System.out.println("highest does not work");
		}
		// TESTING HIGHESTFROMYEAR
	    System.out.println(" \n ***Testing highest from year*** \n");
	    //b1.addBuilding(ob16);
	    System.out.println(b1.highestFromYear(1985).name + " should be building 14");
	    System.out.println(b1.highestFromYear(1987).name + " should be building 12");
	    //System.out.println(b1.highestFromYear(1991).name + " should be building 16");
	    System.out.println(b1.highestFromYear(1980) + " should be null");
		if (b1.highestFromYear(1989) == null && b1.highestFromYear(1986).equals(ob7) && b1.highestFromYear(1985).name.equals("Building 6")){
			System.out.println("highestFromYear seems to work, check it on more examples though");
		}
		else{
			System.out.println("highestFromYear does not work");
		}
		System.out.println(b1.toString());
		
		// TESTING NUMBERFROMYEARS
		 System.out.println("\n ***Testing numberFromYears*** \n");
		    System.out.println(b1.numberFromYears(1900, 2000)+ " should be 20");
		    System.out.println(b1.numberFromYears(1985, 1985)+ " should be 6");
		    System.out.println(b1.numberFromYears(1984, 1985)+ " should be 7");
		    System.out.println(b1.numberFromYears(1983, 1985)+ " should be 8");
		    System.out.println(b1.numberFromYears(1983, 1988)+ " should be 16");
		    System.out.println(b1.numberFromYears(1983, 1993)+ " should be 19");
		    System.out.println(b1.numberFromYears(1995, 1993)+ " should be 0");
		    System.out.println(b1.numberFromYears(1995, 2000)+ " should be 1");
		    System.out.println(b1.numberFromYears(1996, 2000)+ " should be 0");

		if (b1.numberFromYears(1986, 1989) == 4 && b1.numberFromYears(1985, 1985) == 3 && b1.numberFromYears(1987, 1985) == 0){
			System.out.println("numberFromYears seems to work, check it on more examples though");
		}
		else{
			System.out.println("numberFromYears does not work");
			System.out.println( b1.numberFromYears(1985, 1985));

		}
			
		// TESTING COSTPLANNING
		
		System.out.println("\n ***Testing costPlanning*** \n");
	    int[] costs = b1.costPlanning(8);
	    for (int i = 0; i<costs.length; i++){
	      System.out.print(" " + costs[i] + " ");
	      
	    }
	    System.out.println(" should be 10 46 40 52 15 60 70 76");
	    costs = b1.costPlanning(9);
	    for (int i = 0; i<costs.length; i++){
	      System.out.print(" " + costs[i] + " ");
	      
	    }
	    System.out.println(" should be 10 46 40 52 15 60 70 76 0");
	    costs = b1.costPlanning(3);
	    for (int i = 0; i<costs.length; i++){
	      System.out.print(" " + costs[i] + " ");
	      
	    }
	    System.out.println(" should be 10 46 40 ");

	

		//int[] costs = b1.costPlanning(7);
		int[] costsol = new int[]{0, 46, 0, 42, 5, 50, 60};
		if (costs.length != 7){
			System.out.println("CostPlanning : incorrect size of the array");
		}
		else{
			if (Arrays.equals(costs, costsol)){
				System.out.println("costPlanning seems to work, check it on more examples though");
			}
			else{
				System.out.println("costPlanning does not work");
			}
		}
		
		System.out.println();
		System.out.println("DISCLAIMER : if the tester says that all your methods work, congrats ! \nPlease continue checking your code on examples that you design yourself as this tester only tests your code on very few examples !");
		
	}

}
*/

package assignment3;

import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {
		
		System.out.println("DISCLAIMER : Please check your code on additional examples that you design yourself as this tester only tests your code on very few examples !");
		System.out.println();
		
		Building b1 = new Building(new OneBuilding("Building 1", 1987, 50, 2025, 35));
		OneBuilding ob2 = new OneBuilding("Building 2", 1988, 60, 2023, 50);
		OneBuilding ob3 = new OneBuilding("Building 3", 1987, 55, 2024, 23);
		OneBuilding ob4 = new OneBuilding("Building 4", 1985, 50, 2022, 5);
		OneBuilding ob5 = new OneBuilding("Building 5", 1985, 45, 2021, 42);
		Building b6 = new Building(new OneBuilding("Building 6", 1985, 60, 2024, 26));
		OneBuilding ob7 = new OneBuilding("Building 7", 1986, 55, 2024, 11);
		OneBuilding ob8 = new OneBuilding("Building 8", 1995, 55, 2019, 46);
		
		// TESTING ADDBUILDING
		b1 = b1.addBuilding(ob2);
		b1 = b1.addBuilding(ob3);
		b1 = b1.addBuilding(ob4);
		b1 = b1.addBuilding(ob5);
		b6 = b6.addBuilding(ob7);
		b6 = b6.addBuilding(ob8);
		
		String sol1 = "Building 3(1987 , 55)\n"+"older than Building 3(1987 , 55) :\n"+"Building 4(1985 , 50)\n";
		sol1 += "same age as Building 4(1985 , 50) :\n"+"Building 5(1985 , 45)\n"+"same age as Building 3(1987 , 55) :\n";
		sol1 += "Building 1(1987 , 50)\n"+"younger than Building 3(1987 , 55) :\n"+"Building 2(1988 , 60)\n";
		String sol2 = "Building 6(1985 , 60)\n"+"younger than Building 6(1985 , 60) :\n"+"Building 7(1986 , 55)\n";
		sol2 += "younger than Building 7(1986 , 55) :\n"+"Building 8(1995 , 55)\n";

		if (sol1.equals(b1.toString()) && sol2.equals(b6.toString())){
			System.out.println("AddBuilding seems to work, check it on more examples though");
		}
		else{
			System.out.println("AddBuilding does not work");
		}
		
		// TESTING ADDBUILDINGS
		b1 = b1.addBuildings(b6);
		
		String sol3 = "Building 3(1987 , 55)\n"+"older than Building 3(1987 , 55) :\n"+"Building 6(1985 , 60)\n";
		sol3 += "same age as Building 6(1985 , 60) :\n"+"Building 4(1985 , 50)\n"+"same age as Building 4(1985 , 50) :\n"+"Building 5(1985 , 45)\n";
		sol3 += "younger than Building 6(1985 , 60) :\n"+"Building 7(1986 , 55)\n"+"same age as Building 3(1987 , 55) :\n"+"Building 1(1987 , 50)\n";
		sol3 += "younger than Building 3(1987 , 55) :\n"+"Building 2(1988 , 60)\n"+"younger than Building 2(1988 , 60) :\n"+"Building 8(1995 , 55)\n";
		
		if (sol3.equals(b1.toString())){
			System.out.println("AddBuildings seems to work, check it on more examples though");
		}
		else{
			System.out.println("AddBuildings does not work");
		}
		
		// TESTING REMOVEBUILDING
		b1 = b1.removeBuilding(ob5);
		b1 = b1.removeBuilding(new OneBuilding("Building 3", 1987, 55, 2024, 23));
		b1 = b1.removeBuilding(new OneBuilding("Building 4", 1985, 50, 2024, 23)); // this OneBuilding cannot be removed as it is not in the tree (the fields do not correspond to ob4 !)
		
		String sol4 = "Building 1(1987 , 50)\n"+"older than Building 1(1987 , 50) :\n"+"Building 6(1985 , 60)\n";
		sol4 += "same age as Building 6(1985 , 60) :\n"+"Building 4(1985 , 50)\n"+"younger than Building 6(1985 , 60) :\n"+"Building 7(1986 , 55)\n";
		sol4 += "younger than Building 1(1987 , 50) :\n"+"Building 2(1988 , 60)\n"+"younger than Building 2(1988 , 60) :\n"+"Building 8(1995 , 55)\n";
		if (sol4.equals(b1.toString())){
			System.out.println("RemoveBuilding seems to work, check it on more examples though");
		}
		else{
			System.out.println("RemoveBuilding does not work");
		}
		
		// TESTING OLDEST
		
		b1 = b1.addBuilding(ob3);
		b1 = b1.addBuilding(ob5);
		
		if (b1.oldest() == 1985 && b1.younger.oldest() == 1988){
			System.out.println("oldest seems to work, check it on more examples though");
		}
		else{
			System.out.println("oldest does not work");
		}
		
		// TESTING HIGHEST
		
		if (b1.highest() == 60 && b1.older.same.highest() == 50){
			System.out.println("highest seems to work, check it on more examples though");
		}
		else{
			System.out.println("highest does not work");
		}
		
		// TESTING HIGHESTFROMYEAR
		
		if (b1.highestFromYear(1989) == null && b1.highestFromYear(1986).equals(ob7) && b1.highestFromYear(1985).name.equals("Building 6")){
			System.out.println("highestFromYear seems to work, check it on more examples though");
		}
		else{
			System.out.println("highestFromYear does not work");
		}
		
		// TESTING NUMBERFROMYEARS
		
		if (b1.numberFromYears(1986, 1989) == 4 && b1.numberFromYears(1985, 1985) == 3 && b1.numberFromYears(1987, 1985) == 0){
			System.out.println("numberFromYears seems to work, check it on more examples though");
		}
		else{
			System.out.println("numberFromYears does not work");
		}
		
		// TESTING COSTPLANNING
		
		int[] costs = b1.costPlanning(7);
		int[] costsol = new int[]{0, 46, 0, 42, 5, 50, 60};
		if (costs.length != 7){
			System.out.println("CostPlanning : incorrect size of the array");
		}
		else{
			if (Arrays.equals(costs, costsol)){
				System.out.println("costPlanning seems to work, check it on more examples though");
			}
			else{
				System.out.println("costPlanning does not work");
			}
		}
		System.out.println();
		System.out.println("DISCLAIMER : if the tester says that all your methods work, congrats ! \nPlease continue checking your code on examples that you design yourself as this tester only tests your code on very few examples !");
		
	}

}

