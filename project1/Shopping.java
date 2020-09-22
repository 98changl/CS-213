/**
 * This class deals with I/O
 * @author Kenneth Christian, Liman Chang
 */

import java.util.*;

public class Shopping {
	private static ShoppingBag instance = new ShoppingBag();	// create only one instance of the shopping bag
	
	public Shopping() {//////////////////////////////// for now use "," to seperate. itemname,price,true/false////////////////////

	}
	
	// main method from driver class will call this for I/O. 
	public void run() {
		
		Scanner sc = new Scanner(System.in); //to get input
		String input = ""; //will get input C, A, R, or D
	    
	    //this while loop will continue asking the user for new commands after each
	    //new item is added to the array until they decide to checkout
	    
		while(!input.equals("C")) {//C for Checkout  
		System.out.println("\nPlease enter one of the following Commands: C, A, R, or D");
		input = sc.next();
		
		String item = "";
		
		//Add to bag
		if(input.equals("A")) {
				
			
		System.out.println("Please enter");  
		item = sc.next();
		
           
              GroceryItem it = new GroceryItem(item);//create new item
              
              instance.add(it);//add the new item into the bag
        	 	
		
		}
		
		//remove from bag
		else if (input.equals("R")) {
			 
		}
		
		//display bag
		else if (input.equals("D")) {
		
               
               instance.print();
                    
			
		}
		
		//checkout
		else if (input.equals("C")) {
			System.out.println("thank You, have a nice day");
		}
		
		//if user inputs in valid option
		else {
			System.out.println("invalid input");
		}
		
	}
	
	}
}
