/*
 * This class deals with I/O
 */

package RunProject1;
import java.util.*;
/**
 *
 * @author kenne
 */
public class Shopping {

    //create only one instance of the shoppingBag
    private static ShoppingBag instance = new ShoppingBag();

	
	//main method from driver class will call this for I/O. 
	public void run() {
		
		Scanner sc = new Scanner(System.in); //to get input
		String input = ""; //will get input C, A, R, or D
	   
	    
	    //this while loop will continue asking the user for new commands after each
	    //new item is added to the array until they decide to checkout
	    
		while(!input.equals("Q")) {//C for Checkout  
		System.out.println("\nPlease enter one of the following Commands: C, A, R, or D");
		input = sc.next();
		
		String item = "";
		
		//Add to bag
		if(input.equals("A")) {
				
			
		System.out.println("Please enter");  
		item = sc.next();
		
           
              GroceryItem it = new GroceryItem(item);//create new item
              
              instance.add(it);//add the new item into the bag
            System.out.println(it.getname() + " added to the bag ");
		
		}
		
		//remove from bag
		else if(input.equals("R")) {
                    
                System.out.println("Please enter");  
		item = sc.next();
		
                    
                  GroceryItem it = new GroceryItem(item);
                  
                 instance.remove(it);
                  
                    
                    
		}
		
		//display bag
		else if(input.equals("P")) {
		
               
               instance.print();
                    
			
		}
		
		//checkout
		else if(input.equals("C")) {
			
                    
                 instance.checkOut();
		}
		
		//if user inputs in valid option
		else {
			System.out.println("invalid input");
		}
		
	}
	
	}
}
