package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import  javafx.event.ActionEvent;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Label errorText;
    @FXML
    private TextField emailText;
    @FXML
    private PasswordField enterPasswordField;
    @FXML
    private Button loginButton;


    public void loginButton() {
        errorText.setText("Wrong username or password");
        if(emailText.getText().isBlank() == false && enterPasswordField.getText().isBlank()== false){
            validateLogin();

        } else {
            errorText.setText("Wrong email or password");

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void validateLogin(){

    }
}
