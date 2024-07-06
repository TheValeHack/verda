package Controllers;

import Models.Pelatihan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PelatihanController implements Initializable {

    @FXML
    private TableColumn<Pelatihan, String> namaPengguna;

    @FXML
    void tekan(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        namaPengguna.setCellValueFactory(new PropertyValueFactory<Pelatihan, String>("namaPengguna"));
    }
}
