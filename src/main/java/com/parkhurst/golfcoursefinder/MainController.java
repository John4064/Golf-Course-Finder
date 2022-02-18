package com.parkhurst.golfcoursefinder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.parkhurst.golfcoursefinder.ApiHandling.*;
import com.parkhurst.golfcoursefinder.PropertyHandler.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
/**
 * @author John parkhurst
 */

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        /*
        //String temp = ApiHandling.courseLookup();
        FileReader reader = new FileReader("config.properties");

        // create properties object
        Properties p = new Properties();

        // Add a wrapper around reader object
        p.load(reader);

        */
        PropertyHandler testHand = new PropertyHandler();
        System.out.println(testHand.getPropValues());

        welcomeText.setText("Kobe Bryant in Prime");
    }
}