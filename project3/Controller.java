package project3;
/**
 * Controller class to handle user actions.
 * Class contains methods to allow user to import and export file.
 * Class also allows user to manually enter in data. Based on the selections
 * certain options are disabled and enabled.
 * @author Liman Chang, Kenneth Christian
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Controller implements Initializable {

    // fxml for main
    @FXML
    public Button FileOptionsButton, CommandsButton;

    @FXML
    public TextArea TextAreaPrint;


    // fxml for command
    @FXML
    public Button SubmitInfo;

    @FXML
    public RadioButton OpenAccRB, CloseAccRB, DepositRB, WithdrawAccRB, MoneyMarketRB, SavingRB, CheckingRB, DisplayByLName, DisplayByDate, DisplayAllAcc;

    @FXML
    public CheckBox SpecialSavingAccCB, DirectDepositCheckingsCB;

    @FXML
    public TextField FirstNameInput, LastNameInput, AmountInput, DateInput , NumWithDrawals;

    // fxml for file
    @FXML
    public Button SelectFileButton, SubmitFileButton, ExportFileButton;

    @FXML
    public TextField FileNameToExport, FileImportNameTxtF;

    @FXML
    public MenuItem PrintAllAccMenuItem, PrintByLastNameMenuItem, PrintByDateOpenMenuItem;

    // private variables for transaction management
    private AccountDatabase accountDatabase = new AccountDatabase();


    /**
     * Method to get data from commands window and
     * perform bank actions such as open, close, withdraw, and deposit.
     * Method also does mismatch input data checking for name, date and amount.
     *
     * @param event
     * @throws Exception
     */
    @FXML
    void getDataFromCommands(ActionEvent event) throws Exception {

        SubmitInfo.setOnAction(e -> {
            boolean nameCheck = true;
            char[] First = FirstNameInput.getText().toCharArray();
            char[] Last = LastNameInput.getText().toCharArray();
            for (char c : First) {
                if (!Character.isAlphabetic(c)) {//check if input has anything other than a letter
                    TextAreaPrint.appendText("Input data type mismatch.\n");
                    nameCheck = false;
                    break;
                }
            }
            for (char a : Last) {
                if (!Character.isAlphabetic(a)) {//check if input has anything other than a letter
                    TextAreaPrint.appendText("Input data type mismatch.\n");
                    nameCheck = false;
                    break;
                }
            }
            if(nameCheck == true) {//if names are good continue

                if (OpenAccRB.isSelected()) {//open account command


                    boolean isGood = true;
                    try {//check amount
                        Double amount = Double.parseDouble(AmountInput.getText());
                    } catch (NumberFormatException u) {
                        isGood = false;
                        TextAreaPrint.appendText("Input data type mismatch.\n");
                    }
                    try {//check date format
                        String[] datein = DateInput.getText().split("/");
                        Date date = new Date(Integer.parseInt(datein[0]), Integer.parseInt(datein[1]), Integer.parseInt(datein[2]));
                        date = stringToDate(DateInput.getText());
                    } catch (NumberFormatException a) {
                        isGood = false;
                        TextAreaPrint.appendText("Input data type mismatch.\n");
                    }
                    if (isGood == true) {//check date to see if within limits of month day and year.
                        Date date = stringToDate(DateInput.getText());
                        if (date.isValid()) {
                            isGood = true;
                        } else {
                            isGood = false;
                            TextAreaPrint.appendText(DateInput.getText() + " is not a valid date!\n");
                        }
                    }

                    if (MoneyMarketRB.isSelected()) {

                        if (isGood == true) {
                            MoneyMarket m = new MoneyMarket(FirstNameInput.getText(), LastNameInput.getText(), Double.parseDouble(AmountInput.getText()), stringToDate(DateInput.getText()), Integer.parseInt(NumWithDrawals.getText()));
                            accountDatabase.add(m);
                            TextAreaPrint.appendText("Account opened and added to the database.\n");
                        }
                    }
                    if (SavingRB.isSelected()) {
                        boolean isLoyal = false;
                        if (SpecialSavingAccCB.isSelected()) {
                            isLoyal = true;
                        }

                        if (isGood == true) {
                            Savings m = new Savings(FirstNameInput.getText(), LastNameInput.getText(), Double.parseDouble(AmountInput.getText()), stringToDate(DateInput.getText()), isLoyal);
                            accountDatabase.add(m);
                            TextAreaPrint.appendText("Account opened and added to the database.\n");
                        }
                    }
                    if (CheckingRB.isSelected()) {
                        boolean isDD = false;
                        if (DirectDepositCheckingsCB.isSelected()) {
                            isDD = true;
                        }

                        if (isGood == true) {
                            Savings m = new Savings(FirstNameInput.getText(), LastNameInput.getText(), Double.parseDouble(AmountInput.getText()), stringToDate(DateInput.getText()), isDD);
                            accountDatabase.add(m);
                            TextAreaPrint.appendText("Account opened and added to the database.\n");
                        }
                    }
                }

                if (CloseAccRB.isSelected()) {//close account command

                    if (MoneyMarketRB.isSelected()) {
                        Date d = new Date(1, 1, 2020);
                        MoneyMarket mm = new MoneyMarket(FirstNameInput.getText(), LastNameInput.getText(), 0.0, d, 0);
                        if (accountDatabase.remove(mm) == false) {
                            TextAreaPrint.appendText("Account not in database\n");
                        } else TextAreaPrint.appendText("Account removed\n");
                    }
                    if (SavingRB.isSelected()) {
                        Date d = new Date(1, 1, 2020);
                        Savings s = new Savings(FirstNameInput.getText(), LastNameInput.getText(), 0.0, d, false);
                        if (accountDatabase.remove(s) == false) {
                            TextAreaPrint.appendText("Account not in database\n");
                        } else TextAreaPrint.appendText("Account removed\n");
                    }
                    if (CheckingRB.isSelected()) {
                        Date d = new Date(1, 1, 2020);
                        Checking c = new Checking(FirstNameInput.getText(), LastNameInput.getText(), 0.0, d, false);
                        if (accountDatabase.remove(c) == false) {
                            TextAreaPrint.appendText("Account not in database\n");
                        } else TextAreaPrint.appendText("Account removed\n");
                    }

                }

                if (WithdrawAccRB.isSelected()) {//Withdraw Command
                    Boolean isGood = true;
                    try {
                        Double amount = Double.parseDouble(AmountInput.getText());
                    } catch (NumberFormatException u) {
                        isGood = false;
                        TextAreaPrint.appendText("Input data type mismatch.\n");
                    }

                    if (MoneyMarketRB.isSelected()) {
                        Date d = new Date(1, 1, 2000);
                        MoneyMarket mm = new MoneyMarket(FirstNameInput.getText(), LastNameInput.getText(), Double.parseDouble(AmountInput.getText()), d, 0);

                        if (isGood == true) {
                            int ans = accountDatabase.withdrawal(mm, Double.parseDouble(AmountInput.getText()));
                            if (ans == 0) {
                                TextAreaPrint.appendText(AmountInput.getText() + " withdrawn from account.\n");
                            }
                            if (ans == 1) {
                                TextAreaPrint.appendText("Insufficient funds.\n");
                            }
                            if (ans == -1) {
                                TextAreaPrint.appendText("account doesn't exist\n");
                            }
                        }
                    }
                    if (SavingRB.isSelected()) {
                        Date d = new Date(1, 1, 2000);

                        if (isGood == true) {

                            Savings s = new Savings(FirstNameInput.getText(), LastNameInput.getText(), Double.parseDouble(AmountInput.getText()), d, false);
                            int ans = accountDatabase.withdrawal(s, Double.parseDouble(AmountInput.getText()));

                            if (ans == 0) {
                                TextAreaPrint.appendText(AmountInput.getText() + " withdrawn from account.\n");
                            }
                            if (ans == 1) {
                                TextAreaPrint.appendText("Insufficient funds.\n");
                            }
                            if (ans == -1) {
                                TextAreaPrint.appendText("account doesn't exist\n");
                            }
                        }
                    }
                    if (CheckingRB.isSelected()) {
                        Date d = new Date(1, 1, 2000);
                        Checking c = new Checking(FirstNameInput.getText(), LastNameInput.getText(), Double.parseDouble(AmountInput.getText()), d, false);

                        if (isGood == true) {
                            int ans = accountDatabase.withdrawal(c, Double.parseDouble(AmountInput.getText()));
                            if (ans == 0) {
                                TextAreaPrint.appendText(AmountInput.getText() + " withdrawn from account.\n");
                            }
                            if (ans == 1) {
                                TextAreaPrint.appendText("Insufficient funds.\n");
                            }
                            if (ans == -1) {
                                TextAreaPrint.appendText("account doesn't exist\n");
                            }
                        }
                    }
                }

                if (DepositRB.isSelected()) {//Deposit Command

                    Boolean isGood = true;
                    try {
                        Double amount = Double.parseDouble(AmountInput.getText());
                    } catch (NumberFormatException u) {
                        isGood = false;
                        TextAreaPrint.appendText("Input data type mismatch.\n");
                    }
                    if (MoneyMarketRB.isSelected()) {
                        Date d = new Date(1, 1, 200);
                        MoneyMarket mm = new MoneyMarket(FirstNameInput.getText(), LastNameInput.getText(), 0.0, d, 0);

                        if (isGood == true) {
                            boolean ans = accountDatabase.deposit(mm, Double.parseDouble(AmountInput.getText()));
                            if (ans == false) {
                                TextAreaPrint.appendText("Account doesn't exist\n");
                            } else TextAreaPrint.appendText(AmountInput.getText() + " deposited to account.");
                        }
                    }

                    if (CheckingRB.isSelected()) {
                        Date d = new Date(1, 1, 200);
                        Checking mm = new Checking(FirstNameInput.getText(), LastNameInput.getText(), 0.0, d, false);

                        if (isGood == true) {
                            boolean ans = accountDatabase.deposit(mm, Double.parseDouble(AmountInput.getText()));
                            if (ans == false) {
                                TextAreaPrint.appendText("Account doesn't exist\n");
                            } else TextAreaPrint.appendText(AmountInput.getText() + " deposited to account.");

                        }
                    }

                    if (SavingRB.isSelected()) {
                        Date d = new Date(1, 1, 200);
                        Savings mm = new Savings(FirstNameInput.getText(), LastNameInput.getText(), 0.0, d, false);

                        if (isGood == true) {
                            boolean ans = accountDatabase.deposit(mm, Double.parseDouble(AmountInput.getText()));
                            if (ans == false) {
                                TextAreaPrint.appendText("Account doesn't exist\n");
                            } else TextAreaPrint.appendText(AmountInput.getText() + " deposited to account.");
                        }
                    }
                }
            }
        });
    }


    /**
     * Method to input and submit a file
     * filtered by .txt extension.
     *
     * @param event
     * @throws Exception
     */
    @FXML
    public void getFileInput(ActionEvent event) throws Exception {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Source File for the Import");
        chooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
                new ExtensionFilter("All Files", "*.*"));
        Stage stage = new Stage();
        File sourceFile = chooser.showOpenDialog(stage); //get the reference of the source file
        //write code to read from the file.

        Scanner sc = null;
        try {
            sc = new Scanner(sourceFile).useDelimiter("\\s+");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            TextAreaPrint.appendText("Error. File not found.\n");
            return;
        }

        String delim = ",";
        while (sc.hasNext())
        {
            Account acc;
            String input = sc.nextLine();
            //System.out.println(input);

            String inputs[] = input.split(delim);

            // get balance
            double balance = 0;
            try {
                balance = Double.parseDouble(inputs[3]);
            }
            catch (InputMismatchException e) {
                TextAreaPrint.appendText("Input data type mismatch.\n");
                break;
            }

            // get date
            Date date = null;
            try {
                date = stringToDate(inputs[4]);
            }
            catch (InputMismatchException e) {
                TextAreaPrint.appendText("Input data type mismatch.\n");
                break;
            }

            // determine type of account to open
            if (inputs[0].equals("C")) {
                boolean direct = false;
                try {
                    direct = Boolean.parseBoolean(inputs[5]);
                }
                catch (InputMismatchException e) {
                    TextAreaPrint.appendText("Input data type mismatch.\n");
                    break;
                }

                if (direct == false) { // parse boolean doesn't catch false strings
                    if (!inputs[5].toLowerCase().equals("false")) {
                        TextAreaPrint.appendText("Input data type mismatch.\n");
                        break;
                    }
                }

                acc = new Checking(inputs[1], inputs[2], balance, date, direct);
                accountDatabase.add(acc);
                TextAreaPrint.appendText("Account opened and added to the database.\n");
            }
            else if (inputs[0].equals("S")) {
                boolean isLoyal = false;
                try {
                    isLoyal = Boolean.parseBoolean(inputs[5]);
                }
                catch (InputMismatchException e) {
                    TextAreaPrint.appendText("Input data type mismatch.\n");
                    break;
                }

                if (isLoyal == false) { // parse boolean doesn't catch false strings
                    if (!inputs[5].toLowerCase().equals("false")) {
                        TextAreaPrint.appendText("Input data type mismatch.\n");
                        break;
                    }
                }

                acc = new Savings(inputs[1], inputs[2], balance, date, isLoyal);
                accountDatabase.add(acc);
                TextAreaPrint.appendText("Account opened and added to the database.\n");
            }
            else if (inputs[0].equals("M")) {
                int withdrawals = 0;
                try {
                    withdrawals = Integer.parseInt(inputs[5]);
                }
                catch (NumberFormatException e) {
                    TextAreaPrint.appendText("Input data type mismatch.\n");
                    break;
                }

                acc = new MoneyMarket(inputs[1], inputs[2], balance, date, withdrawals);
                accountDatabase.add(acc);
                TextAreaPrint.appendText("Account opened and added to the database.\n");
            }
            else {
                TextAreaPrint.appendText("Bad input.\n");
            }
        }

        sc.close();
    }

    /**
     * Method to disable specials savings check box or direct deposit check box
     * based on selection of account type. Method also disables text fields
     * based on user selection of bank options and account type.
     *
     * @param event
     * @throws Exception
     */
    @FXML
    public void DisableCheckBox(ActionEvent event) throws Exception {

        if (!SavingRB.isSelected() || !OpenAccRB.isSelected()) {//if savings is not selected than disable specials acc check box
            SpecialSavingAccCB.setSelected(false);
            SpecialSavingAccCB.setDisable(true);
        } else SpecialSavingAccCB.setDisable(false);

        if (!CheckingRB.isSelected() || !OpenAccRB.isSelected()) {//if checkings is not selected than disable direct deposit check boc
            DirectDepositCheckingsCB.setSelected(false);
            DirectDepositCheckingsCB.setDisable(true);
        } else DirectDepositCheckingsCB.setDisable(false);

        if (CloseAccRB.isSelected()) {//if and else if to disable textfields based on bank options
            AmountInput.setDisable(true);
            DateInput.setDisable(true);
        } else if (DepositRB.isSelected() || WithdrawAccRB.isSelected()) {
            AmountInput.setDisable(false);
            DateInput.setDisable(true);
        } else {
            AmountInput.setDisable(false);
            DateInput.setDisable(false);
        }
        if(!MoneyMarketRB.isSelected() || !OpenAccRB.isSelected()){
            NumWithDrawals.setDisable(true);
        }
        else NumWithDrawals.setDisable(false);

    }

    /**
     * Prints accounts to target file.
     */
    @FXML
    public void exportFile(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Target File for the Export");
        chooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
                new ExtensionFilter("All Files", "*.*"));
        Stage stage = new Stage();
        File targetFile = chooser.showSaveDialog(stage); //get the reference of the target file
        //write code to write to the file.

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(targetFile);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (pw != null) {
            String[] printData = accountDatabase.printAccounts();

            for (int i = 0; i < printData.length; i++) {
                pw.write(printData[i]);
                pw.write("\n");
            }
        }

        pw.close();
    }

    /**
     * Prints the account database by last name when the PrintByLastNameMenuItem has an event.
     * @param event
     */
    @FXML
    public void PrintAccByLastName(ActionEvent event) {
        String acc[] = accountDatabase.printByLastName();

        if (acc[0].equals("Database is empty.")) {
            TextAreaPrint.appendText("Database is empty.\n");
            return;
        }

        String delim = "&";
        for (int i = 0; i < acc.length; i++) {
            TextAreaPrint.appendText("\n");
            if (i == acc.length - 1) {
                TextAreaPrint.appendText(acc[i]);
                TextAreaPrint.appendText("\n");
            }
            else {
                String elements[] = acc[i].split(delim);
                for (int j = 0; j < elements.length; j++) {
                    TextAreaPrint.appendText(elements[j]);
                    TextAreaPrint.appendText("\n");
                }
            }
        }
    }

    /**
     * Prints the account database by date open when the PrintByDateOpenMenuItem has an event.
     * @param event
     */
    @FXML
    public void PrintAccByDateOpen(ActionEvent event) {
        String acc[] = accountDatabase.printByDateOpen();

        if (acc[0].equals("Database is empty.")) {
            TextAreaPrint.appendText("Database is empty.\n");
            return;
        }

        String delim = "&";
        for (int i = 0; i < acc.length; i++) {
            TextAreaPrint.appendText("\n");
            if (i == acc.length - 1) {
                TextAreaPrint.appendText(acc[i]);
                TextAreaPrint.appendText("\n");
            }
            else {
                String elements[] = acc[i].split(delim);
                for (int j = 0; j < elements.length; j++) {
                    TextAreaPrint.appendText(elements[j]);
                    TextAreaPrint.appendText("\n");
                }
            }
        }
    }

    /**
     * Method to append to text area.
     * Method calls return method in AccountDatabase class
     * and receives and array of accounts to append.
     */
    @FXML
    public void DisplayAccounts() {
        String acc[]= accountDatabase.printAccounts();

        if (acc[0].equals("Database is empty.")) {
            TextAreaPrint.appendText("Database is empty.\n");
            return;
        }

        String delim = "&";
        for (int i = 0; i < acc.length; i++) {
            if (i == acc.length - 1) {
                TextAreaPrint.appendText(acc[i]);
                TextAreaPrint.appendText("\n");
            }
            else {
                String elements[] = acc[i].split(delim);
                for (int j = 0; j < elements.length; j++) {
                    TextAreaPrint.appendText(elements[j]);
                    TextAreaPrint.appendText("\n");
                }
            }
        }
    }

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
     * Called when view loads
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {}

}
