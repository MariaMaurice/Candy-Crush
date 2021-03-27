
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class Candy {

    static final Image Colors = new Image("Images/Candies.png");
    public int type =(int)(6 * Math.random());
    public int x ;
    public int y ;
    public int i , j;
    public ImageView image_view = new ImageView(Colors);
    public boolean special = false;

    public Candy(int x, int y)
    {
        this.x=x;
        this.y=y;
        this.getImage_view();
        i = (x+30)/100;
        j= (y+100)/90;

    }

    public void getImage_view() {
        if (this.type == 1 && this.special == true){
            this.image_view.setViewport(new Rectangle2D(0, 60, 68, 60));
            this.image_view.setTranslateX(x);
            this.image_view.setTranslateY(y);
        }
        else if ( this.type == 2  && this.special == true){
            this.image_view.setViewport(new Rectangle2D(68, 60, 68, 60));
            this.image_view.setTranslateX(x);
            this.image_view.setTranslateY(y);
        }
        else if ( this.type == 3  && this.special == true){
            this.image_view.setViewport(new Rectangle2D(136, 60, 68, 60));
            this.image_view.setTranslateX(x);
            this.image_view.setTranslateY(y);
        }
        else if ( this.type == 4  && this.special == true){
            this.image_view.setViewport(new Rectangle2D(204, 60, 68, 60));
            this.image_view.setTranslateX(x);
            this.image_view.setTranslateY(y);
        }
        else if ( this.type == 5  && this.special == true){
            this.image_view.setViewport(new Rectangle2D(272, 60, 68, 60));
            this.image_view.setTranslateX(x);
            this.image_view.setTranslateY(y);
        }

        else if (this.type == 1 ){
            this.image_view.setViewport(new Rectangle2D(0, 0, 68, 60));
            this.image_view.setTranslateX(x);
            this.image_view.setTranslateY(y);
        }
        else if ( this.type == 2){
            this.image_view.setViewport(new Rectangle2D(68, 0, 68, 60));
            this.image_view.setTranslateX(x);
            this.image_view.setTranslateY(y);
        }
        else if ( this.type == 3){
            this.image_view.setViewport(new Rectangle2D(136, 0, 68, 60));
            this.image_view.setTranslateX(x);
            this.image_view.setTranslateY(y);
        }
        else if ( this.type == 4){
            this.image_view.setViewport(new Rectangle2D(204, 0, 68, 60));
            this.image_view.setTranslateX(x);
            this.image_view.setTranslateY(y);
        }
        else if ( this.type == 5){
            this.image_view.setViewport(new Rectangle2D(272, 0, 68, 60));
            this.image_view.setTranslateX(x);
            this.image_view.setTranslateY(y);
        }


        else{
            type =(int)(6 * Math.random());
            this.getImage_view();
        }
    }

    public void swapCandy(Candy c1) {
        Candy temp = new Candy(0, 0);
        temp.type=c1.type;
        c1.type = this.type;
        c1.getImage_view();
        this.type = temp.type;
        this.getImage_view();
    }
}