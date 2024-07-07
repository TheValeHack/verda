package Service.repository;

import Models.LowonganPengguna;
import Service.Config;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class LowonganPenggunaRepository {
    public static ArrayList<LowonganPengguna> getAllLowonganPengguna(){
        try {
            Connection connection = Config.getConnection();
            var statement = connection.createStatement();
            var result = statement.executeQuery("SELECT * FROM lowongan_pengguna");
            ArrayList<LowonganPengguna> lowonganPengguna = new ArrayList<>();
            while (result.next()) {
            	lowonganPengguna.add(new LowonganPengguna(
            			result.getInt("id"), 
                        result.getInt("idLowongan"),
                        result.getInt("idPengguna"), 
                        result.getString("status"),
                        result.getString("namaLengkap"), 
                        result.getString("gender"), 
                        result.getString("asalDaerah"), 
                        result.getString("pendidikanTerakhir"), 
                        result.getString("tentangSaya")
                ));
            }
            connection.close();
            return lowonganPengguna;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
		System.out.println(getAllLowonganPengguna());
	}
}
