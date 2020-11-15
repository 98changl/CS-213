package project4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class Controller  implements Initializable {


    @FXML
    public ComboBox SandwichTypeCB;


    @FXML
    public ListView ExtraIngredientLV, SelectedExtraIngredientLV;

    @FXML
    public ImageView SandwichImage;

    @FXML
    public Button AddB, DetailsB , AddIngredientsB, RemoveIngredientsB;

    @FXML
    public TextField PriceTF;

    //to keep track of line number
    public int lineCounter = 0;
    public OrderLine orderLine;
    public Order order = new Order(lineCounter);

    /**
     * Method to control all ComboBox functions based on
     * the sandwich type selected.
     */
    public void ComboBoxActions(){

        //change image
        if(SandwichTypeCB.getValue().toString().matches("Chicken") ) {//change image
            try {
                FileInputStream input = new FileInputStream("C:\\Users\\kenne\\OneDrive\\Desktop\\PJ4_Chicken.png");
                Image image = new Image(input);
                SandwichImage.setImage(image);
                ExtraIngredientLV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

            } catch (FileNotFoundException t) {
                t.printStackTrace();
            }
        }
            if(SandwichTypeCB.getValue().toString().matches("Beef")){//change image
                try {
                    FileInputStream input = new FileInputStream("C:\\Users\\kenne\\OneDrive\\Desktop\\PJ4_Beef.png");
                    Image image = new Image(input);
                    SandwichImage.setImage(image);
                    ExtraIngredientLV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

                }catch (FileNotFoundException t){
                    t.printStackTrace();
                }

        }
        if(SandwichTypeCB.getValue().toString().matches("Fish")) {//change image
            try {
                FileInputStream input = new FileInputStream("C:\\Users\\kenne\\OneDrive\\Desktop\\PJ4_Fish.png");
                Image image = new Image(input);
                SandwichImage.setImage(image);
                ExtraIngredientLV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

            } catch (FileNotFoundException t) {
                t.printStackTrace();
            }
        }
    }

    /**
     * Mehtod to control all extra add Ingredient functions.
     */
    public void SubmitExtra() {
        if(SelectedExtraIngredientLV.getItems().size() < 6) {
            SelectedExtraIngredientLV.getItems().addAll(ExtraIngredientLV.getSelectionModel().getSelectedItems());
        }
    }

    /**
     * Method to control all extra remove Ingredient functions.
     */
    public void RemoveExtra(){
        SelectedExtraIngredientLV.getItems().removeAll(ExtraIngredientLV.getSelectionModel().getSelectedItems());
    }

    /**
     * Method to add sandwich to the order and
     * Increases line counter by 1. Method also
     * gets the extra the Ingredient.
     */
    public void addSandwich(){

        lineCounter++;
        String extraIng = null;
        extraIng = (String) SelectedExtraIngredientLV.getItems().stream()////get extras into a string
                .map(Object::toString)
                .collect(Collectors.joining(", "));//"," as delimiter


        Sandwich sandwich = new Chicken();
        sandwich.add(null);

        Extra extra = null;
        String[] extras = null;


        if(SandwichTypeCB.getValue().toString().matches("Chicken")) {//change image
            sandwich = new Chicken();

            if((!SelectedExtraIngredientLV.getItems().isEmpty())) {
                extras = extraIng.split(",");
                for (int x = 0; x < extras.length; x++) {
                    sandwich.add(new Extra(extras[x]));//Split Ingredients to create extra
                }
            }
            order.add(orderLine = new OrderLine(lineCounter,sandwich));


        }

        if(SandwichTypeCB.getValue().toString().matches("Beef")) {//change image
            sandwich = new Beef();

            if((!SelectedExtraIngredientLV.getItems().isEmpty())){
                extras = extraIng.split(",");
                for (int x = 0; x < extras.length; x++) {
                    sandwich.add(new Extra(extras[x]));//Split Ingredients to create extra
                }
            }
            order.add(orderLine = new OrderLine(lineCounter,sandwich));

        }

        if(SandwichTypeCB.getValue().toString().matches("Fish")) {//change image
            sandwich = new Fish();

            if((!SelectedExtraIngredientLV.getItems().isEmpty())){
                extras = extraIng.split(",");

                for (int x = 0; x < extras.length; x++) {
                    sandwich.add(new Extra(extras[x]));//Split Ingredients to create extra
                }
            }
            order.add(orderLine = new OrderLine(lineCounter,sandwich));

        }
        SelectedExtraIngredientLV.getItems().clear();

    }

    /**
     * Method opens a new stage
     * for OrderDetails. Method adds 
     * order to the listview in the new stage.
     */
    public void openDetails(){

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderDetails.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root,1250,900);
            stage.setScene(scene);
            stage.show();

            //Get controller of scene2
            SecondController controller2 = loader.getController();
            for(int x  = 0 ; x < order.getArray().size() ; x++){

                    controller2.DetailsListView.getItems().addAll(order.getArray().get(x).getLineNumber() + " " + order.getArray().get(x).getSandwich());
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * Called when view loads.
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //set image to chicken upon start
        SandwichTypeCB.getSelectionModel().selectFirst();
        try {
            FileInputStream input = new FileInputStream("C:\\Users\\kenne\\OneDrive\\Desktop\\PJ4_Chicken.png");
            Image image = new Image(input);
            SandwichImage.setImage(image);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ExtraIngredientLV.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);



    }
}
