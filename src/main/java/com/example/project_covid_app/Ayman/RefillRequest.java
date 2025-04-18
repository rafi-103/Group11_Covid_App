package com.example.project_covid_app.Ayman;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RefillRequest {
    private final StringProperty requestID;
    private final StringProperty patientID;
    private final StringProperty medication;
    private final StringProperty date;

    public RefillRequest(String requestID, String patientID, String medication, String date) {
        this.requestID = new SimpleStringProperty(requestID);
        this.patientID = new SimpleStringProperty(patientID);
        this.medication = new SimpleStringProperty(medication);
        this.date = new SimpleStringProperty(date);
    }

    public StringProperty requestIDProperty() {
        return requestID;
    }

    public StringProperty patientIDProperty() {
        return patientID;
    }

    public StringProperty medicationProperty() {
        return medication;
    }

    public StringProperty dateProperty() {
        return date;
    }

    public String getRequestID() {
        return requestID.get();
    }

    public String getPatientID() {
        return patientID.get();
    }

    public String getMedication() {
        return medication.get();
    }

    public String getDate() {
        return date.get();
    }
}
