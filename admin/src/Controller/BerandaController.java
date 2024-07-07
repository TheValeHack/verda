package Controller;

import java.util.ArrayList;

import Models.Lowongan;
import Models.Pelatihan;
import Service.repository.LowonganRepository;
import Service.repository.PelatihanRepository;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class BerandaController {

	@FXML
	private Text jumlahPengguna;
	
	@FXML
	private Text jumlahLowongan;
	
	@FXML
	private Text jumlahPelatihan;
	
	@FXML
	private Text jumlahKomunitas;
	
	@FXML
	private Text jumlahPelatihanPengguna;
	
	@FXML
	private Text jumlahLowonganPengguna;
	
	@FXML
	private Text jumlahLanggananPengguna;
	
	@FXML
	private Text jumlahKomunitasPengguna;
	
	private ArrayList<Lowongan> daftarLowongan;
	private ArrayList<Pelatihan> daftarPelatihan;
	
	@FXML
	public void initialize() {
		PelatihanRepository pelatihanRepo = new PelatihanRepository();
		daftarPelatihan = pelatihanRepo.getAllPelatihanDB();
		
		LowonganRepository lowonganRepo = new LowonganRepository();
		daftarLowongan = lowonganRepo.getAllLowonganDB();
	}
}
