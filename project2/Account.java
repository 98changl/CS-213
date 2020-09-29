package project2;

/**
 * 
 * @author Liman Chang, Kenneth Christian
 */
public abstract class Account {
	private Profile holder;
	private double balance;
	private Date dateOpen;
	
	/**
	 * Decrease the balance of the account.
	 * @param amount money to decrease
	 */
	public void debit(double amount) {
		
	}
	
	/**
	 * Increase the balance of the account.
	 * @param amount
	 */
	public void credit(double amount) {
		
	}
	
	public String toString() {
		return "";
	}
	
	public abstract double monthlyInterest();
	
	public abstract double monthlyFee();
}
