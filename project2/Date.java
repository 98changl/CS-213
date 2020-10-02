package project2;

/**
 * 
 * @author Liman Chang, Kenneth Christian
 */
public class Date {
	private int year;
	private int month;
	private int day;
	
	public Date (int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	/**
	 * Compares the date given by the parameter to this date.
	 * @param date to compare to this date 
	 * @return 0, 1, or -1
	 */
	public int compareTo(Date date) {
		
		return -1;
	}
	
	/**
	 * Creates a string representation of the date.
	 * @return String in the format of mm/dd/yyyy
	 */
	public String toString() {
		String str = String.valueOf(month);
		str = str.concat("/");
		str = str.concat(String.valueOf(day));
		str = str.concat("/");
		str = str.concat(String.valueOf(year));
		return str;
	}
	
	public boolean isValid() {
		
		if (month < 1 && month > 12) {
			return false;
		}
		if (month == 2 && day > 28) {
			return false;
		}
		if (day < 1 && day > 31) {
			return false;
		}
		if (year < 0 && year > 2020) {
			return false;
		}
		return true;
	}
}
