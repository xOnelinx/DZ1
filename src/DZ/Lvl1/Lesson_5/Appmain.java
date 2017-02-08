package DZ.Lvl1.Lesson_5;


import java.util.Random;

public class Appmain {

    static void jumpTest(Animal animal, float hight){
        System.out.println("Сможет ли "+animal.getAnimalName()+" перепрыгнуть преграду высотой "+hight+"м");
        System.out.println("*прыжок!*");
        if(animal.jump(hight)) System.out.println("смог!");
        else System.out.println("*бум(*не допрыгнул(");
        System.out.println();
    }

    static void swimTest(Animal animal, int distance){
        System.out.println("Сможет ли "+animal.getAnimalName()+" проплыть "+distance+"км");
        System.out.println("*прыжок!*");
        if(animal.swim(distance)) System.out.println("смог!");
        else System.out.println("*не смог( буль буль(*");
        System.out.println();
    }

    static void runTest(Animal animal, int distance){
        System.out.println("Сможет ли "+animal.getAnimalName()+" пробежать кросс "+distance+"км");
        System.out.println("*старт!*");
        if(animal.run(distance)) System.out.println("смог!");
        else System.out.println("не добежад*устал(*");
        System.out.println();
    }


    public static void main(String[] args) {
        Random random =new Random();
        Animal[] animals = new Animal[3];
        animals[0] = new Cat("Barsic","Black",5);
        animals[1] = new Dog("Bob","Yellow",4);
        animals[2] = new Horse("Horrrs","pied",6);

        for (int i = 0; i <animals.length ; i++) {
            jumpTest(animals[i],1+random.nextFloat());
            swimTest(animals[i],random.nextInt(2));
            runTest(animals[i],random.nextInt(10));
        }


    }
}
