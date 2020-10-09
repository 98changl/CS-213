package project2;

import java.text.DecimalFormat;

/**
 * This is a sub class of Account and creates a Account of type Checking.
 * @author Liman Chang, Kenneth Christian
 */
public class Checking extends Account {
	private boolean directDeposit;
	
        /**
         * Constructor for Checking
         * @param first_name
         * @param last_name
         * @param balance
         * @param date
         * @param directDeposit 
         */
	public Checking(String first_name, String last_name, double balance, Date date, boolean directDeposit) {
		super(first_name, last_name, balance, date);
		this.directDeposit = directDeposit;
	}


	
    /**
     * 
     * @return value of monthly interest
     */
	@Override
	public double monthlyInterest() {
		double interest = 0.05 / 100.0;
		return interest / 12;
	}
       
    /**
     * 
     * @param balance
     * @return monthly fee of 0 if balance is greater than $1500 or if account is direct deposit. Else
     * returns a fee of 25.  
     */    
	@Override
	public double monthlyFee(double balance) {
     	if(balance >= 1500 || directDeposit)
            return 0;
     	else{
             return 25;   
     	}
	}
        
    /**
     * Method will return true if account is direct deposit and false if not
     * @return directDeposit
     */  
     @Override
     public boolean isDd(){
         return this.directDeposit;
     }
     
     /**
      * Compares the account instance and account profile names to determine whether accounts are equal.
      * @return true if accounts are equals, false otherwise
      */
     @Override
     public boolean equals(Account account) {
    	 if (account instanceof Checking) {
    		 if (super.stringEquals(super.getName(), account.getName()) == true) {
    			 return true;
    		 }
    	 }
    	 return false;
     }
    
}
