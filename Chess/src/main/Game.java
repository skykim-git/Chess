package main;

import java.util.List;

public class Game {
    //initialize game
    ChessBoard cb;
    private List<Position> bd;
    int turn;


    public Game() {
        this.cb = new ChessBoard();
        List<Position> board = cb.getBoard();

        // positions 0~63 index should be..., values are from 1 to 64
        board.get(0).setPiece(new Rook("WR"));
        board.get(1).setPiece(new Knight("WN"));
        board.get(2).setPiece(new Bishop("WB"));
        board.get(3).setPiece(new Queen("WQ"));
        board.get(4).setPiece(new King("WK"));
        board.get(5).setPiece(new Bishop("WB"));
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
        board.get(59).setPiece(new King("BQ"));
        board.get(60).setPiece(new Queen("BK"));
        board.get(61).setPiece(new Bishop("BB"));
        board.get(62).setPiece(new Knight("BN"));
        board.get(63).setPiece(new Rook("BR"));

    }

    public ChessBoard getChessBoard() {
        return cb;
    }

    void progressTurn() {
        turn++;
    }

    public void movePiece(String startCoor, String endCoor) {
        int startNp = coorToNp(startCoor);
        int endNp   = coorToNp(endCoor);
        Position endPosition = bd.get(endNp);

        bd.get(startNp).getPiece().move(endPosition, cb);

    }

    public int coorToNp(String coor) {

        String givenAlpha = coor.substring(0,1);
        int alphaNum = -100;
        if (givenAlpha.equals("a")) {
            alphaNum = 0;
        } else if (givenAlpha.equals("b")) {
            alphaNum = 1;
        } else if (givenAlpha.equals("c")) {
            alphaNum = 2;
        } else if (givenAlpha.equals("d")) {
            alphaNum = 3;
        } else if (givenAlpha.equals("e")) {
            alphaNum = 4;
        }else if (givenAlpha.equals("f")) {
            alphaNum = 5;
        }else if (givenAlpha.equals("g")) {
            alphaNum = 6;
        }else if (givenAlpha.equals("h")) {
            alphaNum = 7;
        }
            int givenNumber = Integer.parseInt(coor.substring(1,1));
        int np = (givenNumber-1)*8 + alphaNum;
        return np;
    }

    public boolean isEnd() {
        // tells if the game is end(checkmate or stalemate) for now just always runs
        return true;
    }

    public static void main(String arg[]) {

    }

}
