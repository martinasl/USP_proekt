package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginController<nextStage, stage> {
    @FXML
    private Button loginButton;
    @FXML
    private TextField email_id;
    @FXML
    private PasswordField password_id;
    @FXML
    private Label login_error;
    @FXML
    private Hyperlink reg_hyperlink;
    Main s =new Main();




    public void loginButton() throws IOException {
        if (email_id.getText().isEmpty() || password_id.getText().isEmpty()) {
            login_error.setText("Моля попълнете всички полета!");
        }
        else{
                       s.changeScene1("home.fxml");
        }

    }

    @FXML
    private void regOnAction() throws IOException {
        reg_hyperlink.setOnAction(e -> {
            Main s = new Main();
            try {

                s.changeScene("registration.fxml");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        }

    }

