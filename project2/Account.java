package project2;
import java.text.DecimalFormat;

/**
 * 
 * @author Liman Chang, Kenneth Christian
 */
public abstract class Account {
	private Profile holder;
	private double balance;
	private Date dateOpen;
	
	/**
	 * Constructor for the Account class.
	 * @param first_name of the account holder
	 * @param last_name of the account holder
	 * @param balance of the account
	 * @param date the account was opened
	 */
	public Account(String first_name, String last_name, double balance, Date date) {
		this.holder = new Profile(first_name, last_name);
		this.balance = balance;
		this.dateOpen = date;
	}
	
	/**
	 * Decrease the balance of the account.
	 * @param amount money to decrease
	 */
	public void debit(Account account , double amount) {
               
            if(account instanceof MoneyMarket){
               ((MoneyMarket) account).incW();
            }
               this.balance -= amount;
	}
	
	/**
	 * Increase the balance of the account.
	 * @param amount money to increase
	 */
	public void credit(double amount) {
            
                
		this.balance += amount;
	}
	
	public String toString() {
            //*Savings*Jane Doe* $500.00*11/1/2019
           /// *Checking*John Doe* $500.00*1/1/2010*direct deposit account*
		DecimalFormat currency = new DecimalFormat("0,000.00");
		String str = "";
		

		
		str = str.concat(holder.getName());
		str = str.concat("* $");
                str = str.concat(currency.format(balance));
                str = str.concat("*");
                str = str.concat(dateOpen.toString());
		
		
		
		return str;
	}
        
       
	
	public abstract double monthlyInterest();
	
	public abstract double monthlyFee(double balance);

        public double getBalance(){
            return this.balance;
        }
       
        /**
         * 
         * @return dateopen
         */
        public Date getDate(){
            return this.dateOpen;
        }
        
        /**
         * 
         * @return holder.gLName 
         */
        public String getLastName(){
            return this.holder.gLName();
        }
        
        /**
         * Checking will override this method.
         * Returns weather or not an checking account is direct deposit or not.
         * @return true if account is direct deposit or false if not.
         */
        public boolean isDd(){
            return true;
        }
        
         /**
         * Savings will override this method.
         * Returns weather or not an checking account is direct deposit or not.
         * @return true if account is loyal or false if not.
         */
        public boolean isLy(){
            return true;
        }
        
       /**
        * MoneyMarket will override this method to return number of withdrawals
        * @return withdrawals 
        */ 
       public int getW(){
           return 0;
       } 
        
        
        }
        
        
        
