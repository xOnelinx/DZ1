package DZ.Lvl_2.Lesson1.sport;

import DZ.Lvl_2.Lesson1.sport.competitors.Competitor;

/**
 * Created by Денис on 21.02.2017. получилась обертка
 */
 class Team {

    private String teamName;
    private Competitor[] competitors;

   Team(Competitor  member1,Competitor  member2,Competitor  member3,Competitor  member4,String teamName){
        this.competitors = new Competitor[4];
        this.competitors[0] = member1;
        this.competitors[1] = member2;
        this.competitors[2] = member3;
        this.competitors[3] = member4;
        this.teamName = teamName;

    }

    Competitor[] getCompetitors() {
        return this.competitors;
    }

   void showResults(){
        System.out.println("\n team "+this.teamName + "\n");
        for (Competitor com: this.competitors
             ) {
            com.result();
        }
    }

}
