/*
 * Created 29 Dec 2021 by Robert Tunn
 * Last updated - 5 January 2022
 */
package uk.ac.rgu.cm2100;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Boolean.parseBoolean;

public class Controller_5_AddDrinksPane extends Model implements Initializable {

    @Override public void initialize(URL url, ResourceBundle resourceBundle) {

        drink1ComboBox.getItems().addAll(dropDownValues);
        drink2ComboBox.getItems().addAll(dropDownValues);
        drink3ComboBox.getItems().addAll(dropDownValues);
        drink4ComboBox.getItems().addAll(dropDownValues);
        drink5ComboBox.getItems().addAll(dropDownValues);
        drink6ComboBox.getItems().addAll(dropDownValues);
        drink7ComboBox.getItems().addAll(dropDownValues);

        drink1Label.setText(drink1.getName());
        drink2Label.setText(drink2.getName());
        drink3Label.setText(drink3.getName());
        drink4Label.setText(drink4.getName());
        drink5Label.setText(drink5.getName());
        drink6Label.setText(drink6.getName());
        drink7Label.setText(drink7.getName());
    }

    public void goToCreateOrder2(ActionEvent event) throws IOException {
        AnchorPane scene2 = FXMLLoader.load(getClass().getResource("Sc2(CreateOrder).fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(scene2);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Da Vinci Pizza Order Interface");
    }

    public void goToMenuManager7 (ActionEvent event) throws IOException {
        AnchorPane scene7 = FXMLLoader.load(getClass().getResource("Sc7(MenuManager).fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(scene7);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Da Vinci Pizza Order Interface");
    }

    //CHOOSE SIDES STAGE
    public Integer[] dropDownValues = {0,1,2,3,4,5,6,7,8,9,10,11,12};

    @FXML private ComboBox drink1ComboBox = new ComboBox();
    @FXML private ComboBox drink2ComboBox = new ComboBox();
    @FXML private ComboBox drink3ComboBox = new ComboBox();
    @FXML private ComboBox drink4ComboBox = new ComboBox();
    @FXML private ComboBox drink5ComboBox = new ComboBox();
    @FXML private ComboBox drink6ComboBox = new ComboBox();
    @FXML private ComboBox drink7ComboBox = new ComboBox();

    private Integer drink1Num = 0;
    private Integer drink2Num = 0;
    private Integer drink3Num = 0;
    private Integer drink4Num = 0;
    private Integer drink5Num = 0;
    private Integer drink6Num = 0;
    private Integer drink7Num = 0;

    @FXML private void drink1ComboBoxIsSelected() {
        drink1Num = (Integer) drink1ComboBox.getValue();
    }
    @FXML private void drink2ComboBoxIsSelected() {
        drink2Num = (Integer) drink2ComboBox.getValue();
    }
    @FXML private void drink3ComboBoxIsSelected() {
        drink3Num = (Integer) drink3ComboBox.getValue();
    }
    @FXML private void drink4ComboBoxIsSelected() {
        drink4Num = (Integer) drink4ComboBox.getValue();
    }
    @FXML private void drink5ComboBoxIsSelected() {
        drink5Num = (Integer) drink5ComboBox.getValue();
    }
    @FXML private void drink6ComboBoxIsSelected() {
        drink6Num = (Integer) drink6ComboBox.getValue();
    }
    @FXML private void drink7ComboBoxIsSelected() {
        drink7Num = (Integer) drink7ComboBox.getValue();
    }

    @FXML private Button saveDrinksToOrder;

    @FXML private Text drink1Label, drink2Label, drink3Label, drink4Label, drink5Label, drink6Label, drink7Label;

    @FXML private TextArea chosenDrinksDisplayArea;

    String showOrderedDrinks;

    @FXML public void generateDrinksOrder() {

        drinkList.clear();
        currentSubOrder.items.clear();
        showOrderedDrinks = "";

        for (int a = 0; a < drink1Num; a++) {
            Drink.addDrink(drinkList, drink1);
        }
        for (int b = 0; b < drink2Num; b++) {
            Drink.addDrink(drinkList, drink2);
        }
        for (int c = 0; c < drink3Num; c++) {
            Drink.addDrink(drinkList, drink3);
        }
        for (int d = 0; d < drink4Num; d++) {
            Drink.addDrink(drinkList, drink4);
        }
        for (int e = 0; e < drink5Num; e++) {
            Drink.addDrink(drinkList, drink5);
        }
        for (int f = 0; f < drink6Num; f++) {
            Drink.addDrink(drinkList, drink6);
        }
        for (int g = 0; g < drink7Num; g++) {
            Drink.addDrink(drinkList, drink7);
        }

        for (int h = 0; h < drinkList.size(); h++) {
            currentSubOrder.items.add(drinkList.get(h));
        }

        showOrderedDrinks = "You have added the following drinks to the current order: \n\r";

        for (int i = 0; i < drinkList.size(); i++) {

            String alcoholWarning = "";

            if (drinkList.get(i).getAlcoholYN() == "Yes") {
                alcoholWarning = "OVER 18 ID ONLY";
            }
            else if(drinkList.get(i).getAlcoholYN() == "No") {
                alcoholWarning = "";
            }

            showOrderedDrinks += drinkList.get(i).getName() + "   " + moneyFormat(drinkList.get(i).getPrice()) +
                    "   " + alcoholWarning + "\n\r";

        }
        chosenDrinksDisplayArea.setText(showOrderedDrinks);
    }

    public void sendDrinksToOrderScreen() {

        chosenDrinksDisplayArea.clear();

        updateCurrentSubOrder();

        chosenDrinksDisplayArea.setText("Your drinks have been committed to your order.\n\r" +
                "Please return to previous screen or order more.");

        currentSubOrder.items.clear();


        for (int i = 0; i < 13; i++) {

            drink1ComboBox.getItems().remove(0);
            drink2ComboBox.getItems().remove(0);
            drink3ComboBox.getItems().remove(0);
            drink4ComboBox.getItems().remove(0);
            drink5ComboBox.getItems().remove(0);
            drink6ComboBox.getItems().remove(0);
            drink7ComboBox.getItems().remove(0);
        }

        drink1ComboBox.getItems().addAll(dropDownValues);
        drink2ComboBox.getItems().addAll(dropDownValues);
        drink3ComboBox.getItems().addAll(dropDownValues);
        drink4ComboBox.getItems().addAll(dropDownValues);
        drink5ComboBox.getItems().addAll(dropDownValues);
        drink6ComboBox.getItems().addAll(dropDownValues);
        drink7ComboBox.getItems().addAll(dropDownValues);

        drink1Num = 0;
        drink2Num = 0;
        drink3Num = 0;
        drink4Num = 0;
        drink5Num = 0;
        drink6Num = 0;
        drink7Num = 0;
    }

    public void updateCurrentSubOrder() {

        for (int j = 0; j < currentSubOrder.items.size(); j++) {
            order.addItem(currentSubOrder.items.get(j));
        }
    }

    public void clearList() {

        chosenDrinksDisplayArea.setText("You have not committed these drinks to your order. Please start again");
        drinkList.clear();
        currentSubOrder.items.clear();
    }


    //I leave the price to be inputted in pennies but for displaying use this method
    //I had to make my own simple method for this because I am outputting to a TextArea and not the console
    public String moneyFormat (Integer inputInteger) {

        String inputPoundsAndPence = String.valueOf(inputInteger);

        String outputPoundsAndPence = "";

        //£0.01
        if (inputPoundsAndPence.length() == 1) {
            outputPoundsAndPence += "£0.0" + inputPoundsAndPence.charAt(0);
        }
        //£0.10
        else if (inputPoundsAndPence.length() == 2) {
            outputPoundsAndPence += "£0." + inputPoundsAndPence.charAt(0) + inputPoundsAndPence.charAt(1);
        }
        //£1.00
        else if (inputPoundsAndPence.length() == 3) {
            outputPoundsAndPence += "£" + inputPoundsAndPence.charAt(0) + "." + inputPoundsAndPence.charAt(1) +
                    inputPoundsAndPence.charAt(2);
        }
        //£10.00
        else if (inputPoundsAndPence.length() == 4) {
            outputPoundsAndPence += "£" + inputPoundsAndPence.charAt(0) + inputPoundsAndPence.charAt(1) + "." +
                    inputPoundsAndPence.charAt(2) + inputPoundsAndPence.charAt(3);
        }
        //No single item should cost £100!!

        return outputPoundsAndPence;
    }
}
