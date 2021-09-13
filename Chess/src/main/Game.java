package main;

import java.util.List;

public class Game {
    //initialize game
    ChessBoard cb;

    public Game() {
        this.cb = new ChessBoard();
        List<Position> board = cb.getBoard();

        // positions 0~63 index should be..., values are from 1 to 64
        board.get(0).setPiece(new Rook("WR"));
        board.get(1).setPiece(new Knight("WN"));
        board.get(2).setPiece(new Bishop("WB"));
        board.get(3).setPiece(new Queen("WQ"));
        board.get(4).setPiece(new King("WK"));
        board.get(5).setPiece(new Bishop("WQ"));
        board.get(6).setPiece(new Knight("WN"));
        board.get(7).setPiece(new Rook("WR"));
        for (int  i = 8; i < 16; i = i +1 ) {
            board.get(i).setPiece(new Pawn("WP"));
        }

        for (int  j = 48; j < 56; j = j +1 ) {
            board.get(j).setPiece(new Pawn("BP"));
        }

        board.get(56).setPiece(new Rook("BR"));
        board.get(57).setPiece(new Knight("BN"));
        board.get(58).setPiece(new Bishop("BB"));
        board.get(59).setPiece(new King("BK"));
        board.get(60).setPiece(new Queen("BQ"));
        board.get(61).setPiece(new Bishop("BQ"));
        board.get(62).setPiece(new Knight("BN"));
        board.get(63).setPiece(new Rook("BR"));

    }

    public ChessBoard getChessBoard() {
        return cb;
    }

}
