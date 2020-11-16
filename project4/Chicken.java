package project4;

import java.text.DecimalFormat;

public class Chicken extends Sandwich {
	private double Price = 8.99;
	
	/**
	 * Constructor for the chicken class.
	 */
	public Chicken() {
		super();
	}
	
	@Override
	public boolean add(Object obj) {
		if (super.extras.size() == super.getMaxExtras()) {
			return false;
		}
		
		if (obj instanceof Extra) {
			return super.extras.add((Extra) obj);
		}

		return false;
	}

	@Override
	public boolean remove(Object obj) {
		if (obj instanceof Extra) {
			for (int i = 0; i < super.extras.size(); i++) {
				if (super.extras.get(i).toString().equals(obj.toString())) {
					super.extras.remove(i);
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public double price() {
		double extraPrice = 0.0;
		
		for (int i = 0; i < super.extras.size(); i++) {
			extraPrice += getPerExtra();
		}
		
		return Price + extraPrice;
	}

	@Override
	public String toString() {
		String str = "Chicken,";
		DecimalFormat format = new DecimalFormat("0.00");
		
		str = str.concat("Fried Chicken,Spicy Sauce,Pickles,");
		str = str.concat(super.toString());
		str = str.concat("$");
		str = str.concat(format.format(price()));
		
		return str;
	}
	
}
