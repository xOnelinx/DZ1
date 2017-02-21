package DZ.Lvl_2.Lesson1.sport;

import DZ.Lvl_2.Lesson1.sport.competitors.Competitor;
import DZ.Lvl_2.Lesson1.sport.course.Obstacle;

/**
 * Created by Денис on 21.02.2017. просто
 */
 class Course {
    private Obstacle[] obstacles;

    Course(Obstacle obstacle1, Obstacle obstacle2, Obstacle obstacle3){
        this.obstacles = new Obstacle[3];
        this.obstacles[0] = obstacle1;
        this.obstacles[1] = obstacle2;
        this.obstacles[2] = obstacle3;

    }

    void doIt(Team team){
        for (Competitor comp:team.getCompetitors()
             ) {
            for (Obstacle o:this.obstacles
                 ) {
                o.doIt(comp);
                if (!comp.isOnDistance())break;
            }
        }
    }
}
