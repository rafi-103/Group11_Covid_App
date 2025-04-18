package com.example.project_covid_app.Ayman;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class PatientRecordController {
    @FXML private TableView<Patient> tblPatients;
    @FXML private TableColumn<Patient,String> colPatientID, colPatientName, colPatientStatus;

    @FXML
    public void initialize() {
        var data = FXCollections.observableArrayList(
                new Patient("P001","Ayman Rahman","Depressed"),
                new Patient("P002","Rafi",  "Cancer")
        );
        tblPatients.setItems(data);

        colPatientID   .setCellValueFactory(d -> d.getValue().patientIDProperty());
        colPatientName .setCellValueFactory(d -> d.getValue().nameProperty());
        colPatientStatus.setCellValueFactory(d -> d.getValue().statusProperty());
    }

    @FXML
    private void onRetrievePatientInfo() {
        Patient sel = tblPatients.getSelectionModel().getSelectedItem();
        if (sel == null) {
            new Alert(AlertType.WARNING, "Select patient!").show();
            return;
        }
        new Alert(AlertType.INFORMATION,
                "Info: " + sel.getPatientID() + ", " + sel.getName())
                .show();
    }

    @FXML
    private void onUpdateHealthStatus() {
        Patient sel = tblPatients.getSelectionModel().getSelectedItem();
        if (sel == null) {
            new Alert(AlertType.WARNING, "Select patient!").show();
            return;
        }
        sel.setStatus("Updated");
        tblPatients.refresh();
        new Alert(AlertType.INFORMATION, "Status updated successfully!").show();
    }
}
