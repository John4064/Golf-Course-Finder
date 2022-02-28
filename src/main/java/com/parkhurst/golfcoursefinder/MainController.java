package com.parkhurst.golfcoursefinder;

import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    @FXML
    private Slider distSlid;

    /**
     * @param longLatArr A string array of the longitude and lattitude of the desired zipcode
     * @brief It takes our longitude/lattidue we got earlier and communicates with the golfapi to get course data
     * @throws IOException
     */
    private void processGolf(String[] longLatArr, int distVal) throws IOException {
        GolfHandler golfH = new GolfHandler();
        golfH.setDistance(distVal);
        ArrayList<Course> courseList= golfH.courseLookup(longLatArr);

        if(courseList==null ){
            errText.setText("Error in API Call report bug");
        }else if(courseList.size()==0){
            errText.setText("No Courses were found at the desired location!");
        } else{
            setTable(courseList);
        }
    }

    @FXML
    protected void onClearClick() throws IOException{
        table.getItems().clear();
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
            processGolf(longLatArr, (int) distSlid.getValue());
        }

    }

    /**
     * @param courseList An arraylist of course objects
     * @brief Given the courseList it will add all the course objects to the table
     */
    protected void setTable(ArrayList<Course> courseList){

        for(int iter = 0; iter<courseList.size();iter++){
            table.getItems().addAll(courseList.get(iter));
        }

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        zipCol.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
        distCol.setCellValueFactory(new PropertyValueFactory<>("distance"));
    }

}