package Service.repository;

import Models.LanggananPengguna;
import Service.Config;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class LanggananPenggunaRepository {
    public ArrayList<LanggananPengguna> getAllLanggananPengguna(){
        try {
            Connection connection = Config.getConnection();
            var statement = connection.createStatement();
            var result = statement.executeQuery("SELECT * FROM langganan_pengguna");
            ArrayList<LanggananPengguna> langgananPenggunaArrayList = new ArrayList<>();
while (result.next()) {
                LanggananPengguna langgananPengguna = new LanggananPengguna(
                        result.getInt("id"),
                        result.getInt("idPengguna"),
                        result.getInt("idLangganan"),
                        result.getString("status")
                );
                langgananPenggunaArrayList.add(langgananPengguna);
            }
            return langgananPenggunaArrayList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
}
