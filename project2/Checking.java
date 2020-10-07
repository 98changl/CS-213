package project2;

import java.text.DecimalFormat;

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
    
                      
            //0.0005/12
            return 0.00004 ;

	}
       
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
}
