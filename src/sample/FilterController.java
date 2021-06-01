package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import java.io.IOException;
import java.sql.*;


public class FilterController {
    @FXML
    private Button backButton;
    @FXML
    private Button searchButton;
    @FXML
    private ComboBox<String> vid_id;
    @FXML
    private ComboBox<String> city_id;
    @FXML
    private ComboBox<String> izl_id;
    @FXML
    private TextField stai_id;
    @FXML
    private  TextField cena_id;

    Main s = new Main();
    final ObservableList<String> cities = FXCollections.observableArrayList();
    final ObservableList<String> izlojenie = FXCollections.observableArrayList();
    final ObservableList<String> vidd =FXCollections.observableArrayList();

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


    public void backOnAction() throws IOException, SQLException {
        s.changeScene1("home.fxml");


    }

    public void searchOnAction(ActionEvent actionEvent) throws IOException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","USP","usp");
        Statement statement = connection.createStatement();
        try{
            String viddd = vid_id.getValue();
            String gradd = city_id.getValue();
            String izll = izl_id.getValue();
           // String id = "select i.USERS_ID_USERS  from IMOTI i inner join USERS U on i.USERS_ID_USERS=u.ID_USERS";
            //String grad = "select i.grad_id_grad, g.grad from imoti i inner join grad g on i.grad_id_grad=g.id_grad ";
            //statement.executeQuery(grad);
            //String imotii = ("INSERT INTO IMOTI (GRAD_ID_GRAD, IZLOJENIE_ID_IZLOJENIE, VID_ID_VID) VALUES ('"+grad+"','"+izll+"','"+viddd+"')");
            //statement.executeUpdate(imotii);

            System.out.println("done");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
