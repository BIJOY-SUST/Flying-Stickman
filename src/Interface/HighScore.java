package Interface;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
public class HighScore {

    // Create variable
    static boolean answer;

    public static void score() {

        Stage window = new Stage();
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.RED);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Highscore");
        Label label = new Label();
        label.setText(startingwindow.highScore);
        label.setStyle("-fx-font-weight:900; -fx-font-size : 80;-fx-text-fill : blue");

        Button close = new Button("Close");
        close.setStyle("-fx-text-fill : white ; -fx-background-color : #022346");

        close.setOnMouseEntered(e -> {
            close.setStyle("-fx-background-color : #06DC2D ; -fx-text-fill : white");
            close.setEffect(shadow);
        });
        close.setOnMouseExited(e -> {
            close.setStyle("-fx-background-color : #022346 ; -fx-text-fill : white");
            close.setEffect(null);
        });
        close.setOnAction(e -> {
            window.close();
        });

        VBox layout = new VBox(20);

        layout.getChildren().addAll(label, close);

        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.setResizable(false);
        window.showAndWait();

    }
}
