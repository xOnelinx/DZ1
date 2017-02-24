package DZ.Lvl1.Lesson_7;

/**
 * перечисление типов конца игры
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
