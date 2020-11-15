package project4;

import java.util.ArrayList;

public class Order implements Customizable {
	public static int lineNumber;
	private ArrayList<OrderLine> orderlines;

	public Order() {
		orderlines = new ArrayList<OrderLine>();
	}
	
	@Override
	public boolean add(Object obj) {
		if (obj instanceof OrderLine) {
			return orderlines.add((OrderLine) obj);
		}
		
		return false;
	}

	@Override
	public boolean remove(Object obj) {
		if (obj instanceof OrderLine) {
			OrderLine temp = (OrderLine) obj;
			for (int i = 0; i < orderlines.size(); i++) {
				if (orderlines.get(i).getSandwich().toString().equals(temp.getSandwich().toString())) {
					orderlines.remove(i);
					return true;
				}
			}
		}
		
		return false;
	}

	public void clear() {
		orderlines.clear();
	}
	
	public int size() {
		return orderlines.size();
	}
}
