package main;

public class Pawn extends Piece{

    // EFFECTS : constructs a main.Pawn
    public Pawn(String name) {
        super(name);
    }

    @Override
    // MODIFIES: this
    // EFFECTS : Moves a Pawn if Pawn can move to the selected position : input:> position
    public void move(Position pos, ChessBoard cb) {// pos is the pos I want to move to
        //RULES move: go front if there's no piece in front of the pawn(o)
        //RULES kill: position given is a either diagonal of the pawn with no piece, or null()
        //checkmate (can move)(o)
        //king kill  : pawn can't kill the king(o)


        //should decide if black or white
        int moveToNumberPos = pos.getNumberPosition();// numberPosition that we are moving to
        Position currentPos = this.position;//position current
        int currentNumberPos = this.position.getNumberPosition();// numberPosition current


        if (moveToNumberPos >= 64 || moveToNumberPos <= -1) { // out of range case // can be defined as a helper
            System.out.print("out of bound");// possible throw exception
        } else {
            if (isWhite(this)) {// white
                if (moveToNumberPos == currentNumberPos + 8) {// compared to current position, front
                    if (pos.getPiece() == null) {// if front empty
                        currentPos.removePiece();// should remove from current position
                        pos.setPiece(this); // can be defined as a helper
                    } else {
                        // no possible place exception
                    }
                } else if (moveToNumberPos == currentNumberPos + 8 + 1 // case where going(killing pieces on the diagonal
                            ||moveToNumberPos == currentNumberPos + 8 -1) { // kill black // get isWhite out(need no possible places exception)
                        // later case king kill
                    if (!isWhite(pos.getPiece())) {
                        currentPos.removePiece();// should remove from current position
                        pos.setPiece(this);
                    } else {
                        // throw no possible place exception (teamkill exception)
                    }

                } else {
                    // no possible place exception
                }

            } else { // black
                if (moveToNumberPos == currentNumberPos - 8) {// front compared to the current position
                    if (pos.getPiece() == null) {
                        currentPos.removePiece();// should remove from current position
                        pos.setPiece(this);
                    } else {
                        // no possible place exception
                    }
                } else if (moveToNumberPos == currentNumberPos - 8 + 1
                            ||moveToNumberPos == currentNumberPos - 8 -1) {
                    if (isWhite(pos.getPiece())) {
                        currentPos.removePiece();// should remove from current position
                        pos.setPiece(this);
                    } else {
                        // throw no possible place exception

                    }



                }

            }
        }


    }

    // promotion feature add later


}
