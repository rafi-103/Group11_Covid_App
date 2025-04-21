package com.example.project_covid_app.Rafi;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.text.StyledEditorKit;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class AppointmentController
{
    @javafx.fxml.FXML
    private TextField PatientID;
    @javafx.fxml.FXML
    private TextField pNameText;
    @javafx.fxml.FXML
    private DatePicker AppointDatepiker;
    @javafx.fxml.FXML
    private ComboBox DocCombo;
    @javafx.fxml.FXML
    private DatePicker AplicasonDatepicker;
    @javafx.fxml.FXML
    private TextField appointTimeTXTfild;
    @javafx.fxml.FXML
    private TextField AplicasonTimetextfield;
    @javafx.fxml.FXML
    private CheckBox Infectcheckbox;
    @javafx.fxml.FXML
    private CheckBox NonInfectcheckbox;

    @javafx.fxml.FXML
    public void initialize() {
        DocCombo.getItems().addAll(
                "Dr. Ahmed: ST 1300-1430",
                "Dr. Rafi: ST 2000-2130",
                "Dr. faisal: MW 1130-1300",
                "Dr. Mustafa: AR 1430-1600"
        );
    }

    private void ShowAlert(Alert.AlertType type, String title, String Context){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(Context);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void bcktohpreOnacson(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HospitalReceptionist .fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene((root)));
        stage.show();
    }

    @javafx.fxml.FXML
    public void SubmitOnAction(ActionEvent actionEvent) {
        String Patientnam = pNameText.getText();
        String PatientId = PatientID.getText();
        String Aplitime = AplicasonTimetextfield.getText();
        String appointmenttime = appointTimeTXTfild.getText();
        String DocSelect = (String) DocCombo.getValue();
        String aplidate = AplicasonDatepicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String appointdate = AppointDatepiker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/YY"));
        Boolean infected = Infectcheckbox.isSelected();
        Boolean noninfacted = NonInfectcheckbox.isSelected();

        if(PatientId.trim().isEmpty()){
            ShowAlert(Alert.AlertType.ERROR,"Error", "Patient ID is required!");
            return;
        }

        if(Patientnam.trim().isEmpty()){
            ShowAlert(Alert.AlertType.ERROR, "Error", "Patient Name is required!");
            return;
        }

        if (Aplitime.trim().isEmpty()){
            ShowAlert(Alert.AlertType.ERROR, "Error", "Application Time is required!");
            return;
        }

        if(appointmenttime.trim().isEmpty()){
            ShowAlert(Alert.AlertType.ERROR, "Error", "Appointment Time is required!");
        }

        if (aplidate.trim().isEmpty()){
            ShowAlert(Alert.AlertType.ERROR, "Error", "Application Date id required");
            return;
        }

        if (appointdate.trim().isEmpty()){
            ShowAlert(Alert.AlertType.ERROR, "Error", "Appointment Date is required");
            return;
        }

        if (DocSelect == null){
            ShowAlert(Alert.AlertType.ERROR, "Error","Doctor Selection is required");
            return;
        }

        if(!(infected ^ noninfacted)){
            ShowAlert(Alert.AlertType.ERROR, "Error", "Must select either Infected or Non-Infected!");
            return;
        }

         ShowAlert(Alert.AlertType.INFORMATION, "Congratulation", "your appointment has register");
    }
}