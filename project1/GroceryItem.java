/**
 * This class defines the abstract data type GroceryItem
 * @author Liman Chang, Kenneth Christian
 */

public class GroceryItem {
	private String name;		// the name of the item
	private double price;		// the cost of the item
	private boolean taxable;	// determines whether item can be taxed
	
	/**
	 * Constructor for the GroceryItem class
	 * 
	 * @param name of the item
	 * @param price of the item
	 * @param true if item is taxable, false if not
	 */
    public GroceryItem(String name, double price, boolean taxable){
    	this.name = name;
    	this.price = price;
    	this.taxable = taxable;
    }
    
    /**
     * Method to determine whether the item and object are the same
     * 
     * @return true if objects are the same
     */
	public boolean equals(Object obj) {
		boolean isEqual = true;
		
		if (obj instanceof GroceryItem) { // check type of obj
			GroceryItem item = (GroceryItem) obj;
			
			if (stringEquals(name, item.name) == false) { // compares item names
				isEqual = false;
			}
			
			if (price != item.price) { // compares item price
				isEqual = false;
			}
			
			if (taxable != item.taxable) { // compares item taxable
				isEqual = false;
			}
		} else {
			isEqual = false;
		}
		
		return isEqual;
	}
	
	/**
	 * Creates a string representation of all data fields in a GroceryItem
	 * 
	 * @return String representation of data in item
	 */
	public String toString() {
		String str = "";
		String cat = ": $";
		
		str = str.concat(name); // concat item name
		str = str.concat(cat);
		//System.out.println(str);
		
		cat = String.valueOf(price); // concat item price
		str = str.concat(cat);  //----->  i had to get rid of .substring(0, 5) in order for code to run str = str.concat(cat/*.substring(0, 5)*/);
		//System.out.println(str);
		
		if (taxable == false) { // concat item taxable
			cat = " : tax free";
		} else {
			cat = " : is taxable";
		}
		str = str.concat(cat);
		//System.out.println(str);
		return str;
	}
	
	/**
	 * 
	 * @return name data field
	 */
	public String getName(){
		return name;
	}
    
	/**
	 * 
	 * @return price data field
	 */
	public double getPrice(){
		return price;
	}
    
	/**
	 * 
	 * @return taxable data field
	 */
    public boolean getTax(){
        return taxable;
    }
    
    /**
     * Check to see if two strings are equal
     * 
     * @param first string to compare
     * @param seccond string to compare
     * @return true if equal, false if not equal
     */
	private boolean stringEquals(String a, String b) {
		if (a.length() != b.length()) { // names are not the same length
			return false;
		}
		
		for (int i = 0; i < a.length(); i++) { // compares each character of both strings
			if (a.charAt(i) != b.charAt(i)) {
				return false;
			}
		}
		
		return true;
	}
}
