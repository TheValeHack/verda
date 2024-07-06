package Service.repository;

import Models.Langganan;
import Service.Config;

import java.sql.Connection;
import java.sql.SQLException;

public class LanggananRepository {
    public static boolean addLangganan(int idPengguna, int idLangganan){
        try {
            Connection connection = Config.getConnection();
            var statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO langganan_pengguna (idPengguna, idLangganan) VALUES (" + idPengguna + ", " + idLangganan + ")");
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean deleteLangganan(int idPengguna, int idLangganan){
        try {
            Connection connection = Config.getConnection();
            var statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM langganan_pengguna WHERE idPengguna = " + idPengguna + " AND idLangganan = " + idLangganan);

            connection.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Langganan getLanggananPengguna(int idPengguna){
        try {
            Connection connection = Config.getConnection();
            var statement = connection.createStatement();
            var result = statement.executeQuery("SELECT * FROM langganan JOIN langganan_pengguna ON langganan.id = langganan_pengguna.idLangganan WHERE langganan_pengguna.idPengguna = " + idPengguna);
            if (result.next()) {
                return new Langganan(
                        result.getInt("id"),
                        result.getString("jenisLangganan"),
                        result.getString("durasiLangganan"),
                        result.getString("benefitLangganan"),
                        result.getInt("hargaLangganan")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
