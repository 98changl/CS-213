package project2;

/**
 * 
 * @author Liman Chang, Kenneth Christian
 */
public class Checking extends Account {
	private boolean directDeposit;
	
	public Checking(String first_name, String last_name, double balance, Date date, boolean directDeposit) {
		super(first_name, last_name, balance, date);
		this.directDeposit = directDeposit;
	}
	
	@Override
	public double monthlyInterest() {
              
            return 5;
	}
       
	@Override
	public double monthlyFee(double balance) {
            if(balance >= 1500 || directDeposit)
            return 0;
            else{
             return 25;   
            }
	}
        
        @Override
        public void credit(double amount){
            
        }
}
