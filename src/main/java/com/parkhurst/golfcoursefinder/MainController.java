package com.parkhurst.golfcoursefinder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author John parkhurst
 */

public class MainController {
    @FXML
    private Label errText;
    @FXML
    private TableView<Course> table;
    @FXML
    private TableColumn<Course, String> nameCol;
    @FXML
    private TableColumn<Course, String> zipCol;
    @FXML
    private TableColumn<Course, String> distCol;
    @FXML
    private TextField subField;

    private void processGolf(String[] longLatArr) throws IOException {
        GolfHandler golfH = new GolfHandler();
        ArrayList<Course> courseList= golfH.courseLookup(longLatArr);

        if(courseList==null && courseList.size()>0){
            errText.setText("Error in API Call report bug");
        }else{
            setTable(courseList);

        }
    }

    @FXML
    protected void onSubmitClick() throws IOException {
        String fieldText=subField.getText();
        if(fieldText.length()!=5){
            errText.setText("Make sure the zipcode is 5 charachters long");
        }else{
            //get string array
            ZipHandler zipH = new ZipHandler();
            String[] longLatArr = zipH.zipToLL(fieldText);
            processGolf(longLatArr);
        }

    }

    protected void setTable(ArrayList<Course> courseList){

        for(int iter = 0; iter<courseList.size();iter++){
            table.getItems().addAll(courseList.get(iter));
        }

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        zipCol.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
        distCol.setCellValueFactory(new PropertyValueFactory<>("distance"));
    }

}