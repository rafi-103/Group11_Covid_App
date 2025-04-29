package com.example.project_covid_app.Ayman;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PatientRecordController {
    @FXML private TableView<Patient> tblPatients;
    @FXML private TableColumn<Patient, String> colPatientID, colPatientName, colPatientStatus;
    @FXML private Button btnModify;

    @FXML
    public void initialize() {
        var data = FXCollections.observableArrayList(
                new Patient("P001", "Ayman Rahman", "Depressed"),
                new Patient("P002", "Rafi", "Chemo"),
                new Patient("P003", "Elon Musk", "Recovery"),
                new Patient("P004", "Sheikh Hasina", "Schizophrenia"),
                new Patient("P005", "Obaidul Kader", "Dementia")
        );
        tblPatients.setItems(data);

        colPatientID.setCellValueFactory(d -> d.getValue().patientIDProperty());
        colPatientName.setCellValueFactory(d -> d.getValue().nameProperty());
        colPatientStatus.setCellValueFactory(d -> d.getValue().statusProperty());
    }

    @FXML
    private void onRetrievePatientInfo() {
        Patient sel = tblPatients.getSelectionModel().getSelectedItem();
        if (sel == null) {
            new Alert(Alert.AlertType.WARNING, "Select patient!").show();
            return;
        }
        new Alert(Alert.AlertType.INFORMATION,
                "Info: " + sel.getPatientID() + ", " + sel.getName())
                .show();
    }

    @FXML
    private void onUpdateHealthStatus() {
        Patient sel = tblPatients.getSelectionModel().getSelectedItem();
        if (sel == null) {
            new Alert(Alert.AlertType.WARNING, "Select patient!").show();
            return;
        }
        sel.setStatus("Updated");
        tblPatients.refresh();
        new Alert(Alert.AlertType.INFORMATION, "Status updated successfully!").show();
    }
}


// //  @FXML
//    //    public void saveUserList(ActionEvent actionEvent) {
//    //        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("data/user.bin"))) {
//    //            outputStream.writeObject(userList);
//    //            messageLabel.setText("Successfully saved to file.");
//    //        } catch (IOException e) {
//    //            e.printStackTrace();
//    //            messageLabel.setText("Could not write to file");
//    //        }
//    //    }
//    //
//    //    @FXML
//    //    public void loadUserList(ActionEvent actionEvent) {
//    //        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("data/user.bin"))) {
//    //            userList.clear();
//    //            tableView.getItems().clear();
//    //
//    //            List< User > loadedList = (List<User>) inputStream.readObject();
//    //            userList.addAll(loadedList);
//    //            tableView.getItems().addAll(loadedList);
//    //
//    //            messageLabel.setText("Successfully loaded data");
//    //        } catch (ClassNotFoundException e) {
//    //            e.printStackTrace();
//    //            messageLabel.setText("Invalid file format");
//    //        } catch (IOException e) {
//    //            e.printStackTrace();
//    //            messageLabel.setText("Could not load data from file!");
//    //        }
//    //    }
//    //}
//}