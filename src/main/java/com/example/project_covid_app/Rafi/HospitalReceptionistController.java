package com.example.project_covid_app.Rafi;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class HospitalReceptionistController {

    @javafx.fxml.FXML
    public void RegPOnAction(ActionEvent actionEvent) throws IOException {
        Parent root =FXMLLoader.load(getClass().getResource("New account.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene((root)));
        stage.show();
    }

    @javafx.fxml.FXML
    public void SignOutOnaction(ActionEvent actionEvent) throws IOException {
        Parent root =FXMLLoader.load(getClass().getResource("Sign in.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene((root)));
        stage.show();

        showAlert(Alert.AlertType.INFORMATION, "Signing Out", "You have been sign out Successifully");
    }

    private void showAlert(Alert.AlertType type, String tittle, String Context){
        Alert alert = new Alert(type);
        alert.setTitle(tittle);
        alert.setHeaderText(null);
        alert.setContentText(Context);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void AppoinmentOnAction(ActionEvent actionEvent) throws IOException {
        Parent root =FXMLLoader.load(getClass().getResource("Appointment.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene((root)));
        stage.show();
    }

    @javafx.fxml.FXML
    public void PListOnAction(ActionEvent actionEvent) throws IOException {
        Parent root =FXMLLoader.load(getClass().getResource("PList.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene((root)));
        stage.show();
    }
}