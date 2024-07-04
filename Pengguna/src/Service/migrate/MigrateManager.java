package Service.migrate;

import Service.Config;

import java.sql.Connection;
import java.sql.SQLException;

public class MigrateManager {


    public static void migrate() throws SQLException {
        migratePengguna();
        migrateLowongan();
        migrateLowonganPengguna();
    }

    public static void main(String[] args) throws SQLException {
        migrate();
    }

    public static void migratePengguna() throws SQLException {
        // Migrate Pengguna
        Connection connection = Config.getConnection();
        connection.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS pengguna (id INT PRIMARY KEY AUTO_INCREMENT, namaPengguna VARCHAR(255), nomorTelepon VARCHAR(255), jenisKelamin VARCHAR(255), tanggalLahir VARCHAR(255), profesi VARCHAR(255), provinsi VARCHAR(255), kota VARCHAR(255), email VARCHAR(255), password VARCHAR(255) ) ");
        System.out.println("Migrate Pengguna berhasil");
        connection.close();
    }

    public static void migrateLowongan() throws SQLException {
        Connection connection = Config.getConnection();
        connection.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS lowongan (id INT PRIMARY KEY AUTO_INCREMENT, posisi VARCHAR(255), perusahaan VARCHAR(255), lokasi VARCHAR(255), gaji INT, kualifikasi VARCHAR(255), waktuDiposting VARCHAR(255), jenisWaktu VARCHAR(255), jobDesk VARCHAR(3000), tanggungJawab VARCHAR(3000))");
        System.out.println("Migrate Lowongan berhasil");
        connection.close();

    }

    public static void migrateLowonganPengguna() throws SQLException {
        Connection connection = Config.getConnection();
        connection.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS lowongan_pengguna (id INT PRIMARY KEY AUTO_INCREMENT, idLowongan INT, idPengguna INT, status VARCHAR(255),namaLengkap VARCHAR(255), asalDaerah VARCHAR(255), gender VARCHAR(255), pendidikanTerakhir VARCHAR(255), tentangSaya VARCHAR(3000), FOREIGN KEY (idLowongan) REFERENCES lowongan(id) ON DELETE CASCADE, FOREIGN KEY (idPengguna) REFERENCES pengguna(id) ON DELETE CASCADE)");

        System.out.println("Migrate Lowongan Pengguna berhasil");
        connection.close();
    }


}
