package Controller;

import java.sql.SQLException;
import java.util.Optional;

import Main.App;
import Models.Lowongan;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import util.Session;

public class LamaranPekerjaanController {
	private Lowongan dataLowongan;
	
	@FXML
    private TextField namaTf;
	@FXML
    private ComboBox<String> genderCb;
	@FXML
    private TextField daerahTf;
	@FXML
    private ComboBox<String> pendidikanCb;
	@FXML
    private TextArea tentangTf;
	@FXML
    private Button simpanButton;
	
	public void initData(Lowongan lowongan) {
        this.setDataLowongan(lowongan);
        
    }
	public void setDataLowongan(Lowongan lowongan) {
		this.dataLowongan = lowongan;
	}
	
	@FXML
    public void initialize() {
        genderCb.getItems().addAll("Laki-laki", "Perempuan");
        pendidikanCb.getItems().addAll("SMA", "D3", "D4/S1");
        
        
        String nama = namaTf.getText();
        String asalDaerah = daerahTf.getText();
        String tentang = tentangTf.getText();
        String gender = genderCb.getValue();
        String pendidikan = pendidikanCb.getValue();

        simpanButton.setOnAction(event -> handleSimpanLowongan(dataLowongan.getId(), "waiting", nama, gender, asalDaerah, pendidikan, tentang));

    }
	@FXML
    private void handleBackButtonClick(MouseEvent event) throws Exception {
        App.showLowonganDetailView(dataLowongan);
    }
	private void handleSimpanLowongan(int idLowongan, String status, String namaLengkap, String gender, String asalDaerah, String pendidikanTerakhir, String tentangSaya) {
		try {
			boolean ajukanLowongan = Session.getUser().joinLowongan(idLowongan, status, namaLengkap, gender, asalDaerah, pendidikanTerakhir, tentangSaya);
			if(ajukanLowongan) {
				showAlertAndNavigate("Sukses", "Lowongan berhasil diajukan!");
			} else {
				showAlertAndNavigate("Gagal", "Lowongan gagal diajukan!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void showAlertAndNavigate(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                App.showBerandaView();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
