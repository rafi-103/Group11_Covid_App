package com.example.project_covid_app.Ayman;

import com.example.project_covid_app.Rafi.InventoryItem;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class InventoryController {
    @FXML private TableView<InventoryItem> tblInventory;
    @FXML private TableColumn<InventoryItem,String> colMedID, colMedName;
    @FXML private TableColumn<InventoryItem,Integer> colQuantity;

    @FXML
    public void initialize() {
        var items = FXCollections.observableArrayList(
                new InventoryItem("M001","Paracetamol",120),
                new InventoryItem("M002","Sergel 20",78),
                new InventoryItem("M003","Ibuprofen", 80)
        );
        tblInventory.setItems(items);

        colMedID   .setCellValueFactory(d -> d.getValue().medicationIDProperty());
        colMedName .setCellValueFactory(d -> d.getValue().medicationNameProperty());
        colQuantity.setCellValueFactory(d -> d.getValue().quantityProperty().asObject());
    }

    @FXML
    private void onUpdateInventory() {
        InventoryItem sel = tblInventory.getSelectionModel().getSelectedItem();
        if (sel == null) {
            new Alert(AlertType.WARNING, "Please select an item").show();
            return;
        }

        new Alert(AlertType.INFORMATION,
                "Inventory for " + sel.getMedicationName() + " updated.")
                .show();
    }
}
