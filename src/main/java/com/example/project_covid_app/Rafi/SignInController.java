package com.example.project_covid_app.Rafi;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignInController
{
    @FXML
    private TextField UserIdTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private ComboBox userTypeComboBox;

    @FXML
    public void initialize() {
        userTypeComboBox.getItems().addAll(
                "Hospital Receptionist",
                "Nurse",
                "Vaccination staff",
                "Quarantine Monitor",
                "Doctor",
                "Patient",
                "community support worker",
                "Pharmacist"
        );
    }

    @FXML
    public void SigninONAction(ActionEvent actionEvent) throws IOException {
        String password = passwordPasswordField.getText();
        int passwordLength = password.length();
        boolean hasnumber = false;
        boolean hasspecial = false;

        String[] charact4er ={"!","@","#","$","%","^","&","*","(",")",",",".","?","/",":","{","}","|","<",">","-","_","+",""};
        String[] numbs = {"0","1","2","3","4","5","6","7","8","9"};
        for (String character : password.split("")){
            for (String number: numbs){
                if (character.equals(number)){
                    hasnumber =true;;
                }
            }

            for (String chac:charact4er){
                if (character.equals(chac)){
                    hasspecial = true;
                }
            }
        }
        if(hasnumber && hasspecial){
            showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome to COVID Management System!");

        } else {
            showAlert (Alert.AlertType.ERROR, "Password error", "Password must contain at least one number and One special character");
        }


    }

    @FXML
    public void PasswordONKeyTyped(Event event) {
        String password = passwordPasswordField.getText();
        int password_length = password.length();
        if(password_length < 6){
            passwordPasswordField.setStyle("-fx-border-color: red");
        } else {
            passwordPasswordField.setStyle("-fx-border-color: green");
        }
    }

    private void showAlert(Alert.AlertType type, String title, String content){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    public void NewAccountOnAction(ActionEvent actionEvent) throws IOException {
        Parent root =FXMLLoader.load(getClass().getResource("New account.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene((root)));
        stage.show();
    }
}