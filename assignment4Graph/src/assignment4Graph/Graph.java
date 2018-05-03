package assignment4Graph;

public class Graph {
	
	boolean[][] adjacency;
	int nbNodes;
	
	public Graph (int nb){
		this.nbNodes = nb;
		this.adjacency = new boolean [nb][nb];
		for (int i = 0; i < nb; i++){
			for (int j = 0; j < nb; j++){
				this.adjacency[i][j] = false;
			}
		}
	}
	
	public void addEdge (int i, int j){
		// ADD YOUR CODE HERE
					
		this.adjacency[i][j] = true;
		this.adjacency[j][i] = true;
	}
	
	public void removeEdge (int i, int j){
		// ADD YOUR CODE HERE
		this.adjacency[i][j] = false;
		this.adjacency[j][i] = false;
	}
	
	public int nbEdges(){
		// ADD YOUR CODE HERE
		int count=0;
		for (int i = 0; i < this.nbNodes; i++) {
			for (int j = i; j < this.nbNodes; j++) {
				if (this.adjacency[i][j] == true)	count ++;
			}
		}
		return count; // DON'T FORGET TO CHANGE THE RETURN
	}
	
	public boolean cycle(int start){
		// ADD YOUR CODE HERE
		if (start<0 || start >= this.nbEdges())	return false;
		boolean[] visited = new boolean[nbNodes];
		int[] relatevertices = getrelatevertice(start);
		if (relatevertices.length <2) return false;
		for(int i=0;i<relatevertices.length;i++) {
		   if(relatevertices[i]==start) {
		    continue;
		   }
		   visited[relatevertices[i]] = true;
		   int[] nondirectrelatevertices = getrelatevertice(relatevertices[i]);
		   for(int j=0;j<nondirectrelatevertices.length;j++) {
			   if(nondirectrelatevertices[j] == start) return true;
			   else{
				   visitvertices(nondirectrelatevertices[j],visited);
			   }
		   }
		}
		return visited[start]; // DON'T FORGET TO CHANGE THE RETURN}
	}
	
	public int shortestPath(int start, int end){
		// ADD YOUR CODE HERE
	
		boolean[] visited = new boolean[this.nbNodes];
		visitvertices(start,visited);
		if(visited[end]==false) {
		   return this.nbNodes+1;
		}
		  
		  //if the end can be reached,
		if(start==end && this.adjacency[start][start]==true) {
		return 1;
		}
		
		visited = new boolean[this.nbNodes];
		visited[start] = true;
		int length = this.DFSlength(start,end,visited);
		
		return length; // DON'T FORGET TO CHANGE THE RETURN
	}
	
	 private void visitvertices(int vertice, boolean[] visited) {
		  visited[vertice] = true;
		  int[] relatevertices = getrelatevertice(vertice);
		  for(int i=0;i<relatevertices.length;i++) {
		   if(!visited[relatevertices[i]]) {
			   visitvertices(relatevertices[i],visited);
		   }
		  }
		 }
	 
	public int[] getrelatevertice(int vertice) {
		
		  int count = 0;
		  for(int i=0;i<this.nbNodes;i++) {
		   if(this.adjacency[vertice][i]==true) {
		    count++;
		   }
		  }

		int[] relatevertice = new int[count];
		int j=0;
		for(int i = 0; i< this.nbNodes ; i++) {
			if (this.adjacency[vertice][i]) {
				relatevertice[j]=  i;
				//System.out.println("The vertices linked to vertices " + vertice +   "are " + i);
				j++;
			}
		}
		if (j == 0) System.out.println("no link");
		return relatevertice;
	}
	
	public int DFSlength(int start, int search, boolean[] visited) {
		//System.out.println("the cuurent vertice are" + start);
		int minlength = 999;
		visited[start] = true;
		int[] relatevertice = new int[this.nbNodes];
		relatevertice = this.getrelatevertice(start);
		
		for (int i = 0; i < relatevertice.length; i ++) {
			int nextvertice = relatevertice[i];
			int length = 1;
			if (nextvertice == search) {
				visited[nextvertice] = true;
				return length;
			}
			else if(!visited[nextvertice]) {
				visited[nextvertice] = true;
				length = length + this.DFSlength(nextvertice, search, visited);
				if  (length <minlength) minlength =length;
			}
		}
		return minlength;
	}
	
}




/*
int minlength = 999;
int length = 0;

int[] relatevertice_start = new int[this.nbNodes];
int j_start= 0;
for(int i = 0; i< this.nbNodes ; i++) {
	if (this.adjacency[start][i]) {
		relatevertice_start[j_start]=  i;
		//System.out.println("The vertices are " + i);
		if (i == end) return 1;
		j_start++;
	}
}

if (j_start == 0 || j_start == 0) return this.nbNodes+1;

int currentrow;
int currentcolumn;

for (currentrow = 0; currentrow < j_start; currentrow++) {
	length++;
	for (currentcolumn = 0; currentcolumn < j_start; currentcolumn++) {
		if ( this.adjacency[relatevertice_start[currentrow]][end]) {
			length++;
			if (length < minlength) minlength = length;
			length --;
		}
	}
}
*/

