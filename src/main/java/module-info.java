module com.parkhurst.golfcoursefinder {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.parkhurst.golfcoursefinder to javafx.fxml;
    exports com.parkhurst.golfcoursefinder;
}