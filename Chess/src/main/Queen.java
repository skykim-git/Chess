package main;

public class Queen extends Piece{

    // EFFECTS : constructs a main.Queen
    public Queen(String name) {
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

    @Override
    public boolean canKillKing(Position pos, ChessBoard cb, boolean isWhite) {
        int moveToNumberPos = pos.getNumberPosition();// numberPosition that we are moving to
        Position currentPos = this.position;//position current
        int currentNumberPos = this.position.getNumberPosition();// numberPosition current


        if (moveToNumberPos >= 64 || moveToNumberPos <= -1) { // out of range case // can be defined as a helper
            return false;
        } else {
            if (isInRange(moveToNumberPos,currentNumberPos)) {
                if (!isBlocking(currentNumberPos,moveToNumberPos,cb)) {
                    if (isWhite(this)) {//white
                        if (pos.getPiece() == null) {// if front empty // helper??? //simpiify using pos.get...
                            return true;

                        } else if (!isWhite) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {//black
                        if (pos.getPiece() == null) {// if front empty // helper??? //simpiify using pos.get...
                            return true;
                        } else if (isWhite) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            } else {
                return false;
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
            for (int i = curr -1; !(i == moveTo); i--) {
                if (!(cb.getBoard().get(i).getPiece() == null)) {
                    return true;
                }
            }
            return false;

        } else if (dir.equals("E")) {
            for (int i = curr +1; !(i == moveTo); i++) {
                if (!(cb.getBoard().get(i).getPiece() == null)) {
                    return true;
                }
            }
            return false;

        } else if (dir.equals("NE")) { // i should be curr + 9, because given piece is
            for (int i = curr + 9; !(i == moveTo); i = i+9) {
                if (!(cb.getBoard().get(i).getPiece() == null)) {
                    return true;
                }
            }
            return false;
        } else if (dir.equals("SE")) {
            for (int i = curr - 7; !(i == moveTo); i = i-7) {
                if (!(cb.getBoard().get(i).getPiece() == null)) {
                    return true;
                }
            }
            return false;
        } else if (dir.equals("NW")) {
            for (int i = curr + 7; !(i == moveTo); i = i+7) {
                if (!(cb.getBoard().get(i).getPiece() == null)) {
                    return true;
                }
            }
            return false;

        } else if (dir.equals("SW")) {
            for (int i = curr - 9; !(i == moveTo); i = i-9) {
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

        for (int i = 0; i<= curr%8 ; i++) { // greater or equal to bc, should get to the final of curr%8
            if (moveTo == curr - i) {
                dir = "W";
            }
        }

        for (int i = 0; i<= (8- (curr%8 + 1)); i++) {
            if (moveTo == curr + i) {
                dir = "E";
            }
        }
// bishop
        for (int n = -7; n < 8; n++) {
            if (moveTo == curr + n*8 + n) {
                if (n > 0) {
                    dir = "NE";
                    break;

                } else if (n == 0) {
                    dir = "NONE";
                    break;
                } else {
                    dir = "SW";
                    break;
                }
            } else if(moveTo == curr + n*8 - n) {
                if (n > 0) {
                    dir = "NW";
                    break;
                } else if (n==0) {
                    dir = "NONE";
                    break;
                } else {
                    dir = "SE";
                    break;
                }
            } else if(moveTo == curr + n*8 - n) {

            } else {

            }
        }
        return dir;
    }

    boolean isInRange(int moveToNumberPos, int currentNumberPos) {

        for (int n = -7; n < 8; n++) {
            if (moveToNumberPos == currentNumberPos + 8 * n)//North and South
            {
                return true;
            }
        }

        for (int i = 0; i <= currentNumberPos%8 ; i++) {
            if (moveToNumberPos == currentNumberPos - i) {
                return true;
            }
        }

        for (int i = 0; i <= (8- (currentNumberPos%8 + 1)); i++) {
            if (moveToNumberPos == currentNumberPos + i) {
                return true;
            }
        }

        for (int n = -7; n < 8; n++) {
            if ((moveToNumberPos == currentNumberPos + 8 * n + n)
                    || moveToNumberPos == currentNumberPos + 8 * n - n) {
                return true;
            }
        }

        return false;

    }


}