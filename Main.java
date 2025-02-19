package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;


public class Main extends Application {
    public static void main(String[] args) {
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Mario.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Mario Game");
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
