package project2;


/**
 * This is a sub class of Account and creates a Account of type MoneyMarket.
 * @author Liman Chang, Kenneth Christian
 */
public class MoneyMarket extends Account {
	private int withdrawals;
        
	/**
	 * Constructor for MoneyMarket
	 * @param first_name
	 * @param last_name
	 * @param balance
	 * @param date
	 * @param withdrawals 
	 */
	public MoneyMarket(String first_name, String last_name, double balance, Date date, int withdrawals ) {
		super(first_name, last_name, balance, date);
		this.withdrawals = withdrawals;
	}
	
    /**
     * Method to increment withdrawals
     */
    @Override
    public void incW(){
    	this.withdrawals++;
    }
       
    /**
     * 
     * @return withdrawals
     */
    public int getW(){
    	return this.withdrawals;
    }
        
   /**
    * 
    * @return monthly interest
    */        
	@Override
	public double monthlyInterest() {
            double interest = 0.65 / 100.0;
            return interest / 12;
	}
        
    /**
     * 
     * @param balance
     * @return fee of 0 if balance is greater than $2500 and withdrawal is less than 6. 
     * Else return a fee of 12.
     */    
	@Override
	public double monthlyFee(double balance) {
		if(balance >= 2500 && withdrawals < 6  ){
            return 0;
		}
       	else
       		return 12;
  	}
        
    /**
     * Compares the account instance and account profile names to determine whether accounts are equal.
     * @return true if accounts are equals, false otherwise
     */
    @Override
    public boolean equals(Account account) {
    	if (account instanceof MoneyMarket) {
   		 	if (super.stringEquals(super.getName(), account.getName()) == true) {
   		 		return true;
   		 	}
   	 	}
   	 	return false;
    }
 
}
