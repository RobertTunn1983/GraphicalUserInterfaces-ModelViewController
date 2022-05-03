/*
 * Created 29 Dec 2021 by Robert Tunn
 * Last updated - 5 January 2022
 */
package uk.ac.rgu.cm2100;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start (Stage stage) {

        try {
            AnchorPane scene1 = FXMLLoader.load(getClass().getResource("Sc1(WelcomeScreen).fxml"));
            Scene scene = new Scene(scene1); //Default size removed
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Da Vinci Pizza Order Interface");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

