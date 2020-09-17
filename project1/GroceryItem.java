/**
 * This class defines the abstract data type GroceryItem
 * @author Liman Chang, Kenneth Christian
 */

public class GroceryItem {
	private String name;
	private double price;
	private boolean taxable;
	
	public boolean equals(Object obj) {
		boolean isEqual = true;
		if (obj instanceof GroceryItem) {
			GroceryItem item = (GroceryItem) obj;
			
			
		} else {
			isEqual = false;
		}
		return isEqual;
	}
	
	public String toString() {
		return name;
	}
}
