/**
 * This class deals with I/O
 * @author Kenneth Christian, Liman Chang
 */

import java.util.*;

public class Shopping {
	//private static ShoppingBag bag = new ShoppingBag();	// create only one instance of the shopping bag
	
	public Shopping() {//////////////////////////////// for now use "," to seperate. itemname,price,true/false////////////////////

	}
	
	// main method from driver class will call this for I/O. 
	public void run() {
		Scanner sc = new Scanner(System.in); //to get input
		ShoppingBag bag = new ShoppingBag();
		String input = ""; // will get input C, A, R, or D
		
		boolean running = true;
		System.out.println("Let's start shopping!");
	    
	    // this while loop will continue asking the user for new commands after each
	    // new item is added to the array until they decide to checkout
		while(running) {
			String command;
			GroceryItem item;
			
			input = sc.next();
			
			command = input.substring(0, 1);
			input = input.trim();
			
			if (command.equals("A")) { // add item to shopping bag
				item = makeItem(input);
				bag.add(item);
				System.out.println(item.getName() + " added to the bag");
			} 
			else if (command.equals("R")) { // remove item from shopping bag
				item = makeItem(input);
				boolean removed = bag.remove(item);
				if (removed == false) {
					
				} else {
					System.out.println(item.getName() + " " + item.getPrice() + " removed");
				}
			} 
			else if (command.equals("P")) { // display all items in the bag
				if (bag.isEmpty()) {
					System.out.println("The bag is empty!");
				} else {
					bag.print();
				}
			}
			else if (command.equals("C")) { // checking out the grocery items in bag
				if (bag.isEmpty()) {
					System.out.println("Unable to check out, the bag is empty!");
				} else {
					checkout(bag);
				}
			} 
			else if (command.equals("Q")) { // stop program execution
				if (!bag.isEmpty()) { // automatically check out items in the bag
					checkout(bag);
				}
				running = false;
			} 
			else { //
				System.out.println("Invalid command!");
			}
		}
		
		System.out.println("Thanks for shopping with us!");
	}
	
	private GroceryItem makeItem(String input) {
		String[] elements = input.split(" ");
		double price = 0.0;
		boolean taxable = false;
		
		price = Double.parseDouble(elements[2]);
		
		if (elements[3].equals("true")) {
			taxable = true;
		}

		return new GroceryItem(elements[1], price, taxable);
	}
	
	private void checkout(ShoppingBag bag) {
		double price = bag.salesPrice();
		double tax = bag.salesTax();
		double total = price + tax;;
		
		bag.print();
		
		System.out.println("Sales total: $" + bag.salesPrice());
		System.out.println("Sales tax: $" + bag.salesTax());
		System.out.println("Total amount paid: $" + total);
	}
	
}
