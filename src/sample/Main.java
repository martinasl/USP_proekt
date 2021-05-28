package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage stage;


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setResizable(true);
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("login");
        primaryStage.setScene(new Scene(root,640,400));
        primaryStage.show();
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stage.getScene().setRoot(pane);

    }
    public void changeScene1(String fxml) throws IOException {
        stage.setResizable(true);
        Parent pane = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage.setTitle("Home");
        stage.setScene(new Scene(pane,350,640));
        stage.show();


    }
    public void changeScene2(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("add.fxml"));
        stage.setResizable(true);
        stage.setTitle("Add");
        stage.setScene(new Scene(pane,378,521));


    }
    public void changeScene3(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stage.setScene(new Scene(pane,640,400));
        stage.setResizable(true);
        stage.setTitle("Registration");
    }



        public static void main(String[] args) {
        launch(args);
    }

}
