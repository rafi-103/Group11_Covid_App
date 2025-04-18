package com.example.project_covid_app.Ayman;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.util.prefs.Preferences;

public class PharmacistDashboardController {
    @FXML private Label lblTitle;

    @FXML
    private void onLogout() {
        Preferences.userNodeForPackage(LoginController.class).remove("loggedInRole");
        SceneLoader.loadScene((Stage) lblTitle.getScene().getWindow(),
                "/com/example/project_covid_app/Ayman/LoginView.fxml");
    }
}
