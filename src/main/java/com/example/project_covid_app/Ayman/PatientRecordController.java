package com.example.project_covid_app.Ayman;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class PatientRecordController {
    @FXML private TableView<Patient> tblPatients;
    @FXML private TableColumn<Patient,String> colPatientID, colPatientName, colPatientStatus;
    @FXML
    private Button btnModify;

    @FXML
    public void initialize() {
        var data = FXCollections.observableArrayList(
                new Patient("P001","Ayman Rahman","Depressed"),
                new Patient("P002","Rafi",  "Cancer"),
                new Patient("P003","Elon Musk",  "BiPolar"),
                new Patient("P004","Sheikh Hasina",  "Schizophrenia"),
                new Patient("P005","Obaidul Kader",  "Dementia")




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
