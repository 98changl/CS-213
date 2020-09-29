package project2;

/**
 * 
 * @author Liman Chang, Kenneth Christian
 */
public class AccountDatabase {
	private Account[] accounts;
	private int size;
	
	/**
	 * 
	 * @param account to find in the database
	 * @return index of the account, -1 if account doesn't exist
	 */
	private int find(Account account) {
		return 0;
	}
	
	private void grow() {
		
	}
	
	/**
	 * 
	 * @param account to add to the database
	 * @return false if account exists
	 */
	public boolean add(Account account) {
		return false;
	}
	
	/**
	 * 
	 * @param account to remove from the database
	 * @return false if account doesn't exist
	 */
	public boolean remove(Account account) {
		return false;
	}
	
	/**
	 * 
	 * @param account to deposit money into
	 * @return false if account doesn't exist
	 */
	public boolean deposit(Account account, double amount) {
		return false;
	}
	
	/**
	 * 
	 * @param account to withdrawal money from
	 * @param amount to withdrawal from the account
	 * @return 0: withdrawal successful, 1: insufficient funds, -1 account doesn't exist
	 */
	public int withdrawal(Account account, double amount) {
		return 0;
	}
	
	/**
	 * sort in ascending order
	 */
	private void sortByDateOpen() {
		
	}
	
	/**
	 * sort in ascending order
	 */
	private void sortByLastName() {
		
	}
	
	public void printByDateOpen() {
		
	}
	
	public void printByLastName() {
		
	}
	
	public void printAccounts() {
		
	}
}
