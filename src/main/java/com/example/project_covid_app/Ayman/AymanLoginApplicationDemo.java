package com.example.project_covid_app.Ayman;

import com.example.project_covid_app.Ayman.SceneLoader;
import javafx.application.Application;
import javafx.stage.Stage;

public class AymanLoginApplicationDemo extends Application {
    @Override
    public void start(Stage stage) {
        SceneLoader.loadScene(stage, "/com/example/project_covid_app/Ayman/LoginView.fxml");
        stage.setTitle("COVID Management App");
    }

    public static void main(String[] args) {
        launch();
    }
}
