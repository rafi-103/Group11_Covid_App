package com.example.project_covid_app.Rafi;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class NewAccountController
{
    @javafx.fxml.FXML
    private TextField PNIDTextField;
    @javafx.fxml.FXML
    private TextField PbloodTextField;
    @javafx.fxml.FXML
    private TextField PageTextfield;
    @javafx.fxml.FXML
    private TextField PGenderTextField;
    @javafx.fxml.FXML
    private TextField EPnameTextField;
    @javafx.fxml.FXML
    private TextField PNameTextField;
    @javafx.fxml.FXML
    private TextField PphoneNoTextfield;
    @javafx.fxml.FXML
    private TextField EPrelationTextfield;
    @javafx.fxml.FXML
    private TextField EPphoneNoTextfield;
    @javafx.fxml.FXML
    private DatePicker dateDatepicker;
    @javafx.fxml.FXML
    private CheckBox termsCondition;
    @javafx.fxml.FXML
    private ComboBox UserTypeComboBox;
    @javafx.fxml.FXML
    private PasswordField PasswordCreatPasswordfield;
    @javafx.fxml.FXML
    private PasswordField recreatpasswordPasswordfield;
    @javafx.fxml.FXML
    private TextField UserNameTF;

    @javafx.fxml.FXML
    public void initialize() {
        UserTypeComboBox.getItems().addAll(
                "Hospital Receptionist",
                "Nurse",
                "Vaccination staff",
                "Quarantine Monitor",
                "Doctor",
                "Patient",
                "Community support worker",
                "Pharmacist"
        );
    }

    private void showAlert(Alert.AlertType type, String tittle, String content){
        Alert alert = new Alert(type);
        alert.setTitle(tittle);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void SubmitOnAction(ActionEvent actionEvent) throws IOException {
        String name =PNameTextField.getText();
        String nid = PNIDTextField.getText();
        String Phone = PphoneNoTextfield.getText();
        String gender = PGenderTextField.getText();
        String blood = PbloodTextField.getText();
        String age = PageTextfield.getText();
        String Ename = EPnameTextField.getText();
        String Ephone = EPphoneNoTextfield.getText();
        String EReltn = EPrelationTextfield.getText();
        String dob = dateDatepicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String usertyp = (String) UserTypeComboBox.getValue();
        String Password = PasswordCreatPasswordfield.getText();
        String cnfrm_password = recreatpasswordPasswordfield.getText();
        String UserName = UserNameTF.getText();

        if (name.isEmpty() ||
                nid.isEmpty() ||
                Phone.isEmpty() ||
                usertyp == null ||
                Ename.isEmpty() ||
                Ephone.isEmpty() ||
                UserName.isEmpty() ||
                Password.isEmpty()){
            showAlert(Alert.AlertType.ERROR, "Missing Information", "Please Fill all required fields!");
            return;
        }

        if (dateDatepicker.getValue() == null){
            showAlert(Alert.AlertType.ERROR,"Date Error", "Please select the date of birth!");
            return;
        }

        if (!Password.equals(cnfrm_password)){
            showAlert(Alert.AlertType.ERROR, "Missing Information", "plese fill all required fields:");
            return;
        }

        if (!termsCondition.isSelected()){
            showAlert(Alert.AlertType.ERROR, "Terms Not Accepted", "You must accept the Terms and condigtions!");
            return;
        }

        showAlert(Alert.AlertType.INFORMATION, "Congratulation", "Account created Successful");

        Parent root = FXMLLoader.load(getClass().getResource("Sign in.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene((root)));
        stage.show();
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Parent root =FXMLLoader.load(getClass().getResource("Sign in.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene((root)));
        stage.show();
    }

    @Deprecated
    public void passOnKeyTyped(Event event) {
        String password = PasswordCreatPasswordfield.getText();
        int password_length = password.length();
        if(password_length < 6){
            PasswordCreatPasswordfield.setStyle("-fx-border-color: red");
        } else {
            PasswordCreatPasswordfield.setStyle("-fx-border-color: green");
        }
    }

    @Deprecated
    public void paccOnKeyTyped(Event event) {
        String password = recreatpasswordPasswordfield.getText();
        int password_length = password.length();
        if(password_length < 6){
            recreatpasswordPasswordfield.setStyle("-fx-border-color: red");
        } else {
            recreatpasswordPasswordfield.setStyle("-fx-border-color: green");

        }
    }
}