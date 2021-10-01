package main;

public class Knight extends Piece {

    // EFFECTS : construct a main.Knight

    public Knight(String name) {
        super(name);
    }
    @Override
    public void move(Position pos, ChessBoard cb) {

        int moveToNumberPos = pos.getNumberPosition();// numberPosition that we are moving to
        Position currentPos = this.position;//position current
        int currentNumberPos = this.position.getNumberPosition();// numberPosition current

        if (moveToNumberPos >= 64 || moveToNumberPos <= -1) { // out of range case
            System.out.print("out of bound");// possible throw exception
        } else {
            if (isWhite(this)) {
                if (moveToNumberPos == currentNumberPos + 2*8 + 1
                    ||moveToNumberPos == currentNumberPos + 2*8 - 1
                    ||moveToNumberPos == currentNumberPos + 1*8 + 2
                    ||moveToNumberPos == currentNumberPos + 1*8 - 2
                    ||moveToNumberPos == currentNumberPos - 1*8 + 2
                    ||moveToNumberPos == currentNumberPos - 1*8 - 2
                    ||moveToNumberPos == currentNumberPos - 2*8 + 1
                    ||moveToNumberPos == currentNumberPos - 2*8 - 1) {

//                    these two are diff, guess something to do with pass by reference... above works below does not catch
                    // changes already made
//                    System.out.print(pos.getPiece());
//                    System.out.print(cb.getBoard().get(moveToNumberPos).getPiece().getName());

                    if (pos.getPiece() == null) {// if front empty // helper??? //simpiify using pos.get...
                        currentPos.removePiece();// should remove from current position
                        pos.setPiece(this); // can be defined as a helper
                    } else if (!isWhite(pos.getPiece())) {
                        currentPos.removePiece();// should remove from current position
                        pos.setPiece(this); // can be defined as a helper
                    } else {
                        //teamkillexception
                    }
                }
            } else { // black
                if (moveToNumberPos == currentNumberPos + 2*8 + 1
                        ||moveToNumberPos == currentNumberPos + 2*8 - 1
                        ||moveToNumberPos == currentNumberPos + 1*8 + 2
                        ||moveToNumberPos == currentNumberPos + 1*8 - 2
                        ||moveToNumberPos == currentNumberPos - 1*8 + 2
                        ||moveToNumberPos == currentNumberPos - 1*8 - 2
                        ||moveToNumberPos == currentNumberPos - 2*8 + 1
                        ||moveToNumberPos == currentNumberPos - 2*8 - 1) {
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

            }

        }

    }
}
