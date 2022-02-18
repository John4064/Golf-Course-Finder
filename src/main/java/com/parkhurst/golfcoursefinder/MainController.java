package com.parkhurst.golfcoursefinder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.parkhurst.golfcoursefinder.ApiHandling.*;
public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        String temp = ApiHandling.courseLookup();
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}