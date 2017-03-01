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

    private final int WINDOW_POS_Y = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2-WINDOW_HIGHT/2;
    private StartNewGameWindow startNewGameWindow;
    private Map map;


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
                StartNewGW();
                startNewGameWindow.setVisible(true);
            }
        });
        JButton btnExitGame = new JButton("Exit Game");
        btnExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        map = new Map();

        JPanel pBottom = new JPanel();
        pBottom.setLayout(new GridLayout(1,2));
        pBottom.add(btnNewGame);
        pBottom.add(btnExitGame);

        add(map,BorderLayout.CENTER);
        add(pBottom,BorderLayout.SOUTH);

        setVisible(true);
    }

    // вызывает окно в момент нажатия кнопки
    private void StartNewGW(){
        startNewGameWindow = new StartNewGameWindow(this);
    }

    void startNewGame (GameMod gameMode,int fildSizeX,int fildSizeY,int winLenth){
        map.startNewGame(gameMode,fildSizeX,fildSizeY,winLenth);
    }
}
