package Interface;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;


public class Settings {

    public static void display(String title) {
        Stage window = new Stage();
        // Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.RED);
        //circle
        Circle cir = new Circle();
        cir.setRadius(20);
        //cir.setFill(Color.BLACK);
        cir.setLayoutX(50);
        cir.setLayoutY(350);
        //cir.setStrokeWidth(10);
        //cir.setStroke(Color.BROWN);
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(3));
        transition.setAutoReverse(true);
        transition.setToX(550);
        transition.setToY(0);
        transition.setNode(cir);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.play();
        Circle cir1 = new Circle();
        cir1.setRadius(20);
        //cir1.setFill(Color.BLACK);
        cir1.setLayoutX(600);
        cir1.setLayoutY(50);
        //cir1.setStrokeWidth(10);
        //cir1.setStroke(Color.BROWN);
        TranslateTransition transition1 = new TranslateTransition();
        transition1.setDuration(Duration.seconds(3));
        transition1.setAutoReverse(true);
        transition1.setToX(50);
        transition1.setToY(250);
        transition1.setNode(cir1);
        transition1.setCycleCount(Animation.INDEFINITE);
        transition1.play();
//		StrokeTransition stroke = new StrokeTransition(Duration.seconds(3),cir,Color.BLACK,Color.BEIGE);
//		stroke.setAutoReverse(true);
//		stroke.setCycleCount(StrokeTransition.INDEFINITE);
//		stroke.play();
//		StrokeTransition stroke1 = new StrokeTransition(Duration.seconds(3),cir1,Color.BLACK,Color.BLUE);
//		stroke1.setAutoReverse(true);
//		stroke1.setCycleCount(StrokeTransition.INDEFINITE);
//		stroke1.play();
        FillTransition fill = new FillTransition(Duration.seconds(3), cir, Color.BLACK, Color.BEIGE);
        fill.setAutoReverse(false);
        fill.setCycleCount(FillTransition.INDEFINITE);
        fill.play();
        FillTransition fill1 = new FillTransition(Duration.seconds(3), cir1, Color.BEIGE, Color.BLACK);
        fill1.setAutoReverse(false);
        fill1.setCycleCount(FillTransition.INDEFINITE);
        fill1.play();
        ScaleTransition scale = new ScaleTransition(Duration.seconds(3), cir);
        scale.setAutoReverse(false);
        scale.setToX(2);
        scale.setToY(2);
        scale.setCycleCount(ScaleTransition.INDEFINITE);
        scale.play();
        ScaleTransition scale1 = new ScaleTransition(Duration.seconds(3), cir1);
        scale1.setAutoReverse(false);
        scale1.setCycleCount(ScaleTransition.INDEFINITE);
        scale1.setToX(2);
        scale1.setToY(2);
        scale1.play();

        Label label = new Label();
        label.setText("Sound");
        label.setFont(new Font("Arial", 30));
        Label label1 = new Label();
        label1.setText("Mode");
        label1.setFont(new Font("Arial", 30));
        label1.setTextFill(Color.AQUA);
        label.setTextFill(Color.AQUA);

        //RadioMenuItem item = new RadioMenuItem();
        // Button
        Button closee = new Button("Close");
        closee.setPrefHeight(30);
        closee.setPrefWidth(60);
        Button save = new Button("Save");
        save.setPrefHeight(10);
        save.setPrefWidth(50);
        save.setPrefHeight(30);
        save.setPrefWidth(60);
        closee.setPrefHeight(30);
        closee.setPrefWidth(60);
//		save.setFont(new Font("Bold", 15));
//		closee.setFont(new Font("Bold", 15));
        closee.setOnMouseEntered(e -> {
            closee.setStyle("-fx-background-color : #06DC2D");
            closee.setEffect(shadow);
        });
        closee.setOnMouseExited(e -> {
            closee.setStyle("-fx-background-color : #FFFFFF");
            closee.setEffect(null);
        });
        save.setOnMouseEntered(e -> {
            save.setStyle("-fx-background-color : #06DC2D");
            save.setEffect(shadow);
        });
        save.setOnMouseExited(e -> {
            save.setStyle("-fx-background-color : #FFFFFF");
            save.setEffect(null);

        });

        ChoiceBox<String> sound = new ChoiceBox<>();
        // getItems returns the ObservableList object which you can add items to
        sound.getItems().add("On");
        sound.getItems().add("Off");
        // Set a default value
        sound.setValue(MainWindow.choiceOfSound);

        ChoiceBox<String> difficulty = new ChoiceBox<>();
        // getItems returns the ObservableList object which you can add items to
        difficulty.getItems().add("Easy");
        difficulty.getItems().add("Medium");
        difficulty.getItems().add("Hard");
        // Set a default value
        difficulty.setValue(MainWindow.choiceOfMode);

        // Button action
        save.setOnAction(e -> {
            if (sound.getValue().equals("On") && MainWindow.choiceOfSound.equals("Off")) {
                MainWindow.Sound.play();
            }
            MainWindow.choiceOfSound = sound.getValue();
            if (MainWindow.choiceOfSound.equals("On")) {
                //MainWindow.mediaplayer.seek(Duration.ZERO);
                MainWindow.Clicksound.play();
            } else {
                MainWindow.Sound.stop();
            }
            MainWindow.choiceOfMode = difficulty.getValue();
        });
        closee.setOnAction(e -> {
            if (MainWindow.choiceOfSound.equals("On")) {
                //MainWindow.mediaplayer.seek(Duration.ZERO);
                MainWindow.Clicksound.play();;
            }
            fill1.stop();
            transition1.stop();
            scale1.stop();
            fill.stop();
            transition.stop();
            scale.stop();
            window.close();
        });

        GridPane grid = new GridPane();
        //grid.setPadding(new Insets(50, 0, 0, 150));
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(8);
        grid.setHgap(10);
        // grid.setConstraints(iv,40,0);
        grid.setConstraints(label, 3, 1);
        grid.setConstraints(sound, 3, 3);
        grid.setConstraints(label1, 8, 1);
        grid.setConstraints(difficulty, 8, 3);
        grid.setConstraints(save, 3, 10);
        grid.setConstraints(closee, 4, 10);
        grid.getChildren().addAll(label, sound, save, closee, label1, difficulty);

        // Background
//		BackgroundImage myBI = new BackgroundImage(new Image("settings.jpg", 1520, 800, false, true),
//				BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
//				BackgroundSize.DEFAULT);
//		grid.setBackground(new Background(myBI));
        // Display window and wait for it to be closed before returning
        Pane Mainlayout = new Pane();
        Mainlayout.getChildren().addAll(grid, cir, cir1);
        grid.prefWidthProperty().bind(Mainlayout.widthProperty());
        grid.prefHeightProperty().bind(Mainlayout.heightProperty());
        Scene scene = new Scene(Mainlayout, 800, 400);
        scene.getStylesheets().add("Alert.css");
        window.setScene(scene);
        window.setResizable(false);
        window.showAndWait();
    }
}
