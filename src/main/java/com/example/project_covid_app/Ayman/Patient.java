package com.example.project_covid_app.Ayman;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Patient {
    private final StringProperty patientID = new SimpleStringProperty(this, "patientID");
    private final StringProperty name      = new SimpleStringProperty(this, "name");
    private final StringProperty status    = new SimpleStringProperty(this, "status");

    public Patient(String id, String name, String status) {
        this.patientID.set(id);
        this.name.set(name);
        this.status.set(status);
    }

    public StringProperty patientIDProperty() { return patientID; }
    public String getPatientID()              { return patientID.get(); }

    public StringProperty nameProperty()      { return name; }
    public String getName()                   { return name.get(); }

    public StringProperty statusProperty()    { return status; }
    public String getStatus()                 { return status.get(); }

    public void setStatus(String s)           { status.set(s); }
}
