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
                    return 35;
                } 
                else
                    return 25;
                
            
	}

	@Override
	public double monthlyFee(double balance) {
                if(balance >= 300){
                    return 0;
                }
                else
                    return 5;
        }
}
                            
           
