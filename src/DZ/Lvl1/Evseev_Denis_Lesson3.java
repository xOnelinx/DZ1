package DZ.Lvl1;

import java.util.Random;
import java.util.Scanner;


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

            setX0(x-1,y-1,HUMAN_DOT);






    }

    private static boolean isCellEmpty(int x,int y) {
        return !(x < 0 || y < 0 || x > FILD_ZONE - 1 || y > FILD_ZONE - 1) && fild[x][y] == EMPTY_DOT;
    }







    private static void ai_Turn(){
        int x;
        int y;
        do {
            System.out.println("Enter coordinates x, y(1-3)");
            x = random.nextInt();
            y = random.nextInt();

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

    private static boolean checWin(char x0){
        int count=0;

        for (int i = 0; i <fild.length ; i++) {
            for (int j = 0; j <fild.length ; j++) {

                if (j<2){                                           //horizontal
                    for (int k = 0; k <WIN_COUNTER ; k++) {
                        if (fild[i][j+k]==x0)count++;
                    }
                    if (count==WIN_COUNTER)return true;
                    else count=0;
                }
                if (i<2){                                           //vertical
                    for (int k = 0; k <WIN_COUNTER ; k++) {
                        if (fild[i+k][j]==x0)count++;
                    }
                    if (count==WIN_COUNTER)return true;
                    else count=0;
                }                                                   //diagonal
                if (i<2&j<2){
                    for (int k = 0; k <WIN_COUNTER ; k++) {
                        if (fild[i+k][j+k]==x0) count++;
                    }
                    if (count==WIN_COUNTER)return true;
                    else count=0;
                }
                if (i<2&j>2){
                    for (int k = 0; k <WIN_COUNTER ; k++) {
                        if (fild[i+k][j-k]==x0) count++;
                    }
                    if (count==WIN_COUNTER)return true;
                    else count=0;
                }
            }
        }


        return false;
    }



    public static void main(String[] args) {

        initfild();
        printFild();
        while (true){
            playerTurn();

            printFild();
            if (checWin(HUMAN_DOT)) {
                System.out.println("You win!");
                break;
            }
            if (isFildFull()){
                System.out.println("DROW!")
                ;break;
            }
            ai_Turn();
            printFild();
            if (checWin(AI_DOT)) {
                System.out.println("AI win!");
                break;
            }
            if (isFildFull()){
                System.out.println("DROW!")
                ;break;
            }

        }

        sc.close();

    }


}
