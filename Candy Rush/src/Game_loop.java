
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Game_loop extends Transition {

    Candy candy[][];
    StackPane parent3;
    ImageView background1;
    Button restart;
    Label Score_label;
    static boolean isClicked = true;
    int lvl;
    Level_functions level = new Level_functions() ;
    
    public Game_loop(Duration duration, Candy candy[][], StackPane parent3, ImageView background1 , Button restart, Label Score_label, int lvl)
    {
        setCycleDuration(duration);
        setInterpolator(Interpolator.LINEAR);
        this.candy = candy;
        this.parent3 = parent3;
        this.background1 = background1;
        this.restart = restart;
        this.Score_label =  Score_label;
        this.lvl=lvl;
    }

    protected void interpolate(double k)
    {
        if (level.win() && lvl == 1)    
        {  
            Level_functions.score=0;
            Game_class.score_counter =50;
            if (Game_class.lvl1 == false){
              try {
                  FileWriter file_writer = null;
                  File file = new File("out.txt");
                  file_writer = new FileWriter(file,true);
                  PrintWriter outputStream;
                   outputStream = new PrintWriter(file_writer);
                   outputStream.println("Best score in level 1 :"+Game_class.score_counter);
                   outputStream.close();
                } catch (IOException ex) {
                      Logger.getLogger(Game_class.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }  
                Game_class.lvl1 = true;
                Game_class.level_counter++;
                Level_functions.score=0; 
                Game_class.Levels_scene();
        }
        if (level.win() && lvl == 2)
        {
            Level_functions.score=0;
            Game_class.score_counter =150;
            
            if (Game_class.lvl2 == false){
              try {
                  FileWriter file_writer = null;
                  File file = new File("out.txt");
                  file_writer = new FileWriter(file,true);
                  PrintWriter outputStream;
                  outputStream = new PrintWriter(file_writer);
                  outputStream.println("Best score in level 2 :"+ Game_class.score_counter);
                  outputStream.close();
                } catch (IOException ex) {
                      Logger.getLogger(Game_class.class.getName()).log(Level.SEVERE, null, ex);
                    }
            } 
            Game_class.lvl2 = true;
            Game_class.Levels_scene();
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                final int x = i , y = j;
                candy[i][j].getImage_view();
                int si = Level_functions.getScore();
                String s =String.valueOf(si);
                Score_label.setText(s);
                if(level.bool_horizontal_4_check(x,y,candy) || level.bool_vertical_4_check(x,y,candy)){
                   level.horizontal_4_check(x,y,candy);
                    level.vertical_4_check(x,y,candy);
                }
                else{
                    level.horizontal_check(x, y, candy);
                   level.vertical_check(x, y, candy);
                }
                restart.setOnAction(e -> {
                    level.re_fill(candy);
                });

                candy[x][y].image_view.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        if (isClicked) {
                            isClicked = false;
                            candy[9][9] = candy[x][y];
                        }
                        else {
                            if ((candy[x][y].x != candy[9][9].x
                                    || candy[x][y].y != candy[9][9].y)) {

                                isClicked = true;
                                candy[x][y].swapCandy(candy[9][9]);
                                if(candy[x][y].i == candy[9][9].i
                                        || candy[x][y].j == candy[9][9].j){
                                    if ( level.bool_horizontal_4_check(x,y,candy)||level.bool_vertical_check(x,y,candy)
                                            || level.bool_horizontal_check(candy[9][9].i,candy[9][9].j,candy)||level.bool_vertical_check(candy[9][9].i,candy[9][9].j,candy)  ){

                                    }

                                    else if (level.bool_horizontal_check(x,y,candy)||level.bool_vertical_check(x,y,candy)
                                            || level.bool_horizontal_check(candy[9][9].i,candy[9][9].j,candy)||level.bool_vertical_check(candy[9][9].i,candy[9][9].j,candy)  ){

                                    }
                                    else{
                                        candy[9][9].swapCandy(candy[x][y]);
                                        System.out.println("Wrong swap");
                                    }

                                }
                                else{
                                    candy[9][9].swapCandy(candy[x][y]);
                                    System.out.println("Wrong swap");
                                }

                                parent3.getChildren().removeAll(candy[x][y].image_view, candy[9][9].image_view);
                                parent3.getChildren().addAll(candy[x][y].image_view, candy[9][9].image_view);

                            }
                        }
                    }
                });
            }
        }
    }

}
