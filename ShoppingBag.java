/**
 * The container class that defines the abstract data type
 * @author Liman Chang, Kenneth Christian
 */

public class ShoppingBag {

    private GroceryItem[] bag;	// array-based implementation of the bag
    private int size;			// number of items currently in the bag

    public ShoppingBag() {
        bag = new GroceryItem[5];	// initial size of array = 5
    }

    // how many items in array
    public int getSize() {
        return this.size;
    }

    /**
     * method that doubles current bag size
     */
    private void grow() {
        GroceryItem[] newBag = new GroceryItem[bag.length * 2];
        
        for (int i = 0; i < size; i++) {
        	newBag[i] = bag[i];
        }
        bag = newBag;
    }

    // empty the bag IF checkout
    public void emptyBag() {
        for (int i = 0; i < size; i++) {
        	bag[i] = null;
        }
        size = 0;
    }

    /**
     * this method adds item to the array bag. if the array is full
     * then will call helper grow method to crease the size by 5 and then add
     * the item to the next empty index. Assume if the array is partially empty
     * then it will be the last index that is empty.
     * 
     * @param item
     */
    public void add(GroceryItem item) {
    	if (this.size == bag.length) {
    		grow();
    	}
    	
    	bag[size] = item;
    	this.size++;
    }

    /**
     * Method removes item from bag if found. return_value = true if item found
     * and removed. return_value = false it item not found in bag.
     *
     * @param item
     * @return return_value
     */
    public boolean remove(GroceryItem item) {

        int index = find(item);
        
        if (index == -1) {
        	return false;
        }
        
        if (index != size) {
        	bag[index] = bag[size];	// swap index and last 
        }
        bag[size] = null;
        this.size--;
        
        return true;
    }

    public boolean isEmpty() {
    	if (size > 0) {
    		return false;
    	}
    	return true;
    }

    /**
     * 
     * @returns price
     */
    public double salesPrice() {
        double salesPrice = 0;

        for (int x = 0; x < size; x++) {
        	salesPrice += bag[x].getPrice();
        }
        
        return salesPrice;
    }

    /**
     *
     * @return taxprice
     */
    public double salesTax() {
    	double taxRate = 0.06625;
        double salesTax = 0;

        for (int i = 0; i < this.size; i++) {
        	if (bag[i].getTax()) {
        		salesTax += bag[i].getPrice() * taxRate;
        	}
        }
        
        return Math.floor(salesTax * 100) / 100;
    }

    /**
     *
     * @return salesPrice() + salesTax()
     */
    public double totalPrice() {
        return salesPrice() + salesTax();
    }

    // print all items in bag
    public void print() {
        //TITLE 
        //System.out.println("**you have " + getSize() + " items in bag:"); ///title statment

        //to print all the items
        for (int e = 0; e < size; e++) {
            System.out.println(bag[e].toString());
        }
    }

    public GroceryItem[] getBag() {
        return bag;
    }

    /**
     * helper method to find an item
     *
     * @param item
     * @return index
     */
    private int find(GroceryItem item) {
        for (int i = 0; i < size; i++) {
        	if (bag[i].equals(item)) {
        		return i;
        	}
        }
        
        return -1;
    }

    public static void main(String[] args) {
    	GroceryItem test1 = new GroceryItem("stuff", 5.99, false);
    	GroceryItem test2 = new GroceryItem("item", 4.50, false);
    	GroceryItem test3 = new GroceryItem("hey", 1.5, false);
    	GroceryItem test4 = new GroceryItem("there", 5.99, false);
    	GroceryItem test5 = new GroceryItem("hello", 5.99, false);
    	GroceryItem test6 = new GroceryItem("world", 5.99, false);
    	
    	// 
    	ShoppingBag testBag = new ShoppingBag();
    	System.out.println("Invalid remove: " + testBag.remove(test1));
    	
    	testBag.add(test1);
    	System.out.println("Valid remove: " + testBag.remove(test1));
    	testBag.print();
    	
    	testBag.add(test1);
    	
    	
    }

}
