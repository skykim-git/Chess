package main;

public class Rook extends Piece{

    // EFFECTS : constructs a main.Rook
    public Rook(String name) {
        super(name);
    }
    @Override
    public void move(Position pos, ChessBoard cb) {

        int moveToNumberPos = pos.getNumberPosition();// numberPosition that we are moving to
        Position currentPos = this.position;//position current
        int currentNumberPos = this.position.getNumberPosition();// numberPosition current


        if (moveToNumberPos >= 64 || moveToNumberPos <= -1) { // out of range case // can be defined as a helper
            System.out.print("out of bound");// possible throw exception
        } else {
            if (isInRange(moveToNumberPos,currentNumberPos)) {
                if (!isBlocking(currentNumberPos,moveToNumberPos,cb)) {
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
                }
            } else {
                System.out.print("not valid position");
            }
        }

    }

    boolean isInRange(int moveToNumberPos, int currentNumberPos) {

        for (int n = -7; n < 8; n++) {
            if (moveToNumberPos == currentNumberPos + 8 * n)//North and South
                {
                return true;
            }
        }

        for (int i = 0; i< currentNumberPos%8 ; i++) {
            if (moveToNumberPos == currentNumberPos - i) {
                return true;
            }
        }

        for (int i = 0; i< (8- (currentNumberPos%8 + 1)); i++) {
            if (moveToNumberPos == currentNumberPos + i) {
                return true;
            }
        }

        return false;

    }

    boolean isBlocking(int curr, int moveTo, ChessBoard cb) {
        String dir = directionHelper(curr,moveTo);
        System.out.print(dir);
//since curr is numberposition(which is one larger than the coordinate, subtracting 1
        if (dir.equals("N")) { // i should be curr + 9, because given piece is
            for (int i = curr + 8; !(i == moveTo); i = i+8) {
                if (!(cb.getBoard().get(i).getPiece() == null)) {
                    return true;
                }
            }
            return false;
        } else if (dir.equals("S")) {
            for (int i = curr - 8; !(i == moveTo); i = i-8) {
                if (!(cb.getBoard().get(i).getPiece() == null)) {
                    return true;
                }
            }
            return false;
        } else if (dir.equals("W")) {
            for (int i = curr -1; !(i == moveTo); i = i--) {
                if (!(cb.getBoard().get(i).getPiece() == null)) {
                    return true;
                }
            }
            return false;

        } else if (dir.equals("E")) {
            for (int i = curr +1; !(i == moveTo); i = i++) {
                if (!(cb.getBoard().get(i).getPiece() == null)) {
                    return true;
                }
            }
            return false;

        } else {
            System.out.print("invalid position");//throw exception
            return true;
        }
    }

    String directionHelper(int curr, int moveTo) {
        String dir = "";
        for (int n = -7; n < 8; n++) {
            if (moveTo == curr + 8 * n)//North and South
            {
                if (n > 0) {
                    dir = "N";
                } else if(n == 0) {
                    dir = "NONE";
                } else {
                    dir = "S";
                }
            }
        }

        for (int i = 0; i< curr%8 ; i++) {
            if (moveTo == curr - i) {
                dir = "W";
            }
        }

        for (int i = 0; i< (8- (curr%8 + 1)); i++) {
            if (moveTo == curr + i) {
                dir = "E";
            }
        }
        return dir;
    }
}