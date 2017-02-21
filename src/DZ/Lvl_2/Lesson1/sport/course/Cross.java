package DZ.Lvl_2.Lesson1.sport.course;

import DZ.Lvl_2.Lesson1.sport.competitors.Competitor;

public class Cross extends Obstacle {
    private int dist;

    public Cross(int dist) {
        this.dist = dist;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(dist);
    }
}
