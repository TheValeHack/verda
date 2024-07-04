package Controller;

import Main.App;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PelatihanController {
    @FXML
    private ImageView profileImage;

    @FXML
    private ImageView masukLowongan;

    @FXML
    private TextField searchField;

    @FXML
    void handleToPelatihan(MouseEvent event) {
       
    }

    @FXML
    public void initialize() {
        // Inisialisasi kontrol jika diperlukan
    }

    @FXML
    private void handleToBeranda(MouseEvent event) {
        try {
            App.showBerandaView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleToLowongan(MouseEvent event) {
        try {
            App.showLowonganView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
