package DZ.Lvl1.Lesson_7;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Денис on 15.02.2017.
 */
public class Map extends JPanel {

    Map(){
        setBackground(Color.BLACK);
    }

    void startNewGame (int gameMode,int fildSizeX,int fildSizeY,int winLenth){
        System.out.println("mode "+ gameMode+
        "\n fild size "+fildSizeX+
        "\n win lenth"+winLenth);
    }
}
