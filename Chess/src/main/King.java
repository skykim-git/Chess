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
                if (isValidMove(currentNumberPos, moveToNumberPos)) {
                    if (possiblePositionChecker(true, cb, currentNumberPos, moveToNumberPos).size() == 0) { // if size 0, no invalid king move
                        if (pos.getPiece() == null) {// if front empty
                            currentPos.removePiece();// should remove from current position
                            pos.setPiece(this); // can be defined as a helper
                        } else if (!isWhite(pos.getPiece())) {
                            currentPos.removePiece();// should remove from current position
                            pos.setPiece(this); // can be defined as a helper
                        } else {
                            // no possible place exception
                        }
                    }
                } else {
                    // not valid position exception
                }

            } else { // black
                if (isValidMove(currentNumberPos, moveToNumberPos)) {
                    if (possiblePositionChecker(false, cb, currentNumberPos, moveToNumberPos).size() == 0) {
                        if (pos.getPiece() == null) {// if front empty
                            currentPos.removePiece();// should remove from current position
                            pos.setPiece(this); // can be defined as a helper
                        } else if (isWhite(pos.getPiece())) {
                            currentPos.removePiece();// should remove from current position
                            pos.setPiece(this); // can be defined as a helper
                        } else {
                            // no possible place exception
                        }


                    }
                } else {
                    // not valid position exception
                }
            }
        }

    }

    @Override
    public boolean canKillKing(Position pos, ChessBoard cb, boolean isWhite) {

        int moveToNumberPos = pos.getNumberPosition();// numberPosition that we are moving to
        Position currentPos = this.position;//position current
        int currentNumberPos = this.position.getNumberPosition();// numberPosition current


        if (moveToNumberPos >= 64 || moveToNumberPos <= -1) { // out of range case // can be defined as a helper
            System.out.print("out of bound");// possible throw exception
        } else {
            if (isWhite(this)) {// white
                //can't kill itself.
                if (isValidMove(currentNumberPos, moveToNumberPos)) {
                    if (possiblePositionChecker(true, cb, currentNumberPos, moveToNumberPos).contains(moveToNumberPos)) {
                        if (pos.getPiece() == null) {// if front empty
                            return true;
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }

            } else { // black
                if (isValidMove(currentNumberPos, moveToNumberPos)) {
                    if (possiblePositionChecker(true, cb, currentNumberPos, moveToNumberPos).contains(moveToNumberPos)) {
                        if (pos.getPiece() == null) {// if front empty
                            return true;
                        } else {
                            return false;
                        }

                    }
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public List<Integer> possiblePositionChecker(boolean isWhite, ChessBoard cb, int curr, int kingMoveTo) {
        List<Integer> loOpponentPieces = OpponentGetter(isWhite, cb);
        List<Integer> loCanKillKingPieces = new ArrayList<Integer>();
        for (int i: loOpponentPieces) {
            if (cb.getBoard().get(i).getPiece().canKillKing(cb.getBoard().get(kingMoveTo), cb, isWhite(this))) {
                loCanKillKingPieces.add(i);
            }
        }

        return loCanKillKingPieces;
    }

    List<Integer> OpponentGetter(boolean isWhite, ChessBoard cb) {
        List<Integer> loOpponentPieces= new ArrayList<Integer>();
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
                    if (cb.getBoard().get(i).getPiece().getName().substring(0,1).equals("W")) {
                        loOpponentPieces.add(i);
                    }
                }
            }

        }

        return loOpponentPieces;

    }

    boolean isValidMove(int curr, int moveTo) {
        return (moveTo == curr + 1 || moveTo == curr - 1
                || moveTo == curr + 7 || moveTo == curr + 8
                || moveTo == curr + 9 || moveTo == curr - 9
                || moveTo == curr - 8 || moveTo == curr - 7);

    }
}
