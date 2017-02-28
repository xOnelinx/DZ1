package DZ.Lvl_2.Lesson2;

/**
 * Created by Денис on 25.02.2017.
 */
public class MyArrayDataException extends Exception {
    private int i,j;

    MyArrayDataException(int i,int j){
        super("в строке i: "+i+", j: "+j+" обнаружен символ!");
        this.i = i;
        this.j = j;
    }
}
