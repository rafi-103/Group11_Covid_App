package com.example.project_covid_app.Ayman;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class TransactionHistoryController {
    @FXML private TableView<Transaction> tblTransactions;
    @FXML private TableColumn<Transaction,String> colTransID, colTransTime, colTransType;

    @FXML
    public void initialize() {
        var list = FXCollections.observableArrayList(
                new Transaction("T001","2025-04-07 10:00","Dispense"),
                new Transaction("T002","2025-04-07 10:00","New Admission"),
                new Transaction("T003","2025-04-07 10:00","Dispense"),
                new Transaction("T004","2025-04-08 11:30","Refill")
        );
        tblTransactions.setItems(list);

        colTransID  .setCellValueFactory(d -> d.getValue().transactionIDProperty());
        colTransTime.setCellValueFactory(d -> d.getValue().dateTimeProperty());
        colTransType.setCellValueFactory(d -> d.getValue().typeProperty());
    }

    @FXML
    private void onExportHistory() {
        new Alert(AlertType.INFORMATION, "Transaction history Exported!").show();
    }
}
