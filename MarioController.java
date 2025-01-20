package com.example.aoop_assignment;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class MarioController{
    @FXML
    private ImageView marioImage;
    @FXML
    private ImageView mushroomImage1;
    @FXML
    private ImageView mushroomImage2;
    @FXML
    private ImageView mushroomImage3;

    @FXML
    public void ButtonUP() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                double marioY = marioImage.getY();
                marioImage.setImage(new Image("/MarioUp.png"));

                marioY = (marioY - 10) % 368;

                marioImage.setY(marioY);

                if (marioImage.getY() < -120) {
                    marioImage.setY(368);
                }

                checkCollisions();
            }
        });
    }

    @FXML
    public void ButtonDown() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                double marioY = marioImage.getY();
                marioImage.setImage(new Image("/MarioDown.png"));

                marioY = (marioY + 10) % 390;

                marioImage.setY(marioY);

                if (marioImage.getY() > 375) {
                    marioImage.setY(-130);
                }

                checkCollisions();
            }
        });
    }

    @FXML
    public void ButtonLeft() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                double marioX = marioImage.getX();
                marioImage.setImage(new Image("/MarioLeft.png"));

                marioX = (marioX - 10) % 340;

                marioImage.setX(marioX);

                if (marioImage.getX() < -320) {
                    marioImage.setX(320);
                }

                checkCollisions();
            }
        });
    }

    @FXML
    public void ButtonRight() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                double marioX = marioImage.getX();
                marioImage.setImage(new Image("/MarioRight.png"));

                marioX = (marioX + 10) % 340;
                marioImage.setX(marioX);

                if (marioImage.getX() > 320) {
                    marioImage.setX(-320);
                }

                checkCollisions();
            }
        });
    }

    private void checkCollisions() {
        if (marioImage.getBoundsInParent().intersects(mushroomImage1.getBoundsInParent())) {
            mushroomImage1.setX(-100000);
        }

        if (marioImage.getBoundsInParent().intersects(mushroomImage2.getBoundsInParent())) {
            mushroomImage2.setX(-10000);
        }

        if (marioImage.getBoundsInParent().intersects(mushroomImage3.getBoundsInParent())) {
            mushroomImage3.setX(+100000);
        }
    }
}
