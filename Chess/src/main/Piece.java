package main;

import java.util.ArrayList;
import java.util.List;

// abstract class representing a main.Piece having position
public abstract class Piece {
    protected Position position;
    protected String name; // take a look at naming convention in p3

    public Piece(String name) {
        this.name = name;
    }

    // abstract method for subclasses
    public abstract void move(Position p, ChessBoard cb);

    public abstract boolean canKillKing(Position p, ChessBoard cb, boolean isWhite);

    public void setPosition(Position position) {
        this.position = position;
    }

    public void removePosition() {
        this.position = null;
    }

    public Position getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    // helper 1
    public boolean isWhite(Piece p) {
        String name = p.getName();
        if (name.substring(0,1).equals("W")) {
            return true;
        } else {
            return false;
        }

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

}
