package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddController {
    @FXML
    private Button backButton;
    @FXML
    private Button addButton;
    @FXML
    private Button loginButton;
    @FXML
    private TextField city_id;
    @FXML
    private TextField izl_id;
    @FXML
    private TextField stai_id;
    @FXML
    private TextField price_id;

    Main s = new Main();


    public void addOnAction() throws IOException {
        s.changeScene1("home.fxml");
    }
}
