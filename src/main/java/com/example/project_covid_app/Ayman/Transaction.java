package com.example.project_covid_app.Ayman;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Transaction {
    private final StringProperty transactionID;
    private final StringProperty dateTime;
    private final StringProperty type;

    public Transaction(String transactionID, String dateTime, String type) {
        this.transactionID = new SimpleStringProperty(transactionID);
        this.dateTime = new SimpleStringProperty(dateTime);
        this.type = new SimpleStringProperty(type);
    }

    public StringProperty transactionIDProperty() {
        return transactionID;
    }

    public StringProperty dateTimeProperty() {
        return dateTime;
    }

    public StringProperty typeProperty() {
        return type;
    }

    public String getTransactionID() {
        return transactionID.get();
    }

    public String getDateTime() {
        return dateTime.get();
    }

    public String getType() {
        return type.get();
    }
}
