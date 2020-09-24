public class Shopping {

    public void run() {
        Scanner sc = new Scanner(System.in).useDelimiter("\\s+"); //to get input for command and data

        ShoppingBag bag = new ShoppingBag();
        String input = "";

        boolean running = true;
        System.out.println("Let's start shopping!");

        // this while loop will continue asking the user for new commands after each
        // new item is added to the array until they decide to checkout
        while (running) {
            String command;
            GroceryItem item;

            input = sc.nextLine();

            command = input.substring(0, 1);
            input = input.trim();

            if (command.equals("A")) { // add item to shopping bag
                item = makeItem(input);
                bag.add(item);
                System.out.println(item.getName() + " added to the bag");
            } else if (command.equals("R")) { // remove item from shopping bag
                item = makeItem(input);
                bag.remove(item);
                System.out.println(item.getName() + " " + item.getPrice() + " removed");
            } else if (command.equals("P")) { // display all items in the bag
                if (bag.isEmpty()) {
                    System.out.println("The bag is empty!");
                } else {
                    System.out.println("You have " + bag.getSize() + " item(s).");
                    bag.print();
                }
            } else if (command.equals("C")) { // checking out the grocery items in bag
                if (bag.isEmpty()) {
                    System.out.println("Unable to check out, the bag is empty!");
                } else {
                    checkout(bag);
                }
            } else if (command.equals("Q")) { // stop program execution
                if (!bag.isEmpty()) { // automatically check out items in the bag
                    checkout(bag);
                }
                running = false;
            } else { //
                System.out.println("Invalid command!");
            }
        }

        System.out.println("Thanks for shopping with us!");
    }

    private GroceryItem makeItem(String input) {
        String[] elements = input.split(" ");
        double price = 0.0;
        boolean taxable = false;

        price = Double.parseDouble(elements[2]);

        if (elements[3].equals("true")) {
            taxable = true;
        }

        return new GroceryItem(elements[1], price, taxable);
    }

    private void checkout(ShoppingBag bag) {
        double price = bag.salesPrice();
        double tax = bag.salesTax();
        double total = price + tax;;

        if (bag.getSize() == 1) {
            System.out.println("Checking out 1 item.");
        } else {
            System.out.println("Checking out " + bag.getSize() + " items.");
        }

        bag.print();

        System.out.println("Sales total: $" + bag.salesPrice());
        System.out.println("Sales tax: $" + bag.salesTax());
        System.out.println("Total amount paid: $" + total);
    }

}
