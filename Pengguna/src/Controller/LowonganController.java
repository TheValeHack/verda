package Controller;

import Models.Lowongan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

import Main.App;

public class LowonganController {
    @FXML
    private TextField searchField;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private HBox HboxLowongan;
    

    private List<Lowongan> lowonganList = new ArrayList<>();

    @FXML
    public void initialize() {
        // Initialize comboBox options
        comboBox.getItems().addAll("Postingan terbaru", "Gaji tertinggi", "Paling populer");

        for (Lowongan lowongan : lowonganList) {
            VBox vbox = new VBox();
            vbox.setSpacing(10);

            Text posisi = new Text(lowongan.getPosisi());
            Text perusahaan = new Text(lowongan.getPerusahaan());
            Text lokasi = new Text(lowongan.getLokasi());
            Text gaji = new Text(lowongan.getGaji());
            Text kualifikasi = new Text(lowongan.getKualifikasi());
            Text waktuDiposting = new Text(lowongan.getWaktuDiposting());

            vbox.getChildren().addAll(posisi, perusahaan, lokasi, gaji, kualifikasi, waktuDiposting);
            HboxLowongan.getChildren().add(vbox);
        }
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
    private void handleToPelatihan(MouseEvent event) {
        try {
            App.showPelatihanView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
