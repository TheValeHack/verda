package Service.seed;

import Service.Config;

import java.sql.Connection;
import java.sql.SQLException;

public class SeedJawabanQuiz {
    public static void SeedJawabanQuiz() {
        try {
            Connection connection = Config.getConnection();
            truncateJawabanQuiz();
            connection.createStatement().executeUpdate("INSERT INTO jawaban_quiz (idPertanyaan, jawaban, isTrue) VALUES (1, 'Wortel', 1)");
            connection.createStatement().executeUpdate("INSERT INTO jawaban_quiz (idPertanyaan, jawaban, isTrue) VALUES (1, 'Tomat', 0)");
            connection.createStatement().executeUpdate("INSERT INTO jawaban_quiz (idPertanyaan, jawaban, isTrue) VALUES (2, '30-40 Hari', 0)");
            connection.createStatement().executeUpdate("INSERT INTO jawaban_quiz (idPertanyaan, jawaban, isTrue) VALUES (2, '50-60 Hari', 1)");
            connection.createStatement().executeUpdate("INSERT INTO jawaban_quiz (idPertanyaan, jawaban, isTrue) VALUES (2, '70-80 Hari', 0)");
            connection.createStatement().executeUpdate("INSERT INTO jawaban_quiz (idPertanyaan, jawaban, isTrue) VALUES (2, '90-100 Hari', 0)");

            System.out.println("Seed Jawaban Quiz berhasil");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Seed Jawaban Quiz berhasil");
    }

    private static void truncateJawabanQuiz() {
        try {
            Connection connection = Config.getConnection();
            connection.createStatement().executeUpdate(" SET FOREIGN_KEY_CHECKS = 0");
            connection.createStatement().executeUpdate("TRUNCATE TABLE jawaban_quiz");
            connection.createStatement().executeUpdate("SET FOREIGN_KEY_CHECKS = 1");

            connection.close();
    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
