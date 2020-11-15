package project4;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class SecondController implements Initializable {


    @FXML
    public ListView DetailsListView;

    @FXML
    public Button AddSelectedSandwichB , RemoveSandwichB, ClearSandwichB ,SaveB;

    public Controller controller1;






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
