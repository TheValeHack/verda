package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        App.primaryStage = primaryStage;
        showLoginView();
    }

    public static void showLoginView() throws Exception {
        Parent loginView = FXMLLoader.load(App.class.getResource("/Views/Login.fxml"));
        Scene loginScene = new Scene(loginView);
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }

    public static void showRegisterView() throws Exception {
        Parent registerView = FXMLLoader.load(App.class.getResource("/Views/Registrasi.fxml"));
        Scene registerScene = new Scene(registerView);
        primaryStage.setScene(registerScene);
        primaryStage.setTitle("Registrasi");
        primaryStage.show();
    }

    public static void showBerandaView() throws Exception {
        Parent berandaView = FXMLLoader.load(App.class.getResource("/Views/Beranda.fxml"));
        Scene berandaScene = new Scene(berandaView);
        primaryStage.setScene(berandaScene);
        primaryStage.setTitle("Beranda");
        primaryStage.show();
    }

    public static void showLowonganView() throws Exception {
        Parent lowonganView = FXMLLoader.load(App.class.getResource("/Views/Lowongan.fxml"));
        Scene lowonganScene = new Scene(lowonganView);
        primaryStage.setScene(lowonganScene);
        primaryStage.setTitle("Lowongan");
        primaryStage.show();
    }

    public static void showPelatihanView() throws Exception {
        Parent pelatihanView = FXMLLoader.load(App.class.getResource("/Views/Pelatihan.fxml"));
        Scene pelatihanScene = new Scene(pelatihanView);
        primaryStage.setScene(pelatihanScene);
        primaryStage.setTitle("Pelatihan");
        primaryStage.show();
    }
    
     public static void showKomunitasView() throws Exception {
        Parent komunitasView = FXMLLoader.load(App.class.getResource("/Views/Komunitas.fxml"));
        Scene komunitasScene = new Scene(komunitasView);
        primaryStage.setScene(komunitasScene);
        primaryStage.setTitle("Komunitas");
        primaryStage.show();
    }

    public static void showLanggananView() throws Exception {
        Parent langgananView = FXMLLoader.load(App.class.getResource("/Views/Langganan.fxml"));
        Scene langgananScene = new Scene(langgananView);
        primaryStage.setScene(langgananScene);
        primaryStage.setTitle("Komunitas");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
