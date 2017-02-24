package DZ.Lvl1.Lesson_7;

/**
 * Created by Денис on 23.02.2017.
 */
public enum GameEnd {
    GameDraw("ничья"),Player1Win("победил игрок1"),Player2Win("победил игрок2"),AIWin("Победил компьютер");
    String msg;

    GameEnd(String msg) {
        this.msg = msg;
    }

    String getMesseg (){
        return msg;
    }
}
