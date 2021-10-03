package main;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{

    // EFFECTS : constructs a main.King
    public King(String name) {
        super(name);
    }
    @Override
    public void move(Position pos, ChessBoard cb) {

        //should decide if black or white
        int moveToNumberPos = pos.getNumberPosition();// numberPosition that we are moving to
        Position currentPos = this.position;//position current
        int currentNumberPos = this.position.getNumberPosition();// numberPosition current


        if (moveToNumberPos >= 64 || moveToNumberPos <= -1) { // out of range case // can be defined as a helper
            System.out.print("out of bound");// possible throw exception
        } else {
            if (isWhite(this)) {// white
                //can't kill itself.
                // if possiblePositionChecker(true, cb)
            } else { // black

            }
        }

    }

    List<Integer> possiblePositionChecker(boolean isWhite, ChessBoard cb, int curr, int kingMoveTo) {
        List<Integer> loOpponentPieces = OpponentGetter(isWhite, cb);
        List<Integer> loCanKillKingPieces = null;
        for (int i: loOpponentPieces) {
            if (cb.getBoard().get(i).getPiece().canKillKing(cb.getBoard().get(kingMoveTo), cb)) {
                loCanKillKingPieces.add(i);
            }
        }
        return loCanKillKingPieces;
    }

    List<Integer> OpponentGetter(boolean isWhite, ChessBoard cb) {
        List<Integer> loOpponentPieces= new ArrayList<Integer>;
        if (isWhite) {
            for (int i = 0; i < 64; i++) {
                if (!(cb.getBoard().get(i).getPiece() == null)) {
                    if (cb.getBoard().get(i).getPiece().getName().substring(0,1).equals("B")) {
                        loOpponentPieces.add(i);
                    }
                }
            }
        } else {
            for (int i = 0; i < 64; i++) {
                if (!(cb.getBoard().get(i).getPiece() == null)) {
                    if (cb.getBoard().get(i).getPiece().getName().substring(0,1).equals("B")) {
                        loOpponentPieces.add(i);
                    }
                }
            }

        }

        return loOpponentPieces;

    }
}
