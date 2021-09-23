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
        int moveToNumberPos = pos.getNumberPosition();
        Position currentPos = this.position;
        int currentNumberPos = this.position.getNumberPosition();


        if (moveToNumberPos >= 64 || moveToNumberPos <= -1) { // out of range case
            System.out.print("out of bound");// possible throw exception
        } else {
            if (this.getName().substring(0, 1).equals("W")) {// white
                if (moveToNumberPos == currentNumberPos + 8) {// compared to current position, front
                    if (cb.getBoard().get(moveToNumberPos).getPiece() == null) {// if front empty
                        pos.setPiece(this); // might be defined as a helper
                        currentPos.removePiece();// should remove from current postion??? current here is changed. so
                        //currentPos.getPiece().removePosition();
                        System.out.print(currentNumberPos);
                        System.out.print(moveToNumberPos);
                    }
                } else if (moveToNumberPos == currentNumberPos + 8 + 1 // case where going(killing pieces on the diagonal
                            ||moveToNumberPos == currentNumberPos + 8 -1) {
                        if (cb.getBoard().get(moveToNumberPos).getPiece().getName().substring(1,1) != "K") {
                            pos.setPiece(this);
                            this.position.removePiece();// should remove from current postion
                        }
                    }

            } else { // white case
                if (moveToNumberPos == currentNumberPos - 8) {// front compared to the current position
                    if (cb.getBoard().get(moveToNumberPos).getPiece() == null) {
                        pos.setPiece(this);
                    }
                } else if (moveToNumberPos == currentNumberPos - 8 + 1
                        ||moveToNumberPos == currentNumberPos - 8 -1) {
                    if (cb.getBoard().get(moveToNumberPos).getPiece().getName().substring(1,1) != "K") {
                        pos.setPiece(this);
                    }

                }

            }
        }


    }
}
