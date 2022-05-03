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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class Controller_6_MenuManagerPane extends Model implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Initialise ComboBoxes
        setDeleteOrderComboBoxDropDownList();
        setOrderNoComboBoxDropDownList();
        setItemNoComboBoxDropDownList();
    }

    public void goToCreateOrder2(ActionEvent event) throws IOException {
        AnchorPane scene2 = FXMLLoader.load(getClass().getResource("Sc2(CreateOrder).fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(scene2);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Da Vinci Pizza Order Interface");
    }

    @FXML private TextArea allOrdersDisplay;

    @FXML void loadAllOrders() {

        String outputString = "";

        for (int i = 0; i < Model.orderList.size(); i++) {

            outputString += "ORDER NO: " + (i+1) + "\n\r";

            for (int j = 0; j < orderList.get(i).items.size(); j++) {

                orderTotal += orderList.get(i).items.get(j).getPrice();

                outputString +=

                        "Item " + (j+1) + "       " +

                                orderList.get(i).items.get(j).getName() + "     " +

                                moneyFormat(orderList.get(i).items.get(j).getPrice()) + "\n\r";
            }

            outputString +=

                    "\n\r" +
                    moneyFormat(orderTotal) +
                    "\n\r" +
                    "\n\r";

            orderTotal = 0;
        }

        //If there are no current orders say so rather than alerting a blank window
        if (orderList.size() == 0) {

            outputString = "There are no current orders.";
        }

        allOrdersDisplay.setText(outputString);
    }

    //COMBO BOXES
    @FXML private ComboBox deleteOrderComboBox  = new ComboBox();
    @FXML private ComboBox orderNoComboBox      = new ComboBox();
    @FXML private ComboBox itemNoComboBox       = new ComboBox();

    ArrayList<String> deleteOrderComboBoxNumbers = new ArrayList<>();
    ArrayList<String> orderNoComboBoxNumbers     = new ArrayList<>();
    ArrayList<String> itemNoComboBoxNumbers      = new ArrayList<>();

    //Populate ComboBoxes with Integers parsed as Strings of equal length as ArrayList of Orders
    public void setDeleteOrderComboBoxDropDownList() {

        for (int i = 0; i < orderList.size(); i++) {
            deleteOrderComboBoxNumbers.add(String.valueOf(i+1));
        }

        deleteOrderComboBox.getItems().addAll(deleteOrderComboBoxNumbers);
    }

    //Change set to initialise
    public void setOrderNoComboBoxDropDownList() {

        //Two drop down menus should always be the same
        orderNoComboBox.getItems().addAll(deleteOrderComboBoxNumbers);
    }

    public void setItemNoComboBoxDropDownList() {

        itemNoComboBox.getItems().addAll(itemNoComboBoxNumbers);
    }

    @FXML private void deleteOrderComboBoxIsSelected() {

        //toString() returned a null pointer and String.valueOf has to be used instead
        deleteOrderComboBoxCHOICE = String.valueOf(deleteOrderComboBox.getValue());
    }

    @FXML public void deleteOrder() {

        //Keep tabs on the size of the order list for deletion of unwanted replicated items in drop down menu
        Integer count = deleteOrderComboBoxNumbers.size();

        //Removes the unwanted order from ArrayList of Orders
        orderList.remove(parseInt(deleteOrderComboBoxCHOICE)-1);

        //Refresh the order list window
        loadAllOrders();

        //Remove last Integer from the drop down list for two boxes
        deleteOrderComboBoxNumbers.clear();
        orderNoComboBoxNumbers.clear();

        //Remove unwanted values from drop down list for both boxes
        for (int i = 0; i < count; i++) {

            deleteOrderComboBox.getItems().remove(0);
            orderNoComboBox.getItems().remove(0);
        }

        //Reload order list
        setDeleteOrderComboBoxDropDownList();

        //Update value of other box so that they are always the same
        setOrderNoComboBoxDropDownList();
    }

    @FXML public void deleteAllOrders() {

        //Wipe all orders from system
        orderList.clear();
        loadAllOrders();
    }

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