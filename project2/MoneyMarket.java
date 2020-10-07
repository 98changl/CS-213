package project2;

/**
 * 
 * @author Liman Chang, Kenneth Christian
 */
public class MoneyMarket extends Account {
	private int withdrawals;
        

	public MoneyMarket(String first_name, String last_name, double balance, Date date, int withdrawals ) {
		super(first_name, last_name, balance, date);
		this.withdrawals = withdrawals;
	}
	
	@Override
	public double monthlyInterest() {
            //0.65%/12
            return 0.0005;
	}

	@Override
	public double monthlyFee(double balance) {
            if(balance >= 2500 && withdrawals < 6  ){
            return 0;
	}
            else
                return 12;
        }
        
        
            void incW(){
            this.withdrawals++;
            
        }
        
        @Override
        public int getW(){
            return this.withdrawals;
        }
        
       
        
      
        
}
