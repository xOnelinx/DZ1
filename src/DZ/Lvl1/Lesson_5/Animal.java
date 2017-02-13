package DZ.Lvl1.Lesson_5;

/**
 * Created by Денис on 07.02.2017.
 */
public abstract class Animal {
    private String name;
    private String color;
    private int age;
    private int runRange;
    private int swimRange;
    private float jumpHight;

    Animal(String name, String color, int age, int runRange, int swimRange, float jumpHight) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.runRange = runRange;
        this.swimRange = swimRange;
        this.jumpHight = jumpHight;
    }

    public String getName() {
        return name;
    }

    public abstract String getAnimalName();

    protected boolean jump(float hight){
        return this.jumpHight>hight;
    }
    protected boolean swim(int swimDistanse){
        return this.swimRange>swimDistanse;
    }
    protected boolean run (int runDistance){
        return this.runRange>runDistance;
        }

}
