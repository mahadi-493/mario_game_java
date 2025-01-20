package com.example.aoop_assignment;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MarioApplication extends Application {
    private double xOffset = 0;
    private double yOffset = 0;
    @Override
    public void start(Stage stage) throws IOException {
        Platform.runLater(() -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(MarioApplication.class.getResource("Mario.fxml"));
                Parent root0 = fxmlLoader.load();
                root0.setOnMousePressed((MouseEvent event) -> {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                });
                root0.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                });
                Scene scene0 = new Scene(root0,600,400);
                stage.getIcons().add(new Image("/Mario.png"));
                stage.setTitle("AOOP Assignment ---- Mario Game");
                stage.setScene(scene0);
                stage.setResizable(false);
                stage.show();
            }catch (Throwable e){
                e.printStackTrace();
            }
        });
    }
    public static void main(String[] args) {
        launch();
    }
}