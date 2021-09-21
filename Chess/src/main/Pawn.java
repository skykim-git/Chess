package main;

public class Pawn extends Piece{

    // EFFECTS : constructs a main.Pawn
    public Pawn(String name) {
        super(name);
    }

    @Override
    // MODIFIES: this
    // EFFECTS : Moves a Pawn if Pawn can move to the selected position : input:> position
    public void Move(Position pos, ChessBoard cb) {// pos is the pos I want to move to
        //RULES move: go front if there's no piece in front of the pawn
        //RULES kill: position given is a either diagonal of the pawn with no piece, or null
        //checkmate (can move_
        //king kill  : pawn can't kill the king


        //should decide if black or white
        int moveToNumberPos = pos.getNumberPosition();
        int currentNumberPos = this.position.getNumberPosition();

//!!! outrange case ( the largest if case)
        //if white(bottom)
        if (moveToNumberPos >= 64 || moveToNumberPos <= -1) { // out of range case
            System.out.print("out of bound");// possible throw exception
        } else {
            if (this.getName().substring(0, 1) == "W") {// white
                if (moveToNumberPos == 8 + currentNumberPos) {// compared to current position, front
                    if (cb.getBoard().get(moveToNumberPos).getPiece() == null) {// if front empty
                        pos.setPiece(this);
                    }
                }
            }
        }


    }
}
