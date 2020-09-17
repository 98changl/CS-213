/**
 * This class defines the abstract data type GroceryItem
 * @author Liman Chang, Kenneth Christian
 */

public class GroceryItem {
	private String name;
	private double price;
	private boolean taxable;
	
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
	
	public String toString() {
		String str = "";
		String cat = ": $";
		
		str = str.concat(name); // concat item name
		str = str.concat(cat);
		
		cat = String.valueOf(price); // concat item price
		str = str.concat(cat.substring(0, 5));
		
		if (taxable == false) { // concat item taxable
			cat = " : tax free";
		} else {
			cat = " : 6.625%";
		}
		str = str.concat(cat);
		
		return str;
	}
}
