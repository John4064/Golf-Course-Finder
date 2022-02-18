package com.parkhurst.golfcoursefinder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GolfApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GolfApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 240);
        stage.setTitle("Golf Finder");
        stage.setResizable(false);
        //Icon was downloaded https://icons8.com/icon/b6RClyMtZuOc/golf"
        stage.getIcons().add(new Image(Objects.requireNonNull(GolfApplication.class.getResourceAsStream("golf.png"))));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}