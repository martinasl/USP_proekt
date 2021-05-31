package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;


public class FilterController {
    @FXML
    private Button backButton;
    @FXML
    private Button searchButton;

    Main s = new Main();



    public void backOnAction() throws IOException {
        s.changeScene1("home.fxml");
    }

    public void searchOnAction(ActionEvent actionEvent) {
    }
}
