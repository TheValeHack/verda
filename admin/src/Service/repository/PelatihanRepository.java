package Service.repository;

import Models.Pelatihan;
import Service.Config;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PelatihanRepository {
    public static ArrayList<Pelatihan> getAllPelatihanDB() {
        try {
            Connection connection = Config.getConnection();
            var statement = connection.createStatement();
            var result = statement.executeQuery("SELECT * FROM pelatihan");
            ArrayList<Pelatihan> pelatihanArrayList = new ArrayList<>();
            while (result.next()) {
                Pelatihan pelatihan = new Pelatihan(
                        result.getInt("id"),
                        result.getString("namaPelatihan")
                );
                pelatihanArrayList.add(pelatihan);
            }
            return pelatihanArrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Pelatihan getSpecificPelatihanDB(int id) {
        try {
            Connection connection = Config.getConnection();
            var statement = connection.createStatement();
            var result = statement.executeQuery("SELECT * FROM pelatihan WHERE id = " + id);
            if (result.next()) {
                return new Pelatihan(
                        result.getInt("id"),
                        result.getString("namaPelatihan")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static ArrayList<Pelatihan> getAllPelatihanByUserIDDB(int userId) {
        try {
            Connection connection = Config.getConnection();
            var statement = connection.createStatement();
            var result = statement.executeQuery("SELECT * FROM pelatihan WHERE id IN (SELECT idPelatihan FROM pelatihan_pengguna WHERE idPengguna = " + userId + " AND status = 'accepted')");
            ArrayList<Pelatihan> pelatihanArrayList = new ArrayList<>();
            while (result.next()) {
                Pelatihan pelatihan = new Pelatihan(
                        result.getInt("id"),
                        result.getString("namaPelatihan")
                );
                pelatihanArrayList.add(pelatihan);
            }
            return pelatihanArrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean joinPelatihanDB(int idPelatihan, int idPengguna) {
        Connection connection = null;
        try {
            connection = Config.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            connection.createStatement().executeUpdate("INSERT INTO pelatihan_pengguna (idPelatihan, idPengguna, status) VALUES ('" + idPelatihan + "', '" + idPengguna + "', 'pending')");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

//    deletePelatihanDB
    public static boolean deletePelatihanDB(int idPelatihan, int idPengguna) {
        Connection connection = null;
        try {
            connection = Config.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            connection.createStatement().executeUpdate("DELETE FROM pelatihan_pengguna WHERE idPelatihan = " + idPelatihan + " AND idPengguna = " + idPengguna);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
