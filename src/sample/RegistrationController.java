package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class RegistrationController {

    @FXML
    private TextField email_id;
    @FXML
    private PasswordField password_id;
    @FXML
    private PasswordField repassword_id;
    @FXML
    private Button registrationButton_id;
    @FXML
    private Label reg_errorid;
    User user;
    Main s = new Main();

    public void registrationButtonOnAction() throws IOException {




        if (email_id.getText().isEmpty() && password_id.getText().isEmpty() && repassword_id.getText().isEmpty()){
        reg_errorid.setText("Въведете данни!");

        } else if ( !repassword_id.getText().equals(password_id.getText())) {
            reg_errorid.setText("Грешно въведени данни!");
        }

        else{
                //  User user=new User(email_id, password_id);
                // user.
            s.changeScene("home.fxml");
            }
    }


}
