
package assignment3;

public class Building {

	OneBuilding data;
	Building older;
	Building same;
	Building younger;
	
	public Building(OneBuilding data){
		this.data = data;
		this.older = null;
		this.same = null;
		this.younger = null;
	}
	
	public String toString(){
		String result = this.data.toString() + "\n";
		if (this.older != null){
			result += "older than " + this.data.toString() + " :\n";
			result += this.older.toString();
		}
		if (this.same != null){
			result += "same age as " + this.data.toString() + " :\n";
			result += this.same.toString();
		}
		if (this.younger != null){
			result += "younger than " + this.data.toString() + " :\n";
			result += this.younger.toString();
		}
		return result;
	}
	
	public Building addBuilding (OneBuilding b){
		// ADD YOUR CODE HERE
		Building insert=new Building(b);
		Building root = this;
		Building temp = this;
		Building output = this;
		//System.out.println(insert.data);
		//System.out.println(temp.data);
			if (insert.data.yearOfConstruction < temp.data.yearOfConstruction) {
				if (temp.older == null) {
					temp.older = insert;
				}
				else {
				//System.out.println(temp.toString());
				temp.older = temp.older.addBuilding(b);
				//System.out.println(temp.toString());
				output = temp;
				}
			}
			if (insert.data.yearOfConstruction > temp.data.yearOfConstruction) {
				if (temp.younger == null) {
					temp.younger = insert;
				}
				else {
				temp.younger = temp.younger.addBuilding(b);
				output = temp;
				}
			}
			if (insert.data.yearOfConstruction == root.data.yearOfConstruction) {
				if(insert.equals(root)) {
					System.out.println("the building is already exist");
					return output;
				}
				else if(root.data.height < insert.data.height) {
					//System.out.println("the root has to be changed");
						insert.older = root.older;
						insert.younger = root.younger;
						root.older = null;
						root.younger = null;
						insert.same = root;
						output = insert;
						//System.out.println(output.toString());
						//System.out.println(insert.same.data.name);
						return output;
					
				}
				else {
					//System.out.println("the root is not changed");
					if (root.same == null) {
						root.same = insert;
						return root;
					}
					while(temp.same != null) {
						if(temp.same.data.height < insert.data.height) {
							//System.out.println(temp.same.data);
							//System.out.println(insert.data);
							insert.same = temp.same;
							temp.same = insert;
							return output;
						}
						temp = temp.same;
					}
					if (temp.same == null)	{
						temp.same =insert;
					}
					
				}
			}
		
		return output; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public Building addBuildings (Building b){
		// ADD YOUR CODE HERE
		Building insert = b;
		Building output = this;
				output = output.addBuilding(insert.data);
				if (insert.older != null) {
				output = output.addBuildings(insert.older);
				}
				if(insert.same != null) {
				output= output.addBuildings(insert.same);
				}
				if(insert.younger != null) {
				output= output.addBuildings(insert.younger);
				}
				//System.out.println("the building " + insert.data.name + "has been added");
				//System.out.println(output.toString());
		return output; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public Building removeBuilding (OneBuilding b){
		// ADD YOUR CODE HERE
		if (b == null) {
			System.out.println("the buildings are empty");
			return null;
		}
		Building remove = new Building (b);
		Building root = this;
		Building temp = this;
		Building output = this;
		
		//System.out.println(remove.data + "is being remvoed");
		//System.out.println(root.data);
		if (root.data.equals(remove.data)) {
			//System.out.println("They are the same");
			if (root.same!= null) {
				output = output.same;
				if(root.older !=null) 	output.addBuildings(root.older);
				if(root.younger !=null)  output.addBuildings(root.younger);
			}
			else if (root.same == null && root.older !=null) {
				output = output.older;
				if(root.younger !=null) output.addBuildings(root.younger);
			}
			else if(root.same == null && root.older == null && root.younger !=null) {
				output = output.younger;
			}
			else		return null;
		}
		else if (remove.data.yearOfConstruction == temp.data.yearOfConstruction ) {
			if (temp.same !=null) output.same = output.same.removeBuilding(b);
			
		}
		else if (remove.data.yearOfConstruction < temp.data.yearOfConstruction) {
			if (temp.older != null) output.older = output.older.removeBuilding(b);
			
		}
		else if (remove.data.yearOfConstruction > temp.data.yearOfConstruction) {
			if (temp.younger != null)	output.younger = output.younger.removeBuilding(b);
			
		}
		
		return output; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public int oldest(){
		// ADD YOUR CODE HERE
		Building root = this;
		if (root.older !=null)	return root.older.oldest();
		else return root.data.yearOfConstruction;
		 // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public int highest(){
		// ADD YOUR CODE HERE
		//Building root = this;
		//Building temp = this;
		int temp_highest = 0;
		Building result = null;
		
		result = this.InOrder(this,result);
		while(result != null) {
			if (result.data.height > temp_highest) {
			temp_highest = result.data.height;
			
			}
			result = result.same;
		}

		return temp_highest; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public OneBuilding highestFromYear (int year){
		// ADD YOUR CODE HERE
		OneBuilding output = null;
		Building temp = this;

		if (year == temp.data.yearOfConstruction) {
			output = temp.data;
		}
		else if (year < temp.data.yearOfConstruction){
			if (temp.older != null) {
			output = temp.older.highestFromYear(year);
			}
			else {
				output = null;
			}
		}
		
		else {
			if (temp.younger != null) {
				output = temp.younger.highestFromYear(year);
				}
				else {
					output = null;
				}
		}
		
		return output; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public int numberFromYears (int yearMin, int yearMax){
		// ADD YOUR CODE HERE
		Building temp = this;
		int number = 0;
		if(yearMin > yearMax) return 0;
		
		if (yearMin != yearMax) {
		for (int i = yearMin; i<= yearMax; i++) {
			number = number + temp.numberFromYears(i, i);
		}
		}
		
		if (yearMin == yearMax) {
			while ( temp != null)
			if (temp.data.yearOfConstruction < yearMin) {
				if (temp.younger != null)	temp = temp.younger;
				else return 0;
			}
			else if (temp.data.yearOfConstruction > yearMin) {
				if (temp.older != null) temp = temp.older;
				else return 0;
			}
			else if (temp.data.yearOfConstruction == yearMin) {
				number = number + 1;
				temp = temp.same;
			}
			else break;
		}
		
		return number; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
	public int[] costPlanning (int nbYears){
		// ADD YOUR CODE HERE
		Building result = null;
		int output[];
		output = new int[nbYears];
		for (int i = 0; i <nbYears; i++) {
			output[i] = 0;
		}
		result = this.InOrder(this,result);
		//System.out.println(result.toString());
		while(result != null) {
			if ((result.data.yearForRepair - 2018) < nbYears) {
			output[result.data.yearForRepair - 2018] = output[result.data.yearForRepair - 2018] + result.data.costForRepair;
			
			}
			result = result.same;
		}
		return output; // DON'T FORGET TO MODIFY THE RETURN IF NEEDS BE
	}
	
public Building InOrder (Building b, Building output) {
	
	Building root = b;
	OneBuilding temp =b.data;
	Building insert = new Building (temp);
	
	if (output == null) {
		output = insert;	
	}
	//System.out.println("InOder"+ output.toString());
	
	while(output.same != null) {
		output = output.same;
	}
	if (output.data.equals(insert.data)){	
	}
	else {
		output.same = insert;
		output = output.same;	
	}
	
	if (root.older != null || root.same !=null || root.younger != null) {
		 
		if (root.older != null) 	InOrder(root.older, output);
		
		if (root.same != null)	InOrder(root.same, output);
		
		if (root.younger != null)	InOrder(root.younger, output);

	}
	return output;
}

}