module com.example.project_covid_app {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.project_covid_app to javafx.fxml;
    exports com.example.project_covid_app;

    opens com.example.project_covid_app.Rafi to javafx.fxml;
    exports com.example.project_covid_app.Rafi;
}