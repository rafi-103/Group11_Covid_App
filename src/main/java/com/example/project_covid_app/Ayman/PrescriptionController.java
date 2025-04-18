package com.example.project_covid_app.Ayman;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PrescriptionController {
    @FXML private TableView<Prescription> tblPrescriptions;
    @FXML private TableColumn<Prescription, String> colRxID;
    @FXML private TableColumn<Prescription, String> colPatientID;
    @FXML private TableColumn<Prescription, String> colMedication;
    @FXML private TableColumn<Prescription, String> colDate;
    @FXML
    private Button verifybtn;

    @FXML
    public void initialize() {

        var prescriptions = FXCollections.observableArrayList(
                new Prescription("001", "P001", "Paracetamol", "2025-04-10"),
                new Prescription("002", "P002", "Sergel 20", "2025-04-28"),
                new Prescription("003", "P003", "Ibuprofen", "2025-04-11")
        );
        tblPrescriptions.setItems(prescriptions);

        colRxID.setCellValueFactory(data -> data.getValue().rxIDProperty());
        colPatientID.setCellValueFactory(data -> data.getValue().patientIDProperty());
        colMedication.setCellValueFactory(data -> data.getValue().medicationProperty());
        colDate.setCellValueFactory(data -> data.getValue().dateProperty());
    }

    @FXML
    private void onUpdatePrescription() {
        Prescription selected = tblPrescriptions.getSelectionModel().getSelectedItem();
        if (selected == null) {
            new Alert(AlertType.WARNING, "Please select a prescription to update!").show();
            return;
        }

        new Alert(AlertType.INFORMATION, "Prescription updated successfully!").show();
    }

    @FXML
    public void onVerifyPrescription(ActionEvent actionEvent) {
    }
}
