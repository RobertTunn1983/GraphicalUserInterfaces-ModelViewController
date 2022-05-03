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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class Controller_7_OrderManagerPane extends Model implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        populateToppingEditComboBox();
        populateSideEditComboBox();
        populateDrinkEditComboBox();
        populateAlcoholYNBox();

        toppingEditComboBox.getItems().addAll(listOfCurrentToppings);
        sideEditComboBox.getItems().addAll(listOfCurrentSides);
        drinksEditComboBox.getItems().addAll(listOfCurrentDrinks);
        alcoBox.getItems().addAll(alcoBoxChoiceArray);
    }

    public void goToCreateOrder2(ActionEvent event) throws IOException {
        AnchorPane scene2 = FXMLLoader.load(getClass().getResource("Sc2(CreateOrder).fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(scene2);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Da Vinci Pizza Order Interface");
    }

    public void goToCreatePizzas3(ActionEvent event) throws IOException {
        AnchorPane scene3 = FXMLLoader.load(getClass().getResource("Sc3(CreatePizzas).fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(scene3);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Da Vinci Pizza Order Interface");
    }

    public void goToAddSides4(ActionEvent event) throws IOException {
        AnchorPane scene4 = FXMLLoader.load(getClass().getResource("Sc4(AddSides).fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(scene4);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Da Vinci Pizza Order Interface");
    }

    public void goToAddDrinks5(ActionEvent event) throws IOException {
        AnchorPane scene5 = FXMLLoader.load(getClass().getResource("Sc5(AddDrinks).fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(scene5);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Da Vinci Pizza Order Interface");
    }

    @FXML private ComboBox toppingEditComboBox = new ComboBox();
    @FXML private ComboBox sideEditComboBox = new ComboBox();
    @FXML private ComboBox drinksEditComboBox = new ComboBox();
    @FXML private ComboBox alcoBox = new ComboBox();

    //Create ArrayLists for injection into ComboBox drop down menus
    ArrayList<String> listOfCurrentToppings = new ArrayList<>();
    ArrayList<String> listOfCurrentSides = new ArrayList();
    ArrayList<String> listOfCurrentDrinks = new ArrayList();
    ArrayList<String> alcoBoxChoiceArray = new ArrayList();

    //Populate ArrayLists to be injected into ComboBox drop down menus
    public void populateToppingEditComboBox() {

        listOfCurrentToppings.add("01 " + setTopping1.getName());
        listOfCurrentToppings.add("02 " + setTopping2.getName());
        listOfCurrentToppings.add("03 " + setTopping3.getName());
        listOfCurrentToppings.add("04 " + setTopping4.getName());
        listOfCurrentToppings.add("05 " + setTopping5.getName());
        listOfCurrentToppings.add("06 " + setTopping6.getName());
        listOfCurrentToppings.add("07 " + setTopping7.getName());
        listOfCurrentToppings.add("08 " + setTopping8.getName());
        listOfCurrentToppings.add("09 " + setTopping9.getName());
        listOfCurrentToppings.add("10 " + setTopping10.getName());
        listOfCurrentToppings.add("11 " + setTopping11.getName());
        listOfCurrentToppings.add("12 " + setTopping12.getName());
    }

    public void populateSideEditComboBox() {
        listOfCurrentSides.add("1 " + side1.getName());
        listOfCurrentSides.add("2 " + side2.getName());
        listOfCurrentSides.add("3 " + side3.getName());
        listOfCurrentSides.add("4 " + side4.getName());
        listOfCurrentSides.add("5 " + side5.getName());
    }

    public void populateDrinkEditComboBox() {
        listOfCurrentDrinks.add("1 " + drink1.getName());
        listOfCurrentDrinks.add("2 " + drink2.getName());
        listOfCurrentDrinks.add("3 " + drink3.getName());
        listOfCurrentDrinks.add("4 " + drink4.getName());
        listOfCurrentDrinks.add("5 " + drink5.getName());
        listOfCurrentDrinks.add("6 " + drink6.getName());
        listOfCurrentDrinks.add("7 " + drink7.getName());
    }

    public void populateAlcoholYNBox() {
        alcoBoxChoiceArray.add("Yes");
        alcoBoxChoiceArray.add("No");
    }

    @FXML private Label toppingsDisplayBox, displayBox1, displayBox2;

    String toppingEditChoice, sideEditChoice, drinkEditChoice, alcoBoxChoice;

    boolean toppingCBSelected;
    boolean sideCBSelected;
    boolean drinkCBSelected;

    @FXML private void toppingEditComboBoxIsSelected() {
        toppingEditChoice = toppingEditComboBox.getValue().toString();
        displayChosenTopping();
        toppingCBSelected = true;
    }
    @FXML private void sideEditComboBoxIsSelected() {
        sideEditChoice = sideEditComboBox.getValue().toString();
        displayChosenSide();
        sideCBSelected = true;
    }
    @FXML private void drinkEditComboBoxIsSelected() {
        drinkEditChoice = drinksEditComboBox.getValue().toString();
        displayChosenDrink();
        drinkCBSelected = true;
    }
    @FXML private void alcoBoxComboBoxIsSelected() {
        alcoBoxChoice = alcoBox.getValue().toString();
    }

    public void displayChosenTopping() {
        toppingsDisplayBox.setText(String.valueOf(toppingEditChoice));
    }

    public void displayChosenSide() {
        displayBox1.setText(String.valueOf(sideEditChoice));
    }

    public void displayChosenDrink() {
        displayBox2.setText(String.valueOf(drinkEditChoice));
    }

    @FXML private TextField newToppingNameInput, newToppingPriceInput, newSideNameInput, newSidePriceInput,
            newDrinkNameInput, newDrinkPriceInput;

    @FXML Label updateBar;

    //TOPPING MANAGER
    @FXML void setNewToppingName() {

        if (toppingCBSelected == true) {

            //Take String, take first two chars and run if-else statements
            String choice = toppingsDisplayBox.getText();

            char char1 = choice.charAt(0);
            char char2 = choice.charAt(1);

            //NO POINT IN STOPPING THE OPERATOR ENTERING INAPPROPRIATE STRINGS EVEN THOUGH IT IS POSSIBLE
            //TRY CATCH USED IN NEXT METHOD TO PREVENT NON-INTEGER ENTRY

            if (char1 == '0' && char2 == '1') {
                changeToppingNamePropertyChange("pizzaTopping1", setTopping1, newToppingNameInput.getText());
                updateBar.setText("Topping 1 has been changed to " + newToppingNameInput.getText());
                newToppingNameInput.setText("");
            } else if (char1 == '0' && char2 == '2') {
                changeToppingNamePropertyChange("pizzaTopping2", setTopping2, newToppingNameInput.getText());
                updateBar.setText("Topping 2 has been changed to " + newToppingNameInput.getText());
                newToppingNameInput.setText("");
            } else if (char1 == '0' && char2 == '3') {
                changeToppingNamePropertyChange("pizzaTopping3", setTopping3, newToppingNameInput.getText());
                updateBar.setText("Topping 3 has been changed to " + newToppingNameInput.getText());
                newToppingNameInput.setText("");
            } else if (char1 == '0' && char2 == '4') {
                changeToppingNamePropertyChange("pizzaTopping4", setTopping4, newToppingNameInput.getText());
                updateBar.setText("Topping 4 has been changed to " + newToppingNameInput.getText());
                newToppingNameInput.setText("");
            } else if (char1 == '0' && char2 == '5') {
                changeToppingNamePropertyChange("pizzaTopping5", setTopping5, newToppingNameInput.getText());
                updateBar.setText("Topping 5 has been changed to " + newToppingNameInput.getText());
                newToppingNameInput.setText("");
            } else if (char1 == '0' && char2 == '6') {
                changeToppingNamePropertyChange("pizzaTopping6", setTopping6, newToppingNameInput.getText());
                updateBar.setText("Topping 6 has been changed to " + newToppingNameInput.getText());
                newToppingNameInput.setText("");
            } else if (char1 == '0' && char2 == '7') {
                changeToppingNamePropertyChange("pizzaTopping7", setTopping7, newToppingNameInput.getText());
                updateBar.setText("Topping 7 has been changed to " + newToppingNameInput.getText());
                newToppingNameInput.setText("");
            } else if (char1 == '0' && char2 == '8') {
                changeToppingNamePropertyChange("pizzaTopping8", setTopping8, newToppingNameInput.getText());
                updateBar.setText("Topping 8 has been changed to " + newToppingNameInput.getText());
                newToppingNameInput.setText("");
            } else if (char1 == '0' && char2 == '9') {
                changeToppingNamePropertyChange("pizzaTopping9", setTopping9, newToppingNameInput.getText());
                updateBar.setText("Topping 9 has been changed to " + newToppingNameInput.getText());
                newToppingNameInput.setText("");
            } else if (char1 == '1' && char2 == '0') {
                changeToppingNamePropertyChange("pizzaTopping10", setTopping10, newToppingNameInput.getText());
                updateBar.setText("Topping 10 has been changed to " + newToppingNameInput.getText());
                newToppingNameInput.setText("");
            } else if (char1 == '1' && char2 == '1') {
                changeToppingNamePropertyChange("pizzaTopping11", setTopping11, newToppingNameInput.getText());
                updateBar.setText("Topping 11 has been changed to " + newToppingNameInput.getText());
                newToppingNameInput.setText("");
            } else if (char1 == '1' && char2 == '2') {
                changeToppingNamePropertyChange("pizzaTopping12", setTopping12, newToppingNameInput.getText());
                updateBar.setText("Topping 12 has been changed to " + newToppingNameInput.getText());
                newToppingNameInput.setText("");
            }

        } else if (toppingCBSelected == false){
            updateBar.setText("Please pick a Topping from the drop down menu to edit");
        }
    }

    @FXML
    void setNewToppingPrice() {

        if (toppingCBSelected == true) {

            try {//CATCH NON-INTEGER VALUES with Integer errorCatcher

                Integer errorCatcher = parseInt(newToppingPriceInput.getText());

                String choice = toppingsDisplayBox.getText();
                char char1 = choice.charAt(0);
                char char2 = choice.charAt(1);

                if (char1 == '0' && char2 == '1') {
                    changeToppingPricePropertyChange("pizzaTopping1", setTopping1, parseInt(newToppingPriceInput.getText()));
                    updateBar.setText("Topping 1 price has been changed to " + parseInt(newToppingPriceInput.getText()));
                    displayBox1.setText("");
                    newToppingPriceInput.setText("");
                } else if (char1 == '0' && char2 == '2') {
                    changeToppingPricePropertyChange("pizzaTopping2", setTopping2, parseInt(newToppingPriceInput.getText()));
                    updateBar.setText("Topping 2 price has been changed to " + parseInt(newToppingPriceInput.getText()));
                    displayBox1.setText("");
                    newToppingPriceInput.setText("");
                } else if (char1 == '0' && char2 == '3') {
                    changeToppingPricePropertyChange("pizzaTopping3", setTopping3, parseInt(newToppingPriceInput.getText()));
                    updateBar.setText("Topping 3 price has been changed to " + parseInt(newToppingPriceInput.getText()));
                    displayBox1.setText("");
                    newToppingPriceInput.setText("");
                } else if (char1 == '0' && char2 == '4') {
                    changeToppingPricePropertyChange("pizzaTopping4", setTopping4, parseInt(newToppingPriceInput.getText()));
                    updateBar.setText("Topping 4 price has been changed to " + parseInt(newToppingPriceInput.getText()));
                    displayBox1.setText("");
                    newToppingPriceInput.setText("");
                } else if (char1 == '0' && char2 == '5') {
                    changeToppingPricePropertyChange("pizzaTopping5", setTopping5, parseInt(newToppingPriceInput.getText()));
                    updateBar.setText("Topping 5 price has been changed to " + parseInt(newToppingPriceInput.getText()));
                    displayBox1.setText("");
                    newToppingPriceInput.setText("");
                } else if (char1 == '0' && char2 == '6') {
                    changeToppingPricePropertyChange("pizzaTopping6", setTopping6, parseInt(newToppingPriceInput.getText()));
                    updateBar.setText("Topping 6 price has been changed to " + parseInt(newToppingPriceInput.getText()));
                    displayBox1.setText("");
                    newToppingPriceInput.setText("");
                } else if (char1 == '0' && char2 == '7') {
                    changeToppingPricePropertyChange("pizzaTopping7", setTopping7, parseInt(newToppingPriceInput.getText()));
                    updateBar.setText("Topping 7 price has been changed to " + parseInt(newToppingPriceInput.getText()));
                    displayBox1.setText("");
                    newToppingPriceInput.setText("");
                } else if (char1 == '0' && char2 == '8') {
                    changeToppingPricePropertyChange("pizzaTopping8", setTopping8, parseInt(newToppingPriceInput.getText()));
                    updateBar.setText("Topping 8 price has been changed to " + parseInt(newToppingPriceInput.getText()));
                    displayBox1.setText("");
                    newToppingPriceInput.setText("");
                } else if (char1 == '0' && char2 == '9') {
                    changeToppingPricePropertyChange("pizzaTopping9", setTopping9, parseInt(newToppingPriceInput.getText()));
                    updateBar.setText("Topping 9 price has been changed to " + parseInt(newToppingPriceInput.getText()));
                    displayBox1.setText("");
                    newToppingPriceInput.setText("");
                } else if (char1 == '1' && char2 == '0') {
                    changeToppingPricePropertyChange("pizzaTopping10", setTopping10, parseInt(newToppingPriceInput.getText()));
                    updateBar.setText("Topping 10 price has been changed to " + parseInt(newToppingPriceInput.getText()));
                    displayBox1.setText("");
                    newToppingPriceInput.setText("");
                } else if (char1 == '1' && char2 == '1') {
                    changeToppingPricePropertyChange("pizzaTopping11", setTopping11, parseInt(newToppingPriceInput.getText()));
                    updateBar.setText("Topping 11 price has been changed to " + parseInt(newToppingPriceInput.getText()));
                    displayBox1.setText("");
                    newToppingPriceInput.setText("");
                } else if (char1 == '1' && char2 == '2') {
                    changeToppingPricePropertyChange("pizzaTopping12", setTopping12, parseInt(newToppingPriceInput.getText()));
                    updateBar.setText("Topping 12 price has been changed to " + parseInt(newToppingPriceInput.getText()));
                    displayBox1.setText("");
                    newToppingPriceInput.setText("");
                }
            } catch (NumberFormatException ex) {
                updateBar.setText("ERROR! Enter an Integer value e.g. 100 for £1.00");
            }
        } else if (toppingCBSelected == false) {
            updateBar.setText("Please pick a Topping from the drop down menu to edit");
        }
    }

    //SIDE MANAGER
    @FXML void setNewSideName() {

        if (sideCBSelected == true) {

            String choice = displayBox1.getText();
            char char1 = choice.charAt(0);

            if (char1 == '1') {
                changeSideNamePropertyChange("Side 1", side1, newSideNameInput.getText());
                updateBar.setText("Side 1 has been changed to " + newSideNameInput.getText());
                newSideNameInput.setText("");
            } else if (char1 == '2') {
                changeSideNamePropertyChange("Side 2", side2, newSideNameInput.getText());
                updateBar.setText("Side 2 has been changed to " + newSideNameInput.getText());
                newSideNameInput.setText("");
            } else if (char1 == '3') {
                changeSideNamePropertyChange("Side 3", side3, newSideNameInput.getText());
                updateBar.setText("Side 3 has been changed to " + newSideNameInput.getText());
                newSideNameInput.setText("");
            } else if (char1 == '4') {
                changeSideNamePropertyChange("Side 4", side4, newSideNameInput.getText());
                updateBar.setText("Side 4 has been changed to " + newSideNameInput.getText());
                newSideNameInput.setText("");
            } else if (char1 == '5') {
                changeSideNamePropertyChange("Side 5", side5, newSideNameInput.getText());
                updateBar.setText("Side 5 has been changed to " + newSideNameInput.getText());
                newSideNameInput.setText("");
            }
        } else if (sideCBSelected == false){
            updateBar.setText("Please pick a Side from the drop down menu to edit");
        }
    }

    @FXML
    void setNewSidePrice() {

        if (sideCBSelected == true) {

            try {

                Integer errorCatcher = parseInt(newSidePriceInput.getText());

                String choice = displayBox1.getText();
                char char1 = choice.charAt(0);

                if (char1 == '1') {
                    changeSidePricePropertyChange("Side 1", side1, parseInt(newSidePriceInput.getText()));
                    updateBar.setText("Side 1 price has been changed to " + parseInt(newSidePriceInput.getText()));
                    displayBox1.setText("");
                    newSidePriceInput.setText("");
                } else if (char1 == '2') {
                    changeSidePricePropertyChange("Side 2", side2, parseInt(newSidePriceInput.getText()));
                    updateBar.setText("Side 2 price has been changed to " + parseInt(newSidePriceInput.getText()));
                    displayBox1.setText("");
                    newSidePriceInput.setText("");
                } else if (char1 == '3') {
                    changeSidePricePropertyChange("Side 3", side3, parseInt(newSidePriceInput.getText()));
                    updateBar.setText("Side 2 price has been changed to " + parseInt(newSidePriceInput.getText()));
                    displayBox1.setText("");
                    newSidePriceInput.setText("");
                } else if (char1 == '4') {
                    changeSidePricePropertyChange("Side 4", side4, parseInt(newSidePriceInput.getText()));
                    updateBar.setText("Side 2 price has been changed to " + parseInt(newSidePriceInput.getText()));
                    displayBox1.setText("");
                    newSidePriceInput.setText("");
                } else if (char1 == '5') {
                    changeSidePricePropertyChange("Side 5", side5, parseInt(newSidePriceInput.getText()));
                    updateBar.setText("Side 2 price has been changed to " + parseInt(newSidePriceInput.getText()));
                    displayBox1.setText("");
                    newSidePriceInput.setText("");
                }

            } catch (NumberFormatException ex) {
                updateBar.setText("ERROR! Enter an Integer value e.g. 100 for £1.00");
            }
        } else if (sideCBSelected == false){
            updateBar.setText("Please pick a Side from the drop down menu to edit");
        }
    }

    //DRINK MANAGER
    @FXML void setNewDrinkName() {

        if (drinkCBSelected == true) {

            String choice = displayBox2.getText();
            char char1 = choice.charAt(0);

            if (char1 == '1') {
                changeDrinkNamePropertyChange("Drink1", drink1, newDrinkNameInput.getText());
                updateBar.setText("Drink 1 has been changed to " + newDrinkNameInput.getText());
                newDrinkNameInput.setText("");
            } else if (char1 == '2') {
                changeDrinkNamePropertyChange("Drink2", drink2, newDrinkNameInput.getText());
                updateBar.setText("Drink 2 has been changed to " + newDrinkNameInput.getText());
                newDrinkNameInput.setText("");
            } else if (char1 == '3') {
                changeDrinkNamePropertyChange("Drink3", drink3, newDrinkNameInput.getText());
                updateBar.setText("Drink 3 has been changed to " + newDrinkNameInput.getText());
                newDrinkNameInput.setText("");
            } else if (char1 == '4') {
                changeDrinkNamePropertyChange("Drink4", drink4, newDrinkNameInput.getText());
                updateBar.setText("Drink 4 has been changed to " + newDrinkNameInput.getText());
                newDrinkNameInput.setText("");
            } else if (char1 == '5') {
                changeDrinkNamePropertyChange("Drink5", drink5, newDrinkNameInput.getText());
                updateBar.setText("Drink 5 has been changed to " + newDrinkNameInput.getText());
                newDrinkNameInput.setText("");
            } else if (char1 == '6') {
                drink6.setName(newDrinkNameInput.getText());
                changeDrinkNamePropertyChange("Drink6", drink6, newDrinkNameInput.getText());
                newDrinkNameInput.setText("");
            } else if (char1 == '7') {
                changeDrinkNamePropertyChange("Drink7", drink7, newDrinkNameInput.getText());
                updateBar.setText("Drink 7 has been changed to " + newDrinkNameInput.getText());
                newDrinkNameInput.setText("");
            }
        } else if (drinkCBSelected == false){
            updateBar.setText("Please pick a Drink from the drop down menu to edit");
        }
    }

    @FXML void setNewDrinkPrice() {

        if (drinkCBSelected == true) {

            try {

                Integer errorCatcher = parseInt(newDrinkPriceInput.getText());

                String choice = displayBox2.getText();
                char char1 = choice.charAt(0);

                if (char1 == '1') {
                    changeDrinkPricePropertyChange("Drink1", drink1, parseInt(newDrinkPriceInput.getText()));
                    updateBar.setText("Drink 1 price has been changed to " + parseInt(newDrinkPriceInput.getText()));
                    newDrinkPriceInput.setText("");
                } else if (char1 == '2') {
                    changeDrinkPricePropertyChange("Drink2", drink2, parseInt(newDrinkPriceInput.getText()));
                    updateBar.setText("Drink 2 price has been changed to " + parseInt(newDrinkPriceInput.getText()));
                    newDrinkPriceInput.setText("");
                } else if (char1 == '3') {
                    changeDrinkPricePropertyChange("Drink3", drink3, parseInt(newDrinkPriceInput.getText()));
                    updateBar.setText("Drink 3 price has been changed to " + parseInt(newDrinkPriceInput.getText()));
                    newDrinkPriceInput.setText("");
                } else if (char1 == '4') {
                    changeDrinkPricePropertyChange("Drink4", drink4, parseInt(newDrinkPriceInput.getText()));
                    updateBar.setText("Drink 4 price has been changed to " + parseInt(newDrinkPriceInput.getText()));
                    newDrinkPriceInput.setText("");
                } else if (char1 == '5') {
                    changeDrinkPricePropertyChange("Drink5", drink5, parseInt(newDrinkPriceInput.getText()));
                    updateBar.setText("Drink 5 price has been changed to " + parseInt(newDrinkPriceInput.getText()));
                    newDrinkPriceInput.setText("");
                } else if (char1 == '6') {
                    changeDrinkPricePropertyChange("Drink6", drink6, parseInt(newDrinkPriceInput.getText()));
                    updateBar.setText("Drink 6 price has been changed to " + parseInt(newDrinkPriceInput.getText()));
                    newDrinkPriceInput.setText("");
                } else if (char1 == '7') {
                    changeDrinkPricePropertyChange("Drink7", drink7, parseInt(newDrinkPriceInput.getText()));
                    //drink7.setPrice(parseInt(newDrinkPriceInput.getText()));
                    updateBar.setText("Drink 7 price has been changed to " + parseInt(newDrinkPriceInput.getText()));
                    newDrinkPriceInput.setText("");
                }
            } catch (NumberFormatException ex) {
                updateBar.setText("ERROR! Enter an Integer value e.g. 100 for £1.00");
            }
        } else if (drinkCBSelected == false) {
            updateBar.setText("Please pick a Drink from the drop down menu to edit");
        }
    }

    public void confirmAlcoholStatus() {

        String choice = displayBox2.getText();
        char char1 = choice.charAt(0);

        System.out.println("alcoBoxChoice is: " + alcoBoxChoice);
        System.out.println("char1 is: " + char1);

        //An if-else statement for every possible Drink
        if (alcoBoxChoice == "Yes" && char1 == '1') {
            changeAlcoholStatusPropertyChange("Drink1", drink1, true);
            updateBar.setText("Alcohol status for Drink 1 set to YES");
        } else if (alcoBoxChoice == "No" && char1 == '1') {
            changeAlcoholStatusPropertyChange("Drink1", drink1, false);
            updateBar.setText("Alcohol status for Drink 1 set to NO");
        }

        if (alcoBoxChoice == "Yes" && char1 == '2') {
            changeAlcoholStatusPropertyChange("Drink2", drink2, true);
            updateBar.setText("Alcohol status for Drink 2 set to YES");
        } else if (alcoBoxChoice == "No" && char1 == '2') {
            changeAlcoholStatusPropertyChange("Drink2", drink2, false);
            updateBar.setText("Alcohol status for Drink 2 set to NO");
        }

        if (alcoBoxChoice == "Yes" && char1 == '3') {
            changeAlcoholStatusPropertyChange("Drink3", drink3, true);
            updateBar.setText("Alcohol status for Drink 3 set to YES");
        } else if (alcoBoxChoice == "No" && char1 == '3') {
            changeAlcoholStatusPropertyChange("Drink3", drink3, false);
            updateBar.setText("Alcohol status for Drink 3 set to NO");
        }

        if (alcoBoxChoice == "Yes" && char1 == '4') {
            changeAlcoholStatusPropertyChange("Drink4", drink4, true);
            updateBar.setText("Alcohol status for Drink 4 set to YES");
        } else if (alcoBoxChoice == "No" && char1 == '4') {
            changeAlcoholStatusPropertyChange("Drink4", drink4, false);
            updateBar.setText("Alcohol status for Drink 4 set to NO");
        }

        if (alcoBoxChoice == "Yes" && char1 == '5') {
            changeAlcoholStatusPropertyChange("Drink5", drink5, true);
            updateBar.setText("Alcohol status for Drink 5 set to YES");
        } else if (alcoBoxChoice == "No" && char1 == '5') {
            changeAlcoholStatusPropertyChange("Drink5", drink5, false);
            updateBar.setText("Alcohol status for Drink 5 set to NO");
        }

        if (alcoBoxChoice == "Yes" && char1 == '6') {
            changeAlcoholStatusPropertyChange("Drink6", drink6, true);
            updateBar.setText("Alcohol status for Drink 6 set to YES");
        } else if (alcoBoxChoice == "No" && char1 == '6') {
            changeAlcoholStatusPropertyChange("Drink6", drink6, false);
            updateBar.setText("Alcohol status for Drink 6 set to NO");
        }

        if (alcoBoxChoice == "Yes" && char1 == '7') {
            changeAlcoholStatusPropertyChange("Drink7", drink7, true);
            updateBar.setText("Alcohol status for Drink 7 set to YES");
        } else if (alcoBoxChoice == "No" && char1 == '7') {
            changeAlcoholStatusPropertyChange("Drink7", drink7, false);
            updateBar.setText("Alcohol status for Drink 7 set to NO");
        }
    }
}






