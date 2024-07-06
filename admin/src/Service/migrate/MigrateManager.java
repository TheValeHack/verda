package Service.migrate;

import Service.Config;

import java.sql.Connection;
import java.sql.SQLException;

public class MigrateManager {
    public static void migrate(){

    }

    public static void main(String[] args) {
        migrate();
    }

    public static void migrateAdmin(){
        try {
            Connection connection = Config.getConnection();
            connection.createStatement().execute("CREATE TABLE admin (id INT PRIMARY KEY AUTO_INCREMENT, email VARCHAR(255), password VARCHAR(255), username VARCHAR(255), profile_picture VARCHAR(255))");
            System.out.println("Table Admin berhasil dibuat");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
