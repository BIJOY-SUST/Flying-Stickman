package Interface;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
public class EggBombLife {

    static ImageView iv[];
    static Circle cir[];
    static Timeline timeline1, timeline2, timeline3, timeline4, timeline5, timeline6, timeline7, timeline8, timeline9, timeline10, timeline11, timeline12;
    static int x, time = 1000;
    static Image img2;

    static void move() {
        iv = new ImageView[12];
        cir = new Circle[12];
        Image img = new Image("egg.png");
        Image img1 = new Image("life.png");
        img2 = new Image("bomb.png");

        for (int i = 0; i < 12; i++) {
            iv[i] = new ImageView();
            cir[i] = new Circle();
            cir[i].setFill(Color.TRANSPARENT);
            //cir[i].setStroke(Color.BLACK);
            //cir[i].setStrokeWidth(2);
            if (i == 2 || i == 4 || i == 11 || i == 6 || i == 9) {
                cir[i].setRadius(13);
            } else {
                cir[i].setRadius(10);
            }
            Game.Layout.getChildren().add(iv[i]);
            Game.Layout.getChildren().add(cir[i]);
        }
        for (int i = 0; i < 12; i++) {
            iv[i].setImage(img);
            iv[i].setVisible(false);
            iv[i].setFitWidth(35);
            iv[i].setPreserveRatio(true);
        }
        iv[2].setImage(img2);//Bomb
        iv[4].setImage(img2);//Bomb
        iv[6].setImage(img2);//Bomb
        iv[9].setImage(img2);//Bomb
        iv[11].setImage(img1);//Life
        iv[11].setFitWidth(30);
        for (int i = 0; i < 12; i++) {
            iv[i].setTranslateX(-10);
        }

        timeline1 = new Timeline(new KeyFrame(Duration.millis(time), e -> {
            if (iv[0].getTranslateX() <= -10 && !Game.GameOver) {
                iv[0].setVisible(true);
                iv[0].setTranslateX(Game.iv4.getTranslateX() - 20);
                iv[0].setTranslateY(Game.iv4.getTranslateY() + 20);
            }
            time = 7000;
            timeline2 = new Timeline(new KeyFrame(Duration.millis(800), e1 -> {
                if (iv[1].getTranslateX() <= -10 && !Game.GameOver) {
                    iv[1].setVisible(true);
                    iv[1].setTranslateX(Game.iv4.getTranslateX() - 20);
                    iv[1].setTranslateY(Game.iv4.getTranslateY() + 20);
                }

                timeline3 = new Timeline(new KeyFrame(Duration.millis(800), e2 -> {
                    if (iv[2].getTranslateX() <= -10 && !Game.GameOver) {
                        iv[2].setVisible(true);
                        iv[2].setTranslateX(Game.iv4.getTranslateX() - 20);
                        iv[2].setTranslateY(Game.iv4.getTranslateY() + 20);
                    }
                    timeline4 = new Timeline(new KeyFrame(Duration.millis(800), e3 -> {
                        if (iv[3].getTranslateX() <= -10 && !Game.GameOver) {
                            iv[3].setVisible(true);
                            iv[3].setTranslateX(Game.iv4.getTranslateX() - 20);
                            iv[3].setTranslateY(Game.iv4.getTranslateY() + 20);
                        }
                        timeline5 = new Timeline(new KeyFrame(Duration.millis(800), e4 -> {
                            if (iv[4].getTranslateX() <= -10 && !Game.GameOver) {
                                iv[4].setVisible(true);
                                iv[4].setTranslateX(Game.iv4.getTranslateX() - 20);
                                iv[4].setTranslateY(Game.iv4.getTranslateY() + 20);
                            }
                            timeline6 = new Timeline(new KeyFrame(Duration.millis(800), e5 -> {
                                if (iv[5].getTranslateX() <= -10 && !Game.GameOver) {
                                    iv[5].setVisible(true);
                                    iv[5].setTranslateX(Game.iv4.getTranslateX() - 20);
                                    iv[5].setTranslateY(Game.iv4.getTranslateY() + 20);
                                }
                                timeline7 = new Timeline(new KeyFrame(Duration.millis(800), e6 -> {
                                    if (iv[6].getTranslateX() <= -10 && !Game.GameOver) {
                                        iv[6].setVisible(true);
                                        iv[6].setTranslateX(Game.iv4.getTranslateX() - 20);
                                        iv[6].setTranslateY(Game.iv4.getTranslateY() + 20);
                                    }
                                    timeline8 = new Timeline(new KeyFrame(Duration.millis(800), e7 -> {
                                        if (iv[7].getTranslateX() <= -10 && !Game.GameOver) {
                                            iv[7].setVisible(true);
                                            iv[7].setTranslateX(Game.iv4.getTranslateX() - 20);
                                            iv[7].setTranslateY(Game.iv4.getTranslateY() + 20);
                                        }
                                        timeline9 = new Timeline(new KeyFrame(Duration.millis(800), e8 -> {
                                            if (iv[8].getTranslateX() <= -10 && !Game.GameOver) {
                                                iv[8].setVisible(true);
                                                iv[8].setTranslateX(Game.iv4.getTranslateX() - 20);
                                                iv[8].setTranslateY(Game.iv4.getTranslateY() + 20);
                                            }
                                            timeline10 = new Timeline(new KeyFrame(Duration.millis(800), e9 -> {
                                                if (iv[9].getTranslateX() <= -10 && !Game.GameOver) {
                                                    iv[9].setVisible(true);
                                                    iv[9].setTranslateX(Game.iv4.getTranslateX() - 20);
                                                    iv[9].setTranslateY(Game.iv4.getTranslateY() + 20);
                                                }
                                                timeline11 = new Timeline(new KeyFrame(Duration.millis(800), e10 -> {
                                                    if (iv[10].getTranslateX() <= -10 && !Game.GameOver) {
                                                        iv[10].setVisible(true);
                                                        iv[10].setTranslateX(Game.iv4.getTranslateX() - 20);
                                                        iv[10].setTranslateY(Game.iv4.getTranslateY() + 20);
                                                    }
                                                }));
                                                timeline11.setCycleCount(1);
                                                timeline11.play();
                                            }));
                                            timeline10.setCycleCount(1);
                                            timeline10.play();
                                        }));
                                        timeline9.setCycleCount(1);
                                        timeline9.play();
                                    }));
                                    timeline8.setCycleCount(1);
                                    timeline8.play();
                                }));
                                timeline7.setCycleCount(1);
                                timeline7.play();
                            }));
                            timeline6.setCycleCount(1);
                            timeline6.play();
                        }));
                        timeline5.setCycleCount(1);
                        timeline5.play();
                    }));
                    timeline4.setCycleCount(1);
                    timeline4.play();
                }));
                timeline3.setCycleCount(1);
                timeline3.play();
            }));
            timeline2.setCycleCount(1);
            timeline2.play();
        }));
        timeline1.setCycleCount(Timeline.INDEFINITE);
        timeline1.play();
        Random dice = new Random();

        timeline12 = new Timeline(new KeyFrame(Duration.millis(800), e -> {
            x = dice.nextInt(20);
            if (x == 10 && iv[11].getTranslateX() <= -10 && !Game.GameOver) {
                iv[11].setVisible(true);
                iv[11].setTranslateX(Game.iv4.getTranslateX() - 20);
                iv[11].setTranslateY(Game.iv4.getTranslateY() + 20);
            }
        }));
        timeline12.setCycleCount(Timeline.INDEFINITE);
        timeline12.play();

    }
}
