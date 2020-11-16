package project4;

import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SecondController implements Initializable {


    @FXML
    public ListView DetailsListView;

    @FXML
    public Button AddSelectedSandwichB, RemoveSandwichB, ClearSandwichB, SaveB , GoToMain;

    @FXML
    public TextField SumTotal;

    //to go back
    public Stage stage;

    /**
     * Method to remove sandwich from order details stage.
     */
    public void remove() {//index
        DecimalFormat format = new DecimalFormat("0.00");

        int selected = DetailsListView.getSelectionModel().getSelectedIndex();
        DetailsListView.getItems().remove(selected);
        Controller.order.remove(Controller.order.getOrderLine(selected));
        Controller.order.reorder();

        double t = 0;//get total price
        for(int x = 0 ; x<Controller.order.size() ; x++){
            t = t + Controller.order.getOrderLine(x).getSandwich().price();
        }

        SumTotal.appendText("Total: $" + format.format(t));
        Controller.order.reorder();



    }

    /**
     * Method to add selected sandwich to the order.
     */
    public void add() {

        DecimalFormat format = new DecimalFormat("0.00");

        int selected = DetailsListView.getSelectionModel().getSelectedIndex();
        DetailsListView.getItems().addAll(DetailsListView.getSelectionModel().getSelectedItems());
        OrderLine orderLine = new OrderLine(0, Controller.order.getOrderLine(selected).getSandwich());
        Controller.order.add(orderLine);

        double t = 0;//get total price
        for(int x = 0 ; x<Controller.order.size() ; x++){
            t = t + Controller.order.getOrderLine(x).getSandwich().price();
        }

        SumTotal.appendText("Total: $" + format.format(t));
        Controller.order.reorder();
        
    }


    /**
     * Mehtod to clear the order.
     */
    public void clear() {

        Controller.order.clear();
        DetailsListView.getItems().clear();
    }

    /**
     * Method to save order to a .txt file.
     */
    public void save() {

        DecimalFormat format = new DecimalFormat("0.00");

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Target File for the Export");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        Stage stage = new Stage();
        File targetFile = chooser.showSaveDialog(stage); //get the reference of the target file
        //write code to write to the file.

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(targetFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        double t = 0;//get total price
        for(int x = 0 ; x<Controller.order.size() ; x++){
            t = t + Controller.order.getOrderLine(x).getSandwich().price();
        }


        if (pw != null) {

            for (int i = 0; i < Controller.order.size(); i++) {
                pw.write(Controller.order.getOrderLine(i).getLineNumber() + " " + Controller.order.getOrderLine(i).getSandwich().toString());
                pw.write("\n");
            }
            pw.write("Total: $" + format.format(t));
        }

        pw.close();
    }

    /**
     * Method to get this stage.
     * 
     * @param stage
     */
    public void getStage(Stage stage){
        this.stage = stage;
    }

    /**
     * Method to close this stage on back button click.
     */
    public void close(){
        this.stage.close();
    }




    /**
     * Called when view loads.
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        DecimalFormat format = new DecimalFormat("0.00");

        double t = 0;//get total price
        for(int x = 0 ; x<Controller.order.size() ; x++){
            t = t + Controller.order.getOrderLine(x).getSandwich().price();
        }

        SumTotal.appendText("Total: $" + format.format(t));
        SumTotal.editableProperty().set(false);


    }
}
