package project4;

import java.util.ArrayList;

public abstract class Sandwich implements Customizable {
	static final int MAX_EXTRAS = 6;
	static final double PER_EXTRA = 1.99;
	protected ArrayList<Extra> extras;
	
	public Sandwich() {
		extras = new ArrayList<Extra>();
	}
	
	public abstract boolean add(Object obj);
	public abstract boolean remove(Object obj);
	public abstract double price();
	
	public String toString() {
		String str = "";
		
		for (int i = 0; i < extras.size(); i++)
		{
			str = str.concat(extras.get(i).toString());
			str = str.concat(",");
		}
		return str;
	}

	public int getMaxExtras() {
		return MAX_EXTRAS;
	}
	
	public double getPerExtra() {
		return PER_EXTRA;
	}
}
