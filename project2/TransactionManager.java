package project2;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is the user interface class that handles the transactions and displays the results on the console.
 * @author Liman Chang, Kenneth Christian
 */
public class TransactionManager {
	
	/**
	 * Converts a string representation of a date into a date object.
	 * Does not perform exception handling.
	 * @param date in the form of a string
	 * @return date object with values from string input
	 */
	private Date stringToDate(String date) {
		String[] elements = date.split("/");
		return new Date(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]), Integer.parseInt(elements[2]));
	}
	
	/**
	 * Creates a Checking account.
	 * @param input from the command line
	 * @return Checking account with data from input, null on exception
	 */
	private Checking createChecking(String input) {
		String[] elements = input.split(" ");
		
		String first_name = elements[1];
		String last_name = elements[2];
		double balance = 0.0;
		Date date = new Date(1, 1, 2000);
		boolean directDeposit = false;
		
		// set up balance
		try {
			balance = Double.parseDouble(elements[3]);
		} 
		catch (NumberFormatException e) {
			return null;
		}
		if (elements.length == 3) { // close account
			return new Checking(first_name, last_name, balance, date, directDeposit);
		} 
		
		// set up date
		try {
			date = stringToDate(elements[4]);
		}
		catch (NumberFormatException e) {
			return null;
		}
		if (elements.length == 4) { // deposit or withdraw funds
			return new Checking(first_name, last_name, balance, date, directDeposit);
		}
		
		// set up directDeposit
		try {
			directDeposit = Boolean.parseBoolean(elements[5]);
		}
		catch (NumberFormatException e) {
			return null;
		}
		return new Checking(first_name, last_name, balance, date, directDeposit);
	}
	
	/**
	 * Creates a Savings account.
	 * @param input from the command line
	 * @return Savings account with data from input, null on exception
	 */
	private Savings createSavings(String input) {
		String[] elements = input.split(" ");
		
		String first_name = elements[1];
		String last_name = elements[2];
		double balance = 0.0;
		Date date = new Date(1, 1, 2000);
		boolean isLoyal = false;
		
		// set up balance
		try {
			balance = Double.parseDouble(elements[3]);
		} 
		catch (NumberFormatException e) {
			return null;
		}
		if (elements.length == 3) { // close account
			return new Savings(first_name, last_name, balance, date, isLoyal);
		} 
		
		// set up date
		try {
			date = stringToDate(elements[4]);
		}
		catch (NumberFormatException e) {
			return null;
		}
		if (elements.length == 4) { // deposit or withdraw funds
			return new Savings(first_name, last_name, balance, date, isLoyal);
		}
		
		// set up isLoyal
		try {
			isLoyal = Boolean.parseBoolean(elements[5]);
		}
		catch (NumberFormatException e) {
			return null;
		}
		return new Savings(first_name, last_name, balance, date, isLoyal);
	}
	
	/**
	 * Creates a MoneyMarket account.
	 * @param input from the command line
	 * @return MoneyMarket account with data from input, null on exception
	 */
	private MoneyMarket createMoneyMarket(String input) {
		String[] elements = input.split(" ");
		
		String first_name = elements[1];
		String last_name = elements[2];
		double balance = 0.0;
		Date date = new Date(1, 1, 2000);
		int withdrawals = 0;
		
		// set up balance
		try {
			balance = Double.parseDouble(elements[3]);
		} 
		catch (NumberFormatException e) {
			return null;
		}
		if (elements.length == 3) { // close account
			return new MoneyMarket(first_name, last_name, balance, date, withdrawals);
		} 
		
		// set up date
		try {
			date = stringToDate(elements[4]);
		}
		catch (NumberFormatException e) {
			return null;
		}
		if (elements.length == 4) { // deposit or withdraw funds
			return new MoneyMarket(first_name, last_name, balance, date, withdrawals);
		}
		
		// set up withdrawals
		try {
			withdrawals = Integer.parseInt(elements[5]);
		}
		catch (NumberFormatException e) {
			return null;
		}
		return new MoneyMarket(first_name, last_name, balance, date, withdrawals);
	}
	
	/**
	 * Takes the String representation of the command line input and creates a double of the amount stated in the input.
	 * @param input from the command line
	 * @return double of the amount stated from the input, -1 if exception occured
	 */
	private double getAmount(String input) {
		String[] elements = input.split(" ");
		double amount = 0.0;
		try {
			amount = Double.parseDouble(elements[3]);
		}
		catch (NumberFormatException e) {
			return -1;
		}
		return amount;
	}
	
	/**
	 * 
	 */
	public void run() {
		Scanner scn = new Scanner(System.in).useDelimiter("\\s+"); // to get input for command and data
		AccountDatabase database = new AccountDatabase();
		DecimalFormat currency = new DecimalFormat("0,000.00");
		String input = new String(); // string to store console inputs
		boolean running = true; // boolean for command loop
		
		System.out.println("Transaction processing starts.....");
		// command loop
		while (running) {
			String command;
			boolean result = false;
			
			try {
				input = scn.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println("InputMismatchException: ");
				continue;
			}
			
			command = input.substring(0, 1);
			command = command.trim();
			
			// open
			if (command.equals("O")) {
				command = input.substring(0, 2);
				
				if (command.equals("OC")) {
					Checking acc = createChecking(input);
					if (acc == null) {
						System.out.println("Input data type mismatch.");
						continue;
					} else {
						result = database.add(acc);
					}
				}
				else if (command.equals("OS")) {
					Savings acc = createSavings(input);
					if (acc == null) {
						System.out.println("Input data type mismatch.");
						continue;
					} else {
						result = database.add(acc);
					}
				} 
				else if (command.equals("OM")) {
					MoneyMarket acc = createMoneyMarket(input);
					if (acc == null) {
						System.out.println("Input data type mismatch.");
						continue;
					} else {
						result = database.add(acc);
					}
				}
				
				if (result == true) {
					System.out.println("Account opened and added to the database.");
				} else {
					System.out.println("Account is already in the database.");
				}
			}
			
			// close
			if (command.equals("C")) {
				command = input.substring(0, 2);
				
				if (command.equals("CC")) {
					Checking acc = createChecking(input);
					if (acc == null) {
						System.out.println("Input data type mismatch.");
						continue;
					} else {
						result = database.remove(acc);
					}
				}
				else if (command.equals("CS")) {
					Savings acc = createSavings(input);
					if (acc == null) {
						System.out.println("Input data type mismatch.");
						continue;
					} else {
						result = database.remove(acc);
					}
				} 
				else if (command.equals("CM")) {
					MoneyMarket acc = createMoneyMarket(input);
					if (acc == null) {
						System.out.println("Input data type mismatch.");
						continue;
					} else {
						result = database.remove(acc);
					}
				}
				
				if (result == true) {
					System.out.println("Account closed and removed from the database.");
				} else {
					System.out.println("Account does not exist.");
				}
			}
			
			// deposit
			if (command.equals("D")) {
				command = input.substring(0, 2);
				
				if (command.equals("DC")) {
					Checking acc = createChecking(input);
					double amount = getAmount(input);
					
					if (acc == null || amount == -1) {
						System.out.println("Input data type mismatch.");
						continue;
					} else {
						result = database.deposit(acc, amount);
					}
				}
				else if (command.equals("DS")) {
					Savings acc = createSavings(input);
					double amount = getAmount(input);
					
					if (acc == null || amount == -1) {
						System.out.println("Input data type mismatch.");
						continue;
					} else {
						result = database.deposit(acc, amount);
					}
				} 
				else if (command.equals("DM")) {
					MoneyMarket acc = createMoneyMarket(input);
					double amount = getAmount(input);
					
					if (acc == null || amount == -1) {
						System.out.println("Input data type mismatch.");
						continue;
					} else {
						result = database.deposit(acc, amount);
					}
				}
				
				if (result == true) {
					System.out.println(currency.format(getAmount(input)) + " deposited to account.");
				} else {
					System.out.println("Account does not exist.");
				}
			}
			
			// withdraw
			if (command.equals("W")) {
				command = input.substring(0, 2);
				int withdrawal_result = -2;
				double amount = getAmount(input);
				
				if (command.equals("WC")) {
					Checking acc = createChecking(input);
					
					if (acc == null || amount == -1) {
						System.out.println("Input data type mismatch.");
						continue;
					} else {
						withdrawal_result = database.withdrawal(acc, amount);
					}
				}
				else if (command.equals("WS")) {
					Savings acc = createSavings(input);
					
					if (acc == null || amount == -1) {
						System.out.println("Input data type mismatch.");
						continue;
					} else {
						withdrawal_result = database.withdrawal(acc, amount);
					}
				} 
				else if (command.equals("WM")) {
					MoneyMarket acc = createMoneyMarket(input);
					
					if (acc == null || amount == -1) {
						System.out.println("Input data type mismatch.");
						continue;
					} else {
						withdrawal_result = database.withdrawal(acc, amount);
					}
				}
				
				if (withdrawal_result == 0) {
					System.out.println(currency.format(amount) + " withdrawn from account.");
				} 
				else if (withdrawal_result == 1) {
					System.out.println("Insufficient funds.");
				} 
				else if (withdrawal_result == -1) {
					System.out.println("Account does not exist.");
				} else {
					
				}
			}
			
			// print
			if (command.equals("PA")) {
				database.printByDateOpen();
			}
			else if (command.equals("PD")) {
				database.printAccounts();
			} 
			else if (command.equals("PN")) {
				database.printByLastName();
			}
			
			// quit
			if (command.equals("Q")) {
				System.out.println("Transaction processing completed.");
				running = false;
			} else {
				command = input.substring(0, 2);
				command.trim();
				System.out.println("Command '" + command + "' not supported!");
			}
		}
	}
}
