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
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_2_CreateOrderPane extends Model implements Initializable {

    @FXML private TextArea orderProgressBox, errorBox2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //This is not required but left in for keeping tabs on the progress of the order from the console
        System.out.println("ORDER IS: ");
        for (int i = 0; i < order.items.size(); i++) {
            System.out.println(order.items.get(i));
        }

        //Clear items Array within orderInProgress
        currentSubOrder.items.clear();

        //Create list of items as String in main order and update on every time user returns to Create Order AnchorPane
        //This is outputted to the orderProgressBox TextArea
        createOrderItemsList();

        updateOrderInfo();
    }

    public void goToWelcomeScreen(ActionEvent event) throws IOException {
        AnchorPane welcomeScreen = FXMLLoader.load(getClass().getResource("Sc1(WelcomeScreen).fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(welcomeScreen);
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

    public void goToOrderManager6(ActionEvent event) throws IOException {
        AnchorPane scene6 = FXMLLoader.load(getClass().getResource("Sc6(OrderManager).fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(scene6);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Da Vinci Pizza Order Interface");
    }

    public void updateOrderInfo() {

        updateOrderProgressString();
        orderProgressBox.setText(orderProgressString);
    }

    public void updateOrderProgressString() {

        orderProgressString =

        "CURRENT ORDER" + "\n" +

        "\nORDERED ITEMS: " + "\n" +

        "\n" + orderItemsList + "\n" +

        "\n" + "TOTAL: " + "\n" +

        "\n" + moneyFormat(orderTotal) + "\n";
    }

    public void totalCalc() {
        orderTotal = order.total();
    }

    public void createOrderItemsList() {

        totalCalc();

        orderItemsList = "";

        for (int i = 0; i < order.items.size(); i++) {

            Boolean check = true;

            String alcoholWarning = "";

            if (order.items.get(i).getClass() == Drink.class) {

                check = alcoCheck((Drink) order.items.get(i));

                if (check == true) {
                    alcoholWarning = "ID REQ";
                } else {
                    alcoholWarning = "";
                }
            }

            String showPrice = "";

            showPrice = moneyFormat(order.items.get(i).getPrice());

            //Create String to be alerted to TextArea
            orderItemsList += order.items.get(i).getName() + "      " +

            showPrice + "      " +

            alcoholWarning + "\n\r";
        }
    }

    public void addOrderToOrderArrayList() {

        //Add completed Order to orderList ArrayList
        //Without if-else statement it is possible to add an order to orderList containing 0 items
        if (order.items.size() == 0) {
            errorBox2.setText("ERROR! You need to add some a Pizza, a Side or a Drink before order can be added!");
        }
        else {
            orderList.add(order);
        }

        completedOrderCount();

        orderItemsList = "";
        orderTotal = 0;
        updateOrderInfo();

        //Refresh Order
        order = new Order();
    }

    @FXML TextArea completedOrderCountOutput;

    public void completedOrderCount() {

        String completedOrderCountString =
                "\nYou have now placed " + orderList.size() + " order(s) in this session\n";

        completedOrderCountOutput.setText(completedOrderCountString);
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


