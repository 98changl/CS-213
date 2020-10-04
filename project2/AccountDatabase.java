package project2;


/**
 * 
 * @author Liman Chang, Kenneth Christian
 */
public class AccountDatabase {
	private Account[] accounts;
	private int size;
        
        public AccountDatabase(){
            accounts = new Account[2];
        }
	
	/**
	 * 
	 * @param account to find in the database
	 * @return index of the account, -1 if account doesn't exist
	 */
	private int find(Account account) {
             for (int i = 0; i < size; i++) {
        	if (accounts[i].equals(account)) {
        		return i;
        	}
             }
             
             return -1;
        }
		
	
        
	
	private void grow() {
             Account[] newAccounts = new Account[size * 2];
        
            for (int i = 0; i < size; i++) {
        	newAccounts[i] = accounts[i];
            }
            accounts = newAccounts;
        
        }
	
	/**
	 * 
	 * @param account to add to the database
	 * @return false if account exists
	 */
	public boolean add(Account account) {
		if(this.size == accounts.length){
                    grow();
                }
                if(find(account) != -1){
                    accounts[size] = account;
        this.size++;
        return true;
                }
                return false;
        }
                
                   
                    
                
            
	/**
	 * 
	 * @param account to remove from the database
	 * @return false if account doesn't exist
	 */
	public boolean remove(Account account) {
		int indexOf = find(account);
                
                if(indexOf == -1){
                    return false;
                }
            if (indexOf != size) {
        	accounts[indexOf] = accounts[size-1];	// swap index and last item
        }
            
            accounts[size-1] = null;
            this.size--;
        
         return true;
	}
	
	/**
	 * 
	 * @param account to deposit money into
	 * @return false if account doesn't exist
	 */
	public boolean deposit(Account account, double amount) {
             
                if(find(account) == -1){
                    return false;
                }
           for(int x = 0; x<size ; x++){
               if(accounts[x].equals(account)){
                  account.credit(amount);
               }
           }
           
           return true;
	}
	
	/**
	 * 
	 * @param account to withdrawal money from
	 * @param amount to withdrawal from the account
	 * @return 0: withdrawal successful, 1: insufficient funds, -1 account doesn't exist
	 */
	public int withdrawal(Account account, double amount) {
            if(find(account) == -1){
                return -1;
            }
             for(int x = 0; x<size ; x++){
                 if(accounts[x].equals(account)){
                     if(account.getBalance() < amount){
                         return -1;
                     }
                     account.debit(amount);
             }
             }
             return 0;
        }
                 
            
		
         /**
	 * sort in ascending order
	 */
	private void sortByDateOpen() {
            Account acc;
                 
		
                  
                  for (int i = 0; i < size; i++){ 
        
            for (int j = i + 1; j < size; j++){ 
            
                if (accounts[i].getDate().getYear() > accounts[j].getDate().getYear()){//check by year
                
                    acc = accounts[i];
                    accounts[i] = accounts[j];
                    accounts[j] = acc;
                }
                else if(accounts[i].getDate().getYear() == accounts[j].getDate().getYear()){//year is equal check by month
                
                    if(accounts[i].getDate().getMonth() > accounts[j].getDate().getMonth()){//check by month
                    
                    acc = accounts[i];
                    accounts[i] = accounts[j];
                    accounts[j] = acc;   
                    }
                    
                    else if(accounts[i].getDate().getMonth() == accounts[j].getDate().getMonth()){//months are equal, sort by day
                    
                        if(accounts[i].getDate().getDay() > accounts[j].getDate().getDay()){
                        
                    acc = accounts[i];
                    accounts[i] = accounts[j];
                    accounts[j] = acc; 
                        }
                    }
                }
            }
        }
        }
                    
                        
                   
              
	/**
	 * sort array in ascending order
	 */
	private void sortByLastName() {
            Account acc;
		
                  for (int x = 0; x < size; x++){ 
        
            for (int a = x + 1; a < size; a++){ 
                if (accounts[x].getLastName().compareTo(accounts[a].getLastName()) > 0){//compares last names 
                
                    acc = accounts[x];
                    accounts[x] = accounts[a];
                    accounts[a] = acc;
                }
            }
                  }
        }
                
         public void printByDateOpen() {
		sortByDateOpen();
             
            String acc ="";
                for(int x = 0 ; x < size ; x++){
                    if(accounts[x] instanceof Checking){
                        acc = "Checking";
                    }
                    if(accounts[x] instanceof MoneyMarket){
                        acc = "MoneyMarket";
                    }
                    if(accounts[x] instanceof Savings){
                        acc = "Savings";
                    }
                    System.out.println("*"+acc+accounts[x].toString());
                }
                
                
	}
	
	public void printByLastName() {
		sortByLastName();
                String acc ="";
                for(int x = 0 ; x < size ; x++){
                    if(accounts[x] instanceof Checking){
                        acc = "Checking";
                    }
                    if(accounts[x] instanceof MoneyMarket){
                        acc = "MoneyMarket";
                    }
                    if(accounts[x] instanceof Savings){
                        acc = "Savings";
                    }
                    System.out.println("*"+acc+accounts[x].toString());
                }
                
	}
	
	public void printAccounts() {
		String acc ="";
                for(int x = 0 ; x < size ; x++){
                    if(accounts[x] instanceof Checking){
                        acc = "Checking";
                    }
                    if(accounts[x] instanceof MoneyMarket){
                        acc = "MoneyMarket";
                    }
                    if(accounts[x] instanceof Savings){
                        acc = "Savings";
                    }
                    System.out.println("*"+acc+accounts[x].toString());
                }
	}
}
