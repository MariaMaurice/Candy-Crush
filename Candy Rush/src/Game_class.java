import javafx.animation.Animation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.geometry.Rectangle2D;
import javafx.util.Duration;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Game_class extends Application
{
    static int level_counter = 1 , posx = -30, posy = 0;
    static boolean lvl1 = false , lvl2 = false;
    static Stage Game_window = new Stage();
    static Image game_buttons = new Image("Images/Game_buttons.png");
    static Animation anime;
    public static int score_counter = 0;
    @Override
    public void start(Stage start) throws Exception
    {
        //creating the stage
        Game_window.setTitle("Candy Crush");
        Game_window.getIcons().add(new Image("Images/Icon.png"));
        Game_window.setWidth(900);
        Game_window.setHeight(800);
        Game_window.centerOnScreen();

        //setting the scene
        StackPane parent = new StackPane();
        Scene Start_menu = new Scene(parent);
        Game_window.setScene(Start_menu);

        //changing the cursor of the game
        Start_menu.setCursor(new ImageCursor(new Image("Images/Cursor.png")));

        //adding background to the game
        Image background = new Image("Images/Background.png");
        ImageView background1 = new ImageView(background);
        parent.getChildren().add(background1);

        //start menu sound
        String uriString = new File("Music/candy_sound.mp3").toURI().toString();
        Media media = new Media(uriString);
        MediaPlayer  media_player = new MediaPlayer(media);
        media_player.setCycleCount(MediaPlayer.INDEFINITE);
        media_player.setAutoPlay(true);


        //Making the play button
        ImageView play1 = new ImageView(game_buttons);
        play1.setViewport(new Rectangle2D(0, 0, 220, 69));
        Button play_button = new Button();
        play_button.setGraphic(play1);
        play_button.setStyle("  -fx-background-color: transparent;");
        play_button.setTranslateY(118);

        //Making the history button
        ImageView history1 = new ImageView(game_buttons);
        history1.setViewport(new Rectangle2D(0, 70, 220, 69));
        Button history_button = new Button();
        history_button.setGraphic(history1);
        history_button.setStyle("  -fx-background-color: transparent;");
        history_button.setTranslateY(225);

        //the animation of the jumping girl
        Image girl_jumping = new Image("Images/Candy_girl.png");
        ImageView girl_jumping1 = new ImageView(girl_jumping);
        girl_jumping1.setViewport(new Rectangle2D(0, 300, 300, 330));
        girl_jumping1.setTranslateX(-250);
        girl_jumping1.setTranslateY(90);
        final Animation animation = new Animator(girl_jumping1, Duration.millis(1000),
                4, 4,
                0, 300,
                300, 330);

        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

        //adding the button to the stage
        parent.getChildren().addAll(play_button, girl_jumping1,history_button);

        //button animation when mouse hovered over it
        play_button.setOnMouseExited(exit -> {
            play1.setFitHeight(69);
            play1.setPreserveRatio(true);
            play_button.setGraphic(play1);
        });
        play_button.setOnMouseEntered(enter -> {
            play1.setFitHeight(80);
            play1.setPreserveRatio(true);
            play_button.setGraphic(play1);
        });
        //button animation when mouse hovered over it
        history_button.setOnMouseExited(exit -> {
            history1.setFitHeight(69);
            history1.setPreserveRatio(true);
            history_button.setGraphic(history1);
        });
        history_button.setOnMouseEntered(enter -> {
            history1.setFitHeight(80);
            history1.setPreserveRatio(true);
            history_button.setGraphic(history1);
        });

        //accessing the menu where you type your name
        Naming_menu(play_button);
        //accessing the menu where you type your name
        history_menu( history_button);
        //showing the stage
        Game_window.show();
    }

    static public void Naming_menu(Button play_button) throws Exception
    {
        //Creating new window to write your name in
        Stage Naming = new Stage();
        Naming.setWidth(400);
        Naming.setHeight(500);
        Naming.initOwner(Game_window);
        Naming.initModality(Modality.WINDOW_MODAL);
        Naming.initStyle(StageStyle.TRANSPARENT);

        //opening the window to type your name
        play_button.setOnMouseClicked(mouseEvent -> Naming.show());

        //creating the pop-up window to write your name in
        StackPane parent1 = new StackPane();
        Scene naming = new Scene(parent1);
        parent1.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-background-radius: 10;" );
        naming.setFill(Color.TRANSPARENT);
        Naming.setScene(naming);

        //adding the images
        Image name_menu = new Image("Images/Name_menu.png");
        ImageView name_menu1 = new ImageView(name_menu);
        name_menu1.setViewport(new Rectangle2D(0, 0, 400, 500));
        naming.setCursor(new ImageCursor(new Image("Images/Cursor.png")));
        parent1.getChildren().add(name_menu1);

        //adding text above entering name field
        Label type_your_name =new Label("Type your name");
        type_your_name.setTranslateX(-15);
        type_your_name.setTranslateY(-150);
        type_your_name.setStyle("-fx-background-color: transparent; -fx-font-size: 60; " +
                "Color: #753a19; -fx-font-family: 'Brush Script MT'");

        //field to type your name
        TextField enter_name = new TextField();
        enter_name.setTranslateX(-10);
        enter_name.setTranslateY(-70);
        enter_name.setMaxWidth(300);
        enter_name.setMaxHeight(20);
        enter_name.setAlignment(Pos.CENTER);
        enter_name.setStyle("-fx-background-color: #fea9ca; -fx-background-radius: 20;-fx-font-size: 45;" +
                "-fx-font-family: 'Brush Script MT';");

        //submitting your name after inputting it
        Button enter = new Button();
        ImageView enter1 = new ImageView(game_buttons);
        enter1.setViewport(new Rectangle2D(0, 0, 220, 69));
        enter.setGraphic(enter1);
        enter.setTranslateX(-10);
        enter.setTranslateY(170);
        enter.setStyle("-fx-background-color: transparent");

        //button animation when mouse hovered over it
        enter.setOnMouseExited(mouse -> {
            enter1.setFitHeight(69);
            enter1.setPreserveRatio(true);
            enter.setGraphic(enter1);
        });
        enter.setOnMouseEntered(mouse -> {
            enter1.setFitHeight(80);
            enter1.setPreserveRatio(true);
            enter.setGraphic(enter1);
        });

        //entering the next scene and save the name of the player
        enter.setOnMouseClicked(mouseEvent -> {

            FileWriter file_writer = null;
            try {
                String Name = new String();
                Name = " "+enter_name.getText();
                File file = new File("out.txt");
                file_writer = new FileWriter(file,true);

                PrintWriter outputStream;
                outputStream = new PrintWriter(file_writer);
                outputStream.println("User name:"+Name);
                outputStream.close();

            }
            catch (IOException ex) {
                Logger.getLogger(Game_class.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    file_writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(Game_class.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            Naming.close();

            //Accessing the Level select scene
            Levels_scene();
        });


        //adding the exit button
        ImageView exit1 = new ImageView(name_menu);
        exit1.setViewport(new Rectangle2D(401, 0, 56, 52));
        Button exit_button = new Button();
        exit_button.setGraphic(exit1);
        exit_button.setStyle("  -fx-background-color: transparent;");
        exit_button.setTranslateX(165);
        exit_button.setTranslateY(-205);

        //button animation when mouse hovered over it
        exit_button.setOnMouseExited(exit -> {
            exit1.setFitHeight(52);
            exit1.setPreserveRatio(true);
            exit_button.setGraphic(exit1);
        });
        exit_button.setOnMouseEntered(enter2 -> {
            exit1.setFitHeight(60);
            exit1.setPreserveRatio(true);
            exit_button.setGraphic(exit1);
        });

        //closing the window in which you typed your name
        exit_button.setOnMouseClicked(mouseEvent -> {
            Naming.close();
            enter_name.setText("");
        });

        //adding the exit button to the window
        parent1.getChildren().addAll(enter_name, type_your_name, enter, exit_button);
    }

    static public void history_menu(Button history_button) throws Exception
    {
        //Creating new window to write your name in
        Stage history = new Stage();
        history.setWidth(500);
        history.setHeight(600);
        history.initOwner(Game_window);
        history.initModality(Modality.WINDOW_MODAL);


        //opening the window to type your name
        history_button.setOnMouseClicked(mouseEvent ->  history.show());

        //creating the pop-up window to write your name in
        StackPane parent1 = new StackPane();
        Scene  History = new Scene(parent1);
        History.setCursor(new ImageCursor(new Image("Images/Cursor.png")));
        parent1.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-background-radius: 10;" );
        History.setFill(Color.TRANSPARENT);
        history.setScene(History);
        Image history_img = new Image("Images/History.png");
        ImageView img = new ImageView(history_img);
        parent1.getChildren().add(img);
        ScrollPane s1 = new ScrollPane();  
        VBox vbox = new VBox();
           vbox= TypeText.type();
        s1.setContent(vbox);
  

     

        //adding the exit button to the window

        parent1.getChildren().add(s1);
    }

    static public void Levels_scene()
    {
        //creating the level select scene
        StackPane parent2 = new StackPane();
        Scene Level_select = new Scene(parent2);
        Game_window.setScene(Level_select);
        Level_select.setCursor(new ImageCursor(new Image("Images/Cursor.png")));

        ImageView level_select1 = new ImageView(new Image("Images/Level_select.png"));
        parent2.getChildren().add(level_select1);

        //creating the toffee animation at the top of the screen
        Image Toffee = new Image("Images/Toffee.png");
        ImageView Toffee1 = new ImageView(Toffee);
        Toffee1.setViewport(new Rectangle2D(0, 0, 100, 138));
        Toffee1.setTranslateX(60);
        Toffee1.setTranslateY(-220);
        final Animation animation = new Animator(Toffee1, Duration.millis(1000),
                4, 4,
                0, 0,
                100, 138);
        parent2.getChildren().add(Toffee1);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

        Buttons level1_button = new Buttons(-167, 140, 1 ,lvl1);
        Buttons level2_button = new Buttons(0, 170, 2 ,lvl2);
        if (lvl1) {
            level1_button.completed = true;
            anime.stop();
        }
        if (lvl2)
            level2_button.completed = true;

        level1_button.imageview1.setOnMouseExited(exit -> {
            level1_button.imageview1.setFitHeight(90);
            level1_button.imageview1.setPreserveRatio(true);
            level1_button.label.setFont(new Font("Brush Script MT", 40));
        });
        level1_button.imageview1.setOnMouseEntered(enter -> {
            level1_button.imageview1.setFitHeight(100);
            level1_button.imageview1.setPreserveRatio(true);
            level1_button.label.setFont(new Font("Brush Script MT", 45));
        });
        level1_button.label.setOnMouseExited(exit -> {
            level1_button.imageview1.setFitHeight(90);
            level1_button.imageview1.setPreserveRatio(true);
            level1_button.label.setFont(new Font("Brush Script MT", 40));
        });
        level1_button.label.setOnMouseEntered(enter -> {
            level1_button.imageview1.setFitHeight(100);
            level1_button.imageview1.setPreserveRatio(true);
            level1_button.label.setFont(new Font("Brush Script MT", 45));
        });

        level1_button.imageview1.setOnMouseClicked(mouseEvent -> {
            Starting_level(1);
            level1_button.setimageview();
            parent2.getChildren().removeAll(level1_button.imageview1, level1_button.label,  level2_button.imageview1, level2_button.label);
            parent2.getChildren().add(level1_button.imageview1);
            parent2.getChildren().add(level1_button.label);
        });
        level1_button.label.setOnMouseClicked(mouseEvent -> {
            Starting_level(1);
            level1_button.setimageview();
            parent2.getChildren().removeAll(level1_button.imageview1, level1_button.label,  level2_button.imageview1, level2_button.label);
            parent2.getChildren().add(level1_button.imageview1);
            parent2.getChildren().add(level1_button.label);
        });

        parent2.getChildren().add(level1_button.imageview1);
        parent2.getChildren().add(level1_button.label);

        if (level_counter>=2)
        {
            parent2.getChildren().add(level2_button.imageview1);
            parent2.getChildren().add(level2_button.label);

            level2_button.imageview1.setOnMouseExited(exit -> {
                level2_button.imageview1.setFitHeight(90);
                level2_button.imageview1.setPreserveRatio(true);
                level2_button.label.setFont(new Font("Brush Script MT", 40));
            });
            level2_button.imageview1.setOnMouseEntered(enter -> {
                level2_button.imageview1.setFitHeight(100);
                level2_button.imageview1.setPreserveRatio(true);
                level2_button.label.setFont(new Font("Brush Script MT", 45));
            });
            level2_button.label.setOnMouseExited(exit -> {
                level2_button.imageview1.setFitHeight(90);
                level2_button.imageview1.setPreserveRatio(true);
                level2_button.label.setFont(new Font("Brush Script MT", 40));
            });
            level2_button.label.setOnMouseEntered(enter -> {
                level2_button.imageview1.setFitHeight(100);
                level2_button.imageview1.setPreserveRatio(true);
                level2_button.label.setFont(new Font("Brush Script MT", 45));
            });

            level2_button.imageview1.setOnMouseClicked(mouseEvent -> {
                Starting_level(2);
                level2_button.setimageview();
                parent2.getChildren().removeAll(level2_button.imageview1, level2_button.label);
                parent2.getChildren().add(level2_button.imageview1);
                parent2.getChildren().add(level2_button.label);
            });
            level2_button.label.setOnMouseClicked(mouseEvent -> {
                Starting_level(2);
                level2_button.setimageview();
                parent2.getChildren().removeAll(level2_button.imageview1, level2_button.label);
                parent2.getChildren().add(level2_button.imageview1);
                parent2.getChildren().add(level2_button.label);
            });
        }
    }

    static public void Starting_level(int lvl)
    {
        //Creating new window to tell you the target and starting the level
        Stage starting = new Stage();
        starting.setWidth(400);
        starting.setHeight(500);
        starting.initOwner(Game_window);
        starting.initModality(Modality.WINDOW_MODAL);
        starting.initStyle(StageStyle.TRANSPARENT);
        starting.show();

        //creating the scene in the window
        StackPane parent4 = new StackPane();
        Scene selecting = new Scene(parent4);
        parent4.setStyle("-fx-background-color: rgba(0, 0, 0, 0); -fx-background-radius: 10;" );
        selecting.setFill(Color.TRANSPARENT);
        starting.setScene(selecting);

        Image selecting_menu = new Image("Images/Level_Start.png");
        ImageView selecting_menu1 = new ImageView(selecting_menu);
        selecting_menu1.setViewport(new Rectangle2D(0, 0, 400, 500));
        parent4.getChildren().add(selecting_menu1);

        //adding the number of the level
        String s = String.valueOf(lvl);
        Label lvl_num =new Label(s);
        lvl_num.setTranslateX(20);
        lvl_num.setTranslateY(-165);
        lvl_num.setStyle("-fx-background-color: transparent; -fx-font-size: 25; " +
                "Color: #003a81; -fx-font-family: 'Brush Script MT'");

        //submitting your name after inputting it
        ImageView enter2 = new ImageView(game_buttons);
        enter2.setViewport(new Rectangle2D(0, 0, 220, 69));
        enter2.setTranslateX(-10);
        enter2.setTranslateY(170);
        enter2.setStyle("-fx-background-color: transparent");

        //button animation when mouse hovered over it
        enter2.setOnMouseExited(mouse -> {
            enter2.setFitHeight(69);
            enter2.setPreserveRatio(true);
        });
        enter2.setOnMouseEntered(mouse -> {
            enter2.setFitHeight(80);
            enter2.setPreserveRatio(true);
        });

        //entering the next scene and save the name of the player
        enter2.setOnMouseClicked(mouseEvent -> {
            starting.close();
            //Accessing the Level select scene
            if (lvl == 1)
                Level1();
            if (lvl == 2)
                Level2();
        });

        //adding the exit button
        ImageView exit1 = new ImageView(selecting_menu);
        exit1.setViewport(new Rectangle2D(400, 0, 40, 41));
        exit1.setStyle("  -fx-background-color: transparent;");
        exit1.setTranslateX(150);
        exit1.setTranslateY(-170);

        //button animation when mouse hovered over it
        exit1.setOnMouseExited(exit -> {
            exit1.setFitHeight(41);
            exit1.setPreserveRatio(true);
        });
        exit1.setOnMouseEntered(enter -> {
            exit1.setFitHeight(50);
            exit1.setPreserveRatio(true);
        });

        //closing the window in which you typed your name
        exit1.setOnMouseClicked(mouseEvent -> {
            starting.close();
            Levels_scene();
        });

        //adding the exit button to the window
        parent4.getChildren().addAll(lvl_num, enter2, exit1);
    }

    static public void Level1()
    {   
        posx = -30;
        posy=0;
        Level_functions.target = 50;
        //setting the scene
        StackPane parent3 = new StackPane();
        Scene level1 = new Scene(parent3);
        Game_window.setScene(level1);

        //changing the cursor of the game
        Image hand = new Image("Images/Cursor.png");
        level1.setCursor(new ImageCursor(hand));

        //adding background to the game
        Image background = new Image("Images/Level1_Background.png");
        ImageView background1 = new ImageView(background);

        Button restart = new Button();
        ImageView restart1 = new ImageView(game_buttons);
        restart1.setViewport(new Rectangle2D(0, 140, 220, 69));
        restart1.setFitHeight(40);
        restart1.setPreserveRatio(true);
        restart.setGraphic(restart1);
        restart.setTranslateX(-150);
        restart.setTranslateY(150);
        restart.setStyle("  -fx-background-color: transparent;");
        Label Score_label = new Label();
        Score_label.setTranslateX(-150);
        Score_label.setTranslateY(100);
        Score_label.setFont(new Font("Brush Script MT", 40));
        Score_label.setTextFill(Color.web("#ffffff"));
        parent3.getChildren().addAll(background1,restart,Score_label);

        Candy[][] candy;
        candy = new Candy[10][10];

        for (int i = 0; i < 4; i++) {

            if(i!=0)
                posx+=100;

            posy=-100;
            for (int j = 0; j < 4; j++) {
                if(j!=0)
                    posy+=90;
                candy[i][j] = new Candy(posx, posy);

                parent3.getChildren().addAll(candy[i][j].image_view);
            }
        }

        anime = new Game_loop(Duration.millis(7000), candy, parent3, background1 ,restart,Score_label ,1) {};
        anime.setCycleCount(Animation.INDEFINITE);
        anime.play();
    }

    static public void Level2()
    {
        posx = -30;
        posy=0;
         Level_functions.target = 100;
        //setting the scene
        StackPane parent3 = new StackPane();
        Scene level2 = new Scene(parent3);
        Game_window.setScene(level2);

        //changing the cursor of the game
        Image hand = new Image("Images/Cursor.png");
        level2.setCursor(new ImageCursor(hand));

        //adding background to the game
        Image background = new Image("Images/Level1_Background.png");
        ImageView background1 = new ImageView(background);

        Button restart = new Button();
        ImageView restart1 = new ImageView(game_buttons);
        restart1.setViewport(new Rectangle2D(0, 140, 220, 69));
        restart1.setFitHeight(40);
        restart1.setPreserveRatio(true);
        restart.setGraphic(restart1);
        restart.setTranslateX(-150);
        restart.setTranslateY(150);
        restart.setStyle("  -fx-background-color: transparent;");
        Label Score_label = new Label();
        Score_label.setTranslateX(-150);
        Score_label.setTranslateY(100);
        Score_label.setFont(new Font("Brush Script MT", 40));
        Score_label.setTextFill(Color.web("#ffffff"));
        parent3.getChildren().addAll(background1,restart,Score_label);

        Candy[][] candy;
        candy = new Candy[10][10];

        for (int i = 0; i < 4; i++) {

            if(i!=0)
                posx+=100;

            posy=-100;
            for (int j = 0; j < 4; j++) {
                if(j!=0)
                    posy+=90;
                candy[i][j] = new Candy(posx, posy);

                parent3.getChildren().addAll(candy[i][j].image_view);
            }
        }

        anime = new Game_loop(Duration.millis(7000), candy, parent3, background1 ,restart,Score_label, 2) {};
        anime.setCycleCount(Animation.INDEFINITE);
        anime.play();
    }
}