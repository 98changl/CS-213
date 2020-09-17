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
		if (a.length() != b.length()) {
			return false;
		}
		
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean equals(Object obj) {
		boolean isEqual = true;
		
		if (obj instanceof GroceryItem) {
			GroceryItem item = (GroceryItem) obj;
			
			if (stringEquals(name, item.name) == false) {
				isEqual = false;
			}
			
			if (price != item.price) {
				isEqual = false;
			}
			
			if (taxable != item.taxable) {
				isEqual = false;
			}
		} else {
			isEqual = false;
		}
		return isEqual;
	}
	
	public String toString() {
		
		return name;
	}
}
