package Controller;

import Main.App;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class BerandaController {

    @FXML
    private TextField searchField;

    @FXML
    private ImageView profileImage;

    @FXML
    private Text profileName;

    @FXML
    private Text dateText;

    @FXML
    private Text timeText;

    @FXML
    private Text quoteText;

    @FXML
    private Text authorText;

    @FXML
    private ImageView masukLowongan;

    @FXML
    public void initialize() {
        // Inisialisasi data di sini
        profileName.setText("BbyCygnus08");
        dateText.setText("Sat, Jun 22");
        timeText.setText("23:06");
        quoteText.setText("\"Langkah kecil untuk bumi, langkah besar untuk masa depan.\"");
        authorText.setText("- Max Verstappen");
    }

    @FXML
    private void handleSearch() {
        String searchQuery = searchField.getText();
        // Logika pencarian di sini
        System.out.println("Mencari: " + searchQuery);
    }

    @FXML
    private void handleToLowongan(MouseEvent event) {
        try {
            App.showLowonganView();
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

    @FXML
    private void handleToKomunitas(MouseEvent event) {
        try {
            App.showKomunitasView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleToLangganan(MouseEvent event) {
        try {
            App.showLanggananView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
