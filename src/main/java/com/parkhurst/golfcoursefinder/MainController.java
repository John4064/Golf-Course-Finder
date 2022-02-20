package com.parkhurst.golfcoursefinder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.parkhurst.golfcoursefinder.ApiHandling.*;
import com.parkhurst.golfcoursefinder.PropertyHandler.*;
import com.parkhurst.golfcoursefinder.Course.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
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
    private TableColumn<Course, String> nameCol;
    @FXML
    private TableColumn<Course, String> zipCol;
    @FXML
    private TableColumn<Course, String> distCol;

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

        welcomeText.setText("Kobe Bryant in Prime");
    }
    protected void setTable(){
        table.getItems().addAll(new Course("Winged Foot", "06820", 3),
                new Course("Pebble Beach", "06902", 4),
                new Course("Oak Hills", "02131", 5),
                new Course("Willow Brook", "04321", 6),
                new Course("Sterling Farms", "09001", 7));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        zipCol.setCellValueFactory(new PropertyValueFactory<Course, String>("zipcode"));
        distCol.setCellValueFactory(new PropertyValueFactory<Course, String>("distance"));
    }

}