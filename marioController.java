package application;


import javafx.fxml.FXML;
//import javafx.scene.image.Image;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class marioController {
@FXML
private ImageView mario;

@FXML
private ImageView mas1;
@FXML
private ImageView mas2;
@FXML
private ImageView mas3;
//private double x,y;

@FXML
public void upButton() {
	
	String imageUrl = getClass().getResource("MarioUp.png").toExternalForm();
	Image marioImage = new Image(imageUrl);
	mario.setImage(marioImage);
	double marioY = mario.getY();
    marioY = (marioY - 10) % 368;
    mario.setY(marioY);

    if (mario.getY() < -200) {
        mario.setY(250);
    }
	checkCollisions();
}
@FXML
public void downButton() {
	String imageUrl = getClass().getResource("MarioDown.png").toExternalForm();
	Image marioImage = new Image(imageUrl);
	mario.setImage(marioImage);
	double marioY = mario.getY();
     marioY = (marioY + 10) % 390;
     mario.setY(marioY);
     if (mario.getY() > 278) {
        mario.setY(-190);
    }

	checkCollisions();
	
}
@FXML
public void rightButton() {
	String imageUrl = getClass().getResource("MarioRight.png").toExternalForm();
	Image marioImage = new Image(imageUrl);
	mario.setImage(marioImage);
	 double marioX = mario.getX();
    

     marioX = (marioX + 10) % 340;
     mario.setX(marioX);

     if (mario.getX() > 320) {
         mario.setX(-280);
     }

	checkCollisions();
}
@FXML
public void leftButton() {
	String imageUrl = getClass().getResource("MarioLeft.png").toExternalForm();
	Image marioImage = new Image(imageUrl);
	mario.setImage(marioImage);
	 double marioX = mario.getX();
     marioX = (marioX - 10) % 340;
     mario.setX(marioX);

     if (mario.getX() < -290) {
         mario.setX(320);
     }

	checkCollisions();
}

private void checkCollisions() {
    if (mario.getBoundsInParent().intersects(mas1.getBoundsInParent())) {
        mas1.setX(-100000);
    }

    if (mario.getBoundsInParent().intersects(mas2.getBoundsInParent())) {
        mas2.setX(-10000);
    }

    if (mario.getBoundsInParent().intersects(mas3.getBoundsInParent())) {
        mas3.setX(+100000);
    }
}
	
	
}

