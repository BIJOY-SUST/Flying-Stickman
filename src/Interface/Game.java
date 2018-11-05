package Interface;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
public class Game {
	static double x1, x2, x, y = 1, f = 1, backgroundw = 0, backgroundw1 = 1420,decre,speed;
	// static private final Timer timer = new Timer();
	// static private TimerTask timerTask;
	static int W = 1420, H = 750;
	static TranslateTransition transition = new TranslateTransition();
	static TranslateTransition transition1 = new TranslateTransition();
	static Timeline timeline2, timeline1, timeline3, timeline4, timeline5, timeline6,timeline7,timeline8;
	static boolean GameOver = false;
	static Scene scene;
	static int dice1Value, dice2Value,score,life;
	static double stickmanx,stickmany,stickmanx1,stickmany1,ex,ey;
	static ImageView iv4,ivegg;
	static Pane Layout;
	static String s,L;
	
	
	static void Start() {
		GameOver = false;
		score=0;
		life=0;
		speed=40;
		backgroundw = 0;
		backgroundw1 = 1420;
		if(MainWindow.choiceOfMode.equals("Easy")) {
			Game.decre=.1;
		}
		else if(MainWindow.choiceOfMode.equals("Medium")){
			Game.decre=.2;
			}
		else {
			Game.decre=.3;
		}
		// Stage
		// Stage window = new Stage();
		// window.initModality(Modality.APPLICATION_MODAL);
		// window.show();
		// window.setResizable(false);

		// Effect
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.RED);

		// Label
		Label gameover = new Label("GameOver!");
		gameover.setTranslateX(500);
		gameover.setTranslateY(200);
		gameover.setVisible(false);
		gameover.setEffect(shadow);
		s ="Score : "+Integer.toString(score);
		Label scoreLabel = new Label(s);
		//scoreLabel.setTranslateX(0);
		//scoreLabel.setTranslateY(0);
		scoreLabel.setStyle("-fx-font-size : 30 ;");
		L ="Life : "+Integer.toString(life);
		Label lifeLabel = new Label(L);
		lifeLabel.setStyle("-fx-font-size : 30");
		lifeLabel.setTranslateX(200);
		Label highScore = new Label();
		highScore.setStyle(" -fx-font-size : 40 ; -fx-text-fill: blue");
		highScore.setTranslateX(560);
		highScore.setTranslateY(300);
		
		// Image
		Image img = new Image("stickman.png");
		Image img1 = new Image("backk.jpg");
		Image img2 = new Image("backk1.jpg");
		Image img3 = new Image("sun.png");
		Image img4 = new Image("bird.png");
		Image img5 = new Image("stickman11.png");
		Image img6 = new Image("stickman22.png");
		Image img7 = new Image("bird1.png");
		ImageView iv = new ImageView(img);
		//iv.setPreserveRatio(true);
		iv.setFitWidth(200);
		iv.setFitHeight(300);
		iv.setTranslateX(0);
		iv.setTranslateY(200);

		ImageView iv3 = new ImageView(img3);
		iv3.relocate(900, 140);
		iv3.setPreserveRatio(true);
		iv3.setFitWidth(80);

		iv4 = new ImageView(img4);
		iv4.setTranslateX(1300);
		iv4.setTranslateY(200);
		iv4.setPreserveRatio(true);
		iv4.setFitWidth(200);

		ImageView iv1 = new ImageView(img1);
		ImageView iv2 = new ImageView(img2);
		// iv1.setPreserveRatio(true);
		iv1.setFitWidth(W);
		iv1.setFitHeight(H);
		iv2.setFitWidth(W);
		iv2.setFitHeight(H);
		iv1.setTranslateX(0);
		iv1.setTranslateY(0);
		iv2.setTranslateX(W);
		iv2.setTranslateY(0);

		// BUTTON
		
		Button close = new Button("Return to mainmenu");
		
		close.setTranslateX(1250);
		close.setTranslateY(720);
		close.setPrefHeight(20);
		close.setPrefWidth(160);
		close.setOnMouseEntered(e -> {
			close.setStyle("-fx-background-color : #06DC2D");
			close.setEffect(shadow);
		});
		close.setOnMouseExited(e -> {
			close.setStyle("-fx-background-color : #022346");
			close.setEffect(null);
		});
		close.setOnMouseClicked(e -> {
			
			timeline8.stop();
			timeline1.stop();
			timeline2.stop();
			timeline3.stop();
			timeline4.stop();
			timeline5.stop();
			timeline6.stop();
			timeline7.stop();
			EggBombLife.timeline1.stop();
			EggBombLife.timeline12.stop();
			MainWindow.transition.play();
			MainWindow.transition1.play();
			MainWindow.audio3.stop();
			if (MainWindow.choiceOfSound.equals("On")) {
				MainWindow.Clicksound.play();
			}
			//MainWindow.Main();
			startingwindow.window.setScene(MainWindow.scene);
			});
		
		
		// MenuBar
		MenuBar bar = new MenuBar();
		
