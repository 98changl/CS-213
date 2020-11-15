package project4;

public class OrderLine {
	private int lineNumber;
	private Sandwich sandwich;
	private double price;
	
	public OrderLine(int lineNumber, Sandwich sandwich) {
		this.lineNumber = lineNumber;
		this.sandwich = sandwich;
		this.price = sandwich.price();
	}
	
	public int getLineNumber() {
		return lineNumber;
	}
	
	public Sandwich getSandwich() {
		return sandwich;
	}
	
	public double getPrice() {
		return price;
	}
}
