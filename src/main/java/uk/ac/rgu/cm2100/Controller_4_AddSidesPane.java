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

public class Controller_4_AddSidesPane extends Model implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Initialise ComboBoxes
        side1ComboBox.getItems().addAll(dropDownValues);
        side2ComboBox.getItems().addAll(dropDownValues);
        side3ComboBox.getItems().addAll(dropDownValues);
        side4ComboBox.getItems().addAll(dropDownValues);
        side5ComboBox.getItems().addAll(dropDownValues);

        //Initialise Labels for sides
        side1Label.setText(side1.getName());
        side2Label.setText(side2.getName());
        side3Label.setText(side3.getName());
        side4Label.setText(side4.getName());
        side5Label.setText(side5.getName());
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

    //Create array from 0-10 for sides, must be stored in ChoiceBox as Strings and then parsed as Integers
    final Integer[] dropDownValues = {0,1,2,3,4,5,6,7,8,9,10,11,12};

    //Remember this format or the ComboBox will be declared null!!!!!
    @FXML private ComboBox side1ComboBox = new ComboBox();
    @FXML private ComboBox side2ComboBox = new ComboBox();
    @FXML private ComboBox side3ComboBox = new ComboBox();
    @FXML private ComboBox side4ComboBox = new ComboBox();
    @FXML private ComboBox side5ComboBox = new ComboBox();

    //Keep track of the amount of each particular Side selected
    //Need to assign a value or it can throw an error (null)
    private Integer side1Num = 0;
    private Integer side2Num = 0;
    private Integer side3Num = 0;
    private Integer side4Num = 0;
    private Integer side5Num = 0;

    //Code for taking selection from ComboBox and outputting in Labels and taking output as quantity for that Side
    @FXML private void side1ComboBoxIsSelected() {side1Num = (Integer) side1ComboBox.getValue();}
    @FXML private void side2ComboBoxIsSelected() {side2Num = (Integer) side2ComboBox.getValue();}
    @FXML private void side3ComboBoxIsSelected() {side3Num = (Integer) side3ComboBox.getValue();}
    @FXML private void side4ComboBoxIsSelected() {side4Num = (Integer) side4ComboBox.getValue();}
    @FXML private void side5ComboBoxIsSelected() {side5Num = (Integer) side5ComboBox.getValue();}

    //Set custom toppings output String
    @FXML private Button saveSidesToOrder;

    @FXML private Text side1Label, side2Label, side3Label, side4Label, side5Label;

    @FXML private TextArea chosenSidesDisplayArea;

    @FXML private TextArea orderSummaryTextArea;

    String showOrderedSides;

    //Button creates an array of Sides using the Sides class and alerts the list of the Sides to the large TextArea
    //on Anchor Pane 2
    @FXML public void generateSideOrder() {

        //On each call of method clear sideList, orderInProgress and showOrderedSides String
        sideList.clear();
        currentSubOrder.items.clear();
        showOrderedSides = "";

        for (int a = 0; a < side1Num; a++) {
            Side.addSide(sideList, side1);
        }
        for (int b = 0; b < side2Num; b++) {
            Side.addSide(sideList, side2);
        }
        for (int c = 0; c < side3Num; c++) {
            Side.addSide(sideList, side3);
        }
        for (int d = 0; d < side4Num; d++) {
            Side.addSide(sideList, side4);
        }
        for (int e = 0; e < side5Num; e++) {
            Side.addSide(sideList, side5);
        }

        //Create currentSubOrder (ArrayList of Sides currently being ordered)
        for (int f = 0; f < sideList.size(); f++) {
            currentSubOrder.items.add(sideList.get(f));
        }

        showOrderedSides = "The following sides will be added to the current order: \n\r";

        for (int g = 0; g < sideList.size(); g++) {

            showOrderedSides += sideList.get(g).getName() + "   " + moneyFormat(sideList.get(g).getPrice()) + "\n\r";

        }

        chosenSidesDisplayArea.setText(showOrderedSides);
    }

    //Send ordered Sides data to Anchor Pane 2
    public void sendSidesToOrderScreen() {

        chosenSidesDisplayArea.clear();

        updateCurrentSubOrder();

        //Update sides display screen
        chosenSidesDisplayArea.setText("Your sides have been committed to your order.\n\r" +
                "Please return to previous screen or order more.");

        //Clear orderInProgress in case further sides are required
        currentSubOrder.items.clear();

        //Now reset the appearance of the ComboBox after committing provisional list
        //Remove unwanted values from drop down list for both boxes
        for (int i = 0; i < 13; i++) {

            side1ComboBox.getItems().remove(0);
            side2ComboBox.getItems().remove(0);
            side3ComboBox.getItems().remove(0);
            side4ComboBox.getItems().remove(0);
            side5ComboBox.getItems().remove(0);
        }

        //Reload all drop down menus list, re-initialise all
        side1ComboBox.getItems().addAll(dropDownValues);
        side2ComboBox.getItems().addAll(dropDownValues);
        side3ComboBox.getItems().addAll(dropDownValues);
        side4ComboBox.getItems().addAll(dropDownValues);
        side5ComboBox.getItems().addAll(dropDownValues);

        //Reset tallies of drinks
        side1Num = 0;
        side2Num = 0;
        side3Num = 0;
        side4Num = 0;
        side5Num = 0;
    }

    //Update current Order
    public void updateCurrentSubOrder() {

        for (int a = 0; a < currentSubOrder.items.size(); a++) {
            MenuManager.order.addItem(currentSubOrder.items.get(a));
        }
    }

    //Clear TextArea, provisional Side order and orderInProgress
    public void clearList() {

        chosenSidesDisplayArea.setText("You have not committed these sides to your order. Please start again");

        sideList.clear();

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
