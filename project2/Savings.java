package project2;

/**
 * 
 * @author Liman Chang, Kenneth Christian
 */
public class Savings extends Account {
	private boolean isLoyal;

	public Savings(String first_name, String last_name, double balance, Date date, boolean isLoyal) {
		super(first_name, last_name, balance, date);
		this.isLoyal = isLoyal;
	}
	
	@Override
	public double monthlyInterest() {
                if(isLoyal){
                    //0.35%/12
                    return 0.0003;
                } 
                else    //0.25%/12
                    return 0.0002;
                
            
	}

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
                            
           
