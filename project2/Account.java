package project2;
import java.text.DecimalFormat;

/**
 * This class is defined as an abstract class and is a super class of MoneyMarket, Savings and Checking.
 * Account contains features that are common of the three account types listed above, features such as deposit and withdraw.
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
    Helper method that checks to see if two strings are equal.
    @param a string to compare to b
    @param b string to compare to a
    @return true if equal, false if not equal
     */
	public boolean stringEquals(String a, String b) {
		if (a.length() != b.length()) { // names are not the same length
			return false;
		}
		
		for (int i = 0; i < a.length(); i++) { // compares each character of both strings
			if (a.charAt(i) != b.charAt(i)) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Decrease the balance of the account.
	 * @param amount money to decrease
	 */
	public void debit(double amount) {
		this.balance -= amount;
	}
	
	/**
	 * Increase the balance of the account.
	 * @param amount money to increase
	 */
	public void credit(double amount) {
		this.balance += amount;
	}
	
	/**
     * 
     * @return str, formatted string to be used by print methods in AccountDatabase.
     */    
	public String toString() {
		DecimalFormat currency = new DecimalFormat("0.00");
		DecimalFormat expensive = new DecimalFormat("0,000.00");
		String str = "";
		
     	str = str.concat(holder.getName());
		str = str.concat("* $");
		
		if (balance >= 1000) {
			str = str.concat(expensive.format(balance));
		} else {
			str = str.concat(currency.format(balance));
		}
    	str = str.concat("*");
    	str = str.concat(dateOpen.toString());

		return str;
	}
        
       
	/**
	 * Method overridden by subclasses to return monthly interest
 	 * @return monthlyIntrest
 	 */
	public abstract double monthlyInterest();
	
	/**
     * Method overridden by subclasses to return monthly fees
     * @param balance
     * @return monthlyFee
     */    
	public abstract double monthlyFee(double balance);

	/**
	 * 
	 * @param account to compare
	 * @return
	 */
	public abstract boolean equals(Account account);
	
	/**
     * 
     * @return balance
     */
    public double getBalance(){
        return this.balance;
    }
   
    /**
     * 
     * @return dateopen
     */
    public Date getDate(){
        return this.dateOpen;
    }
    
    /**
     * Returns the full name of the account holder.
     * @return string representation of profile
     */
    public String getName() {
    	return this.holder.getName();
    }
    
    /**
     * 
     * @return holder.gLName 
     */
    public String getLastName(){
        return this.holder.gLName();
    }
    
    /**
     * 
     * @return holder.gFName
     */
    public String getFirstName(){
        return this.holder.gFName();
    }
    
    /**
     * Checking will override this method.
     * Returns weather or not an checking account is direct deposit or not.
     * @return true if account is direct deposit or false if not.
     */
    public boolean isDd(){
        return true;
    }
        
        
         /**
         * Savings will override this method.
         * Returns weather or not an checking account is direct deposit or not.
         * @return true if account is loyal or false if not.
         */
        public boolean isLy(){
            return true;
        }
     
      /**
       * method will be overridden by MoneyMarket class in order to increase number of withdrawals
       */
         public void incW(){}
        
       /**
        * MoneyMarket will override this method to return number of withdrawals
        * @return withdrawals 
        */ 
       public int getW(){
           return 0;
       } 
        
        
}