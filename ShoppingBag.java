/**
 * The container class that defines the abstract data type
 * @author Liman Chang, Kenneth Christian
 */

public class ShoppingBag {

    private GroceryItem[] bag;	// array-based implementation of the bag
    private int size;			// number of items currently in the bag

    public ShoppingBag() {
        bag = new GroceryItem[5];	//initial size of array = 5
    }

    // how many items in array
    public int getSize() {
        return this.size;
    }

    //helper method to grow array by 5
    private void grow() {
        /*
                        All the index are filled.
                        This creates a new array (newBag) that has size 5 greater than bag (initial array),
                        copies the content of bag into it and assigns that array to bag (the original array)
         */

        GroceryItem[] newBag = new GroceryItem[bag.length + 5];
        System.arraycopy(bag, 0, newBag, 0, bag.length);

        bag = newBag;
        size = bag.length;
    }

    // empty the bag IF checkout
    public void setEmpty() {
        bag = new GroceryItem[5];
    }

    /**
     * @param item 
     * this method adds item to the array bag. if the array is full
     * then will call helper grow method to crease the size by 5 and then add
     * the item to the next empty index. Assume if the array is partially empty
     * then it will be the last index that is empty.
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
     * @returns price
     */
    public double salesPrice() {

        double price = 0;

        for (int x = 0; x < bag.length; x++) {
            if (bag[x] != null) {
                price += bag[x].getPrice();
            }
        }
        return price;

    }

    /**
     *
     * @return taxprice
     */
    public double salesTax() {
        double taxprice = 0;

        for (int t = 0; t < bag.length; t++) {
            if (bag[t] != null && bag[t].getTax() == true) {
                taxprice += bag[t].getPrice() * 0.06625;

            }

        }

        return taxprice;

    }

    /**
     *
     * @return salesPrice() + salesTax()
     */
    public double totalPrice() {
        return salesPrice() + salesTax();
    }

    //print all items in bag
    public void print() {

        //TITLE 
        System.out.println("**you have " + getSize() + " items in bag:"); ///title statment

        //to print all the items
        for (int e = 0; e < bag.length; e++) {
            if (bag[e] != null) {

                System.out.println(bag[e].toString());

            }
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

        int index = -1;

        for (int x = 0; x < bag.length; x++) {

            if (item.equals(bag[x]) && bag[x] != null) {

                index = x; //x means item found at a particular index

                break;
            } else if (bag[x] == null || !item.equals(bag[x])) {

                index = -1; //0 means item not found

            }

        }

        return index;

    }

    public static void main(String[] args) {

    }

}