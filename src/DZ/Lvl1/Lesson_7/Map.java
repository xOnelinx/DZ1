package DZ.Lvl1.Lesson_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by Денис on 15.02.2017.
 */
public class Map extends JPanel {

    static final int GAME_MOD_H_vs_AI = 0;
    static final int GAME_MOD_H_vs_H = 1;

    private int [][] field;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLen;

    private int cellWeigth;
    private int cellHeigth;

    private final int EMPTY_DOT = 0;
    private final int AI_DOT = 1;
    private final int HUMAN_DOT = 2;

    private static final int GAME_DRAW = 0;
    private static final int GAME_HUMAN = 1;
    private static final int GAME_AI = 2;
    private int gameStateOver;

    private boolean gameOver = false;
    private boolean initiolize = false;

    private static final String MSG_DRAW = "ничья";
    private static final String MSG_HUM = "победил игрок";
    private static final String MSG_AI = "победил компьютер";

    private final Random random = new Random();

    private final Font font = new Font("Times new roman",Font.BOLD,48);


    Map(){

    addMouseListener(new MouseAdapter() {
        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            update(e);
            System.out.println(gameOver);
        }
    });


    }

   private void update (MouseEvent e){
       if (!initiolize)return;                                                               // Ход игрока
       if (gameOver)return;
       int cellx = e.getX()/cellWeigth;
       int celly = e.getY()/cellHeigth;
       if(!isValidCell(cellx,celly)||!isEmptyCell(cellx,celly))return;
       field[cellx][celly] = HUMAN_DOT;
       repaint();
       ///TODO переделать в метод
       if (checkWin(HUMAN_DOT)){
           gameStateOver = GAME_HUMAN;
           gameOver = true;
           return;
       }
       if (isMapFull()) {
           gameStateOver = GAME_DRAW;
           gameOver = true;
           return;
       }
       aiTurn();
       repaint();
       if (checkWin(AI_DOT)){
           gameStateOver = GAME_AI;
           gameOver=true;
           return;
       }
       if (isMapFull()) {
           gameStateOver = GAME_DRAW;
           gameOver = true;
           return;
       }


    }

    void startNewGame (int gameMode,int fildSizeX,int fildSizeY,int winLenth){
        this.fieldSizeX = fildSizeX;
        this.fieldSizeY = fildSizeY;
        this.winLen = winLenth;
        field = new int[fildSizeX][fildSizeY];
        gameOver = false;
        initiolize = true;
        repaint();

    }
    @Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        render(g);

    }

    public void render (Graphics g){
        if (!initiolize)return;
        int panelWeigth = getWidth();
        int panelHeigth = getHeight();
        cellHeigth = panelHeigth/fieldSizeY;
        cellWeigth = panelWeigth/fieldSizeX;

        int bottom = 25;
        g.setColor(Color.RED);

        for (int i = 0; i <fieldSizeY; i++) {                      ////отрисовка поля
            int y = i*cellHeigth;
            g.drawLine(0,y,panelWeigth,y);
        }
        for (int i = 0; i <fieldSizeX; i++) {
            int x = i*cellHeigth;
            g.drawLine(x,0,x,panelHeigth);
        }

        for (int i = 0; i <fieldSizeX; i++) {                        ///отрисовка ходов игрока или АИ
            for (int j = 0; j <fieldSizeY ; j++) {
            if (isEmptyCell(i,j)) continue;
                if (field[i][j]==HUMAN_DOT){
                    g.setColor(Color.RED);
                }
                else if (field[i][j]==AI_DOT){
                    g.setColor(Color.BLUE);
                }
                else {
                    throw new RuntimeException("Unexpected value in cell X:"+i+"Y:"+j);
                }

                g.fillOval(i*cellWeigth+bottom,
                        j*cellHeigth+bottom,
                        cellWeigth-bottom*2,
                        cellHeigth-bottom*2);
            }
        }
        if (gameOver) showGameOverMessage(g);

    }

    void showGameOverMessage(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,200,getWidth(),70);
        g.setColor(Color.YELLOW);
        g.setFont(font);

        switch (gameStateOver){
            case GAME_DRAW:g.drawString(MSG_DRAW,180,getHeight()/2);
                break;
            case GAME_HUMAN:g.drawString(MSG_HUM,80,getHeight()/2);
             break;

            case GAME_AI:g.drawString(MSG_AI,20,getHeight()/2);
                break;

            default:
                throw new RuntimeException("Unexpected Game Over:"+gameStateOver);
        }

    }


    // Ход компьютера
    private  void aiTurn() {
        if(turnAIWinCell()) return;		// проверим, не выиграет-ли игрок на следующем ходу
        if(turnHumanWinCell()) return;	// проверим, не выиграет-ли комп на следующем ходу
        int x, y;
        do {							// или комп ходит в случайную клетку
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[x][y] = AI_DOT;
    }
    // Проверка, может ли выиграть комп
    private  boolean turnAIWinCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isEmptyCell(i, j)) {				// поставим нолик в каждую клетку поля по очереди
                    field[i][j] = AI_DOT;
                    if (checkWin(AI_DOT)) return true;	// если мы выиграли, вернём истину, оставив нолик в выигрышной позиции
                    field[i][j] = EMPTY_DOT;			// если нет - вернём обратно пустоту в клетку и пойдём дальше
                }
            }
        }
        return false;
    }
    // Проверка, выиграет-ли игрок своим следующим ходом
    private  boolean turnHumanWinCell() {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (isEmptyCell(i, j)) {
                    field[i][j] = HUMAN_DOT;			// поставим крестик в каждую клетку по очереди
                    if (checkWin(HUMAN_DOT)) {			// если игрок победит
                        field[i][j] = AI_DOT;			// поставить на то место нолик
                        return true;
                    }
                    field[i][j] = EMPTY_DOT;			// в противном случае вернуть на место пустоту
                }
            }
        }
        return false;
    }
    // проверка на победу
    private  boolean checkWin(int dot) {
        for (int i = 0; i < fieldSizeX; i++) {			// ползём по всему полю
            for (int j = 0; j < fieldSizeY; j++) {
                if (checkLine(i, j, 1, 0, winLen, dot)) return true;	// проверим линию по х
                if (checkLine(i, j, 1, 1, winLen, dot)) return true;	// проверим по диагонали х у
                if (checkLine(i, j, 0, 1, winLen, dot)) return true;	// проверим линию по у
                if (checkLine(i, j, 1, -1, winLen, dot)) return true;	// проверим по диагонали х -у
            }
        }
        return false;
    }

    // проверка линии
    private  boolean checkLine(int x, int y, int vx, int vy, int len, int dot) {
        final int far_x = x + (len - 1) * vx;			// посчитаем конец проверяемой линии
        final int far_y = y + (len - 1) * vy;
        if (!isValidCell(far_x, far_y)) return false;	// проверим не выйдет-ли проверяемая линия за пределы поля
        for (int i = 0; i < len; i++) {					// ползём по проверяемой линии
            if (field[x + i * vx][y + i * vy] != dot) return false;	// проверим одинаковые-ли символы в ячейках
        }
        return true;
    }
    // ничья?
    private  boolean isMapFull() {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }
    // ячейка-то вообще правильная?
    private  boolean isValidCell(int x, int y) { return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY; }
    // а пустая?
    private  boolean isEmptyCell(int x, int y) { return field[x][y] == EMPTY_DOT; }
    // ну, поиграем))
}
