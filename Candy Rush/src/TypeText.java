import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class TypeText {
       
    
    static public VBox type( ){
        VBox vbox = new VBox();
        File file = new File("out.txt");
        Text [] names = new Text[100];
        int i=0 , end=100;
        
        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8.name())) {
            while (sc.hasNextLine()){
                names[i] = new Text();
                names[i].setFont(new Font("Brush Script MT", 40));
                names[i].setText(sc.nextLine());
                i++;
                end = i;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        for (int j=0 ; j <  end ;j++){
            if (names[j] != null)
                vbox.getChildren().add(names[j]);
        }
        return vbox;
    }

}