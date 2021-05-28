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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import oracle.jdbc.driver.*;


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
    Main s = new Main();

    public void registrationButtonOnAction() throws IOException {


        if (email_id.getText().isEmpty() && password_id.getText().isEmpty() && repassword_id.getText().isEmpty()) {
            reg_errorid.setText("Въведете данни!");

        } else if (!repassword_id.getText().equals(password_id.getText())) {
            reg_errorid.setText("Грешно въведени данни!");
        } else {
            //  User user=new User(email_id, password_id);
            // user.

            String username = email_id.getText();
            String pass = password_id.getText();
            String pass2 = repassword_id.getText();

            try {

                //String DBURL = "jdbc:oracle:thin:@localhost:1521:xe";
                //String username1 = "USP";
                //String password = "usp";
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","USP","usp");
                Statement stmt = conn.createStatement();
                String insertQuery="INSERT INTO USERS(ID_USER,E-mail,PASSWORD) VALUES('"+pass2+"','"+username+"','"+pass+"')";
                stmt.executeUpdate(insertQuery);
                System.out.println("done");

            } catch (Exception e) {
                e.printStackTrace();
            }

            s.changeScene("home.fxml");
        }

    }
}






