package DZ.Lvl1.Lesson_5;

/**
 * Created by Денис on 07.02.2017.
 */
public class Cat extends Animal {

     Cat(String name, String color, int age){
        super(name,color,age, 8,0,2.5f);
    }

    public String getAnimalName(){
         return "кот "+getName();
    }
}
