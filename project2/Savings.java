package project2;

/**
 * This is a sub class of Account and creates a Account of type Savings.
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
         * Method returns monthly interest. Value depends on the account details.
         * @return monthly interest. 
         */
	@Override
	public double monthlyInterest() {
                if(isLoyal){
                    //0.35%/12
                    return 0.0003;
                } 
                else    //0.25%/12
                    return 0.0002;
                
            
	}
        
        /**
         * 
         * @param balance
         * @return 0 or 5 depending on the details of the account 
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
}
                            
           
