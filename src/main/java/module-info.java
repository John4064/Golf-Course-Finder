module com.parkhurst.golfcoursefinder {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires com.google.gson;
    requires annotations;


    opens com.parkhurst.golfcoursefinder to javafx.fxml;
    exports com.parkhurst.golfcoursefinder;
}