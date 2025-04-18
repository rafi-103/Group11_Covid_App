package com.example.project_covid_app.Ayman;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Prescription {
    private final StringProperty rxID;
    private final StringProperty patientID;
    private final StringProperty medication;
    private final StringProperty date;

    public Prescription(String rxID, String patientID, String medication, String date) {
        this.rxID = new SimpleStringProperty(rxID);
        this.patientID = new SimpleStringProperty(patientID);
        this.medication = new SimpleStringProperty(medication);
        this.date = new SimpleStringProperty(date);
    }

    public StringProperty rxIDProperty() { return rxID; }
    public StringProperty patientIDProperty() { return patientID; }
    public StringProperty medicationProperty() { return medication; }
    public StringProperty dateProperty() { return date; }

    public String getRxID() { return rxID.get(); }
    public String getPatientID() { return patientID.get(); }
    public String getMedication() { return medication.get(); }
    public String getDate() { return date.get(); }

    public void setRxID(String value) { rxID.set(value); }
    public void setPatientID(String value) { patientID.set(value); }
    public void setMedication(String value) { medication.set(value); }
    public void setDate(String value) { date.set(value); }
}
