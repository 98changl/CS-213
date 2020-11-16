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

	/**
	 * Resets the line number and clears the orderlines array.
	 */
	public void clear() {
		lineNumber = 0;
		orderlines.clear();
	}
	
	/**
	 * Gets the size of the orderlines array list.
	 * @return
	 */
	public int size() {
		return orderlines.size();
	}
	
	/**
	 * Gets the order line at the given index
	 * @param index
	 * @return OrderLines if the index is valid, null otherwise
	 */
	public OrderLine getOrderLine(int index) {
		if (index < 0 || index > orderlines.size()) {
			return null;
		}
		return orderlines.get(index);
	}
	
}
