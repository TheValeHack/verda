package Service.seed;

import Service.Config;

import java.sql.Connection;
import java.sql.SQLException;

public class SeedKelasBelajar {
    public static void SeedKelasBelajar() {
        try {
            Connection connection = Config.getConnection();
            truncateKelasBelajar();

            connection.createStatement().executeUpdate("INSERT INTO kelas_belajar (idPelatihan, namaKelas, gambarKelas) VALUES (1, 'Wortel', '/Styles/Image/icon%20wortel.png')");
            connection.createStatement().executeUpdate("INSERT INTO kelas_belajar (idPelatihan, namaKelas, gambarKelas) VALUES (1, 'Tomat', '/Styles/Image/icon%20wortel.png')");

            System.out.println("Seed Kelas Belajar berhasil");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void truncateKelasBelajar() {
        try {
            Connection connection = Config.getConnection();
            connection.createStatement().executeUpdate(" SET FOREIGN_KEY_CHECKS = 0");
            connection.createStatement().executeUpdate("TRUNCATE TABLE kelas_belajar");
            connection.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 1");

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }
