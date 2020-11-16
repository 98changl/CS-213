package project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SecondController implements Initializable {


    @FXML
    public ListView<String> DetailsListView;

    @FXML
    public Button AddSelectedSandwichB , RemoveSandwichB, ClearSandwichB ,SaveB;

    /**
     * Method to remove sandwich from order details stage.
     */
    public void remove() {//index
        int selected = DetailsListView.getSelectionModel().getSelectedIndex();
        DetailsListView.getItems().remove(selected);
        Controller.order.remove(Controller.order.getOrderLine(selected));
        updateListView();
    }

    /**
     * Method to add selected sandwich to the order.
     */
    public void add() {
        int selected = DetailsListView.getSelectionModel().getSelectedIndex();
        DetailsListView.getItems().addAll(DetailsListView.getSelectionModel().getSelectedItems());
        OrderLine duplicate = new OrderLine(Order.lineNumber, Controller.order.getOrderLine(selected).getSandwich());
        Controller.order.add(duplicate);
        updateListView();
    }


    /**
     * Method to clear the order.
     */
    public void clear() {
        Controller.order.clear();
        DetailsListView.getItems().clear();
    }
    
    /**
     * Method to save the order to a file.
     */
    public void SaveB() {
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
			ObservableList<String> list = getDetailsList();
			
			for (int i = 0; i < list.size(); i++) {
				pw.write(list.get(i));
			}
		}
		
		pw.close();
    }

    /**
     * Called when view loads.
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	updateListView();
    }
    
    /**
     * Updates the DetailsListView with the order.
     */
    private void updateListView() {
    	DetailsListView.setItems(getDetailsList());
    }
    
    /**
     * Converts the order into an observable list for the DetailsListView.
     * @return Observable List list
     */
    private ObservableList<String> getDetailsList() {
    	ObservableList<String> list = FXCollections.observableArrayList();
    	
    	// loop through order line list
    	for (int i = 0; i < Controller.order.size(); i++) {
    		OrderLine temp = Controller.order.getOrderLine(i);
    		String[] sandwichStr = temp.getSandwich().toString().split(",");
    		String display = "Order #";
    		
    		// set up sandwich name
    		display = display.concat(String.valueOf(temp.getLineNumber()));
    		display = display.concat(": ");
    		display = display.concat(sandwichStr[0]);
    		display = display.concat(" sandwich\n");
    		
    		int j = 1;
    		// loop through ingredients
    		for (j = 1; j < sandwichStr.length - 1; j++) {
    			display = display.concat("\t");
    			display = display.concat(sandwichStr[j]);
    			display = display.concat("\n");
    		}
    		
    		// price of the sandwich
    		display = display.concat("Price: ");
    		display = display.concat(sandwichStr[j]);
    		
    		list.add(display);
    	}
    	
    	return list;
    }
}