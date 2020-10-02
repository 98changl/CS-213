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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double monthlyFee() {
		// TODO Auto-generated method stub
		return 0;
	}
}
