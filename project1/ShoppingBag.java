/**
 * The container class that defines the abstract data type.
 * 
 * @author Liman Chang, Kenneth Christian
 */
public class ShoppingBag {
    private GroceryItem[] bag;	// array-based implementation of the bag
    private int size;			// number of items currently in the bag

    /**
     * Initializes the shopping bag with an initial array size of 2.
     */
    public ShoppingBag() {
        bag = new GroceryItem[2];
    }

    /**
     * This method adds item to the array bag. 
     * If the array is full, then it will call grow() to double array's size.
     * 
     * @param GroceryItem to be added to Shopping Bag
     */
    public void add(GroceryItem item) {
    	if (this.size == bag.length) { // the shopping bag is at maximum capacity
    		grow();
    	}
    	
    	bag[size] = item;
    	this.size++;
    }

    /**
     * Method to remove a grocery item from bag if found.
     * The bag array will not be affected if the item is not found in the bag.
     *
     * @param GroceryItem to be removed from Shopping Bag
     * @return true if item was found and removed, false if the item is not in the bag
     */
    public boolean remove(GroceryItem item) {
        int index = find(item);
        
        if (index == -1) { // item was not found
        	return false;
        }
        
        if (index != size) {
        	bag[index] = bag[size-1];	// swap index and last item
        }
        bag[size-1] = null;
        this.size--;
        
        return true;
    }

    /**
     * Calculates the sales price of items in the shopping bag.
     * 
     * @returns total sales price
     */
    public double salesPrice() {
        double salesPrice = 0;

        for (int x = 0; x < size; x++) {
        	salesPrice += bag[x].getPrice();
        }
        
        return salesPrice;
    }

    /**
     * Calculates the sales tax of items in the shopping bag.
     * The method does not format the sales tax to "$0.00".
     * 
     * @return total sales tax
     */
    public double salesTax() {
    	double taxRate = 0.06625;
        double salesTax = 0;

        for (int i = 0; i < this.size; i++) {
        	if (bag[i].getTax()) {
        		salesTax += bag[i].getPrice() * taxRate;
        	}
        }
        
        return salesTax;
    }

    /**
     * Prints to IO all items in the shopping bag.
     */
    public void print() {
        for (int e = 0; e < size; e++) {
            System.out.println("·" + bag[e].toString());
        }
    }
    
    /**
     * Shows the number of items in the shopping bag.
     * 
     * @return integer size of shopping bag
     */
    public int getSize() {
        return this.size;
    }
    
    /**
     * Checks the size of the shopping bag for items and determines whether it's empty.
     * 
     * @return true if the shopping bag is empty
     */
    public boolean isEmpty() {
    	if (size > 0) {
    		return false;
    	}
    	return true;
    }
    
    /**
     * Nulls all items in the shopping bag array and resets the size to 0.
     */
    public void emptyBag() {
        for (int i = 0; i < size; i++) {
        	bag[i] = null;
        }
        size = 0;
    }

    /**
     * Doubles the maximum size of the shopping bag.
     */
    private void grow() {
        GroceryItem[] newBag = new GroceryItem[bag.length * 2];
        
        for (int i = 0; i < size; i++) {
        	newBag[i] = bag[i];
        }
        bag = newBag;
    }
    
    /**
     * Helper method to find a grocery item in the shopping bag array
     *
     * @param Grocery item to be found
     * @return index of the grocery item, -1 if the item is not in the shopping bag
     */
    private int find(GroceryItem item) {
        for (int i = 0; i < size; i++) {
        	if (bag[i].equals(item)) {
        		return i;
        	}
        }
        return -1;
    }

    /**
     * Test bed main that implements test cases.
     * The results of the tests are printed to console.
     * 
     * @param args
     */
    public static void main(String[] args) {
    	ShoppingBag testBag = new ShoppingBag();
    	GroceryItem test1 = new GroceryItem("I", 5.987, false);
    	GroceryItem test2 = new GroceryItem("like", 4.321, false);
    	GroceryItem test3 = new GroceryItem("sushi_and_burger", 1000, false);
    	GroceryItem test4 = new GroceryItem("hello", 40, true);
    	GroceryItem test5 = new GroceryItem("world", 60, true);
    	
    	// test getSize() 1
    	System.out.println("Size zero: " + testBag.getSize() + "\n");
    	
    	// test remove() 1
    	System.out.println("Invalid remove: " + testBag.remove(test1) + "\n");
    	
    	// test add() and print()
    	System.out.println("Testing add:");
    	testBag.add(test1);
    	testBag.print();
    	System.out.println();
    	
    	// test remove() 2
    	System.out.println("Valid remove: " + testBag.remove(test1));
    	testBag.print();
    	System.out.println();
    	
    	// test grow() 1
    	testBag.add(test1);
    	testBag.add(test2);
    	testBag.add(test3);
    	testBag.print();
    	System.out.println();
    	
    	// test getSize() 2
    	System.out.println("Size three: " + testBag.getSize() + "\n");
    	
    	// test grow() 2
    	testBag.add(test1);
    	testBag.add(test2);
    	testBag.add(test3);
    	testBag.print();
    	System.out.println();
    	
    	// test isEmpty() 1
    	System.out.println("Bag is empty: " + testBag.isEmpty() + "\n");
    	
    	// test emptyBag()
    	System.out.println("Emptying bag: ");
    	testBag.emptyBag();
    	testBag.print();
    	System.out.println();
    	
    	// test isEmpty() 2
    	System.out.println("Bag is empty: " + testBag.isEmpty() + "\n");
    	
    	// test print() 2
    	testBag.add(test4);
    	testBag.add(test5);
    	testBag.print();
    	System.out.println();
    	
    	// test salesPrice() 1
    	System.out.println("Sales Price 100: $" + testBag.salesPrice() + "\n");
    	
    	// test salesTax() 1
    	System.out.println("Sales Tax 6.62: $" + testBag.salesTax() + "\n");
    	
    	// test remove() 3
    	testBag.add(test1);
    	testBag.add(test1);
    	testBag.add(test1);
    	System.out.println("Duplicate remove: " + testBag.remove(test1));
    	testBag.print();
    	System.out.println();
    }
}
