package DZ.Lvl1.Lesson_5;

/**
 * Created by Денис on 07.02.2017.
 */
public class Dog extends Animal{

    Dog(String name, String color, int age){
        super(name,color,age, 12,3,1.5f);
    }
    public String getAnimalName(){
        return "пес "+getName();
    }

}
