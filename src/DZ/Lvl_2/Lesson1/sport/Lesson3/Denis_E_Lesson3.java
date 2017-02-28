package DZ.Lvl_2.Lesson1.sport.Lesson3;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * dz  lesson3
 */
public class Denis_E_Lesson3 {

    static int notUnicNum(ArrayList<String> l,String s){
        int i=0;
        for (String arrMember:l
             ) {
               if(arrMember.equals(s))i++;
        }
        return i;
    }

    static ArrayList<String> unicList(ArrayList<String> l){
        ArrayList<String> unicList = new ArrayList<>();
        for (String s:l
                ) {
            if (notUnicNum(l,s)==1) unicList.add(s);
        }
        return unicList;
    }


    public static void main(String[] args) throws IOException{
        ArrayList<String> list  = new ArrayList<>();
        list.add("vfvf");
        list.add("ffff");
        list.add("lflf");
        list.add("fdfdf");
        list.add("ffff");
        list.add("llll");
        list.add("aaaa");
        list.add("aaaww");
        list.add("dwdw");
        list.add("llll");
        list.add("llll");

        System.out.println(list);
        System.out.println(notUnicNum(list,"ffff"));
        System.out.println(notUnicNum(list,"llll"));
        System.out.println(unicList(list));
    }
}
