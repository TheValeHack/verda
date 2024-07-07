package Controller;

import java.util.ArrayList;

import Models.LanggananPengguna;
import Models.Lowongan;
import Models.LowonganPengguna;
import Models.Pelatihan;
import Models.PelatihanPengguna;
import Models.Pengguna;
import Service.repository.LanggananPenggunaRepository;
import Service.repository.LowonganPenggunaRepository;
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
	private Text jumlahProgram;
	
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
	private ArrayList<LowonganPengguna> daftarLowonganPengguna;
	private ArrayList<LanggananPengguna> daftarLanggananPengguna;
	
	@FXML
	public void initialize() {
		daftarPengguna = PenggunaRepository.getAllPenggunaDB();
		daftarLowongan = LowonganRepository.getAllLowonganDB();
		daftarPelatihan = PelatihanRepository.getAllPelatihanDB();
		daftarPelatihanPengguna = PelatihanPenggunaRepository.getAllPelatihanPengguna();
		daftarLowonganPengguna = LowonganPenggunaRepository.getAllLowonganPengguna();
		daftarLanggananPengguna = LanggananPenggunaRepository.getAllLanggananPengguna();
		
		jumlahPengguna.setText(Integer.toString(daftarPengguna.size()));
		jumlahLowongan.setText(Integer.toString(daftarLowongan.size()));
		jumlahProgram.setText(Integer.toString(daftarPelatihan.size()));
		jumlahKomunitas.setText("6");
		jumlahPelatihanPengguna.setText(Integer.toString(daftarPelatihanPengguna.size()));
		jumlahLowonganPengguna.setText(Integer.toString(daftarLowonganPengguna.size()));
		jumlahLanggananPengguna.setText(Integer.toString(daftarLanggananPengguna.size()));
		jumlahKomunitasPengguna.setText("1");
	}
}
