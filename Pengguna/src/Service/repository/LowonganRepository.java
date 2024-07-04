package Service.repository;

import Service.Config;

import java.sql.Connection;
import java.sql.SQLException;

public class LowonganRepository {
    public static boolean joinLowonganDB(int idLowongan, int idPengguna, String status, String namaLengkap, String gender, String asalDaerah, String pendidikanTerakhir, String tentangSaya) throws SQLException {
        Connection connection = null;
        try {
            connection = Config.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            connection.createStatement().executeUpdate("INSERT INTO lowongan_pengguna (idLowongan, idPengguna, status, namaLengkap, gender, asalDaerah, pendidikanTerakhir, tentangSaya) VALUES ('" + idLowongan + "', '" + idPengguna + "', '" + status + "', '" + namaLengkap + "', '" + gender + "', '" + asalDaerah + "', '" + pendidikanTerakhir + "', '" + tentangSaya + "')");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
