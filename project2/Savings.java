package project2;

/**
 * This is a sub class of Account class and creates a account of type Savings.
 * @author Liman Chang, Kenneth Christian
 */
public class Savings extends Account {
	private boolean isLoyal;

    /**
     * Constructor for Savings
     * @param first_name
     * @param last_name
     * @param balance
     * @param date
     * @param isLoyal 
     */    
	public Savings(String first_name, String last_name, double balance, Date date, boolean isLoyal) {
		super(first_name, last_name, balance, date);
		this.isLoyal = isLoyal;
	}
	
    /**
     * Method returns monthly interest of 0.35% if account is loyal else returns 0.25%. 
     * @return monthly interest. 
     */    
	@Override
	public double monthlyInterest() {
		double interest;
     	if(isLoyal){
        	//0.35%/12
     		interest = 0.35 / 100.0;
           	return interest / 12;
       	} 
     	else    //0.25%/12
     		interest = 0.25 / 100.0;
     		return interest / 12;     
	}
        
    /**
     * 
     * @param balance
     * @return a fee of 0 if balance is greater than or equal to $300.   
     * Else return a fee of 5.
     */    
	@Override
	public double monthlyFee(double balance) {
     	if(balance >= 300){
          	return 0;
      	}
      	else
        	return 5;
  	}
        
    /**
     * Method will return true if account is loyal and false if not
     * @return isLoyal
     */
    @Override
    public boolean isLy(){
        return this.isLoyal;
    }
    
    /**
     * Compares the account instance and account profile names to determine whether accounts are equal.
     * @return true if accounts are equals, false otherwise
     */
    @Override
    public boolean equals(Account account) {
    	if (account instanceof Savings) {
   		 	if (super.stringEquals(super.getName(), account.getName()) == true) {
   		 		return true;
   		 	}
   	 	}
   	 	return false;
    }    
}
                            
           
