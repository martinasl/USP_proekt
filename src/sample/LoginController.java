package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class LoginController {
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
    Main s=new Main();



    public void loginButton() throws IOException {
        if (email_id.getText().isEmpty() || password_id.getText().isEmpty()){
            login_error.setText("Моля попълнете всички полета!");
        }
        else{
            try {
                Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "USP", "usp");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select PASSWORD from USERS");
                while (resultSet.next()) {
                  //  String suser = resultSet.getString("E-mail");
                    String spass= resultSet.getString("PASSWORD");
                    if (spass.equals(password_id.getText())) {
                        s.changeScene1("home.fxml");
                    } else {
                        login_error.setText("Не е намерен потребител или грешна парола!");
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }

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
