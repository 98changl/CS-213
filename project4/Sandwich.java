package project4;

import java.util.ArrayList;

public abstract class Sandwich implements Customizable {
	static final int MAX_EXTRAS = 6;
	static final double PER_EXTRA = 1.99;
	protected ArrayList<Extra> extras;
	
	public abstract double price();
	public abstract boolean add(Object obj);
	public abstract boolean remove(Object obj);
	
	public String toString() {
		String str = "";
		
		for (int i = 0; i < extras.size(); i++)
		{
			str = str.concat(extras.get(i).toString());
			str = str.concat(",");
		}
		return str;
	}

	
}
