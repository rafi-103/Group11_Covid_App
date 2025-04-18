package com.example.project_covid_app.Rafi;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InventoryItem {
    private final StringProperty medicationID;
    private final StringProperty medicationName;
    private final IntegerProperty quantity;

    public InventoryItem(String medicationID, String medicationName, int quantity) {
        this.medicationID = new SimpleStringProperty(medicationID);
        this.medicationName = new SimpleStringProperty(medicationName);
        this.quantity = new SimpleIntegerProperty(quantity);
    }

    public StringProperty medicationIDProperty() {
        return medicationID;
    }

    public StringProperty medicationNameProperty() {
        return medicationName;
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }

    public String getMedicationID() {
        return medicationID.get();
    }

    public String getMedicationName() {
        return medicationName.get();
    }

    public int getQuantity() {
        return quantity.get();
    }

    public void setMedicationID(String id) {
        this.medicationID.set(id);
    }

    public void setMedicationName(String name) {
        this.medicationName.set(name);
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }
}
