package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
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

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]";
        if (email_id.getText().isEmpty() && password_id.getText().isEmpty() && repassword_id.getText().isEmpty()){
        reg_errorid.setText("Въведете данни!");

        } else if (!email_id.getText().equals(emailPattern ) || !repassword_id.getText().equals(password_id)) {
            reg_errorid.setText("Грешно въведени данни!");
        }

        else{
                //  User user=new User(email_id, password_id);
                // user.
                s.changeScene("home.fxml");
            }

    }
}
