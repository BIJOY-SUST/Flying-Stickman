package Interface;

import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.AudioSpectrumListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Translate;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * This is the main window which contain several button.
 */
public class MainWindow {

    static String choiceOfSound = "On";
    static String choiceOfMode = "Easy";
    static AudioClip Clicksound, Sound, audio1, audio2, audio3;
    static Scene scene;
    static TranslateTransition transition, transition1;
    static Button playAgain;
    static boolean result;

    public static void Main() {

        Button newgame, setting, exit, highscore;
        DropShadow shadow = new DropShadow();
        DropShadow shadow1 = new DropShadow();
        shadow1.setColor(Color.DARKRED);
        shadow.setColor(Color.RED);
        /**
         * Media.
         * Just a working compilation of what the other answers say:

            String musicFile = "StayTheNight.mp3";     // For example

            Media sound = new Media(new File(musicFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
            Add the music file in your Project folder, alongside bin and src.

            Any IDE will prompt you to add these as well:

            import javafx.scene.media.Media;
            import javafx.scene.media.MediaPlayer;
            import java.io.File;
            Works like a charm.
         */
//            * C:\Users\BIJOY\Documents\GitHub\Flying-Stickman-Game-With-JavaFX\src

        Sound = new AudioClip("file:///C:/Users/BIJOY/Documents/GitHub/Flying-Stickman-Game-With-JavaFX/src/sound.mp3");
        Sound.setCycleCount(Sound.INDEFINITE);
        Sound.setVolume(1);
        Clicksound = new AudioClip("file:///C:/Users/BIJOY/Documents/GitHub/Flying-Stickman-Game-With-JavaFX/src/click3.mp3");
        audio1 = new AudioClip("file:///C:/Users/BIJOY/Documents/GitHub/Flying-Stickman-Game-With-JavaFX/src/bonus.mp3");
        audio1.setVolume(1);
        audio2 = new AudioClip("file:///C:/Users/BIJOY/Documents/GitHub/Flying-Stickman-Game-With-JavaFX/src/fail.mp3");
        audio2.setVolume(1);
        audio3 = new AudioClip("file:///C:/Users/BIJOY/Documents/GitHub/Flying-Stickman-Game-With-JavaFX/src/failfinal.mp3");
        audio3.setVolume(1);

        if (choiceOfSound == "On") {
            Sound.play();
        }

        /*
            Button
         */
        playAgain = new Button("Play Again");
        playAgain.setTranslateX(540);
        playAgain.setTranslateY(400);
        playAgain.setPrefHeight(40);
        playAgain.setPrefWidth(300);
        //playAgain.setVisible(false);
        playAgain.setStyle("-fx-background-color : transparent; -fx-font-size : 40 ; -fx-text-fill: blue ; -fx-font-weight : 900");
        playAgain.setOnMouseEntered(e -> {
            playAgain.setStyle("-fx-background-color : #06DC2D ;-fx-font-size : 40 ; -fx-text-fill: blue ; -fx-font-weight : 900");
            playAgain.setEffect(shadow);
        });
        playAgain.setOnMouseExited(e -> {
            playAgain.setStyle("-fx-background-color : transparent ; -fx-font-size : 40 ; -fx-text-fill: blue ; -fx-font-weight : 900");
            playAgain.setEffect(null);
        });
        playAgain.setOnMouseClicked(e -> {
            MainWindow.audio3.stop();
            if (choiceOfSound.equals("On")) {
                //Clicksound.seek(Duration.ZERO);
                Clicksound.play();
                MainWindow.Sound.stop();
                MainWindow.Sound.play();

            }
            Game.Start();
            startingwindow.window.setScene(Game.scene);

        });

        newgame = new Button("New Game");
        newgame.setPrefHeight(80);
        newgame.setPrefWidth(300);
        /*
            newgame.setFont(new Font("Bold",30));
            newgame.setTextFill(Color.BLUE);
            newgame.setStyle("-fx-background-radius : 60");
            newgame.setStyle("-fx-background-color : #33F6FF");
            newgame.setEffect(shadow);
         */
        newgame.setOnMouseEntered(e -> {
            newgame.setStyle("-fx-background-color : #06DC2D");
            newgame.setEffect(shadow);
        });
        newgame.setOnMouseExited(e -> {
            newgame.setStyle("-fx-background-color : #022346");
            newgame.setEffect(null);
        });
        newgame.setOnMouseClicked(e -> {
            if (choiceOfSound.equals("On")) {
                Clicksound.play();
                MainWindow.Sound.stop();
                MainWindow.Sound.play();

            }
            transition.stop();
            transition1.stop();
            Game.Start();
            startingwindow.window.setScene(Game.scene);
        });
        newgame.setLayoutX(-100);
        newgame.setLayoutY(290);
        TranslateTransition ng = new TranslateTransition(Duration.seconds(2), newgame);
        ng.setByX(160);
        ng.setByY(0);
        ng.setCycleCount(1);
        ng.play();
        RotateTransition ng1 = new RotateTransition(Duration.seconds(2), newgame);
        ng1.setCycleCount(1);
        ng1.setByAngle(360);
        ng1.setDelay(Duration.seconds(0));
        ng1.setRate(1);
        ng1.play();

        setting = new Button("Settings");
        setting.setPrefHeight(80);
        setting.setPrefWidth(300);
        setting.setOnAction(e -> {
            if (choiceOfSound == "On") {
                Clicksound.play();
            }
            Settings.display("Settings");
        });

        setting.setOnMouseEntered(e -> {
            setting.setStyle("-fx-background-color : #06DC2D");
            setting.setEffect(shadow);
        });
        setting.setOnMouseExited(e -> {
            setting.setStyle("-fx-background-color : #022346");
            setting.setEffect(null);
        });
        /*
            setting.setLayoutX(-100);
            setting.setLayoutY(410);
         */
        setting.relocate(-100, 410);
        TranslateTransition st = new TranslateTransition(Duration.seconds(2), setting);
        st.setToX(160);
        st.setToY(0);
        st.setCycleCount(1);
        st.play();
        RotateTransition st1 = new RotateTransition(Duration.seconds(2), setting);
        st1.setCycleCount(1);
        st1.setByAngle(360);
        st1.setDelay(Duration.seconds(0));
        st1.setRate(1);
        st1.play();

        exit = new Button("Exit");
        exit.setPrefHeight(80);
        exit.setPrefWidth(300);
        exit.setOnAction(e -> {
            if (choiceOfSound == "On") {
                Clicksound.play();
            }
            try {
                result = ConfirmBox.confirmDisplay("Confirm", "Are you sure ?");
            } catch (Exception ex1) {
            };

            if (result == true) {
                startingwindow.window.close();
            }
        });
        exit.setOnMouseEntered(e -> {
            exit.setStyle("-fx-background-color : #06DC2D");
            exit.setEffect(shadow);
        });
        exit.setOnMouseExited(e -> {
            exit.setStyle("-fx-background-color : #022346");
            exit.setEffect(null);
        });
        exit.setLayoutX(-100);
        exit.setLayoutY(650);
        TranslateTransition ex = new TranslateTransition(Duration.seconds(2), exit);
        ex.setToX(160);
        ex.setToY(0);
        ex.setCycleCount(1);
        ex.play();
        RotateTransition ex1 = new RotateTransition(Duration.seconds(2), exit);
        ex1.setCycleCount(1);
        ex1.setByAngle(360);
        ex1.setDelay(Duration.seconds(0));
        ex1.setRate(1);
        ex1.play();

        highscore = new Button("Highscore");
        highscore.setPrefHeight(80);
        highscore.setPrefWidth(300);
        highscore.setOnMouseEntered(e -> {
            highscore.setStyle("-fx-background-color : #06DC2D");
            highscore.setEffect(shadow);
        });
        highscore.setOnMouseExited(e -> {
            highscore.setStyle("-fx-background-color : #022346");
            highscore.setEffect(null);
        });
        highscore.setOnAction(e -> {
            if (choiceOfSound == "On") {
                Clicksound.play();
                HighScore.score();
            }
        });
        highscore.setLayoutX(-100);
        highscore.setLayoutY(530);
        TranslateTransition hs = new TranslateTransition(Duration.seconds(2), highscore);
        hs.setToX(160);
        hs.setToY(0);
        hs.setCycleCount(1);
        hs.play();
        RotateTransition hs1 = new RotateTransition(Duration.seconds(2), highscore);
        hs1.setCycleCount(1);
        hs1.setByAngle(360);
        hs1.setDelay(Duration.seconds(0));
        hs1.setRate(1);
        hs1.play();

        /*
            Label
         */
        Label nameLabel = new Label("Flying  StickMan");
        nameLabel.setLayoutX(0);
        nameLabel.setLayoutY(0);
        TranslateTransition nl = new TranslateTransition(Duration.seconds(2), nameLabel);
        nl.setToX(450);
        nl.setToY(150);
        nl.setCycleCount(1);
        nl.play();

        /*
            backgroundimage
         */
        BackgroundImage myBI = new BackgroundImage(new Image("backk.jpg", 1420, 750, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        /*
            Image
         */
        Image img3 = new Image("sun.png");
        ImageView iv3 = new ImageView(img3);
        iv3.relocate(900, 140);
        iv3.setPreserveRatio(true);
        iv3.setFitWidth(80);

        Image image = new Image("stickman.png");
        ImageView iv = new ImageView();
        iv.setImage(image);
        // iv.setRotate(90);
        iv.setPreserveRatio(true);
        iv.setFitWidth(300);
        iv.setLayoutX(1461);
        iv.setLayoutY(30);

        /*
            Moving Image
         */
        TranslateTransition tt1 = new TranslateTransition(Duration.seconds(2), iv);
        tt1.setToX(-1461);
        tt1.setToY(0);
        tt1.setCycleCount(1);
        tt1.play();
        RotateTransition tt2 = new RotateTransition(Duration.seconds(2), iv);
        tt2.setCycleCount(1);
        tt2.setByAngle(360);
        tt2.setDelay(Duration.seconds(0));
        tt2.setRate(1);
        tt2.play();

        Timeline time2 = new Timeline(new KeyFrame(Duration.millis(2000), e1
                -> {
            transition = new TranslateTransition();
            transition.setDuration(Duration.seconds(1));
            transition.setAutoReverse(true);
            /**
             * transition.setToX(-1481); transition.setToY(10);
             */
            transition.setByX(20);
            transition.setByY(-20);
            transition.setNode(iv);
            transition.setCycleCount(Animation.INDEFINITE);
            transition.play();
        }));
        time2.play();
        time2.setCycleCount(1);

        /*
            image1
         */
        Image image1 = new Image("bird.png");
        ImageView iv1 = new ImageView();
        iv1.setImage(image1);
        iv1.setPreserveRatio(true);
        iv1.setFitWidth(300);
        iv1.setLayoutX(0);
        iv1.setLayoutY(35);

        /*
            moving image2
         */
        TranslateTransition t1 = new TranslateTransition(Duration.seconds(2), iv1);
        t1.setToX(1200);
        t1.setToY(35);
        t1.setCycleCount(1);
        t1.play();
        RotateTransition t2 = new RotateTransition(Duration.seconds(2), iv1);
        t2.setCycleCount(1);
        t2.setByAngle(360);
        t2.setDelay(Duration.seconds(0));
        t2.setRate(1);
        t2.play();

        /*
            moving object2
         */
        Timeline time1 = new Timeline(new KeyFrame(Duration.millis(2000), e1
                -> {
            transition1 = new TranslateTransition();
            transition1.setDuration(Duration.seconds(1));
            transition1.setAutoReverse(true);
            transition1.setToX(1262.2);
            transition1.setToY(50.2);
            transition1.setNode(iv1);
            transition1.setCycleCount(Animation.INDEFINITE);
            transition1.play();
        }));
        time1.play();
        time1.setCycleCount(1);
        /*
            GridPane grid = new GridPane();
            grid.setPadding(new Insets(0,0, 0,0));;
            grid.setAlignment(Pos.CENTER);
            grid.setVgap(8);
            grid.setHgap(10);
            grid.setConstraints(iv,4,0);
            grid.setConstraints(iv1, 40, 0);
            grid.setConstraints(nameLabel, 20, 3);
            grid.setConstraints(newgame, 4, 5);
            grid.setConstraints(setting, 4, 6);
            grid.setConstraints(highscore, 4, 7);
            grid.setConstraints(exit, 4, 8);
            grid.getChildren().addAll(iv1, nameLabel, newgame, setting, exit, highscore);
            grid.setBackground(new Background(myBI));
            grid.setStyle("-fx-border-color : black;");
         */

        Pane Mainlayout = new Pane();
        Mainlayout.setStyle("-fx-border-color : black;");
        Mainlayout.getChildren().addAll(iv, iv1, newgame, highscore, exit, setting, iv3, nameLabel);
        Mainlayout.setBackground(new Background(myBI));

        scene = new Scene(Mainlayout, 1420, 750);
        scene.getStylesheets().add("viper.css");

        // closerequest
        startingwindow.window.setOnCloseRequest(e -> {
            e.consume();
            try {
                result = ConfirmBox.confirmDisplay("Confirm", "Are you sure ?");
            } catch (Exception ex2) {
            };
            if (result == true) {
                startingwindow.window.close();
            }
        });

    }
}
