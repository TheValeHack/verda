package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import Main.App;

public class RegistrasiController {

    @FXML
    private TextField TfUsername;

    @FXML
    private TextField TfEmail;

    @FXML
    private PasswordField PfPassword;

    @FXML
    private PasswordField PfConfirm;

    @FXML
    private Text SuccesRegister;

    @FXML
    private Text errorRegister;

    @FXML
    private Button BtRegistrasi;

    @FXML
    private Hyperlink LinkLogin;

    @FXML
    public void initialize() {
    }

    @FXML
    private void handleRegisterClickIcon() {
        String username = TfUsername.getText();
        String email = TfEmail.getText();
        String password = PfPassword.getText();
        String confirmPassword = PfConfirm.getText();
        
        if (!isValidUsername(username)) {
            errorRegister.setText("Username harus memiliki huruf besar, kecil, dan angka");
            errorRegister.setVisible(true);
            SuccesRegister.setVisible(false);
            System.out.println("Registrasi gagal: Username tidak valid");
        } else if (!password.equals(confirmPassword)) {
            errorRegister.setText("Password dan konfirmasi password tidak cocok");
            errorRegister.setVisible(true);
            SuccesRegister.setVisible(false);
            System.out.println("Registrasi gagal: Password tidak cocok");
        } else {
            SuccesRegister.setVisible(true);
            errorRegister.setVisible(false);
            System.out.println("Registrasi berhasil");
        }
    }

    private boolean isValidUsername(String username) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$";
        return username.matches(regex);
    }

    @FXML
    private void handleBackToLogin(ActionEvent event) {
        try {
            App.showLoginView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
