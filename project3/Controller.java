package project3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Controller implements Initializable {
	
	// fxml for main
	@FXML
	public Button FileOptionsButton, CommandsButton;
	
	@FXML
	public TextArea TextAreaPrint;
	
	
	// fxml for command
	@FXML
	public Button SubmitFromCommand;
	
	@FXML
	public RadioButton OpenAccRB, CloseAccRB, DepositRB, WithdrawAccRB, MoneyMarketRB, SavingRB, CheckingRB;
	
	@FXML
	public CheckBox SpecialSavingAccCB, DirectDepositCheckingsCB;
	
	@FXML
	public TextField FirstNameInput, LastNameInput, AmountInput, DateInput;
	
	// fxml for file
	@FXML
	public Button SelectFileButton, SubmitFileButton, ExportFileButton;
	
	@FXML
	public TextField FileNameToExport, FileImportNameTxtF;
    
    // private variables for transaction management
    private AccountDatabase database = new AccountDatabase();
    private String[] a = new String[1];// to store the file path for import.
    private String first_name;
    private String last_name;
    private String Amount;
    private String Date;

    @FXML
    /**
     * Method to open commands window.
     *
     * @param event
     * @throws Exception
     */
    public void OpenCommands(ActionEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("CommandWindow.fxml"));
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Commands");
        stage.setScene(new Scene(root, 1100, 800));
        stage.show();

    }

    @FXML
    /**
     * Method to Open file import/export window.
     *
     * @param event
     * @throws Exception
     */
    public void OpenFileOptions(ActionEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("ListWindow.fxml"));
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("File Options");
        stage.setScene(new Scene(root, 1000, 800));
        stage.show();
    }

    @FXML
    /**
     * Method to get data from commands window
     *
     * @param event
     * @throws Exception
     */
    public void getDataFromCommands(ActionEvent event) throws Exception {


        SubmitFromCommand.setOnAction(e -> {
            first_name = FirstNameInput.getText();
            last_name = LastNameInput.getText();
            Amount = AmountInput.getText();
            Date = DateInput.getText();
        });

    }

    public String getUserFirstName(){

        return first_name;
    }

    public String getUserlastName(){

        return last_name;
    }

    public String getUserAmount(){

        return Amount;
    }

    public String getDate(){

        return Date;
    }

    @FXML
    /**
     * Mehtod to get .txt file from the user
     *
     * @param event
     * @throws Exception
     */
    public void getDataFromFileOptionsOpen(ActionEvent event) throws Exception {
    	
        //file choose
        FileChooser fileChooser = new FileChooser();
        SelectFileButton.setOnAction(e -> {
            try {
                FileImportNameTxtF.clear();
                File selectedFile = fileChooser.showOpenDialog(null);
                //fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(".txt"));//only shows .txt files to user
                FileImportNameTxtF.appendText(selectedFile.getPath());

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        //submit file
        SubmitFileButton.setOnAction(e -> {
             a[0] =  FileImportNameTxtF.getText();

        });
    }

    @FXML
    /**
     * Method to export .txt file
     *
     * @param event
     * @throws Exception
     */
    public void getDataFromFileOptionsExport(ActionEvent event) throws Exception {}

    /**
     *
     * @return Path of the file imported
     */
    public String getPath() {
        return a[0];
    }

    @FXML
    /**
     * Method to disable specials savings check box or direct deposit check box
     * based on selection of account type.
     *
     * @param event
     * @throws Exception
     */
    public void DisableCheckBox(ActionEvent event) throws Exception {

        if (!SavingRB.isSelected()) {//if savings is not selected than disable specials acc check box
            SpecialSavingAccCB.setSelected(false);
            SpecialSavingAccCB.setDisable(true);
        } else SpecialSavingAccCB.setDisable(false);

        if (!CheckingRB.isSelected()) {//if checkings is not selected than disable direct deposit check boc
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


    }


    /**
     * Called when view loads
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {}
    
    /*
	@FXML
    void importFile(ActionEvent event) {
    	FileChooser chooser = new FileChooser();
		chooser.setTitle("Open Source File for the Import");
		chooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
				new ExtensionFilter("All Files", "*.*"));
		Stage stage = new Stage();
		File sourceFile = chooser.showOpenDialog(stage); //get the reference of the source file
		//write code to read from the file.
    }
    
    @FXML
    void exportFile(ActionEvent event) {
    	FileChooser chooser = new FileChooser();
		chooser.setTitle("Open Target File for the Export");
		chooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"),
				new ExtensionFilter("All Files", "*.*"));
		Stage stage = new Stage();
		File targeFile = chooser.showSaveDialog(stage); //get the reference of the target file
		//write code to write to the file.
    }
    */
}
