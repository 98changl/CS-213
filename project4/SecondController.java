package project4;

import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SecondController implements Initializable {


    @FXML
    public ListView DetailsListView;

    @FXML
    public Button AddSelectedSandwichB , RemoveSandwichB, ClearSandwichB ,SaveB;

    /**
     * Method to remove sandwich from order details stage.
     */
    public void remove() {//index

        int selected = DetailsListView.getSelectionModel().getSelectedIndex();
        DetailsListView.getItems().remove(selected);
        Controller.order.remove(Controller.order.getOrderLine(selected));

    }

    /**
     * Method to add selected sandwich to the order.
     */
    public void add(){
        int selected = DetailsListView.getSelectionModel().getSelectedIndex();
        DetailsListView.getItems().addAll(DetailsListView.getSelectionModel().getSelectedItems());
        Controller.order.add(Controller.order.getOrderLine(selected));
    }


    /**
     * Mehtod to clear the order.
     */
    public void clear(){

        Controller.order.clear();
        DetailsListView.getItems().clear();
    }




    /**
     * Called when view loads.
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }
}
