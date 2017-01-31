package DZ.Lvl1;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by DENIS on 31.01.2017.
 */
public class Evseev_Denis_Lesson3 {
    private static final int FILD_ZONE =5;
    private static final int WIN_COUNTER =4;
    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = '0';
    private static final char EMPTY_DOT = '*';
    private static Scanner sc = new Scanner(System.in);
    private static char [][] fild = new char[FILD_ZONE][FILD_ZONE];
    private static Random random= new Random();

    private static void initfild(){
        for (int i = 0; i <fild.length ; i++)
            for (int j = 0; j <fild.length ; j++)
                fild[i][j] = EMPTY_DOT;
    }

    private static void printFild(){
        System.out.println("----------");
        for (int i = 0; i <fild.length ; i++) {
            for (int j = 0; j < fild.length ; j++) {
                System.out.print(fild[i][j]+"|");
            }
            System.out.println();
            System.out.println("----------");
        }
    }

    private static void setX0(int x,int y,char simv){
        fild[x][y]=simv;
    }

    private static void playerTurn(){
        System.out.println("You turn!");
        int x;
        int y;
        do {
            System.out.println("Enter coordinates x, y(1-3)");
            x = sc.nextInt();
            y = sc.nextInt();
        }while (!isCellEmpty(x-1,y-1));
        checWin(x,y,HUMAN_DOT,WIN_COUNTER);

        setX0(x-1,y-1,HUMAN_DOT);

    }

    private static boolean isCellEmpty(int x,int y) {
        return !(x < 0 || y < 0 || x > FILD_ZONE - 1 || y > FILD_ZONE - 1) && fild[x][y] == EMPTY_DOT;
    }


    private static void ai_Turn(){
        int x;
        int y;
        do {
            x = random.nextInt(FILD_ZONE);
            y = random.nextInt(FILD_ZONE);
              }while (!isCellEmpty(x,y));
        setX0(x,y,AI_DOT);
    }

    private static boolean isFildFull (){
        for (int i = 0; i <fild.length ; i++) {
            for (int j = 0; j <fild.length ; j++) {
                if (fild[i][j]==EMPTY_DOT)return false;
            }
        }
        return true;
    }
    private static boolean checWin(int x,int y,char x0,int win_count){

        int count=0;
        for (int i = 0; i+x <FILD_ZONE||i+y <FILD_ZONE; i++) { //проверяю диагональ вправо вниз
            if (fild[x+i][y+i]==x0) count++;
            else break;
        }
        if (count== win_count) return true;
        for (int i = 0; x-i>0||y-i>0; i++) {            //проверяю диагональ влево вверх
            if (fild[x-i][y-i]==x0) count++;
            else break;
        }
        if (count== win_count) return true;
        count =0;
        for (int i = 0; i+x <FILD_ZONE||y-i>0; i++) {        //проверяю диагональ вправо вверх
            if (fild[x+i][y-i]==x0) count++;
            else break;
        }
        if (count==win_count) return true;
        for (int i = 0; x-i>0||i+y <FILD_ZONE; i++) {           //проверяю диагональ влево вниз
            if (fild[x-i][y+i]==x0) count++;
            else break;
        }
        if (count==win_count) return true;
        count=0;
        for (int i = 0; x-i>0; i++) {                            //проверяю  влево
            if (fild[x-i][y]==x0) count++;
            else break;
        }
        if (count==win_count) return true;                       //проверяю  вправо
        for (int i = 0; i+x <FILD_ZONE; i++) {
            if (fild[x+i][y]==x0) count++;
            else break;
        }
        if (count==win_count) return true;                      //проверяю  вниз
        count=0;
        for (int i = 0; y-i>0; i++) {
            if (fild[x][y-i]==x0) count++;
            else break;
        }
        if (count==win_count) return true;                      //проверяю  вверх
        for (int i = 0; i+y <FILD_ZONE; i++) {
            if (fild[x][y+i]==x0) count++;
            else break;
        }
        if (count==win_count) return true;
        else  return false;
    }


    public static void main(String[] args) {
        initfild();
        printFild();
        playerTurn();
        printFild();
        sc.close();
    }


}
