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
import java.util.Hashtable;
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
        //PropertyHandler testHand = new PropertyHandler();
        //System.out.println(testHand.getPropValues());
        //System.out.println(ApiHandling.courseLookup());
        String response = "{\"courses\": [{\"name\": \"Golf Links Course at Pebble Beach Golf Links\", \"zip_code\": \"93953\", \"distance\": 0.0}, {\"name\": \"Cypress Point Club\", \"zip_code\": \"93953\", \"distance\": 0.3}, {\"name\": \"Cypress Point Club\", \"zip_code\": \"93953\", \"distance\": 0.3}, {\"name\": \"Spyglass Hill Golf Course\", \"zip_code\": \"93953\", \"distance\": 1.0}, {\"name\": \"Spyglass Hill Golf Course\", \"zip_code\": \"93953\", \"distance\": 1.0}, {\"name\": \"Poppy Hills Golf Course\", \"zip_code\": \"93953\", \"distance\": 1.2}, {\"name\": \"Dunes Course at Monterey Peninsula Country Club\", \"zip_code\": \"93953\", \"distance\": 2.2}, {\"name\": \"The Links at Spanish Bay\", \"zip_code\": \"93953\", \"distance\": 2.9}, {\"name\": \"West Course at Rancho Canada Golf Club\", \"zip_code\": \"93923\", \"distance\": 3.9}, {\"name\": \"Pacific Grove Municipal Golf Course\", \"zip_code\": \"93950\", \"distance\": 4.6}, {\"name\": \"Del Monte Golf Course\", \"zip_code\": \"93940\", \"distance\": 4.7}, {\"name\": \"Naval Postgraduate School Golf Course\", \"zip_code\": \"93940\", \"distance\": 5.0}, {\"name\": \"Quail Lodge Resort & Golf Club\", \"zip_code\": \"93923\", \"distance\": 6.0}, {\"name\": \"The Bayonet Course at Bayonet/Black Horse Golf Course\", \"zip_code\": \"93955\", \"distance\": 8.4}, {\"name\": \"Carmel Valley Ranch Resort\", \"zip_code\": \"93923\", \"distance\": 8.7}, {\"name\": \"Tehama Golf Club\", \"zip_code\": \"93923\", \"distance\": 8.8}, {\"name\": \"Laguna Seca Ranch Golf Club\", \"zip_code\": \"93940\", \"distance\": 9.0}, {\"name\": \"Pasadera Country Club\", \"zip_code\": \"93940\", \"distance\": 9.8}]}";
        Hashtable <String,String> myHash = new Hashtable<String,String>();

        System.out.println(response);
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