		//rectangel
		Rectangle rec = new Rectangle();
		rec.setWidth(15);
		rec.setHeight(46);
		rec.setFill(Color.TRANSPARENT);
		
		
		// Layout
		Layout = new Pane(iv1, iv2, iv, iv3, gameover, iv4, close,rec,scoreLabel,lifeLabel);

		// Scene
		scene = new Scene(Layout, W, H);
		// window.setScene(scene);
		scene.getStylesheets().add("game.css");

		// timerTask = new TimerTask() {
		//
		// @Override
		// public void run() {
		// x=x+y;
		// if(x>600)x=600;
		// iv.setTranslateY(x);
		// }
		// };
		// timer.schedule(timerTask, 0L,5L);

		// BACKGROUND MOVING
		
		timeline3 = new Timeline(new KeyFrame(Duration.millis(speed), e2 -> {
			backgroundw--;
			if (backgroundw <= -1420)
				backgroundw = 1420;
			iv1.setTranslateX(backgroundw);
			backgroundw1--;
			if (backgroundw1 <= -1420)
				backgroundw1 = 1420;
			iv2.setTranslateX(backgroundw1);

		}));
		timeline3.setCycleCount(Timeline.INDEFINITE);
		timeline3.play();

		// STICKMAN'S MOVEMENT
		
		/////////////////////////////////////////////////////////////////////////////
		timeline2 = new Timeline(new KeyFrame(Duration.millis(10), e2 -> {
			x = x + 2;
			if (x > 540 && life <= 0) {
				//x = 540;
				gameover.setVisible(true);
				GameOver = true;						
				timeline8.stop();
				timeline1.stop();
				timeline2.stop();
				timeline3.stop();
				timeline4.stop();
				timeline5.stop();
				timeline6.stop();
				timeline7.stop();
				EggBombLife.timeline1.stop();
				EggBombLife.timeline12.stop();
				MainWindow.Sound.stop();
				if (MainWindow.choiceOfSound.equals("On")) {
					MainWindow.audio2.play();
					MainWindow.audio3.play();
				}
				if(score>startingwindow.hScore)startingwindow.hScore=score;
				startingwindow.highScore= Integer.toString(startingwindow.hScore);
				highScore.setText("Highscore : "+startingwindow.highScore);
				Layout.getChildren().addAll(MainWindow.playAgain,highScore);
			}
			else if(x > 540 && life > 0){
					life--;
					L ="Life : "+Integer.toString(life);
					lifeLabel.setText(L);
					x=200;
					MainWindow.audio2.play();
			}
			iv.setTranslateY(x);
			
		}));
		timeline2.setCycleCount(timeline2.INDEFINITE);
		timeline1 = new Timeline(new KeyFrame(Duration.millis(500), e1 -> {
			x = iv.getTranslateY();
			timeline2.play();
		}));
		timeline1.setCycleCount(1);

		// scene.setOnKeyPressed(e ->{
		scene.addEventFilter(KeyEvent.KEY_PRESSED, e -> { // setonkeypressed use korle scene e onno component thakle
															// oigula execute hoye jay
			if (e.getCode() == KeyCode.SPACE && !GameOver) {
				// y=0;
				// if(f==1) x=x-80;
				// else x=x-3;
				// if(x<-80)x=-80;
				// iv.setTranslateY(x);
				// f=0;
				// y=0;
				timeline2.stop();
				timeline1.stop();
				transition.stop();
				if (f == 1) {
					transition.setDuration(Duration.seconds(.5));
					transition.setByX(0);
					if (iv.getTranslateY() <= 10)
						x1 = (-110) - iv.getTranslateY();
					else
						x1 = -110;
					transition.setByY(x1);
					transition.setNode(iv);
					transition.setCycleCount(1);
					transition.play();
				} else {
					
					x = iv.getTranslateY();
					x = x - 3;
					if (x < -110)
						x = -110;
					iv.setTranslateY(x);
				}
				if(f>1)transition.stop();
				f++;
			}
		});
		// scene.setOnKeyReleased(e ->{
		scene.addEventFilter(KeyEvent.KEY_RELEASED, e -> {
			if (e.getCode() == KeyCode.SPACE && !GameOver) {
				// y=1;
				f = 1;
				timeline1.play();
			}
		});
//		scene.setOnMouseClicked(e -> {
//			System.out.println(iv.getTranslateX() + " " + iv.getTranslateY());
//			System.out.println(e.getX() + " " + e.getY());
//			System.out.println(EggBombLife.iv[8].getTranslateX()+" "+EggBombLife.iv[8].getTranslateY());
//			
//		});

		// BIRD AND STICKMAN CHANGE

