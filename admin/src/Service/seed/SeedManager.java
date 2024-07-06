package Service.seed;

import Service.Config;

import java.sql.Connection;
import java.sql.SQLException;

public class SeedManager {
    public static void seed() {
    }

    public static void main(String[] args)  {
        seed();
    }

    public static void seedAdmin() {
        try {
            Connection connection = Config.getConnection();
            connection.createStatement().execute("INSERT INTO admin (email, password, username, profile_picture) VALUES ('admin@gmail.com', '123', 'aaa', 'aaa.jpg')");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
