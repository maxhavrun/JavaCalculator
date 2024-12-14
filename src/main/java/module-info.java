module com.havrun.javacalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.havrun.javacalculator to javafx.fxml;
    exports com.havrun.javacalculator;
}