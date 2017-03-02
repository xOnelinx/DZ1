package DZ.Lvl1;

import java.util.Set;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by DENIS on 24.01.2017.
 */
public class Evseev_Denis_Lesson1  {

    static boolean getTF(boolean a) {
        System.out.print(a + " ");
        return a;    }
    public static void main(String[] args) {
        if (getTF(true) & getTF(false) & getTF(true)) { }
        System.out.println();
        if (getTF(true) && getTF(false) && getTF(true)) { }    }

    }

