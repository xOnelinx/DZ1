package DZ.Lvl1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by DENIS on 27.01.2017.
 */
public class Evseev_Denis_Lesson2 {

    static int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 }; //task 1

    public static void chenge (int [] arr ){             // task 2
        for (int i = 0; i <arr.length ; i++) {
           arr[i] = (arr[i]==0) ? 1 : 0 ;
        }
    }
    static int[] aprog(){                               //task 3
        int [] amas = new int[8];
        for (int i = 0,j=1;i <amas.length ; i++,j+=3) {
            amas[i] = j;
        }
        return amas;
    }

    static void x2 (int [] arr){                           // task 4
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]<6)arr[i]*=2;
        }
    }

    static int max(int[]arr){                               // task 5
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]>maxi) maxi=arr[i];
        }
        return maxi;
    }
    static int min(int[]arr){
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i <arr.length ; i++) {
                if (mini>arr[i]) mini=arr[i];
        }
        return mini;
    }

    static int calc(int a,int b,String c){                  //task 6
        int result=0;
        switch (c){
            case "+": result=a+b;break;
            case "-": result=a-b;break;
            case "*": result=a*b;break;
            case "/": result=a/b;break;

        }
        return result;
    }



    public static void main(String[] args) {
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+"  ");
        }

        System.out.println("   task 1");
    chenge(arr);
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+"  ");
        }
        System.out.println("   task 2");
                System.out.println();
        System.out.println("task 3:");
        for (int i = 0; i <aprog().length ; i++) {
            System.out.print(aprog()[i]+"  ");
        }
        System.out.println();
        System.out.println("task 4");
        int[] mas = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        x2(mas);
        for (int i = 0; i <mas.length ; i++) {
            System.out.print("  "+mas[i]);
        }
        System.out.println();
        System.out.println("task 5");
        System.out.println("max element:"+max(mas));
        System.out.println("min element:"+min(mas));
                                                                                                    //task 6
        int arg1=0;
        int arg2=0;
        String func=null;
        Scanner sc = new Scanner(System.in);
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));           // Когда я когда-то учил джава на javaRush мне рассказывали что класс Scanner очень плохой и пользоваться им плохо,
                                                                                                   // а абракадабра с BufferedReader это хорошо. Почему это так, я тогда не понял (или не удосужился разобраться сам)
                                                                                                   //но теперь то у меня есть Вы!))   Интересно так ли это и почему?   PS не задал этот вопрос потому что интернет под конец трансляции у меня пропал((


        ArrayList<String> list = new ArrayList<>();
        System.out.println("Это Калькулятор! Ведите первый аргумент:");                                               //ввод и вывод сделал в мэйне, хотя кажется задание предпологало сделать все 1 куском
        if (sc.hasNextInt())  arg1 = sc.nextInt();
        System.out.println("Введите функцию:");
        if (sc.hasNext()) func = sc.next();
        System.out.println("Ведите второй аргумент:");
        if (sc.hasNextInt())  arg2 = sc.nextInt();
        sc.close();
        System.out.println(calc(arg1,arg2,func));

        System.out.println("спасибо)");

    }



}
