package Service.seed;

import java.sql.SQLException;

public class SeedManager {
    public static void seed() throws SQLException {
        SeedPengguna.SeedPengguna();
        SeedLowongan.SeedLowongan();
        SeedLowonganPengguna.SeedLowonganPengguna();
    }

    public static void main(String[] args) throws SQLException {
        seed();
    }
}
