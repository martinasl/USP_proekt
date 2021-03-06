package sample;

import javafx.fxml.FXML;
import javafx.fxml.LoadException;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;


public class HomeController {
    @FXML
    private Hyperlink add_id;
    @FXML
    private Hyperlink search_id;
    @FXML
    private AnchorPane root;

  @FXML
    private void addOnAction() throws IOException, LoadException {
     add_id.setOnAction(e -> {
    Main s=new Main();
         try {
             s.changeScene2("add.fxml");
         } catch (IOException ioException) {
             ioException.printStackTrace();
         }
     });
    }

    @FXML
    private void searchOnAction() throws IOException {
        search_id.setOnAction(e -> {
            Main s=new Main();
            try {
                s.changeScene4("filter.fxml");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }



}