		Random dice1 = new Random();
		Random dice2 = new Random();
		timeline6 = new Timeline(new KeyFrame(Duration.millis(500), e2 -> {
			//////
			decre+=0.001;
			if(speed>1)speed-=0.01;
			//////
			dice1Value = dice1.nextInt(2);
			dice2Value = dice2.nextInt(2);
			if (dice1Value == 0) {
				iv.setImage(img);
				;
			} else if (dice1Value == 1) {
				iv.setImage(img5);
				;
			}
//			else
//				iv.setImage(img6); 
			if (dice2Value == 0) {
				iv4.setImage(img4);
				;
			} else {
				iv4.setImage(img7);
				;
			}
			//System.out.println(iv.getTranslateX()+" "+iv.getTranslateY());
		}));
		timeline6.setCycleCount(Timeline.INDEFINITE);
		timeline6.play();

		/////////////////////////////////////////////////////////////////////////////

		// Bird's Movement
		timeline5 = new Timeline(new KeyFrame(Duration.millis(1), e2 -> {
			transition1.setDuration(Duration.seconds(.5));
			transition1.setByX(0);
			transition1.setNode(iv4);
			transition1.setCycleCount(1);
			transition1.play();
		}));
		timeline5.setCycleCount(1);

		Random dice = new Random();
		timeline4 = new Timeline(new KeyFrame(Duration.millis(1), e2 -> {
			if (dice.nextInt(2) == 0) {
				if (iv4.getTranslateY() + 100 <= 620)
					x2 = 100;
				else
					x2 = (620) - iv4.getTranslateY();
				transition1.setByY(x2);
			} else {
				if (iv4.getTranslateY() - 100 >= -10)
					x2 = -100;
				else
					x2 = (-10) - iv4.getTranslateY();
				transition1.setByY(x2);
			}
			timeline5.play();
		}));
		timeline4.setCycleCount(Timeline.INDEFINITE);
		timeline4.play();
		
		//Egg, Bomb , Lives movement
		
		EggBombLife.move();
		timeline7 = new Timeline(new KeyFrame(Duration.millis(1), e -> {
			for(int i=0;i<12;i++) {
			EggBombLife.iv[i].setTranslateX(EggBombLife.iv[i].getTranslateX()-decre);
			}
		}));
		timeline7.setCycleCount(timeline7.INDEFINITE);
		timeline7.play();
		
		//collision
		
		timeline8 = new Timeline(new KeyFrame(Duration.millis(1), e1 -> {
			for(int i=0;i<12;i++) {
				rec.setX(iv.getTranslateX()+130);
				rec.setY(iv.getTranslateY()+117);
				if(i==9 || i==4 || i==11) {
					EggBombLife.cir[i].setTranslateX(EggBombLife.iv[i].getTranslateX()+13);
					EggBombLife.cir[i].setTranslateY(EggBombLife.iv[i].getTranslateY()+22);
				}
				else if(i==8 || i==10) {
					EggBombLife.cir[i].setTranslateX(EggBombLife.iv[i].getTranslateX()+15);
					EggBombLife.cir[i].setTranslateY(EggBombLife.iv[i].getTranslateY()+11);
				}
				else {
					EggBombLife.cir[i].setCenterX(EggBombLife.iv[i].getTranslateX()+17);
					EggBombLife.cir[i].setCenterY(EggBombLife.iv[i].getTranslateY()+13);
				}
				
				if(rec.intersects(EggBombLife.cir[i].getBoundsInParent())){
					if(i==2 || i==4 || i==6 || i==9) {
						if(life>=1) {
							life--;
							L ="Life : "+Integer.toString(life);
							lifeLabel.setText(L);
							if (MainWindow.choiceOfSound.equals("On")) {
								MainWindow.audio2.play();
							}
						}
						else
						{
						gameover.setVisible(true);
						GameOver = true;
						timeline8.stop();
						timeline1.stop();
						timeline2.stop();
						timeline3.stop();
						timeline4.stop();
						timeline5.stop();
						timeline6.stop();
						timeline7.stop();
						EggBombLife.timeline1.stop();
						EggBombLife.timeline12.stop();
						MainWindow.Sound.stop();
						if (MainWindow.choiceOfSound.equals("On")) {
							MainWindow.audio2.play();
							MainWindow.audio3.play();
						}
						if(score>startingwindow.hScore)startingwindow.hScore=score;
						startingwindow.highScore= Integer.toString(startingwindow.hScore);
						highScore.setText("Highscore : "+startingwindow.highScore);
						Layout.getChildren().addAll(MainWindow.playAgain,highScore);
						}
						EggBombLife.iv[i].setTranslateX(-30);
						
					}
					else if(i==11) {
						life++;
						L ="Life : "+Integer.toString(life);
						lifeLabel.setText(L);
						EggBombLife.iv[i].setTranslateX(-30);
						iv.setImage(img6);
						if (MainWindow.choiceOfSound.equals("On")) {
							MainWindow.audio1.play();
						}
					}
					else {
						score++;
						s ="Score : "+Integer.toString(score);
						scoreLabel.setText(s);
						EggBombLife.iv[i].setTranslateX(-30);
						iv.setImage(img6);
						if (MainWindow.choiceOfSound.equals("On")) {
							MainWindow.audio1.play();
						}
					}
				}
			}
		}));
		timeline8.setCycleCount(timeline8.INDEFINITE);
		timeline8.play();
	}
}
