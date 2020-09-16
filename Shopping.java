/*
 * This class deals with I/O
 */

import java.util.*;;
public class Shopping {

	public Shopping() {
		// TODO Auto-generated constructor stub
	}
	
	//main method from driver class will call this for I/O. 
	public void run() {
		
		Scanner sc = new Scanner(System.in); //to get input
		
		String input = ""; //will get input C, A, R, or D
	   
		
	    
	    //this while loop will continue asking the user for new commands after each
	    //new item is added to the array until they decide to checkout
	    
		while(!input.equals("C")) {//C for Checkout  
		System.out.println("\nPlease enter one of the following Commands: C, A, R, or D");
		
		input = sc.next();
			
		if(input.equals("A")) {//add to the bag
			
		//for debugging//		
		System.out.println("Please enter");  
		String item = "";
		item = sc.next();
		System.out.println("you added: " + item);
		//for debugging//
		
		}
		
		else if(input.equals("R")) {//remove from the bag
			 
		}
		else if(input.equals("D")) {//display
			
		}
		else if(input.equals("C")) {
			System.out.println("thank You, have a nice day");
		}
		else {
			System.out.println("invalid input");
		}
		
	}//end of while loop
	
	}
}
