package com.example.project_covid_app.Ayman;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Prescription {
    private final StringProperty rxID, patientID, medication, date;
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
    public void setRxID(String v) { rxID.set(v); }
    public String getPatientID() { return patientID.get(); }
    public void setPatientID(String v) { patientID.set(v); }
    public String getMedication() { return medication.get(); }
    public void setMedication(String v) { medication.set(v); }
    public String getDate() { return date.get(); }
    public void setDate(String v) { date.set(v); }
}
