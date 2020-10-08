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
        @Override
        public int getW(){
            return this.withdrawals;
        }
        
        /**
         * 
         * @return monthly interest
         */
	@Override
	public double monthlyInterest() {
            //0.65%/12
            return 0.0005;
	}
        
        /**
         * 
         * @param balance
         * @return 0 or 12, depending on the account details
         */
	@Override
	public double monthlyFee(double balance) {
            if(balance >= 2500 && withdrawals < 6  ){
            return 0;
	}
            else
                return 12;
        }
        
       
      
       
        
      
        
}
