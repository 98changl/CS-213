package project4;

import java.util.ArrayList;

public class Order implements Customizable {
	public static int lineNumber;
	private ArrayList<OrderLine> orderlines;

	public Order() {
		lineNumber = 1;
		orderlines = new ArrayList<OrderLine>();
	}
	
	@Override
	public boolean add(Object obj) {
		if (obj instanceof OrderLine) {
			lineNumber++;
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
					if (orderlines.get(i).getLineNumber() == temp.getLineNumber()) {
						orderlines.remove(i);
						return true;
					}
				}
			}
		}
		
		return false;
	}

	/**
	 * Gets the size of the orderlines array list.
	 * @return
	 */
	public int size() {
		return orderlines.size();
	}
	
	/**
	 * Resets the line number and clears the orderlines array.
	 */
	public void clear() {
		lineNumber = 1;
		orderlines.clear();
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
	
	/** 
	 * Reorders the line numbers in the array list.
	 */
	public void reorder() {
		for (int i = 0; i < size(); i++) {
			if (orderlines.get(i).getLineNumber() != i + 1) {
				orderlines.get(i).setLineNumber(i + 1);
			}
		}
		lineNumber = size() + 1;
	}
}
