package DZ.Lvl1.Lesson_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Денис on 15.02.2017.
 */
public class GameWindow extends JFrame{
    private final int WINDOW_HIGHT = 500;
    private final int WINDOW_WIGHT = 451;
   private final int WINDOW_POS_X = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2-WINDOW_WIGHT;
   // private final int WINDOW_POS_X = 600;
   // private final int WINDOW_POS_Y = 300;
  private final int WINDOW_POS_Y = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2-WINDOW_HIGHT/2;
    StartNewGameWindow startNewGameWindow;
    Map map;


    GameWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Denis can!");
        setSize(WINDOW_WIGHT,WINDOW_HIGHT);
        setResizable(false);

        setLocation(WINDOW_POS_X,WINDOW_POS_Y);

        JButton btnNewGame = new JButton("New Game");
        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGameWindow.setVisible(true);
            }
        });
        JButton btnExitGame = new JButton("do this");
        btnExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        startNewGameWindow = new StartNewGameWindow(this);

        map = new Map();

        JPanel pBottom = new JPanel();
        pBottom.setLayout(new GridLayout(1,2));
        pBottom.add(btnNewGame);
        pBottom.add(btnExitGame);

        add(map,BorderLayout.CENTER);
        add(pBottom,BorderLayout.SOUTH);



        setVisible(true);
    }

    void startNewGame (int gameMode,int fildSizeX,int fildSizeY,int winLenth){
        map.startNewGame(gameMode,fildSizeX,fildSizeY,winLenth);
    }
}
