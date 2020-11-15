package project4;

import java.util.ArrayList;

public class Order implements Customizable {
	public static int lineNumber;
	private ArrayList<OrderLine> orderlines;

	public Order(int lineNumber) {
		this.lineNumber = lineNumber;
		orderlines = new ArrayList<OrderLine>();
	}
	
	@Override
	public boolean add(Object obj) {
		if (obj instanceof OrderLine) {
			orderlines.add((OrderLine) obj);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean remove(Object obj) {
		if (obj instanceof OrderLine) {
			return orderlines.remove((OrderLine) obj);
		}
		
		return false;
	}

}