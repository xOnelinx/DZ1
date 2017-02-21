package DZ.Lvl_2.Lesson1.sport;


import DZ.Lvl_2.Lesson1.sport.competitors.*;
import DZ.Lvl_2.Lesson1.sport.course.*;


public class MainClass {
    public static void main(String[] args) {
//        Competitor[] competitors = {new Human("Bob"), new Cat("Barsik"), new Dog("Bobik"), new Dog("Sharik")};
//        Obstacle[] course = {new Cross(300), new Wall(2), new Cross(800), new Water(5)};
//        for (Competitor c : competitors) {
//            for (Obstacle o : course) {
//                o.doIt(c);
//                if (!c.isOnDistance()) break;
//            }
//        }
//        System.out.println("\n===== RESULTS =====\n");
//        for (Competitor c : competitors) {
//            c.result();
//        }
        Course c = new Course(new Wall(10),new Cross(5000),new Water(300));
        Team t1 = new Team(new Dog("Sharic"),new Human("Bob"),new Cat("Barsic"),new Human("Bob2"),
                "Humans+pets");
        Team t2 = new Team(new Human("H1"),new Human("H2"),new Human("H3"),new Human("H4"),
                "4humans");
        c.doIt(t1);
        c.doIt(t2);
        t1.showResults();
        t2.showResults();
    }
}
