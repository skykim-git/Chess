package main;

import java.util.List;

public class Game {
    //initialize game
    ChessBoard cb;

    public Game() {
        this.cb = new ChessBoard();
        List<Position> board = cb.getBoard();

        // positions 0~63 index should be...
//        board.get(0).setPiece(new Rook());// setPiece should impliment bi-directional
//        board.get(1).setPiece(new Knight());
//        board.get(2).setPiece(new Bishop());



    }

}
