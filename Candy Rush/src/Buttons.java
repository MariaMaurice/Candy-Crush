import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class Buttons {

    final Image image = new Image("Images/Buttons.png");
    ImageView imageview1 = new ImageView(image);
    Label label = new Label();
    float posx, posy, counter;
    boolean completed;

    public Buttons(int posx, int posy, int counter, boolean b)
    {
        this.posx = posx;
        imageview1.setTranslateX(posx);
        this.posy = posy;
        imageview1.setTranslateY(posy);
        this.completed = b;
        this.counter = counter;
        String count = String.valueOf(counter);

            label.setText(count);
            label.setFont(new Font("Brush Script MT", 40));
            label.setTextFill(Color.web("#ffffff"));


        setimageview();
    }

    public void setimageview()
    {
        if (completed) {
            imageview1.setViewport(new Rectangle2D(107, 0, 107, 90));
        }
        else {
            imageview1.setViewport(new Rectangle2D(0, 0, 107, 90));
        }
        if (completed==true){
            label.setTranslateX(posx+3);
            label.setTranslateY(posy-15);
        }
        else{
            label.setTranslateX(posx -5);
            label.setTranslateY(posy-15);
        }
    }
}