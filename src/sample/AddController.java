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
    private ComboBox<String> vid_id;
    @FXML
    private ChoiceBox<String> izl_id;
    @FXML
    private TextField stai_id;
    @FXML
    private TextField price_id;
    @FXML
    private ChoiceBox<String> city_id;


    Main s = new Main();
    final ObservableList<String> cities = FXCollections.observableArrayList();
     final ObservableList<String> izlojenie = FXCollections.observableArrayList();
    final ObservableList<String> vidd =FXCollections.observableArrayList();

    public AddController() throws SQLException {
    }
    @FXML
    private void initialize() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "USP", "usp");
        try {
            String v = "Select * from VID ";
            PreparedStatement preparedStatement=connection.prepareStatement(v);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                vidd.add(rs.getString("vid"));
            }
            preparedStatement.close();
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }


        try {
            String g = "Select * from GRAD ";
            PreparedStatement preparedStatement=connection.prepareStatement(g);
            ResultSet rs1 = preparedStatement.executeQuery();

            while (rs1.next()) {
                cities.add(rs1.getString("GRAD"));
            }
            preparedStatement.close();
            rs1.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        try {
            String i = "Select  * from IZLOJENIE ";
            PreparedStatement preparedStatement=connection.prepareStatement(i);
            ResultSet rs2 = preparedStatement.executeQuery();

            while (rs2.next()) {
                izlojenie.add(rs2.getString("IZLOJENIE"));

            }
            preparedStatement.close();
            rs2.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        vid_id.setItems(vidd);
        city_id.setItems(cities);
        izl_id.setItems(izlojenie);

    }


    public void addOnAction() throws IOException, SQLException {

        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","USP","usp");
        Statement statement = connection.createStatement();
        try{
            String stai = stai_id.getText();
            String cena = price_id.getText();
            String viddd = vid_id.getValue();
            String gradd = city_id.getValue();
            String izll = izl_id.getValue();
            //String city  = vidd.
            String id = "select i.USERS_ID_USERS  from IMOTI i inner join USERS U on i.USERS_ID_USERS=u.ID_USERS";
            String imoti = ("INSERT INTO IMOTI (CENA,STAI,GRAD_ID_GRAD, IZLOJENIE_ID_IZLOJENIE, VID_ID_VID) VALUES ( '"+cena+"' , '"+stai+"','"+gradd+"','"+izll+"','"+viddd+"')");
            statement.executeUpdate(imoti);

            System.out.println("done");

        } catch (Exception e) {
            e.printStackTrace();
        }

        s.changeScene1("home.fxml");
    }


    }
