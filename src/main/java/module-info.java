module com.example.Coursework2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    opens uk.ac.rgu.cm2100 to javafx.fxml;
    exports uk.ac.rgu.cm2100;


}