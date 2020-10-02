package project2;

/**
 * 
 * @author Liman Chang, Kenneth Christian
 */
public class MoneyMarket extends Account {
	private int withdrawals;

	public MoneyMarket(String first_name, String last_name, double balance, Date date, int withdrawals) {
		super(first_name, last_name, balance, date);
		this.withdrawals = withdrawals;
	}
	
	@Override
	public double monthlyInterest() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double monthlyFee() {
		// TODO Auto-generated method stub
		return 0;
	}
}
