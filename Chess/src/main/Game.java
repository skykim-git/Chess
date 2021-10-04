package main;

import java.util.ArrayList;
import java.util.List;

public class Game {
    //initialize game
    ChessBoard cb;
    private List<Position> bd;
    int turn;


    public Game() {
        this.cb = new ChessBoard();
        bd = cb.getBoard();


        // positions 0~63 index should be..., values are from 1 to 64
        bd.get(0).setPiece(new Rook("WR"));
        bd.get(1).setPiece(new Knight("WN"));
        bd.get(2).setPiece(new Bishop("WB"));
        bd.get(3).setPiece(new Queen("WQ"));
        bd.get(4).setPiece(new King("WK"));
        bd.get(5).setPiece(new Bishop("WB"));
        bd.get(6).setPiece(new Knight("WN"));
        bd.get(7).setPiece(new Rook("WR"));
        for (int  i = 8; i < 16; i = i +1 ) {
            bd.get(i).setPiece(new Pawn("WP"));
        }

        for (int  j = 48; j < 56; j = j +1 ) {
            bd.get(j).setPiece(new Pawn("BP"));
        }

        bd.get(56).setPiece(new Rook("BR"));
        bd.get(57).setPiece(new Knight("BN"));
        bd.get(58).setPiece(new Bishop("BB"));
        bd.get(59).setPiece(new King("BQ"));
        bd.get(60).setPiece(new Queen("BK"));
        bd.get(61).setPiece(new Bishop("BB"));
        bd.get(62).setPiece(new Knight("BN"));
        bd.get(63).setPiece(new Rook("BR"));

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
            int givenNumber = Integer.parseInt(coor.substring(1,2));
        int np = (givenNumber-1)*8 + alphaNum;
        return np;
    }

    public boolean isEnd() {
        // tells if the game is end(checkmate) for now just always runs
        //checkmate
        int countTrue = 0;
        List<Integer> kings = findKings();
        if (bd.get(kings.get(0)).getPiece().getName().equals("WK")) { //0 W, 1 B
            if (bd.get(kings.get(0)).getPiece().possiblePositionChecker(true,cb,kings.get(0),kings.get(0)).size() == 0) {
                //return false;
            } else {
                if (0 <= kings.get(0) + 1 && kings.get(0) + 1 <= 63) {
                    if (bd.get(kings.get(0)+1).getPiece().possiblePositionChecker(true,cb,kings.get(0)+1,kings.get(0)+1).size() == 0) {
                        //return false;
                    }
                } else if (0 <= kings.get(0) - 1 && kings.get(0) - 1 <= 63) {
                    if (bd.get(kings.get(0)-1).getPiece().possiblePositionChecker(true,cb,kings.get(0)-1,kings.get(0)-1).size() == 0) {
                        //return false;
                    }
                } else if (0 <= kings.get(0) + 7 && kings.get(0) + 7 <= 63) {
                    if (bd.get(kings.get(0)-1).getPiece().possiblePositionChecker(true,cb,kings.get(0)+7,kings.get(0)+7).size() == 0) {
                        //return false;
                    }

                } else if (0 <= kings.get(0) + 8 && kings.get(0) + 8 <= 63) {
                    if (bd.get(kings.get(0)-1).getPiece().possiblePositionChecker(true,cb,kings.get(0)+8,kings.get(0)+8).size() == 0) {
                        //return false;
                    }

                } else if (0 <= kings.get(0) + 9 && kings.get(0) + 9 <= 63) {
                    if (bd.get(kings.get(0)-1).getPiece().possiblePositionChecker(true,cb,kings.get(0)+9,kings.get(0)+9).size() == 0) {
                        //return false;
                    }

                } else if (0 <= kings.get(0) - 7 && kings.get(0) - 7 <= 63) {
                    if (bd.get(kings.get(0)-1).getPiece().possiblePositionChecker(true,cb,kings.get(0)-7,kings.get(0)-7).size() == 0) {
                        //return false;
                    }

                } else if (0 <= kings.get(0) - 8 && kings.get(0) - 8 <= 63) {
                    if (bd.get(kings.get(0)-1).getPiece().possiblePositionChecker(true,cb,kings.get(0)-8,kings.get(0)-8).size() == 0) {
                        //return false;
                    }

                } else if (0 <= kings.get(0) - 9 && kings.get(0) - 9 <= 63) {
                    if (bd.get(kings.get(0)-1).getPiece().possiblePositionChecker(true,cb,kings.get(0)-9,kings.get(0)-9).size() == 0) {
                        //return false;
                    }

                } else {
                    countTrue++;
                }
            }

        } else {// 0 B, 1 W
            if (bd.get(kings.get(1)).getPiece().possiblePositionChecker(true,cb,kings.get(1),kings.get(1)).size() == 0) {
                //return false;
            } else {
                if (0 <= kings.get(1) + 1 && kings.get(1) + 1 <= 63) {
                    if (bd.get(kings.get(1)+1).getPiece().possiblePositionChecker(true,cb,kings.get(1)+1,kings.get(1)+1).size() == 0) {
                        //return false;
                    }
                } else if (0 <= kings.get(1) - 1 && kings.get(1) - 1 <= 63) {
                    if (bd.get(kings.get(1)-1).getPiece().possiblePositionChecker(true,cb,kings.get(1)-1,kings.get(1)-1).size() == 0) {
                        //return false;
                    }
                } else if (0 <= kings.get(1) + 7 && kings.get(1) + 7 <= 63) {
                    if (bd.get(kings.get(1)-1).getPiece().possiblePositionChecker(true,cb,kings.get(1)+7,kings.get(1)+7).size() == 0) {
                        //return false;
                    }

                } else if (0 <= kings.get(1) + 8 && kings.get(1) + 8 <= 63) {
                    if (bd.get(kings.get(1)-1).getPiece().possiblePositionChecker(true,cb,kings.get(1)+8,kings.get(1)+8).size() == 0) {
                        //return false;
                    }

                } else if (0 <= kings.get(1) + 9 && kings.get(1) + 9 <= 63) {
                    if (bd.get(kings.get(1)-1).getPiece().possiblePositionChecker(true,cb,kings.get(1)+9,kings.get(1)+9).size() == 0) {
                        //return false;
                    }

                } else if (0 <= kings.get(1) - 7 && kings.get(1) - 7 <= 63) {
                    if (bd.get(kings.get(1)-1).getPiece().possiblePositionChecker(true,cb,kings.get(1)-7,kings.get(1)-7).size() == 0) {
                        //return false;
                    }

                } else if (0 <= kings.get(1) - 8 && kings.get(1) - 8 <= 63) {
                    if (bd.get(kings.get(1)-1).getPiece().possiblePositionChecker(true,cb,kings.get(1)-8,kings.get(1)-8).size() == 0) {
                        //return false;
                    }

                } else if (0 <= kings.get(1) - 9 && kings.get(1) - 9 <= 63) {
                    if (bd.get(kings.get(1) - 1).getPiece().possiblePositionChecker(true, cb, kings.get(1) - 9, kings.get(1) - 9).size() == 0) {
                        //return false;
                    }
                } else {
                    countTrue++;
                }
            }

        }

        if (countTrue > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<Integer> findKings() {
        List<Integer> kings = new ArrayList<Integer>();
        for (int i = 0; i < 64; i++) {
             if (!(bd.get(i).getPiece() == null)) {
                 if (bd.get(i).getPiece().getName().equals("WK")
                     || bd.get(i).getPiece().getName().equals("BK")) {
                     kings.add(i);
                 }
             }
        }
        return kings;
    }

    public static void main(String arg[]) {
    }

}
