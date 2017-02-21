package DZ.Lvl_2.Lesson1.sport.course;

import DZ.Lvl_2.Lesson1.sport.competitors.Competitor;

public class Water extends Obstacle {
    private int dist;

    public Water(int dist) {
        this.dist = dist;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(dist);
    }
}
