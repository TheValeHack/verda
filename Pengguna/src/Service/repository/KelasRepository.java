package Service.repository;

import Models.*;
import Service.Config;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class KelasRepository {
    public static ArrayList<KelasBelajar> getAllKelasBelajarByPelatihanDB(int idPelatihan){
        try {
            Connection connection = Config.getConnection();
            var statement = connection.createStatement();
            var result = statement.executeQuery("SELECT * FROM kelas_belajar WHERE idPelatihan = " + idPelatihan);
            ArrayList<KelasBelajar> kelasBelajarArrayList = new ArrayList<>();
            while (result.next()) {
                KelasBelajar kelasBelajar = new KelasBelajar(
                        result.getInt("id"),
                        result.getInt("idPelatihan"),
                        result.getString("namaKelas"),
                        result.getString("gambarKelas")
                );
                kelasBelajarArrayList.add(kelasBelajar);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static ArrayList<KelasVideo> getVideosByIdKelas(int idKelas){
        try {
            Connection connection = Config.getConnection();
            var statement = connection.createStatement();
            var result = statement.executeQuery("SELECT * FROM kelas_belajar_video WHERE idKelas = " + idKelas);
            ArrayList<KelasVideo> kelasVideoArrayList = new ArrayList<>();
            while (result.next()) {
                KelasVideo kelasVideo = new KelasVideo(
                        result.getInt("id"),
                        result.getInt("idKelas"),
                        result.getInt("orderVideo"),
                        result.getString("judulVideo"),
                        result.getString("videoURL")
                );
                kelasVideoArrayList.add(kelasVideo);
            }
            return kelasVideoArrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<KelasQuiz> getQuizzesByIdKelas(int idKelas){
        try {
            Connection connection = Config.getConnection();
            var statement = connection.createStatement();
            var result = statement.executeQuery("SELECT * FROM kelas_belajar_quiz WHERE idKelas = " + idKelas);
            ArrayList<KelasQuiz> kelasQuizArrayList = new ArrayList<>();
            while (result.next()) {
                KelasQuiz kelasQuiz = new KelasQuiz(
                        result.getInt("id"),
                        result.getInt("idKelas"),
                        result.getInt("orderQuiz"),
                        result.getString("namaQuiz")
                );
                kelasQuizArrayList.add(kelasQuiz);
            }
            return kelasQuizArrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<KelasPertanyaan> getPertanyaanByIdQuiz(int idQuiz){
        try {
            Connection connection = Config.getConnection();
            var statement = connection.createStatement();
            var result = statement.executeQuery("SELECT * FROM pertanyaan_quiz WHERE idQuiz = " + idQuiz);
            ArrayList<KelasPertanyaan> kelasPertanyaanArrayList = new ArrayList<>();
            while (result.next()) {
                KelasPertanyaan kelasPertanyaan = new KelasPertanyaan(
                        result.getInt("id"),
                        result.getInt("idQuiz"),
                        result.getString("pertanyaan")
                );
                kelasPertanyaanArrayList.add(kelasPertanyaan);
            }
            return kelasPertanyaanArrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<KelasJawaban> getJawabanByIdPertanyaan(int idPertanyaan){
        try {
            Connection connection = Config.getConnection();
            var statement = connection.createStatement();
            var result = statement.executeQuery("SELECT * FROM jawaban_pertanyaan WHERE idPertanyaan = " + idPertanyaan);
            ArrayList<KelasJawaban> kelasJawabanArrayList = new ArrayList<>();
            while (result.next()) {
                KelasJawaban kelasJawaban = new KelasJawaban(
                        result.getInt("id"),
                        result.getInt("idPertanyaan"),
                        result.getString("jawaban"),
                        result.getBoolean("isBenar")
                );
                kelasJawabanArrayList.add(kelasJawaban);
            }
            return kelasJawabanArrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
