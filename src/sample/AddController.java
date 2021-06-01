package sample;

import com.sun.javafx.scene.layout.region.Margins;
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
                vidd.addAll(rs.getString("vid"));
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
                //cities.add(rs1.getString("ID_GRAD"));
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
            String id = "select i.USERS_ID_USERS  from IMOTI i inner join USERS U on i.USERS_ID_USERS=u.ID_USERS";
            String grad = "select i.grad_id_grad, g.grad from imoti i inner join grad g on i.grad_id_grad=g.id_grad ";
            statement.executeQuery(grad);
            String imotii = ("INSERT INTO IMOTI (CENA,STAI,GRAD_ID_GRAD, IZLOJENIE_ID_IZLOJENIE, VID_ID_VID) VALUES ( '"+cena+"' , '"+stai+"','"+grad+"','"+izll+"','"+viddd+"')");
            statement.executeUpdate(imotii);

            System.out.println("done");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void backOnAction() throws IOException {
        s.changeScene1("home.fxml");
    }

    }
