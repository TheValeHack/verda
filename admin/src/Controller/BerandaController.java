package Controller;

import java.util.ArrayList;

import Models.Lowongan;
import Models.Pelatihan;
import Models.PelatihanPengguna;
import Models.Pengguna;
import Service.repository.LowonganRepository;
import Service.repository.PelatihanRepository;
import Service.repository.PenggunaRepository;
import Service.repository.PelatihanPenggunaRepository;
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
	
	private ArrayList<Pengguna> daftarPengguna;
	private ArrayList<Lowongan> daftarLowongan;
	private ArrayList<Pelatihan> daftarPelatihan;
	private ArrayList<PelatihanPengguna> daftarPelatihanPengguna;
//	private ArrayList<PelatihanPengguna> daftarPelatihanPengguna;
	
	@FXML
	public void initialize() {
		daftarPengguna = PenggunaRepository.getAllPenggunaDB();
		daftarLowongan = LowonganRepository.getAllLowonganDB();
		daftarPelatihan = PelatihanRepository.getAllPelatihanDB();
		daftarPelatihanPengguna = PelatihanPenggunaRepository.getAllPelatihanPengguna();
		
		
		
	}
}
