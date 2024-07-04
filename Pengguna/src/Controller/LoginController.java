package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import Main.App;

public class LoginController {

    @FXML
    private TextField TfEmail;

    @FXML
    private PasswordField PfPassword;

    @FXML
    private Text errorMessage;

    @FXML
    private Hyperlink DaftarSekarang;

    @FXML
    private Hyperlink LupaPassword;

    @FXML
    private Models.Login model;

    @FXML
    public void initialize() {
        model = new Models.Login();
    }

    @FXML
    private void handleIconClickLogin(MouseEvent event) throws Exception {
        String email = TfEmail.getText();
        String password = PfPassword.getText();
        
        if (model.login(email, password)) {
            errorMessage.setVisible(false);
            System.out.println("Login berhasil");
            App.showBerandaView();
        } else {
            errorMessage.setVisible(true);
            System.out.println("Login gagal");
        }
    }

    @FXML
    private void handleDaftarSekarangAction(ActionEvent event) {
        try {
            App.showRegisterView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
