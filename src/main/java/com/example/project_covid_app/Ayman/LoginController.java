package com.example.project_covid_app.Ayman;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.prefs.Preferences;

public class LoginController {
    @FXML private TextField tfUsername;
    @FXML private PasswordField pfPassword;
    @FXML private ChoiceBox<String> cbRole;
    @FXML
    private Button loginbtn;
    @FXML
    private AnchorPane regisbtn;
    @FXML
    private Button loginViewRegisterBtn;

    @FXML
    public void initialize() {
        cbRole.setItems(FXCollections.observableArrayList("Pharmacist", "Community Support Worker", "Hospital","Nurse","Vaccination staff","Quarintine Monitor","Doctor", "Patient"));
        cbRole.getSelectionModel().selectFirst();
    }

    @FXML
    private void onLogin() {
        if (tfUsername.getText().isEmpty() || pfPassword.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Enter Login Details!").show();
            return;
        }
        String role = cbRole.getValue();
        Preferences.userNodeForPackage(LoginController.class)
                .put("loggedInRole", role);

        Stage stage = (Stage) tfUsername.getScene().getWindow();
        String fxml = role.equals("Pharmacist")
                ? "/com/example/project_covid_app/Ayman/PharmacistDashboardView.fxml"
                : "/com/example/project_covid_app/Ayman/CommunitySupportWorkerDashboardView.fxml";

        SceneLoader.loadScene(stage, fxml);
    }

    @FXML
    public void onSignIn(ActionEvent actionEvent) {
    }

}
