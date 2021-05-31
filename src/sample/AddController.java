package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.*;

public class AddController {
    @FXML
    private Button backButton;
    @FXML
    private Button addButton;
    @FXML
    private Button loginButton;
    @FXML
    private ComboBox city_id;
    @FXML
    private ChoiceBox izl_id;
    @FXML
    private ChoiceBox stai_id;
    @FXML
    private TextField price_id;
    @FXML
    private ChoiceBox vid_id;

    Main s = new Main();
    ObservableList<String> cityList = FXCollections.observableArrayList("Варна", "Бургас", "Русе", "София", "Пловдив");
    ObservableList<String> izlList = FXCollections.observableArrayList("Северно изложение", "Западно изложение", "Източно изложение", "Южно изложение");
    final ObservableList option=FXCollections.observableArrayList();

    public AddController() throws SQLException {

    }

    @FXML
    private void initialize() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "USP", "usp");
        try {
            String v = "Select VID from VID ";
            Statement statement=connection.createStatement();
            ResultSet rs = statement.executeQuery(v);
            while (rs.next()) {
                String vid=rs.getString("VID");
                option.add(rs.getString("vid"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        city_id.setItems(cityList);
        izl_id.setItems(izlList);
    }

    public void addOnAction() throws IOException {
        s.changeScene1("home.fxml");
    }
}
