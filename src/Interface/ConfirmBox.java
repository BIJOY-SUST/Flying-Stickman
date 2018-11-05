package Interface;

import javafx.stage.*;
import javafx.util.Duration;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javafx.geometry.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
/*
    Confirm that this window is close or not
 */
public class ConfirmBox {

    static boolean answer;

    public static boolean confirmDisplay(String title, String message) throws Exception {
        File file = new File("highscore.txt");
        BufferedWriter bf = new BufferedWriter(new FileWriter(file));
        startingwindow.highScore = Integer.toString(startingwindow.hScore);
        bf.write(startingwindow.highScore);
        bf.close();

        Stage window = new Stage();
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.RED);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        Label label = new Label();
        label.setText(message);
        /*
            Create two buttons
         */
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        yesButton.setPrefHeight(30);
        yesButton.setPrefWidth(60);
        noButton.setPrefHeight(30);
        noButton.setPrefWidth(60);
        noButton.setStyle("-fx-background-color : #E80C0C");
        yesButton.setStyle("-fx-background-color : #34E80C");

        /*
        Clicking will set answer and close window
         */
        yesButton.setOnAction(e -> {
            if (MainWindow.choiceOfSound.equals("On")) {
                MainWindow.Clicksound.play();
            }
            answer = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            if (MainWindow.choiceOfSound.equals("On")) {
                MainWindow.Clicksound.play();
            }
            answer = false;
            window.close();
        });
        noButton.setOnMouseEntered(e -> {
            shadow.setColor(Color.GREEN);
            noButton.setEffect(shadow);
        });
        noButton.setOnMouseExited(e -> {
            shadow.setColor(Color.RED);
            noButton.setEffect(null);
        });
        yesButton.setOnMouseEntered(e -> {
            yesButton.setEffect(shadow);
        });
        yesButton.setOnMouseExited(e -> {
            yesButton.setEffect(null);
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300, 200);
        scene.getStylesheets().add("confirm.css");
        window.setScene(scene);
        window.setResizable(false);
        window.showAndWait();
        return answer;
    }
}
