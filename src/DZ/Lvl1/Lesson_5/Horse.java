package DZ.Lvl1.Lesson_5;


public class Horse extends Animal {

     Horse(String name, String color, int age){
        super(name,color,age, 102,15,2.0f);
    }
    public String getAnimalName(){
        return "лошадь "+getName();
    }
}
