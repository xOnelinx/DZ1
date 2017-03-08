package DZ.TicTacToe;

/**
 * перечисление типов конца игры
 */
 enum GameEnd {
    GameDraw("ничья"),Player1Win("победил игрок 1"),Player2Win("победил игрок 2"),AIWin("Победил компьютер");
    String msg;

    GameEnd(String msg) {
        this.msg = msg;
    }

    String getMesseg (){
        return msg;
    }
}
