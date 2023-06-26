/*
 * Created 29 Dec 2021 by Robert Tunn
 * Last updated - 5 January 2022
 */
package uk.ac.rgu.cm2100;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_1_WelcomePane extends Model {

    

    //Switch to Create Order AnchorPane
    public void goToCreateOrder2(ActionEvent event) throws IOException {
        AnchorPane scene2 = FXMLLoader.load(getClass().getResource("Sc2(CreateOrder).fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(scene2);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Da Vinci Pizza Order Interface");
    }

    //Switch to Order Manager AnchorPane
    public void goToOrderManager6 (ActionEvent event) throws IOException {
        AnchorPane scene6 = FXMLLoader.load(getClass().getResource("Sc6(OrderManager).fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(scene6);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Da Vinci Pizza Order Interface");
    }

    //Switch to Create Order AnchorPane
    public void goToOrderManager7(ActionEvent event) throws IOException {
        AnchorPane scene7 = FXMLLoader.load(getClass().getResource("Sc7(MenuManager).fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(scene7);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Da Vinci Pizza Order Interface");
    }
}
