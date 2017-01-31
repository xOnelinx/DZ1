package DZ.Lvl1;

/**
 * Created by DENIS on 24.01.2017.
 */
public class Evseev_Denis_Lesson1 {

    private static int tasc3 (int a,int b,int c,int d){

        return  a*(b+(c/d));
    }
    private static boolean task4 (int x,int y){

        return (x+y)>10&&(x+y)<20;
    }

    private static void VisocosniGod (int year){        //task5*
        if (year%100!=0&year%4==0) System.out.println("высокосный год");
            else {if (year%400==0)System.out.println("высокосный год"); else System.out.println("не высокосный год");}
    }

    public static void main(String[] args) {
        byte byte_8bit = Byte.MAX_VALUE;
        short short_16bit = Short.MAX_VALUE;

        int a = 145;
        int b = -654;
        int c = Integer.MAX_VALUE;
        int d = 2016;

        long long_64bit = 20000000000000000L;
        float p =3.14f;
        double doub = 34.1215412454;
        boolean pravda_logg = true;
        char ch= 'c';
        String ss ="ссылочная переменная";

        tasc3(a,b,c,d);
        System.out.println(task4(a,b));
        VisocosniGod(d);

    }
}
