package DZ.Lvl_2.Lesson1.sport.competitors;

public interface Competitor {
    void run(int dist);
    void swim(int dist);
    void jump(int height);
    void result();
    boolean isOnDistance();
}
