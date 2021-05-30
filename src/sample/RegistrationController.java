package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

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

    public void registrationButtonOnAction() throws IOException, SecurityException, SQLException {


        if (email_id.getText().isEmpty() && password_id.getText().isEmpty() && repassword_id.getText().isEmpty()) {
            reg_errorid.setText("Въведете данни!");

        } else if (!repassword_id.getText().equals(password_id.getText())) {
            reg_errorid.setText("Грешно въведени данни!");
        }
        else {
                Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","USP","usp");
                Statement statement = connection.createStatement();
                try{
                    String username = email_id.getText();
                    String pass = password_id.getText();
                    String sql = ("INSERT INTO USERS  ( EMAIL,PASSWORD) VALUES ( '"+username+"' , '"+pass+"')");
                    statement.executeUpdate(sql);
                    System.out.println("done");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            s.changeScene1("home.fxml");
        }

    }




