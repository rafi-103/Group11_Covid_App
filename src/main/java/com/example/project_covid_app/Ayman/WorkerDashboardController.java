package com.example.project_covid_app.Ayman;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.util.prefs.Preferences;

public class WorkerDashboardController {
    @FXML
    private void onLogout() {
        Preferences.userNodeForPackage(LoginController.class).remove("loggedInRole");

        if (Platform.isFxApplicationThread()) {
            Window window = Window.getWindows().stream()
                    .filter(Window::isShowing)
                    .findFirst()
                    .orElse(null);

            if (window != null) {
                SceneLoader.loadScene((Stage) window, "/com/example/project_covid_app/Ayman/LoginView.fxml");
            }
        }
    }
}
