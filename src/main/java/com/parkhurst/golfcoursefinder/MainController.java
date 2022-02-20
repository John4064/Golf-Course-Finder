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
        table.setRowFactory(tableView -> {
            TableRow<Course> row = new TableRow<>();
            return row;
        });
        //table.getItems().addAll(new Course(("Winged foot","06820",3.2F));


        table.getItems().addAll(new Course("Jacob", "Smith", 3),
                new Course("Isabella", "Johnson", 4),
                new Course("Ethan", "Williams", 5),
                new Course("Emma", "Jones", 6),
                new Course("Michael", "Brown", 7));
        nameCol.setCellValueFactory(new PropertyValueFactory<Course, String>("courseName"));
        zipCol.setCellValueFactory(new PropertyValueFactory<Course, String>("courseZip"));
        distCol.setCellValueFactory(new PropertyValueFactory<Course, String>("distanceTo "));
        table.getColumns().addAll(Arrays.asList(nameCol,zipCol,distCol));

        welcomeText.setText("Kobe Bryant in Prime");
    }
}