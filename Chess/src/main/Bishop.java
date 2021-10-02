package main;

public class Bishop extends Piece {

    // EFFECTS : construct a main.Knight

    public Bishop(String name) {
        super(name);
    }

    @Override
    public void move(Position pos, ChessBoard cb) {

        int moveToNumberPos = pos.getNumberPosition();// numberPosition that we are moving to
        Position currentPos = this.position;//position current
        int currentNumberPos = this.position.getNumberPosition();// numberPosition current


        if (moveToNumberPos >= 64 || moveToNumberPos <= -1) { // out of range case // can be defined as a helper
            System.out.print("out of bound");// possible throw exception
        } if (isInRange(moveToNumberPos,currentNumberPos)) {
            if (isWhite(this)) {//white
                if (pos.getPiece() == null) {// if front empty // helper??? //simpiify using pos.get...
                    currentPos.removePiece();// should remove from current position
                    pos.setPiece(this); // can be defined as a helper
                } else if (!isWhite(pos.getPiece())) {
                    currentPos.removePiece();// should remove from current position
                    pos.setPiece(this); // can be defined as a helper
                } else {
                    //teamkillexception
                }
            } else {//black
                if (pos.getPiece() == null) {// if front empty // helper??? //simpiify using pos.get...
                    currentPos.removePiece();// should remove from current position
                    pos.setPiece(this); // can be defined as a helper
                } else if (isWhite(pos.getPiece())) {
                    currentPos.removePiece();// should remove from current position
                    pos.setPiece(this); // can be defined as a helper
                } else {
                    //teamkillexception
                }

            }
        } else {
            System.out.print("not valid position");


        }

    }

    boolean isInRange(int moveToNumberPos, int currentNumberPos) {

        for (int n = -7; n < 8; n++) {
            if ((moveToNumberPos == currentNumberPos + 8 * n + n)
                    || moveToNumberPos == currentNumberPos + 8 * n - n) {
                return true;
            }
        }
        return false;

    }
}
