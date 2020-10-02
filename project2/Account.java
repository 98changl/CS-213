package project2;
import java.text.DecimalFormat;

/**
 * 
 * @author Liman Chang, Kenneth Christian
 */
public abstract class Account {
	private Profile holder;
	private double balance;
	private Date dateOpen;
	
	/**
	 * Constructor for the Account class.
	 * @param first_name of the account holder
	 * @param last_name of the account holder
	 * @param balance of the account
	 * @param date the account was opened
	 */
	public Account(String first_name, String last_name, double balance, Date date) {
		this.holder = new Profile(first_name, last_name);
		this.balance = balance;
		this.dateOpen = date;
	}
	
	/**
	 * Decrease the balance of the account.
	 * @param amount money to decrease
	 */
	public void debit(double amount) {
		balance -= amount;
	}
	
	/**
	 * Increase the balance of the account.
	 * @param amount money to increase
	 */
	public void credit(double amount) {
		balance += amount;
	}
	
	public String toString() {
		DecimalFormat currency = new DecimalFormat("0,000.00");
		String str = "*";
		String cat = "* $";
		
		str = str.concat(holder.getName());
		str = str.concat("* $");
		
		
		
		return str;
	}
	
	public abstract double monthlyInterest();
	
	public abstract double monthlyFee();
}
