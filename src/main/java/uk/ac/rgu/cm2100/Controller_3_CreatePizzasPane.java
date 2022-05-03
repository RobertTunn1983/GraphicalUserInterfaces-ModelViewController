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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static uk.ac.rgu.cm2100.Size.*;

public class Controller_3_CreatePizzasPane extends Model implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Initialise toppings labels
        setToppingLabel1.setText(setTopping1.getName());
        setToppingLabel2.setText(setTopping2.getName());
        setToppingLabel3.setText(setTopping3.getName());
        setToppingLabel4.setText(setTopping4.getName());
        setToppingLabel5.setText(setTopping5.getName());
        setToppingLabel6.setText(setTopping6.getName());
        setToppingLabel7.setText(setTopping7.getName());
        setToppingLabel8.setText(setTopping8.getName());
        setToppingLabel9.setText(setTopping9.getName());
        setToppingLabel10.setText(setTopping10.getName());
        setToppingLabel11.setText(setTopping11.getName());
        setToppingLabel12.setText(setTopping12.getName());
    }

    //Create Labels to be automatically named from variables taken from Model
    @FXML private Label setToppingLabel1, setToppingLabel2, setToppingLabel3, setToppingLabel4, setToppingLabel5,
            setToppingLabel6, setToppingLabel7, setToppingLabel8, setToppingLabel9, setToppingLabel10,
            setToppingLabel11, setToppingLabel12;

    //Load linked AnchorPanes
    public void goToCreateOrder2(ActionEvent event) throws IOException {
        AnchorPane scene2 = FXMLLoader.load(getClass().getResource("Sc2(CreateOrder).fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(scene2);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Da Vinci Pizza Order Interface");

        toppingsArrayList.clear();
    }

    public void goToMenuManager7 (ActionEvent event) throws IOException {
        AnchorPane scene7 = FXMLLoader.load(getClass().getResource("Sc7(MenuManager).fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(scene7);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Da Vinci Pizza Order Interface");

        //Need to clear the information for toppings because the topping toggle buttons were resetting but the list
        //was not which caused errors
        wipeInformation();
    }

    //TEXT AREAS
    @FXML private TextArea toppingsTextArea, pizzasListTextArea, errorBox3;

    //SIZE RADIO BUTTONS AND LABELS
    //Adding a size was never part of the Coursework but I think this gave the GUI extra realism
    @FXML private ToggleGroup pizzaSizeRadio;

    @FXML private RadioButton smallRadButton, mediumSizeRadButton, largeRadButton, hugeRadButton;

    @FXML private Label pizzaSizeLabel;

    //These will bar further progress with Pizza creation until a Crust and Size are selected
    //Size, Crust and Topping buttons automatically unselected on each reload of AnchorPane
    boolean crustWatch = false;
    boolean sizeWatch = false;

    //KEEP A RECORD OF THE ENUM TYPES BEING CHOSEN
    public static Size sizePick = Size.SMALL;
    public static Crust crustPick = Crust.THIN;

    @FXML void chooseSize() {
        if (smallRadButton.isSelected()) {
            pizzaSizeLabel.setText(smallRadButton.getText());
            sizePick = SMALL;
            boolean sizeWatch = true;
            System.out.println(sizeWatch);
        } else if (mediumSizeRadButton.isSelected()) {
            pizzaSizeLabel.setText(mediumSizeRadButton.getText());
            sizePick = MED;
            boolean sizeWatch = true;
        } else if (largeRadButton.isSelected()) {
            pizzaSizeLabel.setText(largeRadButton.getText());
            sizePick = LARGE;
            boolean sizeWatch = true;
        } else if (hugeRadButton.isSelected()) {
            pizzaSizeLabel.setText(hugeRadButton.getText());
            sizePick = HUGE;
            boolean sizeWatch = true;
        }
    }

    //CRUST RADIO BUTTONS AND LABELS
    @FXML private ToggleGroup crustType;

    @FXML private RadioButton thinRadButton, mediumBaseRadButton, deepRadButton, stuffedCrustRadButton;

    @FXML private Label pizzaBaseLabel;

    @FXML void chooseBaseType() {
        if (thinRadButton.isSelected()) {
            pizzaBaseLabel.setText(thinRadButton.getText());
            crustPick = Crust.THIN;
            crustWatch = true;
            System.out.println(crustWatch);
        } else if (mediumBaseRadButton.isSelected()) {
            pizzaBaseLabel.setText(mediumBaseRadButton.getText());
            crustPick = Crust.MEDIUM;
            crustWatch = true;
        } else if (deepRadButton.isSelected()) {
            pizzaBaseLabel.setText(deepRadButton.getText());
            crustPick = Crust.DEEP;
            crustWatch = true;
        } else if (stuffedCrustRadButton.isSelected()) {
            pizzaBaseLabel.setText(stuffedCrustRadButton.getText());
            crustPick = Crust.CHEESE_AND_SAUCE_STUFFED_CRUST;
            crustWatch = true;
        }
    }

    //TOPPINGS

    //Yes and No toggle topping buttons
    @FXML private ToggleButton setTopping1No, setTopping1Yes, setTopping2No, setTopping2Yes, setTopping3No,
            setTopping3Yes, setTopping4No, setTopping4Yes, setTopping5No, setTopping5Yes, setTopping6No, setTopping6Yes,
            setTopping7No, setTopping7Yes, setTopping8No, setTopping8Yes, setTopping9No, setTopping9Yes,
            setTopping10No, setTopping10Yes, setTopping11No, setTopping11Yes, setTopping12No, setTopping12Yes;

    //Multiple choice topping toggle groupings
    @FXML private ToggleGroup
            setTopping1Buttons, setTopping2Buttons, setTopping3Buttons, setTopping4Buttons, setTopping5Buttons,
            setTopping6Buttons, setTopping7Buttons, setTopping8Buttons, setTopping9Buttons, setTopping10Buttons,
            setTopping11Buttons, setTopping12Buttons;

    //Add remove setTopping1 etc
    @FXML void addRemoveSetTopping1(ActionEvent event) {

        //Use event to decide whether Y or N is selected
        if (event.getSource() == setTopping1Yes) {

            //Add setTopping1 (defined in Model) to ArrayList of toppings if Y is selected
            toppingsArrayList.add(setTopping1);
            //Call showToppings method and update the provisional list of toppings in RHS window
            showToppings();

        } else if (event.getSource() == setTopping1No) {

            //If N is selected, remove from ArrayList of Toppings
            toppingsArrayList.remove(setTopping1);
            showToppings();
        }
    }

    //And repeat for remaining 11 possible toppings
    @FXML void addRemoveSetTopping2(ActionEvent event) {
        if (event.getSource() == setTopping2Yes) {
            toppingsArrayList.add(setTopping2);
            showToppings();
        } else if (event.getSource() == setTopping2No) {
            toppingsArrayList.remove(setTopping2);
            showToppings();
        }
    }

    @FXML void addRemoveSetTopping3(ActionEvent event) {
        if (event.getSource() == setTopping3Yes) {
            toppingsArrayList.add(setTopping3);
            showToppings();
        } else if (event.getSource() == setTopping3No) {
            toppingsArrayList.remove(setTopping3);
            showToppings();
        }

    }

    @FXML void addRemoveSetTopping4(ActionEvent event) {
        if (event.getSource() == setTopping4Yes) {
            toppingsArrayList.add(setTopping4);
            showToppings();
        } else if (event.getSource() == setTopping4No) {
            toppingsArrayList.remove(setTopping4);
            showToppings();
        }
    }

    @FXML void addRemoveSetTopping5(ActionEvent event) {
        if (event.getSource() == setTopping5Yes) {
            toppingsArrayList.add(setTopping5);
            showToppings();
        } else if (event.getSource() == setTopping5No) {
            toppingsArrayList.remove(setTopping5);
            showToppings();
        }
    }

    @FXML void addRemoveSetTopping6(ActionEvent event) {
        if (event.getSource() == setTopping6Yes) {
            toppingsArrayList.add(setTopping6);
            showToppings();
        } else if (event.getSource() == setTopping6No) {
            toppingsArrayList.remove(setTopping6);
            showToppings();
        }
    }

    @FXML void addRemoveSetTopping7(ActionEvent event) {
        if (event.getSource() == setTopping7Yes) {
            toppingsArrayList.add(setTopping7);
            showToppings();
        } else if (event.getSource() == setTopping7No) {
            toppingsArrayList.remove(setTopping7);
            showToppings();
        }
    }

    @FXML void addRemoveSetTopping8(ActionEvent event) {
        if (event.getSource() == setTopping8Yes) {
            toppingsArrayList.add(setTopping8);
            showToppings();
        } else if (event.getSource() == setTopping8No) {
            toppingsArrayList.remove(setTopping8);
            showToppings();
        }
    }

    @FXML void addRemoveSetTopping9(ActionEvent event) {
        if (event.getSource() == setTopping9Yes) {
            toppingsArrayList.add(setTopping9);
            showToppings();
        } else if (event.getSource() == setTopping9No) {
            toppingsArrayList.remove(setTopping9);
            showToppings();
        }
    }

    @FXML void SetTopping10(ActionEvent event) {
        if (event.getSource() == setTopping10Yes) {
            toppingsArrayList.add(setTopping10);
            showToppings();
        } else if (event.getSource() == setTopping10No) {
            toppingsArrayList.remove(setTopping10);
            showToppings();
        }
    }

    @FXML void SetTopping11(ActionEvent event) {
        if (event.getSource() == setTopping11Yes) {
            toppingsArrayList.add(setTopping11);
            showToppings();
        } else if (event.getSource() == setTopping11No) {
            toppingsArrayList.remove(setTopping11);
            showToppings();
        }
    }

    @FXML void SetTopping12(ActionEvent event) {
        if (event.getSource() == setTopping12Yes) {
            toppingsArrayList.add(setTopping12);
            showToppings();
        } else if (event.getSource() == setTopping12No) {
            toppingsArrayList.remove(setTopping12);
            showToppings();
        }
    }

    public void addPizzaToList() {

        //Empty errorBox TextArea
        errorBox3.setText("");

        if (crustWatch == false || crustWatch == false) {
            errorBox3.setText("ERROR! You need to choose a Crust, a Size and at least one topping!");
            reset();
        }

        Integer pizzaCount = 0;

        //Automatically assign names "Pizza No: 1" etc
        pizzaCount ++;
        String pizzaName = "Pizza No " + pizzaCount;

        //Create instance of Pizza object
        Pizza currentPizza = new Pizza(pizzaName, crustPick, sizePick);
        currentPizza.addToppings(toppingsArrayList);

        //Add newly created Pizza to currentPizzaList ArrayList<Pizza>
        //Use if-else to catch silly situation where a pizza is ordered without toppings
        if (toppingsArrayList.size() == 0) {
            errorBox3.setText("ERROR! You need to choose a Crust, a Size and at least one topping!");
            reset();
        }
        else if (toppingsArrayList.size() > 0){
            currentPizzaList.add(currentPizza);
        }

        //Update toppingString which will be used for tracking order progress in windows
        //toppingString is the final list of toppings and is sent to the list of Pizzas window
        createToppingString(toppingsArrayList);

        //Send relevant info to pizzasListTextArea
        updatepizzasListTextArea();
    }

    public void addPizzaListToOrder() {

        for (int i = 0; i < currentPizzaList.size(); i++) {
            order.addItem(currentPizzaList.get(i));
        }

        pizzasListTextArea.setText("You have committed the pizzas to the current order. " + "\n\r" +
                "Please order more pizzas or return to the Create Order screen.");

        currentPizzaList.clear();

        toppingsArrayList.clear();
    }

    //If the operator makes a mistake, this simple method is called to clear the list of pizzas in progress
    public void reset() {

        currentPizzaList.clear();

        pizzasListTextArea.setText("You have cleared your current selection without committing to the current order."
                + "\n\r" + "Please order more pizzas or return to the Create Order screen");

        toppingsArrayList.clear();

        showToppings();
    }

    public void createToppingString(ArrayList<PizzaTopping> input) {

        toppingString = "";

        for (int i = 0; i < input.size(); i++) {
            toppingString += input.get(i).getName() + "\n\r";
        }

        System.out.println("toppingString is: " + toppingString);
    }

    public void showToppings() {

        String displayString = "";

        for (int i = 0; i < toppingsArrayList.size(); i++) {
            displayString += toppingsArrayList.get(i).getName() + "\n\r";
        }

        toppingsTextArea.setText(

                "Your current chosen toppings are:" + "\n\r" +
                displayString);
    }

    public void updatepizzasListTextArea() {

        String displayString = "";

        for (int i = 0; i < currentPizzaList.size(); i++) {

            displayString +=

                    "Name: " + currentPizzaList.get(i).getName() + "\n\r" +
                    "Size: " + currentPizzaList.get(i).getSize() + "\n\r" +
                    "Crust: " + currentPizzaList.get(i).getCrust() + "\n\r" +
                    "Toppings: " + "\n\r" +
                    toppingString +
                    "Price: " + moneyFormat(currentPizzaList.get(i).getPrice()) + "\n\r" + "\n\r";
        }

        pizzasListTextArea.setText(displayString);
    }

    public void wipeInformation() {

        //See notes in goToMenuManager method above
        toppingsArrayList.clear();
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


