package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class KelasPraktikController {

    @FXML
    private TextField namaLengkap;

    @FXML
    private TextField idField;

    @FXML
    private ComboBox<Integer> faseComboBox;

    @FXML
    private ComboBox<String> tumbuhanComboBox;

    @FXML
    private Button uploadButton;

    @FXML
    private Button submitButton;

    @FXML
    public void initialize() {
        faseComboBox.getItems().addAll(1, 2, 3, 4, 5);
        tumbuhanComboBox.getItems().addAll("Wortel", "Tomat", "Cabai");

        uploadButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {
                uploadButton.setText(file.getName());
            }
        });

        submitButton.setOnAction(event -> handleSubmit());
    }

    private void handleSubmit() {
        String nama = namaLengkap.getText();
        String id = idField.getText();
        Integer fase = faseComboBox.getValue();
        String tumbuhan = tumbuhanComboBox.getValue();
        String videoFile = uploadButton.getText();

        // Handle form submission logic here
        System.out.println("Nama: " + nama);
        System.out.println("ID: " + id);
        System.out.println("Fase: " + fase);
        System.out.println("Tumbuhan: " + tumbuhan);
        System.out.println("Video: " + videoFile);
    }
}
