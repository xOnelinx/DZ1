package DZ.Lvl_2.Lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import java.util.Set;

/**
 * класс Телефонный справочник
 */
public class PhoneBook {

   private static HashMap<String,String> pBook = new HashMap<>();
private String [] num;

    private static void add(String name,String phone){
        pBook.put(phone,name);
    }

    //как то не очень выходит, вроде все работает но некрасиво
    private static String serchNumber(HashMap<String,String> map,String value){

        String s = " ";
        Set<String> keySet = map.keySet();
        for (String key:keySet
             ) {

           if (map.get(key).equals(value)) {
               if (!s.equals(" ")) s += " или ";
               s+="номер "+ value + "  "+key  ;}
           else s= "нет таких друзей в вашем телефонном справочнике!";
        }

        return s;
    }
    public static void main(String[] args) {
        pBook.put("+79788257431","Вася");
        pBook.put("+79788268768","Вася");
        pBook.put("+79788222565","Дима");
        pBook.put("+79788551441","Саша");
        pBook.put("+79997878481","Маша");
        pBook.put("+79788222521","Катя");

        System.out.println(serchNumber(pBook,"Вася"));
    }
}
