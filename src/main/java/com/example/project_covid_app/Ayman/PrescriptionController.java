package com.example.project_covid_app.Ayman;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PrescriptionController {
    @FXML private TableView<Prescription> tblPrescriptions;
    @FXML private TableColumn<Prescription, String> colRxID;
    @FXML private TableColumn<Prescription, String> colPatientID;
    @FXML private TableColumn<Prescription, String> colMedication;
    @FXML private TableColumn<Prescription, String> colDate;

    @FXML private ComboBox<String> comboboxPrescriptionPaneRowSelect;
    @FXML private TextField prescriptionPaneTextField;
    @FXML private TextField prescriptionPaneTextField2;
    @FXML private TextField prescriptionPaneTextField3;
    @FXML private TextField prescriptionPaneTextField4;

    @FXML private Button verifybtn;
    @FXML private Button addBtnPrescriptionPane;

    private ObservableList<Prescription> prescriptions;

    @FXML
    public void initialize() {
        // 1) Initialize prescriptions list ONCE
        prescriptions = FXCollections.observableArrayList(
                new Prescription("001","P001","Paracetamol","2025-04-10"),
                new Prescription("002","P002","Sergel 20",  "2025-04-28"),
                new Prescription("003","P003","Ibuprofen",   "2025-04-11")
        );
        tblPrescriptions.setItems(prescriptions);

        // 2) Bind table columns
        colRxID      .setCellValueFactory(d -> d.getValue().rxIDProperty());
        colPatientID .setCellValueFactory(d -> d.getValue().patientIDProperty());
        colMedication.setCellValueFactory(d -> d.getValue().medicationProperty());
        colDate      .setCellValueFactory(d -> d.getValue().dateProperty());

        updateComboBox();
    }

    private void updateComboBox() {
        var options = FXCollections.observableArrayList("New Row");
        for (Prescription p : prescriptions) {
            options.add(p.getRxID());
        }
        comboboxPrescriptionPaneRowSelect.setItems(options);
        comboboxPrescriptionPaneRowSelect.getSelectionModel().selectFirst();
    }

    @FXML
    private void onVerifyPrescription() {
        Prescription sel = tblPrescriptions.getSelectionModel().getSelectedItem();
        if (sel == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a prescription!").show();
            return;
        }
        new Alert(Alert.AlertType.INFORMATION, "Verified: " + sel.getRxID()).show();
    }

    @FXML
    private void onAddPrescription() {
        String rowKey  = comboboxPrescriptionPaneRowSelect.getValue();
        String idVal   = prescriptionPaneTextField.getText();
        String patVal  = prescriptionPaneTextField2.getText();
        String medVal  = prescriptionPaneTextField3.getText();
        String dateVal = prescriptionPaneTextField4.getText();

        if (idVal.isBlank() || patVal.isBlank() || medVal.isBlank() || dateVal.isBlank()) {
            new Alert(Alert.AlertType.WARNING, "Fill all four fields").show();
            return;
        }

        if ("New Row".equals(rowKey)) {
            Prescription p = new Prescription(idVal, patVal, medVal, dateVal);
            prescriptions.add(p);
        } else {
            for (Prescription p : prescriptions) {
                if (p.getRxID().equals(rowKey)) {
                    p.setRxID(idVal);
                    p.setPatientID(patVal);
                    p.setMedication(medVal);
                    p.setDate(dateVal);
                    break;
                }
            }
        }


        tblPrescriptions.refresh();


        prescriptionPaneTextField.clear();
        prescriptionPaneTextField2.clear();
        prescriptionPaneTextField3.clear();
        prescriptionPaneTextField4.clear();


        updateComboBox();
    }
}
