package com.parkhurst.golfcoursefinder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.parkhurst.golfcoursefinder.ApiHandling.*;
import com.parkhurst.golfcoursefinder.PropertyHandler.*;
import com.parkhurst.golfcoursefinder.Course.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;

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
    private TableView<Course> table;
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
        //System.out.println(testHand.getPropValues());
        table.setRowFactory(tableView -> {
            TableRow<Course> row = new TableRow<>();
            return row;
        });
        welcomeText.setText("Kobe Bryant in Prime");
    }
}