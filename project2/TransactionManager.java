package project2;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * This is the user interface class that handles the transactions and displays the results on the console.
 * @author Liman Chang, Kenneth Christian
 */
public class TransactionManager {
	
	private Date stringToDate(String date) {
		String[] elements = date.split("/");
		return new Date(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]), Integer.parseInt(elements[2]));
	}
	
	/**
	 * Creates a Checking account.
	 * @param input from the command line
	 * @return Checking account with data from input
	 */
	private Checking createChecking(String input) {
		String[] elements = input.split(" ");
		
		if (elements.length == 3) { // close account
			return new Checking(elements[1], elements[2], 0, new Date(10, 8, 2020), false);
		} 
		else if (elements.length == 4) { // deposit or withdraw funds
			return new Checking(elements[1], elements[2], Double.parseDouble(elements[3]), new Date(10, 8, 2020), false);
		} 
		else { // open account
			if (elements[5].equals("true")) {
				return new Checking(elements[1], elements[2], Double.parseDouble(elements[3]), stringToDate(elements[4]), true);
			} else {
				return new Checking(elements[1], elements[2], Double.parseDouble(elements[3]), stringToDate(elements[4]), false);
			}
		}
	}
	
	/**
	 * Creates a Savings account.
	 * @param input from the command line
	 * @return Savings account with data from input
	 */
	private Savings createSavings(String input) {
		String[] elements = input.split(" ");
		
		if (elements.length == 3) { // close account
			return new Savings(elements[1], elements[2], 0, new Date(10, 8, 2020), false);
		} 
		else if (elements.length == 4) { // deposit or withdraw funds
			return new Savings(elements[1], elements[2], Double.parseDouble(elements[3]), new Date(10, 8, 2020), false);
		} 
		else { // open account
			if (elements[5].equals("true")) {
				return new Savings(elements[1], elements[2], Double.parseDouble(elements[3]), stringToDate(elements[4]), true);
			} else {
				return new Savings(elements[1], elements[2], Double.parseDouble(elements[3]), stringToDate(elements[4]), false);
			}
		}
	}
	
	/**
	 * Creates a MoneyMarket account.
	 * @param input from the command line
	 * @return MoneyMarket account with data from input
	 */
	private MoneyMarket createMoneyMarket(String input) {
		String[] elements = input.split(" ");
		
		if (elements.length == 3) { // close account
			return new MoneyMarket(elements[1], elements[2], 0, new Date(10, 8, 2020), 0);
		} 
		else if (elements.length == 4) { // deposit or withdraw funds
			return new MoneyMarket(elements[1], elements[2], Double.parseDouble(elements[3]), new Date(10, 8, 2020), 0);
		} 
		else { // open account
			return new MoneyMarket(elements[1], elements[2], Double.parseDouble(elements[3]), stringToDate(elements[4]), Integer.parseInt(elements[5]));
		}
	}
	
	/**
	 * Takes the String representation of the command line input and creates a double of the amount stated in the input.
	 * @param input from the command line
	 * @return double of the amount stated from the input
	 */
	private double getAmount(String input) {
		String[] elements = input.split(" ");
		return Double.parseDouble(elements[3]);
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
			input = scn.nextLine();
			boolean result = false;
			
			command = input.substring(0, 1);
			command = command.trim();
			
			// open
			if (command.equals("O")) {
				command = input.substring(0, 2);
				
				if (command.equals("OC")) {
					result = database.add(createChecking(input));
				}
				else if (command.equals("OS")) {
					result = database.add(createSavings(input));
				} 
				else if (command.equals("OM")) {
					result = database.add(createMoneyMarket(input));
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
					result = database.remove(createChecking(input));
				}
				else if (command.equals("CS")) {
					result = database.remove(createSavings(input));
				} 
				else if (command.equals("CM")) {
					result = database.remove(createMoneyMarket(input));
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
					result = database.deposit(createChecking(input), getAmount(input));
				}
				else if (command.equals("DS")) {
					result = database.deposit(createSavings(input), getAmount(input));
				} 
				else if (command.equals("DM")) {
					result = database.deposit(createMoneyMarket(input), getAmount(input));
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
				int remainder;
				
				if (command.equals("WC")) {
					remainder = database.withdrawal(createChecking(input), getAmount(input));
				}
				else if (command.equals("WS")) {
					remainder = database.withdrawal(createSavings(input), getAmount(input));
				} 
				else if (command.equals("WM")) {
					remainder = database.withdrawal(createMoneyMarket(input), getAmount(input));
				}
				
				System.out.println(currency.format(getAmount(input)) + " withdrawn from account.");
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
