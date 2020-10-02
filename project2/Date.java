package project2;

/**
 * Date class
 * @author Liman Chang, Kenneth Christian
 */
public class Date {
	private int year;
	private int month;
	private int day;
	
	/**
	 * Constructor for the date class.
	 * @param month of the date
	 * @param day of the date
	 * @param year of the date
	 */
	public Date (int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	/**
	 * Compares the date given by the parameter to this date.
	 * Returns a positive integer if this date is later then the input date.
	 * Returns a negative integer if this date is earlier than the input date.
	 * @param date to compare to this date 
	 * @return 0 if the dates are equal, 1 if the date is later, or -1 if the date is earlier
	 */
	public int compareTo(Date date) {
		// compares years
		if (this.year > date.getYear()) {
			return 1;
		}
		if (this.year < date.getYear()) {
			return -1;
		}
		
		// compares months
		if (this.month > date.getMonth()) {
			return 1;
		}
		if (this.month < date.getMonth()) {
			return -1;
		}
		
		// compares days
		if (this.day > date.getDay()) {
			return 1;
		}
		if (this.day < date.getDay()) {
			return -1;
		}
		
		// the dates are equivalent
		return 0;
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
	
	/**
	 * Checks whether the date is in the correct format.
	 * Any date after the year of 2020 will be considered invalid.
	 * @return true if date is valid
	 */
	public boolean isValid() {
		if (year < 0 || year > 2020) { // year check
			return false;
		}
		if (month < 1 || month > 12) { // month check
			return false;
		}
		if (month == 2 && day > 28) { // February check
			return false;
		}
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) { // 31 day months
			if (day < 1 || day > 31) {
				return false;
			}
		}
		if (month == 4 || month == 6 || month == 9 || month == 11) { // 30 day months
			if (day < 1 || day > 30) {
				return false;
			}
		}
		if (day < 1 || day > 31) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Gets the year for the date.
	 * @return integer representation of the year
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * Gets the month for the date.
	 * @return integer representation of the month
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * Gets the day for the date.
	 * @return integer representation of the day
	 */
	public int getDay() {
		return day;
	}
}
