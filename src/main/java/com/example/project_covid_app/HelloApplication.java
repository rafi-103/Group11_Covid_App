package com.example.project_covid_app;

import com.example.project_covid_app.Ayman.SceneLoader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        SceneLoader.loadScene(stage, "/com/example/project_covid_app/Ayman/LoginView.fxml");
        stage.setTitle("COVID Management App");
    }

    public static void main(String[] args) {
        launch();
    }
}