/*
int[] horizontal  = new int[this.nbNodes];
int[] vertical  = new int[this.nbNodes];
int[] temphorizontal  = new int[this.nbNodes];
int[] tempvertical  = new int[this.nbNodes];
horizontal = this.gethorizontal(start);


for (int i=0; i < this.nbNodes; i++) {
	if (this.sum(horizontal) < 2) return false;
	if (horizontal [i] != 0) {
		vertical = this.getvertical(horizontal[i]);
		if (this.sum(vertical) >= 2) {
			for (int j =0; j < this.nbNodes ; j++) {
			if (vertical[j] != 0) {
				if (vertical[j] == horizontal [j]) return true;
				else		temphorizontal = this.gethorizontal(vertical[j]);
				System.out.println("the" + j + " vertical is checking");
			}
			for(int k = 0; k< this.nbNodes; k++) {
				if (temphorizontal[k] != 0) {
					if (temphorizontal[k] == horizontal [k]) return true;
					else		tempvertical = this.gethorizontal(vertical[j]);
					System.out.println("the" + k + " horizontal is checking");
				}
				for(int p =0; p< this.nbNodes; p++) {
					if (tempvertical[p] != 0) {
						if (tempvertical[p] == horizontal [p]) return true;
						else		temphorizontal = this.gethorizontal(tempvertical[p]);
					}
			}		
		}
	}	
}
}
}
/*

/*
		int relateverticenumber;
int[] relatevertice = new int[this.nbNodes];
int[] visitedvertice = new int[this.nbNodes];
int visitedindex = 0;
relatevertice = this.getrelatevertice(start, visitedvertice, visitedindex);
relateverticenumber = this.getsize(relatevertice);
visitedvertice[0] = start;
visitedindex = 1;
System.out.println("the number of relate vertice are" + relateverticenumber);
//System.out.println("the visited vertice are" + this.getsize(visitedvertice));

for(int i=0; i <relateverticenumber; i++) {
if (this.DFS(relatevertice[i], start, visitedvertice, this.getsize(visitedvertice))) return true;
//else visitedvertice[this.getsize(visitedvertice)] = relatevertice[i];
}
int currentrow;
int currentcolumn;
for (currentrow = 0; currentrow < relateverticenumber; currentrow++) {
	for (currentcolumn = 0; currentcolumn < relateverticenumber; currentcolumn++) {
		if ( this.adjacency[relatevertice[currentrow]][relatevertice[currentcolumn]])	return true;
	}
}
*/
/*
public int getnumberrelatevertice(int vertice) {
	
	int[] relatevertice = new int[this.nbNodes];
	int j=0;
	for(int i = 0; i< this.nbNodes ; i++) {
		if (this.adjacency[vertice][i]) {
			relatevertice[j]=  i;
			System.out.println("The vertices are " + i);

			j++;
		}
	}
	return j;
}
*/
/*
public int[] addingvertice (int vertice, int[] queue, int[] visited) {
	int index = 0;
	if (queue[index] != 0) index ++;
	int[] relatevertice = new int[this.nbNodes];
	int relateverticenumber = 0;
	relatevertice = this.getrelatevertice(vertice);
	relateverticenumber = this.getnumberrelatevertice(vertice);
	int[] output = new int[this.nbNodes];
	for (int i = 0; i < (index -1); i++) {
		output [i] = queue[i+1];  // removing the visited vertices
	}
	for (int i = index -1; i < (index + relateverticenumber -1); i ++) {
		
outerloop:	for (int k =0; k <= relateverticenumber; k++) {
			for (int j = 0; j < this.nbNodes; j++) {
			
				if (relatevertice[k] == visited[j]) break outlerloop;
				
		}
		output [] = relatevertice
	}
	}
	return output;
}

public boolean comparearray(int numbertocompare, int[] visited, int size) {
	for (int  i =0; i < size; i++ ) {
	if (numbertocompare == visited[i]) return true;
	}
	return false;
}

public boolean DFS(int start, int search, int[] visited, int size) {
	System.out.println("the cuurent vertice are" + start);
	int relateverticenumber;
	
	int[] relatevertice = new int[this.nbNodes];
	relatevertice = this.getrelatevertice(start, visited, size);
	relateverticenumber = this.getsize(relatevertice);
	
	for (int i = 0; i < relateverticenumber; i ++) {
		if (relatevertice[i] == search) return true;
	}
	visited[this.getsize(visited)] = start;
	size = size +1;
	//System.out.println("the visited vertice are" + this.getsize(visited));

	for (int i = 0; i < relateverticenumber; i ++) {
		if (this.DFS(relatevertice[i], search, visited, size)) return true;
	}
	
	
	return false;
}
*/
/*
public int getsize(int[] array) {
	int i = 0; 
	while (array[i] != 0) {
		i++;
	}
	return i;
}

public int[] gethorizontal(int vertice) {
	int[] horizontal = new int[this.nbNodes];
	for(int i = 0; i< this.nbNodes ; i++) {
		
			if (this.adjacency[vertice][i]) horizontal[i]= 1;
			else 	horizontal[i]= 0;
			//System.out.println("The vertices linked to vertices " + vertice +   "are " + i);
		}
	return horizontal;
}
public int[] getvertical(int vertice) {
	int[] vertical = new int[this.nbNodes];
	for(int i = 0; i< this.nbNodes ; i++) {
		
			if (this.adjacency[i][vertice]) vertical[i]= 1;
			else 	vertical[i]= 0;
			//System.out.println("The vertices linked to vertices " + vertice +   "are " + i);
		}
	return vertical;
}
public int sum(int[] array) {
	int sum=0;
	for(int i = 0; i< this.nbNodes ; i++) {
		
			sum = sum + array[i];
		
			//System.out.println("The vertices linked to vertices " + vertice +   "are " + i);
		}
	return sum;
}
*/