package com.example.project_covid_app.Ayman;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class RefillController {
    @FXML private TableView<RefillRequest> tblRefills;
    @FXML private TableColumn<RefillRequest,String> colRefillID, colRefillPatient, colRefillMed, colRefillDate;

    @FXML
    public void initialize() {
        var data = FXCollections.observableArrayList(
                new RefillRequest("RR001","P001","Paracetamol","2025-04-10"),
                new RefillRequest("RR002","P002","Ibuprofen",  "2025-04-11")
        );
        tblRefills.setItems(data);

        colRefillID    .setCellValueFactory(d -> d.getValue().requestIDProperty());
        colRefillPatient.setCellValueFactory(d -> d.getValue().patientIDProperty());
        colRefillMed   .setCellValueFactory(d -> d.getValue().medicationProperty());
        colRefillDate  .setCellValueFactory(d -> d.getValue().dateProperty());
    }

    @FXML
    private void onProcessRefill() {
        RefillRequest sel = tblRefills.getSelectionModel().getSelectedItem();
        if (sel == null) {
            new Alert(AlertType.WARNING, "Select refill request").show();
            return;
        }
        new Alert(AlertType.INFORMATION,
                "Refill " + sel.getRequestID() + " processed")
                .show();
    }
}
