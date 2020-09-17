/**
 * This class defines the abstract data type GroceryItem
 * @author Liman Chang, Kenneth Christian
 */

public class GroceryItem {
	private String name;
	private double price;
	private boolean taxable;
	
	public boolean equals(Object obj) {
		return false;
	}
	
	public String toString() {
		return name;
	}
}
